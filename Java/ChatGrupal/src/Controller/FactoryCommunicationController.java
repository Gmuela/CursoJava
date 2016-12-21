package Controller;

public class FactoryCommunicationController {

    public static CommunicationController communicationController;

    public static boolean initController(String host){
        communicationController = new CommunicationController(host);
        return true;
    }

    public static CommunicationController getController(){
        return communicationController;
    }
}
