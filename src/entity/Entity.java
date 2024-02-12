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
    private Rectangle hitBox;

    //animazioni
    public Image[] movingRight;
    public Image[] movingLeft;
    public Image frame;
    
    //gestisco tutte le entita'
    static ArrayList<Entity> entities = new ArrayList<>();


    public Entity(int x, int y, int width, int height) {
        
        //setting position
        position = new Position(x, y);

        //setting size
        size = new Size(width, height);

        //setting hitbox
        hitBox = new Rectangle(x, y, width, height);

    }

    //COLLISIONI
//************************************************************* */
    public boolean collisionX(Entity entity, int dX) {

        int playerX = getHitBox().x;
        int playerWidth = getHitBox().width;

        int entityX = entity.getHitBox().x;
        int entityWidth = entity.getHitBox().width;

        return (playerX+playerWidth+dX >= entityX-dX && playerX+dX <= entityX+entityWidth-dX); 
    }

    public boolean collisionY(Entity entity, int dY) {

        int playerY = getHitBox().y;
        int playerHeight = getHitBox().height;

        int entityY = entity.getHitBox().y;
        int entityHeight = entity.getHitBox().height;

        return (playerY+playerHeight+dY >= entityY-dY && playerY+dY <= entityY+entityHeight-dY); 
        
    }
//********************************************************* */

    

    public void setSprites(String[] movingLeft, String[] movingRight) {

        this.movingLeft = new Image[2];
        this.movingRight = new Image[2];

        this.movingRight[0] = new ImageIcon(movingRight[0]).getImage().
            getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING);
        this.movingRight[1] = new ImageIcon(movingRight[1]).getImage().
            getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING);

        this.movingLeft[0] = new ImageIcon(movingLeft[0]).getImage().
            getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING);
        this.movingLeft[1] = new ImageIcon(movingLeft[1]).getImage().
            getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING);
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


    //get&set image
    public Image[] movingLeftImages() {return movingLeft;}
    public Image[] movingRightImages() {return movingRight;}


    //set&get positionX
    public int getX() {return position.getX();}
    public void setX(int x) {position.setX(x);}


    //set&get positionY
    public int getY() {return position.getY();}
    public void setY(int y) {position.setY(y);}


    //hitbox
    public Rectangle getHitBox() {return hitBox;}
    public void setHitBox(Rectangle hitBox) {this.hitBox = hitBox;}

    public int getXHitbox() {return this.hitBox.x;}
    public void setXHitbox(int x) {this.hitBox.x += x;}

    public int getYHitbox() {return this.hitBox.y;}
    public void setYHitbox(int y) {this.hitBox.y += y;}

    public int getHitBoxWidth() {return (int)hitBox.getWidth();}
    public int getHitBoxHeight() {return (int)hitBox.getHeight();}


    @Override
    public String toString() {return "{" + getX() + "," + getY() + "}";}
}
