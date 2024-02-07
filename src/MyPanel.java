import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener, KeyListener, MouseListener {
    private class Tile {
        float x;
        float y;
        Image img;

        Tile(float x, float y, String imgSrc) {
            this.x = x;
            this.y = y;
            this.img = new ImageIcon(imgSrc).getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_AREA_AVERAGING);
        }
    }

    int boardWidth;
    int boardHeight;
    int tileSize = 20;
    
    //hero
    Tile hero;

    //enemy
    Tile enemy;
    Random random;

    //game logic
    int velocityX;
    int velocityY;
    Timer gameLoop;
    int score = 0;

    boolean gameOver = false;

    public MyPanel(final int BOARD_WIDTH,final int BOARD_HEIGHT) {
        this.boardWidth = BOARD_WIDTH;
        this.boardHeight = BOARD_HEIGHT;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight)); //Panel's DIM x, y
        setBackground(Color.black); //sets bg's color | it can be an image too
        addKeyListener(this); //puts Panel in listen mode for user inputs
        setFocusable(true); //to Interact with this. Panel 
    
        hero = new Tile(5, 5, "icons/hero/hero.png");

        enemy = new Tile(10, 10, "icons/enemy/shinobuPadoru.jpg");
        random = new Random();
        placeEnemy();
        
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
        for(int i = 0; i < boardWidth/tileSize; i++) {
            g.drawLine(i*tileSize, 0, i*tileSize, boardHeight);
            g.drawLine(0, i*tileSize, boardWidth, i*tileSize); 
        }
        

        //Food
        //g.setColor(Color.red);
        //g.fillRect(food.x*tileSize, food.y*tileSize, tileSize, tileSize);
        //g.fill3DRect(enemy.x*tileSize, enemy.y*tileSize, tileSize, tileSize, true);
        g.drawImage(enemy.img, (int)enemy.x*tileSize, (int)enemy.y*tileSize, null);


        //Snake Head
        //g.setColor(Color.green);
        //g.fillRect(snakeHead.x, snakeHead.y, tileSize, tileSize);
        //g.fillRect(snakeHead.x*tileSize, snakeHead.y*tileSize, tileSize, tileSize);
        //g.fill3DRect(hero.x*tileSize, hero.y*tileSize, tileSize, tileSize, true);
        g.drawImage(hero.img, (int)hero.x*tileSize, (int)hero.y*tileSize, null);
		
        //Score
        g.setFont(new Font("Arial", Font.ITALIC, 16));
        if(collision(hero, enemy)) {
            score++;
            placeEnemy();
        }
        //String.valueOf(score)
        g.drawString("Score: " + score, 0, tileSize);
	}

    public void placeEnemy() {
        enemy.x = random.nextInt(boardWidth/tileSize);
		enemy.y = random.nextInt(boardHeight/tileSize);
	}

    public boolean collision(Tile tile1, Tile tile2) {
        return tile1.x == tile2.x && tile1.y == tile2.y;
    }

    @Override
    public void actionPerformed(ActionEvent e) { //called every x milliseconds by gameLoop timer
        if (gameOver) {
            gameLoop.stop();
        }
    }  

    @Override
    public void keyPressed(KeyEvent e) {     
        
        if (e.getKeyCode() == KeyEvent.VK_W) {
            if(hero.y*tileSize > 0)
                velocityY = -1;  
        }
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            if(hero.y*tileSize < boardHeight-tileSize)
                velocityY = 1;
        }
        else if (e.getKeyCode() == KeyEvent.VK_A) {
            if(hero.x*tileSize > 0)
                velocityX = -1;
        }
        else if (e.getKeyCode() == KeyEvent.VK_D) {
            if(hero.x*tileSize < boardWidth-tileSize)
                velocityX = 1;
        }

        //RIGHT-TOP
        if(velocityX == 1 && e.getKeyCode() == KeyEvent.VK_W) {
            velocityY = -1;
        }
        //RIGHT-BOTTOM
        else if(velocityX == 1 && e.getKeyCode() == KeyEvent.VK_S) {
            velocityY = 1;
        }
        //LEFT-TOP
        else if(velocityX == -1 && e.getKeyCode() == KeyEvent.VK_W) {
            velocityY = -1;
        }
        //LEFT-BOTTOM
        else if(velocityX == -1 && e.getKeyCode() == KeyEvent.VK_S) {
            velocityY = 1;
        }
        
        hero.x += velocityX;
        hero.y += velocityY;
    }

    
    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_W ||
            e.getKeyCode() == KeyEvent.VK_S) {
                velocityY = 0;
        }

        if(e.getKeyCode() == KeyEvent.VK_D ||
            e.getKeyCode() == KeyEvent.VK_A) {
                velocityX = 0;
        }
    }


//not needed

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
