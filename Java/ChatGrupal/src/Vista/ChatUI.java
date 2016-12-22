package Vista;

import Controller.CommunicationController;
import Controller.EventController;
import Controller.FactoryCommunicationController;
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
        CommunicationController controller = FactoryCommunicationController.getController();
        controller.initChat(this.textAreaMensajes);
        EventController eventController = FactoryEventController.getController();
        this.buttonSend.addActionListener(eventController);
        this.buttonSend.setName("send");
    }

    public void openChat() {
        JFrame frame = new JFrame("ChatUI");
        JPanel general = this.chatGrupal;
        frame.setPreferredSize(new Dimension(450, 700));
        frame.setMaximumSize(new Dimension(450, 700));
        frame.setMinimumSize(new Dimension(450, 700));
        frame.setLocationRelativeTo(null);
        frame.setContentPane(general);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
