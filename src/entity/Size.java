package entity;
//La classe Size permette di settare le dimensioni delle entità e di modificarle passandogli
// le nuove dimesioni. Viene usata dalla classe Entity 
public class Size {
    //Lunghezza
    private int width;
    //Altezza
    private int height;
    //Costruttore di default, dove vengono passate le dimensioni e salvate
    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }



    //metodo per la ricezione della lunghezza
    public int getWidth() {
        return width;
    }
    //metodo per il settaggio della lunghezza
    public void setWidth(int width) {
        this.width = width;
    }
    //metodo per la ricezione dell'altezza
    public int getHeight() {
        return height;
    }
    //metodo per il settaggio del'altezza
    public void setHeight(int height) {
        this.height = height;
    }
}
