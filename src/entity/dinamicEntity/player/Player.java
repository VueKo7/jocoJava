package entity.dinamicEntity.player;

import java.awt.event.KeyEvent;

import entity.Entity;
import entity.Position;
import entity.Size;
import entity.dinamicEntity.Movement;
import entity.dinamicEntity.MovingEntity;
import input.Input;
import utility.Vector2D;
//Classe utilizzata per gestire il player.Utilizza Input, Movement e Vector 2D.
//Figlia di Entyty, quindi controllare la mommy. Viene richiamata dal Game
public class Player extends MovingEntity implements Movement {

    //attributi + quelli ereditati da Entity
    Camera camera;
    Input input;
    
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

    public Player(int x, int y, int width, int height, Input input, Camera camera) {
        
        super(x, y, width, height);
        this.camera = camera;
        this.input = input;
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
    

    //CAMERA COLLISION
//******************************************************************************************** */
    public boolean collisionX(int dX) {

        return (getX()+dX <= camera.getX() //from left to right
        || getX()+getWidth()+dX >= camera.getX()+camera.getWidth()); //form right to left
        
    }

    public boolean collisionY(int dY) {

        return (getY()+dY <= camera.getY() //from down to up
        || getY()+getHeight()+dY >= camera.getY()+camera.getHeight()); //from up to down
            
    }
//******************************************************************************************** */


    //Methodo per far muovere il player, passato Input, crea un nuovo Vector2D e aggiorna le direzioni di movement
    public void move() {
        
        update_position();

        //Metodi settaggi della posizione del player(Appartiene ad entità)
        setX((int)getVector().getX());
        setY((int)getVector().getY());

        setXHitbox((int)getVector().getX());
        setYHitbox((int)getVector().getY());

        updateSprite();
    }


    public Size getCameraSize() {return camera.size;}

    public Position getCameraPos() {return camera.position;}


    @Override
    public void update_position() {

        //(0=fermo in x, -1=spostamento verso sinistra, 1=spostamento verso destra)
        setDirectionX(0);

        //(0=fermo in y, -1=spostamento verso l'alto, 1=spostamento verso il basso)
        setDirectionY(0);

        
        if(input.getKeyState(KeyEvent.VK_W)) //VK_W is pressed | going up
            setDirectionY(-1);   
        else if(input.getKeyState(KeyEvent.VK_S)) //VK_S is pressed | going down
            setDirectionY(1);

        if(input.getKeyState(KeyEvent.VK_A)) //VK_A is pressed | going left
            setDirectionX(-1); 
        else if(input.getKeyState(KeyEvent.VK_D)) //VK_D is pressed | goign right
            setDirectionX(1);

        
        boolean xCameraCollision = collisionX(getDirectionX()*getSpeed());
        boolean yCameraCollision = collisionY(getDirectionY()*getSpeed());

        if(xCameraCollision)
            setDirectionX(0);
        
        if(yCameraCollision)
            setDirectionY(0);

        
        for(Entity obstacle : Entity.getEntities())
        {
            boolean xCollision = collisionX(obstacle, getDirectionX()*getSpeed());
            boolean yCollision = collisionY(obstacle, getDirectionY()*getSpeed());

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
                boolean reverseXCollision = collisionX(obstacle, -getDirectionX()*getSpeed());
                boolean reverseYCollision = collisionY(obstacle, -getDirectionY()*getSpeed());
                
                //impone che tu NON abbia un'ostacolo a destra/sinistra per fermarti in X
                if(!reverseXCollision)
                    setDirectionX(0);
                
                //impone che tu NON abbia un'ostacolo sopra/sotto per fermarti in Y
                if(!reverseYCollision)
                    setDirectionY(0);

                break;
            }

        }
    
        //inizializzo il Vectore2D passandogli le direzioni x e y
        setVector(new Vector2D(getDirectionX(), getDirectionY())); 
        getVector().normalize();
        //richiamo la multiply passandogli la velocità desiderata
        getVector().multiply(getSpeed());
    
        //System.out.println(vector.toString()); //stampo le direzioni 
    }


   
}
