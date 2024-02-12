package entity.dinamicEntity;
//Classe che crea un Vector2D, utilizzata per memorizzare le direzioni x e y delle entità
//passategli dal costruttore o settate coi setter. Classe utilizzata da Movement
public class Vector2D {
    //Direzioni delle ascisse(0=fermo, negativo va verso sinistra, positivo va verso destra)
    private double x;
    //Direzioni delle ascisse(0=fermo, negativo va verso l'alto, positivo va verso il basso)
    private double y;

    //Costruttore che setta le direzioni x e y passate
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //Metodo che calcola la lunghezza della direzione(0 fermo, 1 se va in verticale/orizzontale, radice di 2 se si sta muovendo in obliquo)
    public double length() {
        return Math.sqrt(x * x + y * y);
    }
    //Metodo che richiamando la lenght permette di rendere il movimento medesimo in tutte le direzioni
    public void normalize() {
        double length = length();
        //se la direzione x è uguale a 0, niente, altrimenti x=x/lenght
        x = x == 0 ? 0 : x/length;
        //se la direzione y è uguale a 0, niente, altrimenti y=y/lenght
        y = y == 0 ? 0 : y/length;
    }
    //Metodo che moltiplica le direzioni per la velocità
    public void multiply(double speed) {
        x *= speed;
        y *= speed;
    }

    //metodo per il settaggio della direzione delle ascisse
    public void setX(double x) { this.x = x; }
    //metodo per il settaggio della direzione delle ordinate
    public void setY(double y) { this.y = y; }

    //metodo per la ricezione della direzione delle ascisse
    public double getX() { return x; }
    
    //metodo per la ricezione della direzione delle ordinate
    public double getY() { return y; }


     //metodo che stampa le direzioni a schermo
    @Override
    public String toString() { return "{" + x + ", " + y + "}"; }
}
