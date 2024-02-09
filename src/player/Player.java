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
    //contiene i movimenti del player
    Movement movement;
    //Position position;
    //Size size;
    //Image icon;

    //Costruttore per creare il player, richiama il costruttore dell'entità
    //x=posizioni ascisse
    //y=posizioni ordinate
    //widht=lunghezza 
    //height=altezza
    //imgSrc=percorso dell'immagine
    public Player(int x, int y, int width, int height, String imgSrc, Input input) {
        super(x, y, width, height, imgSrc);
        movement = new Movement(input);
    }
    

    public boolean collisionX(Position pos, Size size, int dX) {

        if(getX()+getWidth()+dX >= pos.getX()
        && getX()+dX <= pos.getX()+size.getWidth()) 
            return true;

        return false;
    }

    public boolean collisionY(Position pos, Size size, int dY) {

        if(getY()+getHeight()+dY >= pos.getY()
        && getY()+dY <= pos.getY()+size.getHeight()) 
            return true;

        return false;
    }

    //Methodo per far muovere il player, passato Input, crea un nuovo Vector2D e aggiorna le direzioni di movement
    public void move() {
        
        Vector2D vector = movement.getVector2d();
        movement.update_position(this);

        //Metodi settaggi della posizione del player(Appartiene ad entità)
        setX((int)vector.getX());
        setY((int)vector.getY());
    }

}
