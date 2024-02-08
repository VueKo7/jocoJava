import entity.Player;
import input.Input;

public class Game {

    Player hero;

    //game logic
    
    Input input;
    MyFrame frame;

    public Game() {

        //input viene passato al frame per addKeyListener()
        input = new Input();
        frame = new MyFrame(input);


        hero = new Player(5, 5, 100, 100, "icons/hero/hero.png");
	}	


    //aggiornamento del frame con le Entity di Game
    public void render() {
        frame.render(this); //'this' is Game class
    }

    //aggiornamento della posizione del player in base ad input
    //1. Input riceve i dati da tastiera
    //2. Input viene passato alla classe Player tramite il metodo .move(input)
    //3. Input viene passato alla classe Movement
    public void update() {
        hero.move(input);
    }

}
