package Chapter12_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import static Chapter12_GUI.SwingConsole.run;

/**
 * @File
 * @Author Emily Weilan Tao
 * @Date June 24, 2021
 * @Description A JTextArea is like a JTextField except that it can have multiple lines and has more functionality.
 * append( ); with this you can easily pour output into the JTextArea
 * @Since version-1.0
 * @Copyright Copyright (c) 2020
 */
public class TextArea extends JFrame {
    private JButton
    b=new JButton("Add Data"),
    c=new JButton("Clear Data");
    private JTextArea t = new JTextArea(20,40);
    private Map<String, String> m =new HashMap<>();

    public TextArea(){
        m.putAll(Countries.capitals());
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Map.Entry me: m.entrySet())
                    t.append(me.getKey()+": "+me.getValue()+"\n");
            }
        });

        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.setText("");
            }
        });

        setLayout(new FlowLayout());
        add(new JScrollPane(t));
        add(b);
        add(c);
    }

    public static void main(String[] args) {
        run(new TextArea(), 475, 425);
    }
}
