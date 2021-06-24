package Chapter12_GUI;

import javax.swing.*;
import java.util.concurrent.TimeUnit;
/**
 * C12E3
 * @author Emily
 * @Date Jun 24, 2021
 */

/**
 * To use it, your application must be in a JFrame.
 * The static run( ) method sets the title of the window to the simple class name of the JFrame
 */
public class SwingConsoleC12E3 {
    static SwingProgram swingProgram;
    public static void main(String args[]) throws InterruptedException {
        run(swingProgram=new SwingProgram(),300,200);
        TimeUnit.SECONDS.sleep(1);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                swingProgram.label.setText("Hi this is a different label");
            }
        });
    }
    public static void run(final JFrame f, final int width, final int height) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                f.setTitle(f.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(width, height);
                f.setVisible(true);
            }
        });

    }
}

class SwingProgram extends JFrame {
    JLabel label;

    public SwingProgram(){
        label=new JLabel("Hi this is a label");
        add(label);
    }
}


