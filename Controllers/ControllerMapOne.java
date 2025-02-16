package Controllers;

import Models.Entity;
import Models.IceCream;
import Models.ModelMapOne;
import Views.ViewMapOne;

public class ControllerMapOne {
    private final ModelMapOne modelMapOne;
    private final ViewMapOne viewMapOne;
    private boolean completed;

    public ControllerMapOne() {
        completed = false;
        modelMapOne = new ModelMapOne();
        viewMapOne = new ViewMapOne(this);
    }

    public boolean startMap() {
        Entity[][] mapOneOfEntities = modelMapOne.getMapOneOfEntities();
        do {
            viewMapOne.showMap(mapOneOfEntities);

            modelMapOne.moveIceCream(viewMapOne.waitUserRequest());
            modelMapOne.moveHorizontalEnemy();
            modelMapOne.moveVerticalEnemy();
        }while (modelMapOne.isAliveTheIceCream() && !modelMapOne.isCompleted());
        viewMapOne.showMap(mapOneOfEntities);
        viewMapOne.showFinalMessage(modelMapOne.isCompleted()? "You win :D" : "You lose :,(");
        return false;
    }

    public int getScore() {
        return modelMapOne.getScore();
    }

    public boolean isCompleted() {
        return modelMapOne.isCompleted();
    }

    public boolean isDie() {
        return !modelMapOne.isAliveTheIceCream();
    }

    public IceCream getIceCream() {
        return modelMapOne.getIceCream();
    }
}
