import javax.swing.*;

public class Display {
    JFrame jFrame = new JFrame();
    JPanel panel1;

    Display(JPanel panel1){
        this.panel1 = panel1;
    }

    void Method(){
        jFrame.setVisible(true);
        jFrame.setResizable(true);
        jFrame.setSize(800, 800);
        jFrame.add(panel1);
        jFrame.setLocation(400, 200);
    }

}
