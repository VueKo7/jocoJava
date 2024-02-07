package entity;

import utility.Vector2D;

public class Player extends Entity {


    public Player(int x, int y, int width, int height, String imgSrc) {
        super(x, y, width, height, imgSrc);
    }
    





    @Override
    public void move() {

        setX(getX()+1);
        setY(getY()+1);
    }

    @Override
    public boolean collision(Entity e) {
        return true;
    }

    
}
