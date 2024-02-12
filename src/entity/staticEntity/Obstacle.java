package entity.staticEntity;

import java.awt.Image;

import javax.swing.ImageIcon;


public class Obstacle extends StaticEntity {

    public Obstacle(int x, int y, int width, int height) {
        //creo l'ostacolo come entita'
        super(x, y, width, height);

        //setting the sprite
        setFrame(new ImageIcon("icons/enemy/shinobuPadoru.jpg").getImage().
        getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING));

        setVisible(true);
    }


    


}
