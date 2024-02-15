package entity;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;


public abstract class Entity {

    //an Entity has a Position, Size and and a Sprite
    private Position position;
    private Size size;
    private Rectangle hitBox;
    private boolean dinamic;
    private int hp;

    //Frame dello sprite che verrà disegnato
    public Image frame;
    
    //gestisco tutte le entita'
    static ArrayList<Entity> entities = new ArrayList<>();


    public Entity(int x, int y, int width, int height) {
        
        //setting position
        position = new Position(x, y);

        //setting size
        size = new Size(width, height);

        //setting defoutl hitbox
        //its OverWritten by MovingEntities & StaticEntity
        hitBox = new Rectangle(x, y, width, height);

        //setting hp to default
        hp = 100;

        dinamic = false;

        position.setPoints(this);
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


    //hp
    public int getHp() {return hp;}
    public void setHp(int hp) {this.hp = hp;}


    //dinamic
    public boolean isDinamic() {return dinamic;}
    public void setDinamic(boolean dinamic) {this.dinamic = dinamic;}


    @Override
    public String toString() {return "{" + getX() + "," + getY() + "}";}
}
