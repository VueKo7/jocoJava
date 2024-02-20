package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {


    private boolean[] clickBuffer;


    public MouseInput() {
        clickBuffer = new boolean[10];
    }


    public boolean getClickState(int nButton) {return clickBuffer[nButton];}


    //Metodo che quando un tasto è cliccato(premuto e rilasciato in contemporanea)...
    @Override
    public void mouseClicked(MouseEvent e) {  } //clickBuffer[e.getButton()] = true;
    //Metodo che quando un tasto è premuto,
    @Override
    public void mousePressed(MouseEvent e) { clickBuffer[e.getButton()] = true; }
    //Metodo che quando un tasto è rilasciato,
    @Override
    public void mouseReleased(MouseEvent e) { clickBuffer[e.getButton()] = false; }
    


//not needed    
    //Metodo che quando il cursore entra in una zona...
    @Override
    public void mouseEntered(MouseEvent e) {}
    //Metodo che quando il cursore esce da una zona...
    @Override
    public void mouseExited(MouseEvent e) {}


    public void setClickState(int i, boolean b) {clickBuffer[i] = b;}    
}
