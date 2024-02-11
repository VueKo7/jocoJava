package input;

import utility.Vector2D;
import java.awt.event.KeyEvent;

import entity.Entity;
import player.Player;

//Classe che utilizzando il Vectore2D, dove verranno salvate le direzioni di X e Y di un'entità
//Permette di modificare le direzioni in base all'input. Viene richiamata nella classe Player
public class Movement {

    Vector2D vector;
    Input input;
    private int speed = 10;
    private int directionX;
    private int directionY;

    //Costruttore che inzializza il vector2D a 0,0(fermo)
    public Movement(Input input) {
        vector = new Vector2D(0, 0);
        this.input = input;
    }

    //Metodo principale che passandogli Input, assegna al Vector2D le direzioni in base agli imput.
    public void update_position(Player player) {

        //System.out.println("{"+getDirectionX()+","+getDirectionY()+"}");
        

        //Attributo contenete la direzione delle ascisse(0=fermo in x, -1=spostamento verso sinistra, 1=spostamento verso destra)
        directionX = 0;
        //Attributo contenete la direzione delle ordinate(0=fermo in y, -1=spostamento verso l'alto, 1=spostamento verso il basso)
        directionY = 0;

        
        if(input.getKeyState(KeyEvent.VK_W)) //VK_W is pressed | going up
            directionY = -1;    
        else if(input.getKeyState(KeyEvent.VK_S)) //VK_S is pressed | going down
            directionY = 1; 

        if(input.getKeyState(KeyEvent.VK_A)) //VK_A is pressed | going left
            directionX = -1; 
        else if(input.getKeyState(KeyEvent.VK_D)) //VK_D is pressed | goign right
            directionX = 1;

        
        boolean xCameraCollision = player.collisionX(player.getCameraPos(), player.getCameraSize(), directionX*speed);
        boolean yCameraCollision = player.collisionY(player.getCameraPos(), player.getCameraSize(), directionY*speed);

        if(xCameraCollision || yCameraCollision)
        {
            if(xCameraCollision)
                directionX = 0;
            
            if(yCameraCollision)
                directionY = 0;
        }

        
        for(Entity obstacle : Entity.getEntities())
        {
            boolean xCollision = player.collisionX(obstacle, directionX*speed);
            boolean yCollision = player.collisionY(obstacle, directionY*speed);

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
                 * il controllo di collisione darà TRUE che negato è FALSE quindi la mia directionX rimane invariata
                 */

                //dopo aver cambiato direzione, domanda se alle sue spalle ha un ostacolo
                boolean reverseXCollision = player.collisionX(obstacle, -directionX*speed);
                boolean reverseYCollision = player.collisionY(obstacle, -directionY*speed);
                
                //impone che tu NON abbia un'ostacolo a destra/sinistra per fermarti in X
                if(!reverseXCollision)
                    directionX = 0;
                
                //impone che tu NON abbia un'ostacolo sopra/sotto per fermarti in Y
                if(!reverseYCollision || player.collisionY(player.getCameraPos(), player.getCameraSize(), directionY))
                    directionY = 0;
            }

        }
        
        //System.out.println("{"+directionX+","+directionY+"}");
    
        //inizializzo il Vectore2D passandogli le direzioni x e y
        vector = new Vector2D(directionX, directionY);
        vector.normalize();
        //richiamo la multiply passandogli la velocità desiderata
        vector.multiply(speed);
    
        //System.out.println(vector.toString()); //stampo le direzioni 
    }

    
    public int getSpeed() {return speed;}
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    
    public Vector2D getVector2d() { return vector; }


    public int getDirectionX() {return directionX;}
    public void setDirectionX(int dX) {this.directionX = dX;}

    public int getDirectionY() {return directionY;}
    public void setDirectionY(int dY) {this.directionX = dY;}
}
