package input;

import utility.Vector2D;

public class Movement {
    
    Input input;
    Vector2D vector;

    public Movement() {
        input = new Input();
        vector = new Vector2D(0, 0);
    }


    public void update_position() {

        int deltaX = 0;
        int deltaY = 0;

        if(input.getKeyState(87)) //VK_W is pressed 
            deltaY = -1;    
        if(input.getKeyState(65)) //VK_A is pressed
            deltaX = -1; 
        if(input.getKeyState(83)) //VK_S is pressed
            deltaY = 1;   
        if(input.getKeyState(68)) //VK_D is pressed
            deltaX = 1;   

        vector.setX(deltaX);
        vector.setY(deltaY);

        vector.normalize();
        vector.multiply(5);

        System.out.println(vector.toString());
    }

    public Vector2D getVector2d() { return vector; }

}
