package player;

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

    public Player(int x, int y, int width, int height, String imgSrc, Input input, Camera camera) {
        super(x, y, width, height, imgSrc);
        this.camera = camera;
        getHitBox().translate(width/4, height/4);
        getHitBox().setSize(width/2, height/2);
        movement = new Movement(input);
    }
    

    //******************************************************************************************** */
    public boolean collisionX(Position pos, Size size, int dX) {

        return (getX()+dX <= pos.getX() //from left to right
        || getX()+getWidth()+dX >= pos.getX()+size.getWidth()); //form right to left
            
    }

    public boolean collisionY(Position pos, Size size, int dY) {

        return (getY()+dY <= pos.getY() //from down to up
        || getY()+getHeight()+dY >= pos.getY()+size.getHeight()); //from up to down
            
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
    }




    public Size getCameraSize() {return camera.size;}

    public Position getCameraPos() {return camera.position;}

}
