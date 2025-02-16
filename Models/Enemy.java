package Models;

public abstract class Enemy extends Entity{
    private int nextDirection;
    public Enemy(int columns, int rows, int code) {
        super(columns, rows, code);
        nextDirection = 1;
    }

    public Entity move(Entity[][] mapOneOfEntities, Entity previousEntity) {
        int previousPosition = getPreviousPosition();
        int nextPosition = getNextPosition(nextDirection);

        if(isAnIceBlock(mapOneOfEntities, nextPosition) || isAnEnemy(mapOneOfEntities, nextPosition)){
            nextDirection = nextDirection * (-1);
            return null;
        }

        if (isAnIceCream(mapOneOfEntities, nextPosition)) {
            killIceCream(mapOneOfEntities,nextPosition);
            return null;
        }

        moveToTheNextPosition(nextPosition);

        Entity nextEntity = mapOneOfEntities[getPosY()][getPosX()];

        mapOneOfEntities[getPosY()][getPosX()] = this;

        savePreviousEntity(previousEntity, mapOneOfEntities, previousPosition);

//        mapOneOfEntities[getPosY()][previousY] = isNull(previousEntity)? new Models.Entity(getPosY(),previousY,0) : previousEntity;

        previousEntity = nextEntity;

        return previousEntity;
    }

    public abstract boolean isAnEnemy(Entity[][] mapOneOfEntities, int nextPosition);

    public abstract void killIceCream(Entity[][] mapOneOfEntities, int nextPosition);

    public abstract boolean isAnIceCream(Entity[][] mapOneOfEntities, int nextDirection);
    //{
      //  return mapOneOfEntities[getPosX()] instanceof Models.IceCream;
    //}

    public abstract boolean isAnIceBlock(Entity[][] mapOneOfEntities, int nextPosition);

    public abstract int getPreviousPosition();

    public abstract int getNextPosition(int nextDirection);

    public abstract void moveToTheNextPosition(int nextPosition);

    public abstract void savePreviousEntity(Entity previousEntity, Entity[][] mapOneOfEntities, int previousPosition);

    public boolean isNull(Entity entity) {
        return entity == null;
    }
}
