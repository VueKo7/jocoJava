package entity;

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
    public Player(int x, int y, int width, int height, String imgSrc) {
        super(x, y, width, height, imgSrc);
        movement = new Movement();
    }
    


    //Methodo per far muovere il player, passato Input, crea un nuovo Vector2D e aggiorna le direzioni di movement
    public void move(Input input) {
    
        Vector2D vector = movement.getVector2d();
        //methodo del Movement
        movement.update_position(input);

        //Metodi settaggi della posizione del player(Appartiene ad entità)
        setX((int)vector.getX());
        setY((int)vector.getY());
             
    }
}
