/*
 * classe Camera è relativa ad un oggetto entita'
 * la Camera ha una poszione x,y fissa al centro dello schermo
 * ha una dimensione Size fissa
 * ha un'osservatore che tiene al suo interno
 * 
 * camera_collision controlla che l'osservatore rimanga dentro la camera
 */
package entity.dinamicEntity;

import java.awt.Rectangle;

import entity.Entity;
import game.Display;


public class Camera {
    
    private Rectangle cameraArea;
    Entity observer;


    public Camera(int x, int y, int width, int height, Entity observer) {
        cameraArea = new Rectangle(x, y, width, height);
        this.observer = observer;
    }



    //MOVES THE CAMERA IN RELATION OF THE DISPLAY DIM
//******************************************************************************************** */





    
    //CAMERA TO FRAME_DISPLAY COLLISION
//******************************************************************************************** */
    public boolean frame_collisionX(int dX) {
        
        return (getX()+dX <= 0 //from left to right
        || getX()+getWidth()+dX >= Display.BOARD_WIDTH); //form right to left
    }

    public boolean frame_collisionY(int dY) {
        
        return (getY()+dY <= 0 //from down to up
        || getY()+getHeight()+dY >= Display.BOARD_HEIGHT); //from up to down
    }
 

            //ENTITY TO CAMERA COLLISION(ENGAGE)
//******************************************************************************************** */
/*
public boolean camera_collisionX(MovingEntity e) {

    return (observer.getX()+observer.getDirectionX()*observer.getSpeed() <= getX() //from left to right
    || observer.getX()+observer.getWidth()+e.getDirectionX()*observer.getSpeed() >= getX()+getWidth()); //form right to left
}

public boolean camera_collisionY(MovingEntity e) {

    return (observer.getY()+observer.getDirectionY()*observer.getSpeed() <= getY() //from down to up
    || observer.getY()+observer.getHeight()+observer.getDirectionY()*observer.getSpeed() >= getY()+getHeight()); //from up to down
}
//******************************************************************************************** */

        //COLLISIONI
//************************************************************* */
    public boolean collisionX(Entity entity, int dX) {

        int observerX = observer.getHitBox().x;
        int observerWidth = observer.getHitBox().width;

        int entityX = entity.getHitBox().x;
        int entityWidth = entity.getHitBox().width;

        return (observerX+observerWidth+dX >= entityX && observerX+dX <= entityX+entityWidth); 
    }

    public boolean collisionY(Entity entity, int dY) {

        int observerY = observer.getHitBox().y;
        int observerHeight = observer.getHitBox().height;

        int entityY = entity.getHitBox().y;
        int entityHeight = entity.getHitBox().height;

        return (observerY+observerHeight+dY >= entityY && observerY+dY <= entityY+entityHeight); 
    }
//********************************************************* */

    public void update_position(int x, int y) {cameraArea.translate(x, y);}
    
    public void setY(int y) {cameraArea.y += y;}  
    public int getY() {return cameraArea.y;}

    public void setX(int x) {cameraArea.x += x;}
    public int getX() {return cameraArea.x;}

    public int getWidth() {return cameraArea.width;}
    public int getHeight() {return cameraArea.height;}

    public Rectangle getCameraArea() {return cameraArea;}
    public void setCameraArea(Rectangle cameraArea) {this.cameraArea = cameraArea;}
}
