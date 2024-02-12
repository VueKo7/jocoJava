/*
 * classe Camera è relativa ad un oggetto entita'
 * la Camera ha una poszione x,y fissa al centro dello schermo
 * ha una dimensione Size fissa
 * ha un'osservatore che tiene al suo interno
 * 
 * camera_collision controlla che l'osservatore rimanga dentro la camera
 */
package entity.dinamicEntity.player;

import java.awt.Rectangle;

import entity.Position;
import entity.Size;

public class Camera {
    
    Position position;
    Size size;
    Rectangle cameraArea;
    Player observer;


    public Camera(int x, int y, int width, int height) {
        position = new Position(x, y);
        size = new Size(width, height);
        cameraArea = new Rectangle(x, y, width, height);
        //this.observer = observer;
    }


    

    public int getX() {return position.getX();}
    public int getY() {return position.getY();}

    public int getWidth() {return size.getWidth();}
    public int getHeight() {return size.getHeight();}


}
