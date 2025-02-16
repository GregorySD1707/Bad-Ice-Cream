package Models;

public class Fruit extends Entity{
    private int points;

    public Fruit(int columns, int rows, int code, int points) {
        super(columns, rows, code);
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
