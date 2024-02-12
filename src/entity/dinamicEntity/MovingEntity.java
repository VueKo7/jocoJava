package entity.dinamicEntity;

import java.awt.Image;

import javax.swing.ImageIcon;

import entity.Entity;
import utility.Vector2D;

public class MovingEntity extends Entity{

    //animations
    private Image[] movingRight;
    private Image[] movingLeft;
    private Image[] standingStill;
    //public Image currentFrame;

    //to get Directions
    private Vector2D vector;
    private int speed = 10;
    private int directionX;
    private int directionY;

    //to make the frame change
    private int spriteTiming = 0;
    private int spriteSide = 1; //defoult


    public MovingEntity(int x, int y, int width, int height) {
        super(x, y, width, height);
        vector = new Vector2D(0, 0);
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

    public void setStillSprites(String[] standingStill) {

        this.standingStill = new Image[2];

        this.standingStill[0] = new ImageIcon(standingStill[0]).getImage().
            getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING);
        this.standingStill[1] = new ImageIcon(standingStill[1]).getImage().
            getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING);
    }

    public void setLeftSprites(String[] movingLeft) {

        this.movingLeft = new Image[2];

        this.movingLeft[0] = new ImageIcon(movingLeft[0]).getImage().
            getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING);
        this.movingLeft[1] = new ImageIcon(movingLeft[1]).getImage().
            getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING);
    }

    public void setRightSprites(String[] movingRight) {

        this.movingRight = new Image[2];

        this.movingRight[0] = new ImageIcon(movingRight[0]).getImage().
            getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING);
        this.movingRight[1] = new ImageIcon(movingRight[1]).getImage().
            getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING);
    }


    public void updateSprite() {

        if(spriteTiming > 10)
        {
            if(directionX == 1) //va a destra
                if(spriteSide == 1) {
                    setFrame(movingRight[0]);
                    spriteSide = 2;
                }    
                else {
                    setFrame(movingRight[1]);
                    spriteSide = 1;
                }    
            else if(directionX == -1) //va a sinistra
                if(spriteSide == 1) {
                    setFrame(movingLeft[0]);
                    spriteSide = 2;
                }    
                else {
                    setFrame(movingLeft[1]);
                    spriteSide = 1;
                }    
            else { //è fermo
                if(spriteSide == 1) {
                    setFrame(standingStill[0]);
                    spriteSide = 2;
                }
                else {
                    setFrame(standingStill[1]);
                    spriteSide = 1;
                }
                
            }
                
            spriteTiming = 0;
        }

        spriteTiming++;

    }


    public Image[] getMovingRight() {return movingRight;}
    public void setMovingRight(Image[] movingRight) {this.movingRight = movingRight;}

    public Image[] getMovingLeft() {return movingLeft;}
    public void setMovingLeft(Image[] movingLeft) {this.movingLeft = movingLeft;}

    public Image[] getStandingStill() {return standingStill;}
    public void setStandingStill(Image[] standingStill) {this.standingStill = standingStill;}

    public Vector2D getVector() {return vector;}
    public void setVector(Vector2D vector) {this.vector = vector;}

    public int getSpeed() {return speed;}
    public void setSpeed(int speed) {this.speed = speed;}

    public int getDirectionX() {return directionX;}
    public void setDirectionX(int directionX) {this.directionX = directionX;}

    public int getDirectionY() {return directionY;}
    public void setDirectionY(int directionY) {this.directionY = directionY;}

    public int getSpriteTiming() {return spriteTiming;}
    public void setSpriteTiming(int spriteTiming) {this.spriteTiming = spriteTiming;}

    public int getSpriteSide() {return spriteSide;}
    public void setSpriteSide(int spriteSide) {this.spriteSide = spriteSide;}
}
