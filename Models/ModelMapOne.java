package Models;

public class ModelMapOne {
    private IceCream iceCream;
    private HorizontalEnemy horizontalEnemyOne;
    private VerticalEnemy verticalEnemy;
    private final Entity[][] mapOneOfEntities;

    //private Models.Entity nextEntityEnemy;
    private Entity previousEntityEnemy;

    //private Models.Entity nextEntityIceCream;
    private Entity previousEntityIceCream;

    //private Models.Entity nextEntityVerticalEnemy;
    private Entity previousEntityVerticalEnemy;

    private int fruitCount;

    public ModelMapOne() {
        fruitCount = 0;
        int[][] mapOne = {
                {1,1,1,1,1,1,1,1,1},
                {1,0,2,0,0,0,0,4,1},
                {1,0,0,1,1,1,0,0,1},
                {1,0,0,1,6,1,0,0,1},
                {1,0,0,1,5,1,0,0,1},
                {1,0,0,1,6,1,0,0,1},
                {1,3,0,0,5,0,0,0,1},
                {1,0,0,0,6,0,0,0,1},
                {1,1,1,1,1,1,1,1,1},
        };
        mapOneOfEntities = new Entity[mapOne.length][mapOne[0].length];
        createMapOfEntities(mapOne);
    }

    private void createMapOfEntities(int[][] mapOne) {
        for(int rows=0; rows<mapOne.length;rows++){
            for(int columns=0; columns<mapOne[0].length; columns++){
                switch (mapOne[rows][columns]){
                    case 0:
                        mapOneOfEntities[rows][columns] = new Entity(columns,rows,0);
                        break;
                    case 1:
                        mapOneOfEntities[rows][columns] = new IceObstacle(columns,rows,1);
                        break;
                    case 2:
                        iceCream = new IceCream(columns,rows, 2);
                        mapOneOfEntities[rows][columns] = iceCream;
                        break;
                    case 3:
                        horizontalEnemyOne = new HorizontalEnemy(columns, rows, 3);
                        mapOneOfEntities[rows][columns] = horizontalEnemyOne;
                        break;
                    case 4:
                        verticalEnemy = new VerticalEnemy(columns, rows, 4);
                        mapOneOfEntities[rows][columns] = verticalEnemy;
                        break;
                    case 5:
                        mapOneOfEntities[rows][columns] = new Fruit(columns, rows, 5, 100);
                        fruitCount++;
                        break;
                    case 6:
                        mapOneOfEntities[rows][columns] = new Fruit(columns,rows,6, 50);
                        fruitCount++;
                        break;
                }
            }
        }
    }

    public Entity[][] getMapOneOfEntities() {
        return mapOneOfEntities;
    }

    public void moveIceCream(String userRequest) {
        previousEntityIceCream = iceCream.move(userRequest, mapOneOfEntities, previousEntityIceCream);
    }

    public int getScore() {
        return iceCream.getScore();
    }

    public IceCream getIceCream() {
        return iceCream;
    }

    public void moveHorizontalEnemy() {
        previousEntityEnemy = horizontalEnemyOne.move(mapOneOfEntities, previousEntityEnemy);
    }

    public boolean isAliveTheIceCream() {
        return iceCream.isAlive();
    }

    public void moveVerticalEnemy(){
        previousEntityVerticalEnemy = verticalEnemy.move(mapOneOfEntities, previousEntityVerticalEnemy);
    }

    public boolean isCompleted() {
        return fruitCount == iceCream.getFruitCount();
    }
}
