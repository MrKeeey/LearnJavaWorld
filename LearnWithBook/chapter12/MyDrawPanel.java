package LearnWithBook.chapter12;

import com.sun.java.accessibility.util.AWTEventMonitor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyDrawPanel extends JPanel {
    public MyDrawPanel() {
        JFrame frame = new JFrame("My first button");
        JPanel panel = new JPanel();

        frame.setVisible(true);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Interview");
        panel.add(button);
        frame.add(panel);

    }
    public void paintComponent(Graphics g) {

        g.drawRect(100, 100, 100, 50);
        //g.fillRect(0, 0, this.getWidth(), this.getHeight());

        /*int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);

        g.fillOval(70, 70, 100, 100);

        Image image = new ImageIcon("img.jpg").getImage();
        g.drawImage(image, 3, 4, this);*/
        
    }
    public static void main(String[] args) {
        new MyDrawPanel();
    }
}
