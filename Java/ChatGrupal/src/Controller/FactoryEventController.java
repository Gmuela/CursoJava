package Controller;

import javax.swing.*;

public class FactoryEventController {

    private static EventController eventController;

    public static boolean initController(String host, String nick){
        eventController = new EventController(host,nick);
        return true;
    }

    public static EventController getController(){
       return eventController;
    }
}
