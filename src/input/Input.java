package input;

import java.awt.event.*;

public class Input implements ActionListener, KeyListener, MouseListener {

    private boolean[] keyBuffer = new boolean[255];





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


    public boolean getKeyBuffer(int i) {
        return keyBuffer[i];
    }


    public void setKeyBuffer(boolean[] keyBuffer) {
        this.keyBuffer = keyBuffer;
    }


}
