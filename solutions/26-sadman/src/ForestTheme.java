import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class ForestTheme implements Theme {

    JPanel Panel_board;
    Hashtable<Integer, JButton> hash1 = new Hashtable<Integer, JButton>();
    ImageIcon fruit, flower;

    public ForestTheme(JPanel panel_board, Hashtable<Integer, JButton> hash1, ImageIcon fruit, ImageIcon flower) {
        Panel_board = panel_board;
        this.hash1 = hash1;
        this.fruit = fruit;
        this.flower = flower;
    }

    public void theme(){

        Panel_board.setBackground(Color.decode("#006400"));
        for (int i = 0; i < 3; i++) {
            for(int j=0; j<3; j++){
                String str = String.valueOf(i)+ String.valueOf(j);
                int temp = Integer.parseInt(str);
                hash1.get(temp).setBackground(Color.decode("#90EE90"));
            }

        }
    }

    public void applyThemeAi(int n){
        hash1.get(n).setIcon(fruit);
    }



    public void applyThemePlayer(int n){

        hash1.get(n).setIcon(flower);



    }
}