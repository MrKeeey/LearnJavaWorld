package LearnWithBook.chapter14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class QuizCardBuilder {

    private String text;
    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizCardBuilder> cardList;
    private JFrame frame;

    public static void main(String[] args) {
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();
    }

    public void go() {

        frame = new JFrame("Quiz Card Builder");
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

        answer = new JTextArea(6, 20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);

        JScrollPane aScroller = new JScrollPane(answer);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton nextButton = new JButton("Next Card");
        nextButton.addActionListener(new NextCardListener());

        cardList = new ArrayList<QuizCardBuilder>();
        JLabel qLabel = new JLabel("Question: ");
        JLabel aLabel = new JLabel("Answer: ");

        mainPanel.add(qLabel);
        mainPanel.add(qScroller);
        mainPanel.add(aLabel);
        mainPanel.add(aScroller);
        mainPanel.add(nextButton);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");

        newMenuItem.addActionListener(new NewMenuListener());
        saveMenuItem.addActionListener(new SaveMenuListener());

        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }

    private class NextCardListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //QuizCardBuilder card = new QuizCardBuilder(question.getText(), answer.getText());
            QuizCardBuilder card = new QuizCardBuilder();
            cardList.add(card);
            clearCard();
        }
    }

    private class SaveMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //QuizCardBuilder card = new QuizCardBuilder(question.getText(), answer.getText());
            QuizCardBuilder card = new QuizCardBuilder();
            cardList.add(card);
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());
        }
    }

    private class NewMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cardList.clear();
            clearCard();
        }
    }

    public void clearCard() {
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }

    public void saveFile(File file) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (QuizCardBuilder card:cardList) {
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
            }
            writer.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void setQuestion(JTextArea question) {
        this.question = question;
    }

    public JTextArea getQuestion() {

        return question;
    }

    public void setAnswer(JTextArea answer) {
        this.answer = answer;
    }

    public JTextArea getAnswer() {
        return answer;
    }
}
