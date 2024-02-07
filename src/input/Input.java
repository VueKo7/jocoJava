package input;

import java.awt.event.*;

import javax.swing.JPanel;

public class Input extends JPanel implements ActionListener, KeyListener, MouseListener {

    //input buffer
    public boolean[] keyBuffer;

    //costruttore
    public Input() { 
        keyBuffer = new boolean[255]; 
        addKeyListener(this);
        setFocusable(true);
    }


    


    //main method to get the single state of a key
    public boolean getKeyState(int i) { return keyBuffer[i]; }


    @Override
    public void keyPressed(KeyEvent e) {     

        if (e.getKeyCode() == KeyEvent.VK_W) {
            keyBuffer[e.getKeyCode()] = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            keyBuffer[e.getKeyCode()] = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_A) {
            keyBuffer[e.getKeyCode()] = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_D) {
            keyBuffer[e.getKeyCode()] = true;
        }

        /*
        //RIGHT-TOP
        if(velocityX == 1 && e.getKeyCode() == KeyEvent.VK_W) {
            velocityY = -1;
        }
        //RIGHT-BOTTOM
        else if(velocityX == 1 && e.getKeyCode() == KeyEvent.VK_S) {
            velocityY = 1;
        }
        //LEFT-TOP
        else if(velocityX == -1 && e.getKeyCode() == KeyEvent.VK_W) {
            velocityY = -1;
        }
        //LEFT-BOTTOM
        else if(velocityX == -1 && e.getKeyCode() == KeyEvent.VK_S) {
            velocityY = 1;
        }
         */
    }

    
    @Override
    public void keyReleased(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_W) {
            keyBuffer[e.getKeyCode()] = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_S) {
            keyBuffer[e.getKeyCode()] = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_D) {
            keyBuffer[e.getKeyCode()] = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_A) {
            keyBuffer[e.getKeyCode()] = false;
        }
    }




//not needed

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

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {}
    
}
