package entity;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.util.ArrayList;


public abstract class Entity {
    
    int screenWidth = 1280;
    int screenHeight = 720;

    //an Entity has a Position, Size and an Img
    private Position position;
    private Size size;
    private Image icon;
    private Rectangle hitBox;

    //gestisco tutte le entita'
    static ArrayList<Entity> entities = new ArrayList<>();;


    public Entity(int x, int y, int width, int height, String imgSrc) {
        
        //setting position
        position = new Position(x, y);

        //setting size
        size = new Size(width, height);

        //setting hitbox
        hitBox = new Rectangle();

        //setting icon
        icon = new ImageIcon(imgSrc).getImage().
        getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);
    }


//************************************************************* */
    public boolean collisionX(Entity entity, int dX) {

        return ((getX()+getWidth()+dX) >= entity.getX()
        && (getX()+dX) <= (entity.getX()+entity.getWidth())); 
    
    }

    public boolean collisionY(Entity entity, int dY) {

        return ((getY()+getHeight()+dY) >= entity.getY()
        && (getY()+dY) <= (entity.getY()+entity.getHeight())); 
        
    }
//********************************************************* */

    //entities ArrayList
    public static void addEntity(Entity e) {entities.add(e);}
    public static ArrayList<Entity> getEntities() {return entities;}


    //get height
    public int getHeight() {return size.getHeight();}
    //get width
    public int getWidth() {return size.getWidth();}


    //get&set image
    public Image getIcon() { return icon; }
    public void setIcon(Image icon) {
        this.icon = icon;
    }


    //set&get positionX
    public int getX() { return position.getX(); }
    public void setX(int x) {position.setX(x);}


    //set&get positionY
    public int getY() {return position.getY();}
    public void setY(int y) {position.setY(y);}


    //hitbox
    public Rectangle getHitBox() {return hitBox;}
    public void setHitBox(Rectangle hitBox) {this.hitBox = hitBox;}


    @Override
    public String toString() {return "{}" + getX() + "," + getY() + "}";}
}
