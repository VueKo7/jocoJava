package entity;

//La classe Position permette di settare le posizioni delle entità e di modificarne le loro posizioni 
//passandogli le nuove coordinate. Viene usata dalla classe Entity
public class Position {
    //Coordinata delle ascisse
    private int x;
    //Coordinata delle ordinate
    private int y;
    //Costruttore di default, dove vengono passate le coordinate e salvate
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }






    
    //metodo per la ricezione della coordinata delle ascisse
    public int getX() { return x; }
    //metodo per il settaggio della coordinata delle ascisse
    public void setX(int x) {
        
        this.x += x;
    }
    //metodo per la ricezione della coordinata delle ordinate
    public int getY() { return y; }
    //metodo per il settaggio della coordinata delle ordinate
    public void setY(int y) {
        this.y += y;
    }

}
