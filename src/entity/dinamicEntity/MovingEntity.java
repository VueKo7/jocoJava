package entity.dinamicEntity;

import java.awt.Image;

import javax.swing.ImageIcon;

import entity.Entity;

public abstract class MovingEntity extends Entity implements Runnable, Movement {

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
    private int facing = 0;

    //to make the frame change
    private int spriteTiming = 0;
    private int spriteSide = 1; //defoult

    //to Interact whit other entities
    Camera camera;


    public MovingEntity(int x, int y, int width, int height) {
        super(x, y, width, height);
        vector = new Vector2D(0, 0);
        setDinamic(true);
    }








        //COLLISIONI
//************************************************************* */
    public boolean collisionX(Entity entity, int dX) {

        int playerX = getHitBox().x;
        int playerWidth = getHitBox().width;

        int entityX = entity.getHitBox().x;
        int entityWidth = entity.getHitBox().width;

        return (playerX+playerWidth+dX >= entityX && playerX+dX <= entityX+entityWidth); 
    }

    public boolean collisionY(Entity entity, int dY) {

        int playerY = getHitBox().y;
        int playerHeight = getHitBox().height;

        int entityY = entity.getHitBox().y;
        int entityHeight = entity.getHitBox().height;

        return (playerY+playerHeight+dY >= entityY && playerY+dY <= entityY+entityHeight); 
    }
//********************************************************* */








        //SETTING SPRITES
//********************************************************* */

    //imposto i frame dello sprite quando è fermo
    public void setStillSprites(String[] standingStill) {

        this.standingStill = new Image[2];

        this.standingStill[0] = new ImageIcon(standingStill[0]).getImage().
            getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING);
        this.standingStill[1] = new ImageIcon(standingStill[1]).getImage().
            getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING);
    }

    //imposto i frame dello sprite quando si muove a sinistra
    public void setLeftSprites(String[] movingLeft) {

        this.movingLeft = new Image[2];

        this.movingLeft[0] = new ImageIcon(movingLeft[0]).getImage().
            getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING);
        this.movingLeft[1] = new ImageIcon(movingLeft[1]).getImage().
            getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING);
    }

    //imposto i frame dello sprite quando si muove a destra
    public void setRightSprites(String[] movingRight) {

        this.movingRight = new Image[2];

        this.movingRight[0] = new ImageIcon(movingRight[0]).getImage().
            getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING);
        this.movingRight[1] = new ImageIcon(movingRight[1]).getImage().
            getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING);
    }

    //imposto il currentFrame in base alla direzione
    public void update_sprite() {

        //determina ogni quanti clock cambia lo sprite cambia frame 
        if(spriteTiming > 10)
        {
            if(facing == 1) //va a destra
            {
                if(spriteSide == 1) {
                    setFrame(movingRight[0]);
                    spriteSide = 2;
                }    
                else {
                    setFrame(movingRight[1]);
                    spriteSide = 1;
                }    
            }
            else if(facing == -1) //va a sinistra 
            {
                if(spriteSide == 1) {
                    setFrame(movingLeft[0]);
                    spriteSide = 2;
                }    
                else {
                    setFrame(movingLeft[1]);
                    spriteSide = 1;
                }    
            }
            else if(facing == 0) //è fermo
            { 
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
//********************************************************* */


    public void update_camera() {
        
        camera.setX(directionX*speed);
        camera.setY(directionY*speed);

    }






    public void setCamera(Camera camera) {this.camera = camera;}
    public Camera getCamera() {return camera;}

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

    public void setFacing(int facing) {this.facing = facing;}
    public int getFacing() {return facing;}


    //metodi che verranno sovrascritti da player/mostro/npc
    public abstract void run();
    public abstract void move();
    public abstract void update_position();
    public abstract int calcXdirection();
    public abstract int calcYdirection();
}
