package input;

import utility.Vector2D;
import java.awt.event.KeyEvent;

//Classe che utilizzando il Vectore2D, dove verranno salvate le direzioni di X e Y di un'entità
//Permette di modificare le direzioni in base all'input. Viene richiamata nella classe Player
public class Movement {
    //Creazione di un nuovo Vector2D
    Vector2D vector;
    //Costruttore che inzializza il vector2D a 0,0(fermo)
    public Movement() {
        vector = new Vector2D(0, 0);
    }

    //Metodo principale che passandogli Input, assegna al Vector2D le direzioni in base agli imput.
    public void update_position(Input input) {

        //Attributo contenete la direzione delle ascisse(0=fermo in x, -1=spostamento verso sinistra, 1=spostamento verso destra)
        int directionX = 0;
        //Attributo contenete la direzione delle ordinate(0=fermo in y, -1=spostamento verso l'alto, 1=spostamento verso il basso)
        int directionY = 0;
        //Se l'input corrisponde al codice della W, allora sto andando verso l'alto, altrimenti
        if(input.getKeyState(KeyEvent.VK_W)) 
            directionY = -1;
        //Se l'input corrisponde al codice della S, allora sto andando verso il basso, altrimenti    
        else if(input.getKeyState(KeyEvent.VK_S))
            directionY = 1; 
        //Se l'input corrisponde al codice della A, allora sto andando verso sinistra, altrimenti
        if(input.getKeyState(KeyEvent.VK_A)) //VK_A is pressed
            directionX = -1; 
        //Se l'input corrisponde al codice della D, allora sto andando verso destra
        else if(input.getKeyState(KeyEvent.VK_D)) //VK_D is pressed
            directionX = 1;   
        //inizializzo il Vectore2D passandogli le direzioni x e y
        vector = new Vector2D(directionX, directionY);
        //richiamo la normalize
        vector.normalize();
        //richiamo la multiply passandogli la velocità desiseraa
        vector.multiply(10);
        //stampo le direzioni 
        System.out.println(vector.toString());
    }
    //metodo per la ricezione del Vector2D
    public Vector2D getVector2d() { return vector; }

}
