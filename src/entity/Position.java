package entity;

import java.awt.Point;

//La classe Position permette di settare le posizioni delle entità e di modificarne le loro posizioni 
//passandogli le nuove coordinate. Viene usata dalla classe Entity
public class Position extends Point {

    //Costruttore di default, dove vengono passate le coordinate e salvate
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


//movimento sommatorio dell'entità
    public void setX(int x) {this.x += x;}
    public void setY(int y) {this.y += y;}
}
