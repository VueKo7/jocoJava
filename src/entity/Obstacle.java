package entity;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import utility.MyPanel;

public class Obstacle extends Entity {

    MyPanel panel;

    public Obstacle(int x, int y, int width, int height) {
        //creo l'ostacolo come entita'
        super(x, y, width, height);

        panel = new MyPanel(x, y, width, height);
        setHitBox(new Rectangle(x, y, width, height));

        //setting the img
        setFrame(new ImageIcon("icons/enemy/shinobuPadoru.jpg").getImage().
        getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING));
    }


    public void setVisible(boolean b) { panel.setVisible(b); }


}
