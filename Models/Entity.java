package Models;

public class Entity {
    private int posX;
    private int posY;
    private final int code;

    public Entity(int columns, int rows, int code) {
        posX = columns;
        posY = rows;
        this.code = code;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int yValue) {
        posY =  yValue;
    }

    public void setPosX(int xValue) {
        posX =  xValue;
    }

    public int getCode() {
        return code;
    }


}
