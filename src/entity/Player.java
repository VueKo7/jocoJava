package entity;

import utility.Vector2D;

public class Player extends Entity {

    //makes the object move
    private Vector2D vector;


    public Player(int x, int y, int width, int height, String imgSrc) {
        super(new Position(x, y), new Size(width, height), imgSrc);
        vector = new Vector2D(x, y);
    }
    





    @Override
    public void move(int x, int y) {}



    public void setX(int x) {
        setX(x);
    }

    public int getX() { return getPosition().getX(); }
    



    public int getY() { return getPosition().getY(); }


    public Vector2D getVector() {
        return vector;
    }
    public void setVector(Vector2D vector) {
        this.vector = vector;
    }
}
