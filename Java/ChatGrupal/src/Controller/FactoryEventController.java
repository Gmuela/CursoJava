package Controller;

public class FactoryEventController {

    private static EventController eventController;

    public static boolean initController(){
        eventController = new EventController();
        return true;
    }

    public static EventController getController(){
       return eventController;
    }
}
