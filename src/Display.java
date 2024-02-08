import input.Input;

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

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        graphics.drawImage(
            game.hero.getIcon(),
            game.hero.getX(),
            game.hero.getY(),
            null
        );

        graphics.dispose();
        bufferStrategy.show();
    }
}
