package Models;

public class VerticalEnemy extends Enemy{

    //private int nextYDirection;

    public VerticalEnemy(int columns, int rows, int code) {
        super(columns, rows, code);
        //nextYDirection = 1;
    }

    @Override
    public boolean isAnEnemy(Entity[][] mapOneOfEntities, int nextY) {
        return (mapOneOfEntities[nextY][getPosX()].getCode() == 3) || (mapOneOfEntities[nextY][getPosX()].getCode() == 4);
    }

    @Override
    public void killIceCream(Entity[][] mapOneOfEntities, int nextY) {
        ((IceCream) mapOneOfEntities[nextY][getPosX()]).die();
    }

    @Override
    public boolean isAnIceCream(Entity[][] mapOneOfEntities, int nextY) {
        return mapOneOfEntities[nextY][getPosX()] instanceof IceCream;
        //((Models.IceCream) mapOneOfEntities[nextPosition][getPosX()]).die();
    }

    @Override
    public boolean isAnIceBlock(Entity[][] mapOneOfEntities, int nextY) {
        return mapOneOfEntities[nextY][getPosX()] instanceof IceObstacle || mapOneOfEntities[nextY][getPosX()] instanceof Enemy;
    }

    @Override
    public int getPreviousPosition() {
        return getPosY();
    }

    @Override
    public int getNextPosition(int nextY) {
        return getPosY() + nextY;
    }

    @Override
    public void moveToTheNextPosition(int nextY) {
        setPosY(nextY);
    }

    @Override
    public void savePreviousEntity(Entity previousEntity, Entity[][] mapOneOfEntities, int previousY) {
        mapOneOfEntities[previousY][getPosX()] = isNull(previousEntity)? new Entity(previousY,getPosX(),0) : previousEntity;
    }

}
