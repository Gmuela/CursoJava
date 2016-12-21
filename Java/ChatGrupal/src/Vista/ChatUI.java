package Vista;

import Controller.CommunicationController;
import Controller.EventController;
import Controller.FactoryEventController;

import javax.swing.*;
import java.awt.*;

public class ChatUI {
    private JPanel chatGrupal;

    private JScrollPane mensajesChat;
    private JTextArea textAreaMensajes;

    private JPanel myWriteArea;
    private JTextField myText;
    private JButton buttonSend;

    public ChatUI() {
        EventController eventController = FactoryEventController.getController();
        this.buttonSend.addActionListener(eventController);
    }

    public void openChat() {
        JFrame frame = new JFrame("ChatUI");
        JPanel general = new ChatUI().chatGrupal;
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
