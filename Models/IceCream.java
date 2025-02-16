package Models;

public class IceCream extends Entity{

    private int score;
    private boolean alive;
    private int fruitCount;

    public IceCream(int columns, int rows, int code) {
        super(columns, rows, code);
        alive = true;
        score =0;
        fruitCount = 0;
    }

    public Entity move(String userRequest, Entity[][] mapOneOfEntities, Entity previousEntityIceCream) {
//        switch (userRequest){
//            case "w" -> setPosY(-1);
//            case "s"-> setPosY(1);
//            case "a"->setPosX(-1);
//            case "d"->setPosX(1);
//            default ->{
//                return -1;
//            }
//        }
        //int result =0;
        int previousX = getPosX();
        int previousY = getPosY();
        int nextMoveY= getPosY();
        int nextMoveX= getPosX();

        switch (userRequest){
            case "w" -> nextMoveY = nextMoveY -1;
            case "s"-> nextMoveY = nextMoveY + 1;
            case "a"->nextMoveX = nextMoveX -1;
            case "d"->nextMoveX =nextMoveX+ 1;
            default ->{
                return null;
            }
        }

//        if(mapOneOfEntities[nextMoveY][nextMoveX] instanceof Models.IceObstacle){
//            return null;
//        }

//        if(mapOneOfEntities[nextMoveY][nextMoveX] instanceof Models.Fruit){
//            increaseScore();
//            mapOneOfEntities[nextMoveY][nextMoveX] = new Models.Entity(previousY, previousX, 0);
//        }

//        if(mapOneOfEntities[nextMoveY][nextMoveX] instanceof Models.HorizontalEnemy){
//            die();
//            return null;
//        }

        switch (mapOneOfEntities[nextMoveY][nextMoveX].getCode()){
            case 1:
                return null;
            case 3,4:
                die();
                return null;
            case 5,6:
                Fruit fruit = (Fruit) mapOneOfEntities[nextMoveY][nextMoveX];
                increaseScore(fruit.getPoints());
                mapOneOfEntities[nextMoveY][nextMoveX] = new Entity(previousY, previousX, 0);
                fruitCount++;
        }

//        setPosX(nextMoveX);
//        setPosY(nextMoveY);
//
//        //result = iceCream.move(nextMoveX, nextMoveY);
//
//        mapOneOfEntities[getPosY()][getPosX()] = this;
//        mapOneOfEntities[previousY][previousX] = new Models.Entity(previousY, previousX, 0);

        setPosX(nextMoveX);
        setPosY(nextMoveY);

        Entity nextEntityIceCream = mapOneOfEntities[getPosY()][getPosX()];

        mapOneOfEntities[getPosY()][getPosX()] = this;

        mapOneOfEntities[previousY][previousX] = isNull(previousEntityIceCream)? new Entity(previousY,previousX,0) : previousEntityIceCream;

        previousEntityIceCream = nextEntityIceCream;

        return previousEntityIceCream;
    }

    public void die() {
        alive = false;
    }

    private boolean isNull(Entity entity) {
        return entity == null;
    }


    public void increaseScore(int points) {
        score = score + points;
    }

    public int getScore() {
        return score;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getFruitCount() {
        return fruitCount;
    }
}
