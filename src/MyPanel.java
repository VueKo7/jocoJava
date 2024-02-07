import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import entity.Player;
import input.Movement;

public class MyPanel extends JPanel implements ActionListener {
    

    Movement movement;

    Player hero;

    int boardWidth;
    int boardHeight;

    //game logic
    
    Timer gameLoop;
    int score = 0;

    boolean gameOver = false;

    public MyPanel(final int BOARD_WIDTH,final int BOARD_HEIGHT) {
        this.boardWidth = BOARD_WIDTH;
        this.boardHeight = BOARD_HEIGHT;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight)); //Panel's DIM x, y
        setBackground(Color.black); //sets bg's color | it can be an image too

        
        Movement movement = new Movement();

        hero = new Player(5, 5, 20, 20, "icons/hero/hero.png");

        //enemy = new Tile(10, 10, "icons/enemy/shinobuPadoru.jpg");
        //random = new Random();
        //placeEnemy();
        
		//game timer
		gameLoop = new Timer(10, this); //how long it takes to start timer, milliseconds gone between frames| DELTA_TIME???
        gameLoop.start();
	}	
    
    @Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
        repaint();
	}

	public void draw(Graphics g) 
    {    
        //Grid Lines
        /*
        for(int i = 0; i < boardWidth/tileSize; i++) {
            g.drawLine(i*tileSize, 0, i*tileSize, boardHeight);
            g.drawLine(0, i*tileSize, boardWidth, i*tileSize); 
        }
         */

        //Food
        //g.setColor(Color.red);
        //g.fillRect(food.x*tileSize, food.y*tileSize, tileSize, tileSize);
        //g.fill3DRect(enemy.x*tileSize, enemy.y*tileSize, tileSize, tileSize, true);
        //g.drawImage(enemy.img, (int)enemy.x*tileSize, (int)enemy.y*tileSize, null);


        //Snake Head
        //g.setColor(Color.green);
        //g.fillRect(snakeHead.x, snakeHead.y, tileSize, tileSize);
        //g.fillRect(snakeHead.x*tileSize, snakeHead.y*tileSize, tileSize, tileSize);
        //g.fill3DRect(hero.x*tileSize, hero.y*tileSize, tileSize, tileSize, true);
        g.drawImage(hero.getIcon(), 
            hero.getX()*hero.getSize().getWidth(), 
            hero.getY()*hero.getSize().getHeight(), null);
		


        /*
        //Score
        g.setFont(new Font("Arial", Font.ITALIC, 16));   
        if(collision(hero, enemy)) {
            score++;
            placeEnemy();
        }
        //String.valueOf(score)
        g.drawString("Score: " + score, 0, tileSize);
         */
    }

    /*
    public void placeEnemy() {
        enemy.x = random.nextInt(boardWidth/tileSize);
		enemy.y = random.nextInt(boardHeight/tileSize);
	}
    
    public boolean collision(Tile tile1, Tile tile2) {
        return tile1.x == tile2.x && tile1.y == tile2.y;
    }
    */

    @Override
    public void actionPerformed(ActionEvent e) { //called every x milliseconds by gameLoop timer
        movement.update_position();
        if(gameOver) {
            gameLoop.stop();
        }
    }


    
}
