package entity;

import java.awt.Image;

import javax.swing.ImageIcon;

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
        icon = new ImageIcon(imgSrc).getImage().getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);
    }


    //adding moving methods
    public abstract void move(int x, int y);

    public abstract boolean collision(Entity e);




















    private void setIconSrc(String imgSrc) {
        setIcon(new ImageIcon(imgSrc).getImage());
    }

    public Size getSize() { return size; }
    public void setSize(Size size) {
        this.size = size;
    }

    public Image getIcon() { return icon; }
    public void setIcon(Image icon) {
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
