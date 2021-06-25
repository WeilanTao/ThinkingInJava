package Chapter22_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.util.regex.*;
import static Chapter22_GUI.SwingConsole.*;

public class ShowAddListeners extends JFrame {
    private JTextField name = new JTextField(25);
    private JTextArea results = new JTextArea(40, 65);
    private static Pattern addListener =
            Pattern.compile("(add\\w+?Listener\\(.*?\\))");
    private static Pattern qualifier =
            Pattern.compile("\\w+\\.");
    class NameL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nm = name.getText().trim();
            if(nm.length() == 0) {
                results.setText("No match");
                return;
            }
            /**
             * Class is a parameterizable class, hence you can use the syntax Class<T> where T is a type. By writing Class<?>, you're declaring a Class object which can be of any type (? is a wildcard). The Class type is a type that contains meta-information about a class.
             */
            Class<?> kind;
            try {
                kind = Class.forName("javax.swing." + nm);
            } catch(ClassNotFoundException ex) {
                results.setText("No match");
                return;
            }
            Method[] methods = kind.getMethods();
            results.setText("");
            for(Method m : methods) {
                Matcher matcher =
                        addListener.matcher(m.toString());
                if(matcher.find())
                    results.append(qualifier.matcher(
                            matcher.group(1)).replaceAll("") + "\n");
            }
        }
    }
    public ShowAddListeners() {
        NameL nameListener = new NameL();
        name.addActionListener(nameListener);
        JPanel top = new JPanel();
        top.add(new JLabel("Swing class name (press Enter):"));
        top.add(name);
        add(BorderLayout.NORTH, top);
        add(new JScrollPane(results));
// Initial data and test:
        name.setText("JTextArea");
        nameListener.actionPerformed(
                new ActionEvent("", 0 ,""));
    }
    public static void main(String[] args) {
        run(new ShowAddListeners(), 500, 400);
    }
} ///:~