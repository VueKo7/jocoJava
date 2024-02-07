package entity;

import javax.swing.ImageIcon;
import utility.Vector2D;

public class Entity {
    
    //an Entity object has a position and a size
    private Position position;
    private Size size;
    private Vector2D vector;
    private ImageIcon icon;


    public Entity(Position pos, Size size, ImageIcon img) {
        
        //setting position
        position.setX(pos.getX());
        position.setY(pos.getY());

        //setting size
        setSize(size);

        //setting icon
        setIcon(img);
    }































    public Size getSize() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
    }

    public Vector2D getVector() {
        return vector;
    }
    public void setVector(Vector2D vector) {
        this.vector = vector;
    }

    public ImageIcon getIcon() {
        return icon;
    }
    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
}
