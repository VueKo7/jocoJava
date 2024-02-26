package entity.dinamicEntity.player;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import entity.Entity;
import entity.dinamicEntity.Attack;
import entity.dinamicEntity.MovingEntity;
import entity.dinamicEntity.Vector2D;
import input.KeyboardInput;
import input.MouseInput;
//Classe utilizzata per gestire il player.Utilizza Input, Movement e Vector 2D.
//Figlia di Entyty, quindi controllare la mommy. Viene richiamata dal Game
public class Player extends MovingEntity implements Attack {

    //attributi + quelli ereditati da Entity
    //Camera camera;
    MouseInput mouseInput;
    KeyboardInput keyboardInput;
    int tempo;

    //Position position;
    //Size size;
    //Image icon;
    //Rectangle hitBox;

    //Costruttore per creare il player, richiama il costruttore dell'entità
    //x=posizioni ascisse
    //y=posizioni ordinate
    //widht=lunghezza 
    //height=altezza
    //imgSrc=percorso dell'immagine
    //hitBox=rettangolo che delinea lo spazio dell'entita'

    public Player(int x, int y, int width, int height, KeyboardInput keyboardInput, MouseInput mouseInput) {
        
        super(x, y, width, height);
        
        this.keyboardInput = keyboardInput;
        this.mouseInput = mouseInput;
        getHitBox().translate(width/4, height/4);
        getHitBox().setSize(width/2, height/2);

        //setting animations
        String[] movingLeft = {"icons/hero/movingLeft/movingLeft1.png",
                                "icons/hero/movingLeft/movingLeft2.png"};
        String[] movingRight = {"icons/hero/movingRight/movingRight2.png",
                                "icons/hero/movingRight/movingRight1.png"};
        String[] standingStill = {"icons/hero/standStill/standingStill1.png",
                                "icons/hero/standStill/standingStill2.png"};
        
        super.setStillSprites(standingStill);
        super.setLeftSprites(movingLeft);
        super.setRightSprites(movingRight);

    }
    


    //MOVEMENT CONTROLS
//********************************************************* */
    @Override
    public void move() { //Methodo per far muovere il player
        
        //determina la direzione del personaggio controllando tutte le collisioni
        this.update_position();

        //aggiorna lo sprite
        this.update_sprite();

        //camera following
        getCamera().update_position((int)getVector().getX(), (int)getVector().getY());

        //Metodi settaggi della posizione del player(Appartiene ad entità)
        setX((int)getVector().getX());
        setY((int)getVector().getY());

        setXHitbox((int)getVector().getX());
        setYHitbox((int)getVector().getY());
    }



    //SETTING THE DIRECTION TO THE REQUESTED ONE
//********************************************************* */
    @Override
    public int calcYdirection() {

        int dY = 0;
        if(keyboardInput.getKeyState(KeyEvent.VK_W)) //VK_W is pressed | going up
            dY = -1;   
        else if(keyboardInput.getKeyState(KeyEvent.VK_S)) //VK_S is pressed | going down
            dY = 1;

        return dY;
    }   

    @Override
    public int calcXdirection() {
        
        int dX = 0;
        if(keyboardInput.getKeyState(KeyEvent.VK_A)) //VK_A is pressed | going left
            dX = -1;   
        else if(keyboardInput.getKeyState(KeyEvent.VK_D)) //VK_D is pressed | goign right
            dX = 1;

        return dX;
    }



