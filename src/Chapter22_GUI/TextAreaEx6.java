package Chapter22_GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Chapter22_GUI.SwingConsole.run;

/**
 * @File
 * @Author Emily Weilan Tao
 * @Date Ch22E6,E8  Turn strings/TestRegularExpression.java into an interactive Swing program that allows you to put an input string in one JTextArea and a regular expression in a JTextField. The results should be displayed in a second JTextArea.
 * @Description
 * @Since version-1.0
 * @Copyright Copyright (c) 2020
 */

public class TextAreaEx6 extends JFrame {

    private JTextArea input = new JTextArea(20, 40);
    private JTextField output = new JTextField(20);
    private JButton search = new JButton("Search"),
            clear = new JButton("clear");

    public TextAreaEx6() {
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = input.getText();
                output.setText(s);
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText("");
                input.setText("");
            }
        });
        search.setCursor(new Cursor(Cursor.HAND_CURSOR ));
        clear.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        input.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        output.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        setLayout(new FlowLayout());
        add(new JScrollPane(input));
        add(output);
        add(search);
        add(clear);

    }


    public static void main(String[] args) {
        run(new TextAreaEx6(), 475, 500);
    }

}
