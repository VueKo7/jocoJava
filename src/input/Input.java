package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//La classe Imput permette di ricavare, tramite il keyBuffer, uno stato rispetto alla condizione 
//di un tasto(premuto, rilasciato o mai premuto e quindi mai rilasciato)
//Viene usata dalla classe Movement e dalla classe Game
public class Input implements KeyListener, MouseListener {

    //input buffer
    //array contentente gli stati dei tasti(sia come tastiera che come mouse)
    //se in posizione i contiene true, allora in quella posizione il tasto è premuto
    //se in posizione i contiene false, allora in quella posizione il tasto è stato rilasciato
    //se in posizione i contiene null, allora in quella posizione il tasto non è stato mai premuto
    public boolean[] keyBuffer;

    //costruttore che inzializza il keyBuffer 
    public Input() { 
        keyBuffer = new boolean[255]; 
    }


    //Metodo principale per ricavare lo stato di un tasto
    public boolean getKeyState(int i) { return keyBuffer[i]; }
    
    //Metodi chiamato quando è presente un evento della tastiera

    //Metodo che quando un tasto è premuto, ricava la sua posizone e la setta true nel keyBuffer
    @Override
    public void keyPressed(KeyEvent e) { keyBuffer[e.getKeyCode()] = true; }
    //Metodo che quando un tasto è rilasciato, ricava la sua posizone e la setta false nel keyBuffer
    @Override
    public void keyReleased(KeyEvent e) { keyBuffer[e.getKeyCode()] = false; }


//not needed

    //Metodo che quando un tasto è cliccato(premuto e rilasciato in contemporanea)...
    @Override
    public void keyTyped(KeyEvent e) {}

    //Metodi chiamato quando è presente un evento del mouse

    //Metodo che quando un tasto è cliccato(premuto e rilasciato in contemporanea)...
    @Override
    public void mouseClicked(MouseEvent e) {}
    //Metodo che quando un tasto è premuto,
    @Override
    public void mousePressed(MouseEvent e) {}
    //Metodo che quando un tasto è rilasciato,
    @Override
    public void mouseReleased(MouseEvent e) {}
    //Metodo che quando il cursore entra in una zona...
    @Override
    public void mouseEntered(MouseEvent e) {}
    //Metodo che quando il cursore esce da una zona...
    @Override
    public void mouseExited(MouseEvent e) {}
}