    //CHECKING IF THE REQUESTED POSITION IS AVAILABLE
//********************************************************* */
    @Override
    public void update_position() {

        //(0=fermo in x, -1=spostamento verso sinistra, 1=spostamento verso destra)
        int dX = calcXdirection();
        setDirectionX(dX);
        setFacing(dX);

        //(0=fermo in y, -1=spostamento verso l'alto, 1=spostamento verso il basso)
        int dY = calcYdirection();
        setDirectionY(dY);

        //getting the speed(needed for collision check)
        int speed = getSpeed();

        boolean xCollision;
        boolean yCollision;


        for(Entity obstacle : Entity.getEntities())
        {
            //Se nella camera del player è presente un'entità allora controlla le collisioni
            if(getCamera().getCameraArea().intersects(obstacle.getHitBox()))
            {
                xCollision = getCamera().collisionX(obstacle, getDirectionX()*speed);
                yCollision = getCamera().collisionY(obstacle, getDirectionY()*speed);

                //check if you actually collide with the obstacle
                if(yCollision && xCollision)
                {      
            /*CONTROLLO CHE SERVE VENGA CONSULTATO SOLO DOPO CHE IL PLAYER CAMBIA DIREZIONE
            * 
            * DOMINIO DI COLLISIONE: tutto lo spazio verticale determinato dalla LARGHEZZA dell'ostacolo
            * CODOMINIO DI COLLISIONE: tutto lo spazio orizzontale determinato dall'ALTEZZA dell'ostacolo
            * 
            * esempio:
            * mi sto muovendo dal basso verso l'alto trovandomi sotto ad un ostacolo QUINDI:
            * in X sono in costante collisione(dominio di collisione)
            * in Y sarò in collisione non appena mi scontro in Y con l'ostacolo(codominio di collisione)
            * 
            * appena mi scontro in Y controllo che nella direzione opposta (-directionY) ci sia un ostacolo
            * mentre mi sto spostando verso questo ostacolo dietro di me sarà libero:
            * il controllo collisione mi darà quindi FALSE perchè non sto collidendo nella direzioneo opposta
            * quindi negato nell'IF avrò TRUE e quindi la directionY sarà posta a 0
            * 
            * caso 1: cambio direzione e vado verso il basso
            * la directionY viene aggiornata sopra e il primo controllo di collisione darà FALSE
            * allora questo if NON viene eseguito e il giocatore riesce ad andare verso il basso
            * 
            * caso 2: cambio direzione e vado verso destra/sinistra
            * in X mi trovo nel dominio di collisione
            * il controllo di collisione darà TRUE che negato è FALSE quindi la mia getDirectionX() rimane invariata
            */

                    //dopo aver cambiato direzione, domanda se alle sue spalle ha un ostacolo
                    xCollision = getCamera().collisionX(obstacle, -getDirectionX()*speed);
                    yCollision = getCamera().collisionY(obstacle, -getDirectionY()*speed);
                    
                    //impone che tu NON abbia un'ostacolo a destra/sinistra per fermarti in X
                    if(!xCollision)
                        setDirectionX(0);
                    
                    //impone che tu NON abbia un'ostacolo sopra/sotto per fermarti in Y
                    if(!yCollision)
                        setDirectionY(0);
                }

            }
        }


        //se il player collide con il bordo schermo con la camera allora tutte le entità si muovono nella direzione opposta
        xCollision = getCamera().frame_collisionX(getDirectionX()*speed);
        yCollision = getCamera().frame_collisionY(getDirectionY()*speed);

        if(xCollision || yCollision)
        {
            for(Entity entity : Entity.getEntities()) {

                    entity.setX(-getDirectionX()*speed);
                    entity.setXHitbox(-getDirectionX()*speed);
                    entity.getCamera().setX(-getDirectionX()*speed);

                    entity.setY(-getDirectionY()*speed);
                    entity.setYHitbox(-getDirectionY()*speed);
                    entity.getCamera().setY(-getDirectionY()*speed);
            }

            if(xCollision)
                setDirectionX(0);

            if(yCollision)
                setDirectionY(0);

        }

    
        //inizializzo il Vectore2D passandogli le direzioni x e y
        setVector(new Vector2D(getDirectionX(), getDirectionY())); 
        getVector().normalize();
        //richiamo la multiply passandogli la velocità desiderata
        getVector().multiply(getSpeed());
    }

   
    @Override
    public void lightAttack() {

        if(mouseInput.getClickState(MouseEvent.BUTTON1)) {
            mouseInput.setClickState(MouseEvent.BUTTON1, false);
            System.out.println("BUTTON1");
        }
    }



    @Override
    public void heavyAttack() {
        
        if(mouseInput.getClickState(MouseEvent.BUTTON3)) {
            System.out.println(tempo);
            if(tempo >= 50) {
                System.out.println("BUTTON3");
                mouseInput.setClickState(MouseEvent.BUTTON3, false);
                tempo = 0;
            }
            tempo++;
        } else
            tempo = 0;
    }






    @Override
    public void run() {
        
        final double updateRate = 1.0d/60.0d;

        double accumulator = 0;
        long currentTime, lastUpdate = System.currentTimeMillis();
        //long nextStatTime = System.currentTimeMillis() + 1000;

        while(getHp() > 0) {
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
            accumulator += lastRenderTimeInSeconds;
            lastUpdate = currentTime;

            if(accumulator >= updateRate) {
                while(accumulator >= updateRate) {
                    
                    try {
                        move();
                        lightAttack();
                        heavyAttack();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    finally {accumulator -= updateRate;}
                }
            }
        }
    }
   
}
