package Vista;

import Controller.EventController;
import Controller.FactoryEventController;

import javax.swing.*;
import java.awt.*;

public class Login {
    private JPanel loginChatGrupal;
    private JTextField nick;
    private JTextField host;
    private JButton loginButton;

    public Login() {
        FactoryEventController.initController();
        EventController eventController = FactoryEventController.getController();
        eventController.initFields(this.nick,this.host);
        this.loginButton.addActionListener(eventController);
        this.loginButton.setName("login");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        JPanel loginChatGrupal = new Login().loginChatGrupal;
        frame.setContentPane(loginChatGrupal);
        frame.setPreferredSize(new Dimension(300, 150));
        frame.setMaximumSize(new Dimension(300, 150));
        frame.setMinimumSize(new Dimension(300, 150));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
