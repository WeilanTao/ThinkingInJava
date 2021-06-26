package Chapter22_GUI.SwingComponents;

//: gui/ButtonGroups.java
// Uses reflection to create groups
// of different types of AbstractButton.

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.lang.reflect.Constructor;

import static Chapter22_GUI.SwingConsole.run;

public class ButtonGroups extends JFrame {
    private static String[] ids = {
            "June", "Ward", "Beaver", "Wally", "Eddie", "Lumpy"
    };
    static JPanel makeBPanel(
            Class<? extends AbstractButton> kind, String[] ids) {
        ButtonGroup bg = new ButtonGroup();
        JPanel jp = new JPanel();
        String title = kind.getName();
        title = title.substring(title.lastIndexOf('.') + 1);
        jp.setBorder(new TitledBorder(title));
        for(String id : ids) {
            AbstractButton ab = new JButton("failed");
            try {
// Get the dynamic constructor method
// that takes a String argument:
                /**
                 *
                 * The getConstructor( ) method produces a Constructor object
                 * that takes the array of arguments of the types in the list
                 * of Classes passed to getConstructor( ).
                 * Then all you do is call newInstance( ), passing it a list
                 * of arguments—in this case, just the String from the ids array.
                 *
                 */
                Constructor ctor =
                        kind.getConstructor(String.class);
// Create a new object:
                ab = (AbstractButton)ctor.newInstance(id);
            } catch(Exception ex) {
                System.err.println("can’t create " + kind);
            }
            bg.add(ab);
            jp.add(ab);
        }
        return jp;
    }
    public ButtonGroups() {
        setLayout(new FlowLayout());
        add(makeBPanel(JButton.class, ids));
        add(makeBPanel(JToggleButton.class, ids));
        add(makeBPanel(JCheckBox.class, ids));
        add(makeBPanel(JRadioButton.class, ids));
    }
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        run(new ButtonGroups(), 500, 350);
    }
}
