package entity;

import java.awt.Point;

//La classe Position permette di settare le posizioni delle entità e di modificarne le loro posizioni 
//passandogli le nuove coordinate. Viene usata dalla classe Entity
public class Position extends Point {
    
    Point topLeft;
    Point topRight;
    Point bottomLeft;
    Point bottomRight;

    //Costruttore di default, dove vengono passate le coordinate e salvate
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public Point getTopLeft() {return topLeft;}
    public Point getTopRight() {return topRight;}
    public Point getBottomLeft() {return bottomLeft;}
    public Point getBottomRight() {return bottomRight;}

    public void setTopLeft(Point topLeft) {this.topLeft = topLeft;}
    public void setTopRight(Point topRight) {this.topRight = topRight;}
    public void setBottomLeft(Point bottomLeft) {this.bottomLeft = bottomLeft;}
    public void setBottomRight(Point bottomRight) {this.bottomRight = bottomRight;}

//impostazione di tutti e quattro i punti dell'entità
    public void setPoints(Entity e) {

        setTopLeft(new Point(e.gePosition().getLocation()));
        setTopRight(new Point(e.getX()+e.getWidth(), e.getY()));
        setBottomLeft(new Point(e.getX(), e.getY()+e.getHeight()));
        setBottomRight(new Point(e.getX()+e.getWidth(), e.getY()+e.getHeight()));
    }

//movimento sommatorio dell'entità
    public void setX(int x) {this.x += x;}
    public void setY(int y) {this.y += y;}
}
