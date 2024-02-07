package entity;

import javax.swing.ImageIcon;
import utility.Vector2D;

public abstract class Entity {
    
    //an Entity object has a position and a size
    private Position position;
    private Size size;
    private ImageIcon icon;


    public Entity(Position pos, Size size, String imgSrc) {
        
        //setting position
        position.setX(pos.getX());
        position.setY(pos.getY());

        //setting size
        setSize(size);

        //setting icon
        setIconSrc(imgSrc);
    }


    //adding moving methods

    


    public abstract void move(int x, int y);






















    private void setIconSrc(String imgSrc) {
        setIcon(new ImageIcon(imgSrc));
    }

    public Size getSize() { return size; }
    public void setSize(Size size) {
        this.size = size;
    }

    public ImageIcon getIcon() { return icon; }
    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public Position getPosition() { return position; }
    public void setPosition(Position position) {
        this.position = position;
    }

    public void setX(int x) {
        position.setX(x);
    }
    public void setY(int y) {
        position.setY(y);
    }
}
