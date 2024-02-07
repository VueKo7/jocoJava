import javax.swing.JFrame;

public class MyFrame extends JFrame{

    public MyFrame(final int BOARD_WIDTH,final int BOARD_HEIGHT) {
	    this.setSize(BOARD_WIDTH, BOARD_HEIGHT); //set Width & Height
        this.setLocationRelativeTo(null); //Center the Frame
        this.setResizable(false); //if resizable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //press X on close

        MyPanel panel = new MyPanel(BOARD_WIDTH, BOARD_HEIGHT); //Create the Panel with same DIM as Frame
        this.add(panel); //Adding the Panel to the Frame
        this.pack(); //Force the Panel to fit into the Frame
        panel.requestFocus();
        this.setVisible(true); //if Frame is Visible
    }

}