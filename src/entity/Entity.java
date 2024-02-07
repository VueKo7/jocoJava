package entity;

import javax.swing.ImageIcon;
import utility.Vector2D;

public class Entity extends Position {
    
    //an Entity object has a position and a size
    private Size size;
    private Vector2D vector;
    private ImageIcon icon;


    public Entity(Position pos, Size size, ImageIcon img) {
        
        //setting position
        super(pos.getX(), pos.getY());

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
}
