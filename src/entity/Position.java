package entity;

public class Position {
    
    private float x;
    private float y;

    Position(float x, float y) {
        this.x = x;
        this.y = y;
    }


    public class Size() {

        private int width;
        private int height;

        public Size(int width, int height) {
            this.width = width;
            this.height = height;
        }

    }


    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }

}
