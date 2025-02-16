package Models;

import Controllers.ControllerMapOne;

public class BadIceCream {
    private boolean finished;
    ControllerMapOne controllerMapOne;

    public BadIceCream() {
        finished = true;
        controllerMapOne = new ControllerMapOne();
    }

    public void startGame() {
        do{
            finished = controllerMapOne.startMap();
        }while (finished);
    }
}
