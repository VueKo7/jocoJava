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

public class Camera {
    

    Rectangle cameraArea;


    public Camera(int x, int y, int width, int height) {
        cameraArea = new Rectangle(x, y, width, height);
        //this.observer = observer;
    }


    public boolean engage() {


        return true;

    }







    
    public void setY(int y) {this.cameraArea.y += y;}  
    public int getY() {return cameraArea.y;}

    public void setX(int x) {this.cameraArea.x += x;}
    public int getX() {return cameraArea.x;}

    public int getWidth() {return cameraArea.width;}
    public int getHeight() {return cameraArea.height;}
}
