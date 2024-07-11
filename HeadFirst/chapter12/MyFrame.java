package HeadFirst.chapter12;

import javax.swing.*;
import java.awt.*;

public class MyFrame {
    JFrame frame;
    JButton button;

    public static void main(String[] args) {
        MyFrame gui = new MyFrame();
        gui.go();
    }

    public void go() {

        frame = new JFrame("My first button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button = new JButton("Click Me");

        MyDrawPanel1 drawPanel1 = new MyDrawPanel1();

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel1);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
}

class MyDrawPanel1 extends JPanel {
    public void paintComponent(Graphics g) {

        g.setColor(Color.orange);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        //g.fillRect(0, 0, 100, 100);
        g.setColor(Color.blue);
        g.drawRect(10, 10, 50, 50);

        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(70, 70, 100, 100);

        Image image = new ImageIcon("HeadFirst/chapter12/img.jpg").getImage();
        g.drawImage(image, 70, 10, 50, 50, this);
    }
}