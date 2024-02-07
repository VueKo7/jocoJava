package entity;

import utility.Vector2D;

public class Player extends Entity {


    public Player(int x, int y, int width, int height, String imgSrc) {
        super(x, y, width, height, imgSrc);
    }
    





    @Override
    public void move(Vector2D vector) {

        setX((int)vector.getX());
        setY((int)vector.getY());
    }

    @Override
    public boolean collision(Entity e) {
        return true;
    }

    


    public Vector2D getVector() {
        return vector;
    }
    public void setVector(Vector2D vector) {
        this.vector = vector;
    }
}
