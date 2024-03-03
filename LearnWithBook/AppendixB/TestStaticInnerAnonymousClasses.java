package LearnWithBook.AppendixB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestStaticInnerAnonymousClasses {
    public static void main(String[] args) {
        TestStaticInnerAnonymousClasses.TestStatic stat = new TestStaticInnerAnonymousClasses.TestStatic();
        stat.hey();

        new TestStaticInnerAnonymousClasses().go();


        JFrame frame = new JFrame("Test Anonymous class");
        JPanel panel = new JPanel();
        JTextField textField = new JTextField(15);
        textField.setEnabled(false);
        JButton button = new JButton("Click");
        button.addActionListener(new ActionListener() {
            int count = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Clicked " + count++ + " times.");
            }
        });

        panel.add(textField);
        panel.add(button);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
        frame.setSize(300, 100);

    }

    public void go() {
        new NotStatic().hey();
    }
    static class TestStatic {
        public void hey() {
            System.out.println("Hey! Static up!");
        }
    }

    public class NotStatic {
        public void hey() {
            System.out.println("Hey! Not static!");
        }
    }
}