package game;
import entity.Entity;
import entity.dinamicEntity.Camera;
import entity.dinamicEntity.player.Player;
import entity.staticEntity.Obstacle;
import input.MovesetInput;
import input.GUI_Input;
import input.MouseInput;

public class Game {

    Player player;
    Thread playerThread;

    Obstacle wall;
    Obstacle wall1;
    
    MovesetInput movesetInput;
    MouseInput mouseInput;
    GUI_Input GUI_input;
    Display display;
    Camera camera;


    public Game() {

        //input viene passato al frame per addKeyListener()
        movesetInput = new MovesetInput();
        mouseInput = new MouseInput();
        GUI_input = new GUI_Input();
        display = new Display(movesetInput, mouseInput, GUI_input);

        player = new Player(display.getWidth()/2, display.getHeight()/2, 100, 150, movesetInput, mouseInput, GUI_input);
        playerThread = new Thread(player);
        playerThread.start();


        wall = new Obstacle(300, 500, 2000, 50);
        wall1 = new Obstacle(300, 200, 200, 50);
        
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
