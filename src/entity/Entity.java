package entity;

import java.awt.Image;
import javax.swing.ImageIcon;

import input.Input;

public abstract class Entity {
    
    //an Entity has a position and a size
    private Position position;
    private Size size;
    private Image icon;


    public Entity(int x, int y, int width, int height, String imgSrc) {
        
        //setting position
        position = new Position(x, y);

        //setting size
        size = new Size(width, height);

        //setting icon
        icon = new ImageIcon(imgSrc).getImage().
        getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);
    }


    //adding moving methods
    public abstract void move(Input input);

    public boolean collision(Entity e) {
    
        if(getX() == e.getX()+1 || getX() == e.getX()-1
        && getY() == e.getY()+1 || getY() == e.getY()-1) {
            return true;
        }
        return false;
    }


    public int getHeight() {return size.getHeight();}
    public int getWidth() {return size.getWidth();}

    public Image getIcon() { return icon; }
    public void setIcon(Image icon) {
        this.icon = icon;
    }

    public Position getPosition() { return position; }
    public void setPosition(int x, int y) {
        this.position.setX(x);
        this.position.setY(y);
    }

    //set&get X
    public int getX() { return position.getX(); }
    public void setX(int x) {
        position.setX(x);
    }
    //set&get Y
    public int getY() { return position.getY(); }
    public void setY(int y) {
        position.setY(y);
    }
}
