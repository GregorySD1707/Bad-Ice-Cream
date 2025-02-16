package Views;

import Controllers.ControllerMapOne;
import Models.Entity;

import java.util.Scanner;

public class ViewMapOne {
    static String BrightMagenta = "\u001b[35;1m";
    static String BackgroundCyan = "\u001b[46m";
    static String Reset = "\u001b[0m";
    static String Red = "\u001b[31m";
    static String Yellow = "\u001b[33m";
    static String Blue = "\u001b[34m";

    private final ControllerMapOne controllerMapOne;

    Scanner sc = new Scanner(System.in);

    public ViewMapOne(ControllerMapOne controllerMapOne) {
        this.controllerMapOne = controllerMapOne;
    }

    public void showMap(Entity[][] mapOne) {
        for(int rows=0; rows<mapOne.length; rows++){
            for (int columns=0; columns<mapOne[0].length; columns++){
                System.out.print(Reset+"[");
                switch (mapOne[rows][columns].getCode()){
                    case 0:
                        System.out.print(Reset+"   ");
                        break;
                    case 1:
                        System.out.print(BackgroundCyan+"   ");
                        break;
                    case 2:
                        if(controllerMapOne.isCompleted()){
                            System.out.print(BrightMagenta+" :)");
                            break;
                        }else if(controllerMapOne.isDie()){
                            System.out.print(BrightMagenta+" X(");
                            break;
                        }
                        System.out.print(BrightMagenta+">:(");
                        break;
                    case 3:
                        System.out.print(Yellow+"._.");
                        break;
                    case 4:
                        System.out.print(Yellow+"o_o");
                        break;
                    case 5:
                        System.out.print(Red+"(')");
                        break;
                    case 6:
                        System.out.print(Blue+"<'>");
                        break;
                    default:
                        System.out.print(Reset+"Error");
                }
                System.out.print(Reset+"]");
            }
            System.out.println(" ");
        }
        System.out.println("Score: "+controllerMapOne.getScore());
        System.out.println(controllerMapOne.getIceCream().isAlive());
//        String userRequest = sc.nextLine();
//        switch (userRequest){
//            case "w":
//                return "w";
//            case "s"
//
//        }
        //return askForFinishTheGame();
    }

    public String waitUserRequest() {
        return sc.nextLine().toLowerCase();
    }

    public void showFinalMessage(String finalMessage) {
        System.out.println(finalMessage);
    }

//    private boolean askForFinishTheGame() {
//        System.out.println("Do you want to finish the game? 0=yes | 1=no");
//        int numberDecision = Integer.parseInt(sc.nextLine());
//        do {
//            switch (numberDecision){
//                case 0:
//                    return true;
//                case 1:
//                    return false;
//                default:
//                    System.out.println("Try again");
//                    break;
//            }
//        }while (true);
//    }
}
