package HeadFirst.chapter14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class QuizCardPlayer {

    private JTextArea display;
    private ArrayList<QuizCard> cardList;
    private QuizCard currentCard;
    private int currentCardIndex;
    private JFrame frame;
    private JButton nextButton;
    private boolean isShowAnswer;

    public static void main(String[] args) {
        QuizCardPlayer reader = new QuizCardPlayer();
        reader.go();
    }

    public void go() {

        frame = new JFrame("Quiz Card Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();

        Font bigFont = new Font("sanserif", Font.BOLD, 24);
        display = new JTextArea(10, 20);
        display.setFont(bigFont);
        display.setLineWrap(true);
        display.setEditable(false);

        JScrollPane scroll = new JScrollPane(display);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        nextButton = new JButton("Show Question");
        nextButton.setEnabled(false);
        nextButton.addActionListener(new NextCardListener());

        mainPanel.add(scroll);
        mainPanel.add(nextButton);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load card set");
        loadMenuItem.addActionListener(new OpenMenuListener());
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500, 450);
        frame.setVisible(true);

    }

    public class NextCardListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (isShowAnswer) {
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next Card");
                isShowAnswer = false;
            } else {
                if (currentCardIndex < cardList.size()) {
                    showNextCard();
                } else {
                    display.setText("That was last Card");
                    nextButton.setEnabled(false);
                    currentCard = null;
                    cardList.clear();
                    currentCardIndex = 0;
                }
            }
        }
    }

    public class OpenMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            if (fileOpen.getSelectedFile() != null) {
                loadFile(fileOpen.getSelectedFile());
            }
        }
    }

    private void loadFile(File file) {
        if (file.exists()) {
            currentCard = null;
            currentCardIndex = 0;
            cardList = new ArrayList<QuizCard>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    makeCard(line);
                }
                reader.close();
            } catch (Exception exception) {
                display.setText("Couldn't read the card file!");
                nextButton.setEnabled(false);
                //exception.printStackTrace();
            }
            showNextCard();
        }
    }
    private void makeCard(String lineToParse) {
        String[] result = lineToParse.split("/");
        QuizCard card = new QuizCard(result[0], result[1]);
        cardList.add(card);
        //System.out.println("Made a card");
    }

    private void showNextCard() {
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setEnabled(true);
        nextButton.setText("Show Answer");
        isShowAnswer = true;
    }
}
