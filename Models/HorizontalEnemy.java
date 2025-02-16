package Models;

public class HorizontalEnemy extends Enemy{

    private int nextXDirection;

    public HorizontalEnemy(int columns, int rows, int code) {
        super(columns, rows, code);
        nextXDirection = 1;
    }

    @Override
    public boolean isAnEnemy(Entity[][] mapOneOfEntities, int nextX) {
        return (mapOneOfEntities[getPosY()][nextX].getCode() == 3) || (mapOneOfEntities[getPosY()][nextX].getCode() == 4);
    }

    //public Models.Entity move(Models.Entity[][] mapOneOfEntities, Models.Entity previousEntity, Models.Entity nextEntity) {

//        int previousX = getPosX();
//
//        int nextX = getPosX() + nextXDirection;
//
//        if(mapOneOfEntities[getPosY()][nextX] instanceof Models.IceObstacle || mapOneOfEntities[getPosY()][nextX] instanceof Models.Enemy){
//            nextXDirection = nextXDirection *(-1);
//            return null;
//        }
//
//        //Sirve cuando el jugador está quieto o cuando tanto el jugador como el enemigo se dirigen al mismo bloque al mismo tiempo
//        if(mapOneOfEntities[getPosY()][nextX] instanceof Models.IceCream){
//            ((Models.IceCream) mapOneOfEntities[getPosY()][nextX]).die();
//            return null;
//        }
//
//        setPosX(nextX);
//
//        nextEntity = mapOneOfEntities[getPosY()][getPosX()];
//
//        mapOneOfEntities[getPosY()][getPosX()] = this;
//
//        mapOneOfEntities[getPosY()][previousX] = isNull(previousEntity)? new Models.Entity(getPosY(),previousX,0) : previousEntity;
//
//        previousEntity = nextEntity;
//
//        return previousEntity;
//
////        int previousX = getPosX();
////        int previousY = getPosY();
////
////        Models.Entity originalNextEntity = mapOneOfEntities[getPosY()][getPosX()+horizontalDirectionValue];
////        mapOneOfEntities[getPosY()][getPosX()+1] = this;
////
////        switch (originalNextEntity.getCode()){
////            case 0 -> mapOneOfEntities[previousY][previousX] = new Models.Entity(previousY, previousX, 0);
////            case 1 -> move(mapOneOfEntities, -1);
////            case 3,4 -> mapOneOfEntities[previousY][previousX] = originalNextEntity;
////        }
    //}

    @Override
    public void killIceCream(Entity[][] mapOneOfEntities, int nextPosition) {
        ((IceCream)mapOneOfEntities[getPosY()][nextPosition]).die();
    }

    @Override
    public boolean isAnIceCream(Entity[][] mapOneOfEntities, int nextX) {
        return mapOneOfEntities[getPosY()][nextX].getCode() == 2;
    }

    @Override
    public boolean isAnIceBlock(Entity[][] mapOneOfEntities, int nextX) {
        return mapOneOfEntities[getPosY()][nextX].getCode() == 1;
    }

    @Override
    public int getPreviousPosition() {
        return getPosX();
    }

    @Override
    public int getNextPosition(int nextX) {
        return getPosX() + nextX;
    }

    @Override
    public void moveToTheNextPosition(int nextX) {
        setPosX(nextX);
    }

    @Override
    public void savePreviousEntity(Entity previousEntity, Entity[][] mapOneOfEntities, int previousX) {
        mapOneOfEntities[getPosY()][previousX] = isNull(previousEntity)? new Entity(getPosY(),previousX,0) : previousEntity;
    }

//    private boolean isNull(Models.Entity entity) {
//        return entity == null;
//    }
}
