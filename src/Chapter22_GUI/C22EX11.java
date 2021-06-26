package Chapter22_GUI;

/**
 * @File
 * @Author Emily Weilan Tao
 * @Date Jun 25, 2020
 * @Description JButton_ColorBox
 * @Since version-1.0
 * @Copyright Copyright (c) 2020
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import static Chapter22_GUI.SwingConsole.run;

public class C22EX11 extends JFrame {

    JButton coloringButton = new JButton("hihihi");


    public C22EX11() {
        setLayout(new FlowLayout());
        Random random=new Random();
        coloringButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                coloringButton.setBackground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            }
        });


        add(coloringButton);
    }

    public static void main(String[] args) {
        run(new C22EX11(), 400, 300);
    }
}
