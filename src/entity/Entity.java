package entity;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import entity.dinamicEntity.Camera;


public abstract class Entity {

    //an Entity has a Position, Size and and a Sprite
    private Position position;
    private Size size;
    private Rectangle hitBox;
    private Camera camera;

    //Frame dello sprite che verrà disegnato
    public Image frame;
    
    //gestisco tutte le entita'
    static ArrayList<Entity> entities = new ArrayList<>();


    public Entity(int x, int y, int width, int height) {
        
        //setting position
        position = new Position(x, y);

        //setting size
        size = new Size(width, height);

        //its OverWritten by MovingEntities & StaticEntity
        hitBox = new Rectangle(x, y, width, height);

        //Camera
        camera = new Camera(getX()/2+getWidth()/2, getY()/2+getHeight()/2, getX(), getY(), this);
    }



    //set&get Frame
    public Image getFrame() {return this.frame;}
    public void setFrame(Image frame) {this.frame = frame;}


    //entities ArrayList
    public static void addEntity(Entity e) {entities.add(e);}
    public static ArrayList<Entity> getEntities() {return entities;}


    //get height
    public int getHeight() {return size.getHeight();}
    //get width
    public int getWidth() {return size.getWidth();}


    //set&get positionX
    public int getX() {return (int)position.getX();}
    public void setX(int x) {position.setX(x);}


    //set&get positionY
    public int getY() {return (int)position.getY();}
    public void setY(int y) {position.setY(y);}

    public Position gePosition() {return position;}


    //hitbox
    public Rectangle getHitBox() {return hitBox;}
    public void setHitBox(Rectangle hitBox) {this.hitBox = hitBox;}

    public int getXHitbox() {return this.hitBox.x;}
    public void setXHitbox(int x) {this.hitBox.x += x;}

    public int getYHitbox() {return this.hitBox.y;}
    public void setYHitbox(int y) {this.hitBox.y += y;}

    public int getHitBoxWidth() {return (int)hitBox.getWidth();}
    public int getHitBoxHeight() {return (int)hitBox.getHeight();}


    public Camera getCamera() {return camera;}
    public void setCamera(Camera camera) {this.camera = camera;}

    


    @Override
    public String toString() {return "{" + getX() + "," + getY() + "}";}



    public Point getPoint() {return new Point(getX(), getY());}
}
