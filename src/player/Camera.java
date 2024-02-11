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


    public Camera(int x, int y, int width, int height) {
        position = new Position(x, y);
        size = new Size(width, height);
        cameraArea = new Rectangle(x, y, width, height);
        //this.observer = observer;
    }


    public void keepInside() {

        int dX = observer.movement.getDirectionX();
        int dY = observer.movement.getDirectionY();
        int speed = observer.movement.getSpeed();

        boolean xCollision = observer.collisionX(position, size, dX*speed);
        boolean yCollision = observer.collisionY(position, size, dY*speed);

        System.out.println(xCollision);
        
        //impone che tu NON abbia un'ostacolo a destra/sinistra per fermarti in X
        if(xCollision)
            observer.movement.setDirectionX(0);

        //impone che tu NON abbia un'ostacolo sopra/sotto per fermarti in Y
        if(yCollision)
            observer.movement.setDirectionY(0);
        

        //if(cameraArea.intersects(observer.getHitBox()));
            
    }
    


}
