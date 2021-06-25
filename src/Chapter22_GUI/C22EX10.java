package Chapter22_GUI;

/**
 *
 * @File
 * @Author Emily Weilan Tao
 * @Date Jun 25, 2020
 * @Description  C22Ex10, Create an application using SwingConsole, with a JButton and a JTextField. Write and attach the appropriate listener so that if the button has the focus, characters typed into it will appear in the JTextField.
 * @Since version-1.0
 * @Copyright Copyright (c) 2020
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static Chapter22_GUI.SwingConsole.run;

public class C22EX10 extends JFrame {

    JTextField jTextField = new JTextField(200);

    KeyAdapter kl = new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
                jTextField.setText(jTextField.getText() + e.getKeyChar());
        }

    };
    private JButton button1 = new JButton("Focus to type..."), button2 = new JButton("Losing focus");


    public C22EX10() {
//        setLayout(new FlowLayout());
        button1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jTextField.setEnabled(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                jTextField.setEnabled(false);
            }
        });

        button1.addKeyListener(kl);

        add(BorderLayout.EAST, button2);
        add(BorderLayout.WEST, button1);
        add(BorderLayout.SOUTH, jTextField);

    }

    public static void main(String[] args) {
        run(new C22EX10(), 300, 100);
    }
}
