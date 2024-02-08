import entity.Player;
import input.Input;

public class Game {

    Player hero;

    //game logic
    
    Input input;
    Display display;

    public Game() {

        //input viene passato al frame per addKeyListener()
        input = new Input();
        display = new Display(input);

        hero = new Player(5, 5, 100, 100, "icons/hero/hero.png");
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
        //if(hero.collision(hero))
            hero.move(input);
    }

}
