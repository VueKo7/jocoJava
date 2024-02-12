package player;

import java.awt.Image;

import entity.Entity;
import entity.Position;
import entity.Size;
import input.Input;
import input.Movement;
import utility.Vector2D;
//Classe utilizzata per gestire il player.Utilizza Input, Movement e Vector 2D.
//Figlia di Entyty, quindi controllare la mommy. Viene richiamata dal Game
public class Player extends Entity {

    //attributi + quelli ereditati da Entity
    Movement movement;
    Camera camera;
    int spriteTiming = 0;
    int spriteSide = 1;
    Image frame;
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
        getHitBox().translate(width/4, height/4);
        getHitBox().setSize(width/2, height/2);
        movement = new Movement(input);

        //setting animations
        String[] movingLeft = {"icons/hero/movingRight/movingRight1.png",
                                "icons/hero/movingRight/movingRight2.png"};
        String[] movingRight = {"icons/hero/movingRight/movingRight2.png",
                                "icons/hero/movingRight/movingRight1.png"};
        super.setSprites(movingLeft, movingRight);
    }
    

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
        
        Vector2D vector = movement.getVector2d();
        movement.update_position(this);

        //Metodi settaggi della posizione del player(Appartiene ad entità)
        setX((int)vector.getX());
        setY((int)vector.getY());

        setXHitbox((int)vector.getX());
        setYHitbox((int)vector.getY());

        updateSprite();
    }


    public void updateSprite() {

        if(spriteTiming > 10)
        {
            if(movement.getDirectionX() == 1)
                if(spriteSide == 1) {
                    setFrame(movingRight[0]);
                    spriteSide = 2;
                }    
                else {
                    setFrame(movingRight[1]);
                    spriteSide = 1;
                }    
            else //è fermo oppure va a sinistra
                if(spriteSide == 1) {
                    setFrame(movingLeft[0]);
                    spriteSide = 2;
                }    
                else {
                    setFrame(movingLeft[1]);
                    spriteSide = 1;
                }    
                
            spriteTiming = 0;
        }
        spriteTiming++;

    }


    public Size getCameraSize() {return camera.size;}

    public Position getCameraPos() {return camera.position;}

}
