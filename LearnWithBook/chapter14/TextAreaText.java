package LearnWithBook.chapter14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class TextAreaText {

    private JTextArea question;
    public ArrayList<Qiz> cardList;
    private JFrame frame;
    public static void main(String[] args) {
        TextAreaText gui = new TextAreaText();
        gui.go();
    }

    public void go() {

        frame = new JFrame("Text");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);
        question = new JTextArea(6, 20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);

        JScrollPane qScroller = new JScrollPane(question);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        cardList = new ArrayList<Qiz>();

        JButton nextButton = new JButton("Next Card");
        nextButton.addActionListener(new NextButtonListener());
        JButton saveButton = new JButton("Save Card");
        saveButton.addActionListener(new SaveButtonListener());

        mainPanel.add(qScroller);
        mainPanel.add(nextButton);
        mainPanel.add(saveButton);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500, 600);
        frame.setVisible(true);

    }

    private class NextButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Qiz card = new Qiz(question.getText());
            cardList.add(card);

            question.setText("");
            question.requestFocus();
        }
    }

    private class SaveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            Qiz card = new Qiz(question.getText());
            cardList.add(card);
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Z:\\NW\\y\\LearnWorld\\LearnWithBook\\chapter14\\123"));
                //String str = question.getText();
                //writer.write(str);
                for (Qiz cardd:cardList) {
                    writer.write(cardd.getQu() + "\n");
                }
                writer.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
class Qiz {

    String qu;

    Qiz(String q) {
        qu = q;
    }

    public String getQu() {
        return qu;
    }

}