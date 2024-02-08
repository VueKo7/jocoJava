public class Main {
    public static void main(String[] args) {
        new Thread(new GameLoop(new Game())).start();
    }
}