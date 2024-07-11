package HeadFirst.chapter12;

import javax.swing.*;
import java.awt.*;

public class Animate {
    int x = 1;
    int y = 1;

    public static void main(String[] args) {
        Animate gui = new Animate();
        gui.go();
    }

    public void go() {

        JFrame frame = new JFrame("Animate Disappear");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawP myDrawP = new MyDrawP();
        frame.getContentPane().add(myDrawP);

        frame.setSize(500, 270);
        frame.setVisible(true);

        for (int i = 0; i <= 124; i++, x++, y++) {
            x++;
            myDrawP.repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class MyDrawP extends JPanel {
        public void paintComponent (Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0, 0, 500, 250);
            g.setColor(Color.blue);
            g.fillRect(x, y, 500 - x * 2, 250 - y * 2);
        }
    }
}
