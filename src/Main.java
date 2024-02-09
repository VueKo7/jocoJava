import game.Game;
import game.GameLoop;

public class Main {
    public static void main(String[] args) {
        new Thread(new GameLoop(new Game())).start();
    }
}

//una cosa che sarebbe da fare è parallelizzare il processo di controllo delle collisioni