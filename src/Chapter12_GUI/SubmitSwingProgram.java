package Chapter12_GUI;

import javax.swing.*;

public class SubmitSwingProgram extends JFrame {
    static SubmitSwingProgram ssp;
    JLabel label;
    JLabel label1;
    JLabel label2;

    public SubmitSwingProgram (){
        super("Hello Swing");
        setLayout(null);
        label=new JLabel("A Label");
        label.setSize(100, 10);
        label.setLocation(100,20);
        label1=new JLabel("This is Label 1");
        label1.setSize(100, 10);
        label1.setLocation(100,30);
        label2=new JLabel("This is Label 2");
        label2.setSize(100, 10);
        label2.setLocation(100,40);
        add(label);
        add(label1);
        add(label2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,200);
        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ssp=new SubmitSwingProgram();

            }
        });
        try{
            Thread.sleep(3000);
        }catch(InterruptedException ie){}
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ssp.label.setText("Hi there. It's different");
            }
        });
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ie){
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ssp.label1.setText("Hi there. It's different");
                ssp.label.setText("Label is back");
            }
        });
        try{
            Thread.sleep(8000);
        }catch(InterruptedException ie){
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ssp.label2.setText("Hi there. It's different");
                ssp.label1.setText("Hi label 1 is back");
            }
        });


    }
}
