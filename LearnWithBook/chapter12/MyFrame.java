package LearnWithBook.chapter12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame implements ActionListener {
    JButton button = new JButton("Click Me");
    public static void main(String[] args) {
        MyFrame gui = new MyFrame();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame("My first button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JButton button = new JButton("Click Me");

        button.addActionListener(this);

        MyDrawPanel1 drawPanel1 = new MyDrawPanel1();

        frame.getContentPane().add(BorderLayout.WEST, button);
        frame.getContentPane().add(BorderLayout.EAST, drawPanel1);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        button.setText("N1");
    }
}

class MyDrawPanel1 extends JPanel {
    public void paintComponent(Graphics g) {

        g.setColor(Color.orange);
        g.fillRect(20, 50, 100, 100);
        //g.fillRect(0, 0, this.getWidth(), this.getHeight());
        //g.drawRect(100, 100, 100, 50);

        /*int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);

        g.fillOval(70, 70, 100, 100);*/

        /*Image image = new ImageIcon("img.jpg").getImage();
        g.drawImage(image, 3, 4, this);*/
    }
}