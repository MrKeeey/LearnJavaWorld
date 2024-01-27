package LearnWithBook.chapter13;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class textJCheckBoxAndJList implements ItemListener, ListSelectionListener {

    JTextArea textArea;
    JCheckBox checkBox;
    JList list;
    public static void main(String[] args) {
        textJCheckBoxAndJList gui = new textJCheckBoxAndJList();
        gui.go();
    }

    public void go() {

        String[] listEntries = {"alpha", "beta", "gamma", "delta", "epsilon", "zeta", "eta", "theta"};

        JFrame frame = new JFrame("CheckBox & CheckList");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JPanel panelTwo = new JPanel();
        JPanel panelThree = new JPanel();

        checkBox = new JCheckBox("It's checkbox.");
        checkBox.addItemListener(this);

        textArea = new JTextArea(10, 20);
        textArea.setLineWrap(true);

        list = new JList(listEntries);
        list.setVisibleRowCount(4);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(this);

        JScrollPane scrollerArea = new JScrollPane(textArea);
        scrollerArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollerArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JScrollPane scrollerList = new JScrollPane(list);
        scrollerList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollerList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(checkBox);
        panelTwo.add(scrollerArea);
        panelThree.add(scrollerList);
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, panelTwo);
        frame.getContentPane().add(BorderLayout.SOUTH, panelThree);

        frame.setSize(300, 400);
        frame.setVisible(true);

    }

    public void itemStateChanged(ItemEvent event) {
        String onOrOff = "Off";
        if (checkBox.isSelected()) onOrOff = "On";
        //textArea.setText("Check box is " + onOrOff);
        textArea.append("Check box is " + onOrOff + " \n");
    }

    public void valueChanged(ListSelectionEvent event) {
        if (!event.getValueIsAdjusting()) {
            textArea.append(list.getSelectedValue() + " \n");
        }
    }

}
