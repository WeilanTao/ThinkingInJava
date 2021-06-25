package Chapter22_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Chapter22_GUI.SwingConsole.run;

/**
 *
 * @File 
 * @Author Emily Weilan Tao 
 * @Date Jun 24, 2021
 * @Description Button with ActionListener
 * @Since version-1.0
 * @Copyright Copyright (c) 2020
 */

public class Button2 extends JFrame {
    private JButton b1 = new JButton("Button 1"),
            b2 = new JButton("Button 2"),
            b3 = new JButton("Button 3");
    private JTextField txt = new JTextField(10);


//    class ButtonListener implements ActionListener{
//        public void actionPerformed(ActionEvent e){
//            String name=((JButton)e.getSource()).getText();
//            txt.setText(name);
//        }
//    }
//
//    private ButtonListener bl=new ButtonListener();

    /**
     * Alternative anonymous inner class
     */
    private ActionListener bl = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton) e.getSource()).getText();
            txt.setText(name);
        }
    };

    public Button2() {
        b1.addActionListener(bl);
        b2.addActionListener(bl);
        b3.addActionListener(bl);
        setLayout(new FlowLayout(0));
        add(b1);
        add(b2);
        add(b3);
        add(txt);

    }

    public static void main(String[] args) {
        run(new Button2(), 200, 150);
    }
}
