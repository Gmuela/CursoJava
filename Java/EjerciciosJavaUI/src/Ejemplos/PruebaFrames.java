package Ejemplos;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PruebaFrames {

    public static void main(String[] args){
        JFrame frame = new JFrame("Mi primer frame modificado");
        frame.setSize(400,500);
        //frame.setLocation(0,0);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try {
            URL urlIcon = new URL("http://i.imgur.com/GJKbn0N.gif");
            frame.setIconImage(getIconFrom(urlIcon));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel label = new JLabel();
        label.setText("Soy la puta rana epileptica y vengo a joderte la vida");
        frame.add(label);
        frame.setVisible(true);
    }

    private static BufferedImage getIconFrom(URL urlIcon) throws IOException {
        return ImageIO.read(urlIcon);
    }

}
