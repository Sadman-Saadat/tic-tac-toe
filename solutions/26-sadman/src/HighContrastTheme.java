import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class HighContrastTheme implements Theme {

    JPanel Panel_board;
    Hashtable<Integer, JButton> hash1 = new Hashtable<Integer, JButton>();

    public HighContrastTheme(JPanel panel_board, Hashtable<Integer, JButton> hash1) {
        Panel_board = panel_board;
        this.hash1 = hash1;
    }

    public void theme(){
        Panel_board.setBackground(Color.decode("#D3D3D3"));
        for (int i = 0; i < 3; i++) {
            for(int j=0; j<3; j++){
                String str = String.valueOf(i)+ String.valueOf(j);
                int temp = Integer.parseInt(str);
                hash1.get(temp).setBackground(Color.decode("#A9A9A9"));
            }

        }

    }

    public void applyThemeAi(int n){

        hash1.get(n).setBackground(Color.WHITE);


    }

    public void applyThemePlayer(int n){

        hash1.get(n).setBackground(Color.BLACK);

    }
}