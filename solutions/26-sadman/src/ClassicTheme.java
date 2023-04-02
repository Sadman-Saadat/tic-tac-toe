import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class ClassicTheme implements Theme {

    JPanel Panel_board;
    Hashtable<Integer, JButton> hash1 = new Hashtable<Integer, JButton>();
    ClassicTheme(JPanel Panel_board, Hashtable<Integer, JButton> hash1){
        this.Panel_board = Panel_board;
        this.hash1 = hash1;

    }
    public void theme() {
            Panel_board.setBackground(Color.BLACK);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    String str = String.valueOf(i) + String.valueOf(j);
                    int temp = Integer.parseInt(str);
                    hash1.get(temp).setBackground(Color.WHITE);

                }

            }

    }

    public void applyThemeAi(int n){

            hash1.get(n).setText("O");

    }

    public void applyThemePlayer(int n){

            hash1.get(n).setText("X");

    }

}
