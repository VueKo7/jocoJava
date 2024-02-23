package entity.staticEntity;

import entity.Entity;
import utility.MyPanel;

public class StaticEntity extends Entity {

    MyPanel panel;

    public StaticEntity(int x, int y, int width, int height) {

        super(x, y, width, height);
        panel = new MyPanel(x, y, width, height);
        setVisible(false);
    }
    

    public boolean isVisibile() {return panel.isVisible();}
    public void setVisible(boolean b) {panel.setVisible(b);}

}
