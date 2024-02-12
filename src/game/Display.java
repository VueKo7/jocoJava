package game;
import input.Input;
import entity.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame {

    final int BOARD_WIDTH = 1280;
    final int BOARD_HEIGHT = 720;

    private Canvas canvas;

    public Display(Input input) {
        setTitle("My Awesome 2D game.Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        canvas.setFocusable(false);
        add(canvas);
        addKeyListener(input);
        pack();

        canvas.createBufferStrategy(3);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void render(Game game){
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        //visualizzazione Canvas
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        graphics.setColor(Color.WHITE);
        graphics.drawRect(0, 0, BOARD_WIDTH-1, BOARD_HEIGHT-1);

        //visualizzazione Camera
        graphics.setColor(Color.RED);
        graphics.drawRect(BOARD_WIDTH/4, BOARD_HEIGHT/4, BOARD_WIDTH/2, BOARD_HEIGHT/2);

        //visualizzazione personaggio
        
        //animation
        graphics.drawImage(game.hero.getFrame(), game.hero.getX(), game.hero.getY(), null);
        graphics.setColor(Color.RED);
        graphics.drawRect(game.hero.getXHitbox(), game.hero.getYHitbox(), game.hero.getHitBoxWidth(), game.hero.getHitBoxHeight());

        //visualizzazione entità a schermo
        Entity.getEntities().forEach((Entity e) -> {
            if(canvas.contains(e.getHitBox().getLocation()))
                graphics.drawImage(e.getFrame(), e.getX(), e.getY(), null);
            //System.out.println(e.toString());
        });

        graphics.dispose();
        bufferStrategy.show();
    }


    public int getHeight() {return BOARD_HEIGHT;}
    public int getWidth() {return BOARD_WIDTH;}
}
