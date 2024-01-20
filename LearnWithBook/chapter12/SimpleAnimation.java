package LearnWithBook.chapter12;

import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {
    int x = 200;
    int y = 200;

    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame("Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawPanel drawpanel = new drawPanel();
        frame.getContentPane().add(BorderLayout.CENTER, drawpanel);

        frame.setSize(400, 400);
        frame.setVisible(true);

        for (int i = 0; i < 130; i++) {
            x = x - 1;
            y = y - 1;
            drawpanel.repaint();
            try {
                Thread.sleep(50);
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    class drawPanel extends JPanel {
        public void paintComponent (Graphics graphics) {
            graphics.setColor(Color.white);
            graphics.fillRect(0, 0, this.getWidth(), this.getHeight());

            graphics.setColor(Color.orange);
            graphics.fillOval(x, y, 100, 100);
        }
    }
}
