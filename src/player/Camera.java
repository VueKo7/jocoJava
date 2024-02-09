/*
 * classe Camera è relativa ad un oggetto entita'
 * la Camera ha una poszione x,y fissa al centro dello schermo
 * ha una dimensione Size fissa
 * ha un'osservatore che tiene al suo interno
 * 
 * camera_collision controlla che l'osservatore rimanga dentro la camera
 */
package player;

import entity.Entity;
import entity.Position;
import entity.Size;

public class Camera {
    
    Position position;
    Size size;
    Entity observer;


    public Camera(int x, int y, int width, int height, Entity observer) {
        position = new Position(x, y);
        size = new Size(width, height);
        this.observer = observer;
    }


    


}
