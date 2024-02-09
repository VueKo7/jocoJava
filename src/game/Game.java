package game;
import entity.Entity;
import entity.Obstacle;
import input.Input;
import player.Camera;
import player.Player;

public class Game {


    Player hero;

    Obstacle wall;
    
    Input input;
    Display display;
    Camera camera;

    public Game() {

        //input viene passato al frame per addKeyListener()
        input = new Input();
        display = new Display(input);

        hero = new Player(display.getWidth()/2, display.getHeight()/2, 50, 50, "icons/hero/hero.png", input);
        camera = new Camera(display.getWidth()/4, display.getHeight()/4, display.getWidth()/2, display.getHeight()/2, hero);


        wall = new Obstacle(300, 500, 200, 50, "icons/enemy/shinobuPadoru.jpg");
        wall.setVisible(true);
        
        Entity.addEntity(wall);
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
        
        hero.move();

        hero.toString();
    }
}
