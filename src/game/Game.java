package game;
import entity.Entity;
import entity.dinamicEntity.Camera;
import entity.dinamicEntity.player.Player;

import entity.dinamicEntity.enemy.Enemy;

import entity.staticEntity.Obstacle;
import input.KeyboardInput;
import input.MouseInput;

public class Game {

    Player player;
    Thread playerThread;

    Enemy enemy;
    Thread enemyThread;

    Obstacle wall;
    Obstacle wall1;
    
    KeyboardInput keyboardInput;
    MouseInput mouseInput;
    Display display;
    Camera camera;


    public Game() {

        //input viene passato al frame per addKeyListener()
        keyboardInput = new KeyboardInput();
        mouseInput = new MouseInput();
        display = new Display(keyboardInput, mouseInput);

        player = new Player(display.getWidth()/2, display.getHeight()/2, 100, 150, keyboardInput, mouseInput);
        playerThread = new Thread(player);
        playerThread.start();

        enemy = new Enemy(500, 600, 100, 150);
        enemyThread = new Thread(enemy);
        enemyThread.start();
    
        wall = new Obstacle(300, 500, 2000, 50);
        wall1 = new Obstacle(300, 200, 200, 50);

        Entity.addEntity(enemy);
        Entity.addEntity(wall);
        Entity.addEntity(wall1);
	}	


    //aggiornamento del frame con le Entity di Game
    public void render() {
        display.render(this); //'this' is Game class
    }

    //aggiornamento della posizione del player in base ad input
    //1. Input riceve i dati da tastiera
    //2. Input viene passato alla classe Player tramite il metodo .move(input)
    //3. Input viene passato alla classe Movement
    //4. dalla classe movement ottiene lo stato del keyBuffer
    //5. allora viene aggiornata la Posizione di Player tramite Vector2D
    public void update() {
    

    }
}
