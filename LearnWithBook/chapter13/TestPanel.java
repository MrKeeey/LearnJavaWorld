package LearnWithBook.chapter13;

import java.awt.*;
import javax.swing.*;

public class TestPanel extends JPanel {
    public TestPanel() {
        JLabel loginLable = new JLabel("Login:");
        JTextField login = new JTextField();
        JLabel passwordLable = new JLabel("Password:");
        JTextField password = new JTextField();

        JButton register = new JButton("Register");
        JButton enter = new JButton("Enter");

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.add(register);
        buttonsPanel.add(enter);

        setLayout(new GridBagLayout());

        // col 0
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.ipadx = 10;
        constraints.ipady = 10;
        constraints.anchor = GridBagConstraints.LINE_START;

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(loginLable, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(passwordLable, constraints);

        // col 1
        constraints.ipadx = 0;
        constraints.ipady = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;

        constraints.gridx = 1;
        constraints.gridy = 0;
        add(login, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        add(password, constraints);

        // bs row
        constraints.gridwidth = 2;
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(buttonsPanel, constraints);
    }

    public static void main(String args[]) throws Exception {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.33;
        frame.getContentPane().add(new JLabel(), constraints);
        constraints.gridx = 1;
        frame.getContentPane().add(new TestPanel(), constraints);
        constraints.gridx = 2;
        frame.getContentPane().add(new JLabel(), constraints);
        frame.setSize(640, 480);


        frame.setVisible(true);
    }
}
