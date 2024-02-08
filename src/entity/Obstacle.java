package entity;

import utility.MyPanel;

public class Obstacle extends Entity {

    MyPanel panel;

    public Obstacle(int x, int y, int width, int height, String imgSrc) {

        //creo l'ostacolo come entita'
        super(x, y, width, height, imgSrc);

        panel = new MyPanel(x, y, width, height);
    }


    


    public void setVisible(boolean b) { panel.setVisible(b); }


}
