package Vista;

import Controller.CommunicationController;
import Controller.EventController;

import javax.swing.*;
import java.awt.*;

public class ChatUI {
    private JPanel chatGrupal;

    private JScrollPane mensajesChat;
    private JTextArea textAreaMensajes;

    private JPanel myWriteArea;
    private JTextField myText;
    private JButton buttonSend;

    private EventController eventController;

    public ChatUI(String host, String nick) {
        //this.eventController = new EventController();
        this.buttonSend.addActionListener(eventController);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ChatUI");
        JPanel general = new ChatUI(args[0],args[1]).chatGrupal;
        frame.setPreferredSize(new Dimension(450, 700));
        frame.setMaximumSize(new Dimension(450, 700));
        frame.setMinimumSize(new Dimension(450, 700));
        frame.setLocationRelativeTo(null);
        frame.setContentPane(general);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
