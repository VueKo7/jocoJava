package entity;

import input.Input;
import input.Movement;
import utility.Vector2D;

public class Player extends Entity {

    //attributi + quelli ereditati da Entity
    Movement movement;
    //Position position;
    //Size size;
    //Image icon;

    public Player(int x, int y, int width, int height, String imgSrc) {
        super(x, y, width, height, imgSrc);
        movement = new Movement();
    }
    



    public void move(Input input) {
    
        Vector2D vector = movement.getVector2d();
        movement.update_position(input);

        
        setX((int)vector.getX());
        setY((int)vector.getY());
             
    }
}
