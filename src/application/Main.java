package application;
import  view.InterfaceGraf;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static BufferedImage img;
    public static  void main(String[] args) {
        InterfaceGraf iFace = new InterfaceGraf();


        //implementamos aqui uma imagem de plano de fundo que é a logo do farmácia
        try {
            img = ImageIO.read(new File("logo4.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

        //criar texto
        JLabel imageLabel = new JLabel();
        imageLabel.setText("Farmácia      Art3mis");
        imageLabel.setForeground(Color.WHITE);
        imageLabel.setFont(new Font("Helvetica", Font.PLAIN | Font.ITALIC, 18));
        imageLabel.setHorizontalTextPosition(JLabel.CENTER);


        //adiciomaos uma ação para a imagem acompanhar o tamanho da janela caso ela aumente ou diminui
        iFace.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Image dimag = img.getScaledInstance(iFace.getWidth(), iFace.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(dimag);
                imageLabel.setIcon(imageIcon);
            }
        });


        //c
        iFace.add(imageLabel);
        iFace.setVisible(true);

    }
}