package LearnWithBook.chapter12;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui1 implements ActionListener {
    JButton button;
    public static void main(String[] args) {
        SimpleGui1 gui = new SimpleGui1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("Interview");
        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event){
        button.setText("Congratulations! You got hired!");
    }
}