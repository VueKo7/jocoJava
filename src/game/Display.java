package game;
import input.Input;
import entity.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame {

    public final static int BOARD_WIDTH = 1280;
    public final static int BOARD_HEIGHT = 720;

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
        graphics.drawRect(game.player.getCamera().getX(), game.player.getCamera().getY(), game.player.getCamera().getWidth(), game.player.getCamera().getHeight());


        //visualizzazione personaggio
        graphics.drawImage(game.player.getFrame(), game.player.getX(), game.player.getY(), null);
        
        graphics.setColor(Color.BLUE);
        graphics.drawRect(game.player.getX(), game.player.getY(), game.player.getWidth(), game.player.getHeight());
        
        graphics.setColor(Color.RED);
        graphics.drawRect(game.player.getXHitbox(), game.player.getYHitbox(), game.player.getHitBoxWidth(), game.player.getHitBoxHeight());


        //visualizzazione entità a schermo
        Entity.getEntities().forEach((Entity e) -> {
            
            if(canvas.contains(e.getHitBox().getLocation())) {
                e.setVisible(true);
                graphics.drawImage(e.getFrame(), e.getX(), e.getY(), null);
            }
            else 
                e.setVisible(false);
        });


        graphics.dispose();
        bufferStrategy.show();
    }


    public int getHeight() {return BOARD_HEIGHT;}
    public int getWidth() {return BOARD_WIDTH;}
}
