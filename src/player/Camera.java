/*
 * classe Camera è relativa ad un oggetto entita'
 * la Camera ha una poszione x,y fissa al centro dello schermo
 * ha una dimensione Size fissa
 * ha un'osservatore che tiene al suo interno
 * 
 * camera_collision controlla che l'osservatore rimanga dentro la camera
 */
package player;

import entity.Position;
import entity.Size;

public class Camera {
    
    Position position;
    Size size;
    Player observer;


    public Camera(int x, int y, int width, int height, Player observer) {
        position = new Position(x, y);
        size = new Size(width, height);
        this.observer = observer;
    }


    public void keepInside() {

        boolean xCollision = observer.collisionX(position, size, observer.movement.getDirectionX());
        boolean yCollision = observer.collisionY(position, size, observer.movement.getDirectionY());

        if(xCollision && yCollision)
        {
            observer.movement.setDirectionX(0);
            observer.movement.setDirectionY(0);
            System.out.println("scimmia");
        }
    }
    


}
