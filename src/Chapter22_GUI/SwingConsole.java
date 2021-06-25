package Chapter22_GUI;

import javax.swing.*;

public class SwingConsole {
    public static void run(final JFrame f, int width, int height){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                f.setTitle(f.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
                f.setSize(width, height);
            }
        });
    }
}
