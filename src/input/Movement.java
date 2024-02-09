package input;

import utility.Vector2D;
import java.awt.event.KeyEvent;

import entity.Entity;

//Classe che utilizzando il Vectore2D, dove verranno salvate le direzioni di X e Y di un'entità
//Permette di modificare le direzioni in base all'input. Viene richiamata nella classe Player
public class Movement {
    //Creazione di un nuovo Vector2D
    Vector2D vector;
    public int directionX;
    public int directionY;

    //Costruttore che inzializza il vector2D a 0,0(fermo)
    public Movement() {
        vector = new Vector2D(0, 0);
    }

    //Metodo principale che passandogli Input, assegna al Vector2D le direzioni in base agli imput.
    public void update_position(Input input, Entity e) {

        //Attributo contenete la direzione delle ascisse(0=fermo in x, -1=spostamento verso sinistra, 1=spostamento verso destra)
        directionX = 0;
        //Attributo contenete la direzione delle ordinate(0=fermo in y, -1=spostamento verso l'alto, 1=spostamento verso il basso)
        directionY = 0;


        if(input.getKeyState(KeyEvent.VK_W)) //VK_W is pressed
            directionY = -1;    
        else if(input.getKeyState(KeyEvent.VK_S)) //VK_S is pressed
            directionY = 1; 

        if(input.getKeyState(KeyEvent.VK_A)) //VK_A is pressed
            directionX = -1; 
        else if(input.getKeyState(KeyEvent.VK_D)) //VK_D is pressed
            directionX = 1;   
     
        //if(!collision(movement.directionX, movement.directionY))
    
        //inizializzo il Vectore2D passandogli le direzioni x e y
        vector = new Vector2D(directionX, directionY);
        vector.normalize();
        //richiamo la multiply passandogli la velocità desiderata
        vector.multiply(10);
    
        //System.out.println(vector.toString()); //stampo le direzioni 
    }
    //metodo per la ricezione del Vector2D
    public Vector2D getVector2d() { return vector; }

}
