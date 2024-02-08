package input;

import utility.Vector2D;
import java.awt.event.KeyEvent;


public class Movement {

    Vector2D vector;

    public Movement() {
        vector = new Vector2D(0, 0);
    }


    public void update_position(Input input) {

        int deltaX = 0;
        int deltaY = 0;

        if(input.getKeyState(KeyEvent.VK_W)) //VK_W is pressed 
            deltaY = -1;    
        if(input.getKeyState(KeyEvent.VK_A)) //VK_A is pressed
            deltaX = -1; 
        if(input.getKeyState(KeyEvent.VK_S)) //VK_S is pressed
            deltaY = 1;   
        if(input.getKeyState(KeyEvent.VK_D)) //VK_D is pressed
            deltaX = 1;   

        vector = new Vector2D(deltaX, deltaY);
        vector.normalize();
        vector.multiply(10);

        System.out.println(vector.toString());
    }

    public Vector2D getVector2d() { return vector; }

}
