/*
 * classe Camera è relativa ad un oggetto entita'
 * la Camera ha una poszione x,y fissa al centro dello schermo
 * ha una dimensione Size fissa
 * ha un'osservatore che tiene al suo interno
 * 
 * camera_collision controlla che l'osservatore rimanga dentro la camera
 */
package player;

import java.awt.Rectangle;

import entity.Position;
import entity.Size;

public class Camera {
    
    Position position;
    Size size;
    Rectangle cameraArea;
    Player observer;


    public Camera(int x, int y, int width, int height, Player observer) {
        position = new Position(x, y);
        size = new Size(width, height);
        cameraArea = new Rectangle(x, y, width, height);
        this.observer = observer;
    }


    public void keepInside() {

        int dX = observer.movement.getDirectionX();
        int dY = observer.movement.getDirectionY();
        int speed = observer.movement.getSpeed();

        boolean xCollision = observer.collisionX(position, size, dX*speed);
        boolean yCollision = observer.collisionY(position, size, dY*speed);

        if(xCollision && yCollision)
        {
            observer.movement.setDirectionX(0);
            observer.movement.setDirectionY(0);
            System.out.println("scimmia");
        }

        if(cameraArea.intersects(observer.getHitBox()));
            
    }
    


}
