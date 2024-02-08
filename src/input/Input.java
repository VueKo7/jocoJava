package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Input implements KeyListener, MouseListener {

    //input buffer
    public boolean[] keyBuffer;

    //costruttore
    public Input() { 
        keyBuffer = new boolean[255]; 
    }


    //main method to get the single state of a key
    public boolean getKeyState(int i) { return keyBuffer[i]; }

    @Override
    public void keyPressed(KeyEvent e) { keyBuffer[e.getKeyCode()] = true; }
    
    @Override
    public void keyReleased(KeyEvent e) { keyBuffer[e.getKeyCode()] = false; }


//not needed

    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
