import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class tic_tac_toe extends JFrame {

    GameState gameState;
    AI ai;
    Theme theme;
    ImageIcon fruit, flower;
    int type_of_theme;
    int AI_type, check = 0;
    public char[][] game_move = new char[3][3];
    Hashtable<Integer, JButton> hash1 = new Hashtable<Integer, JButton>();


    public JPanel mainPanel;
    public JButton button1;
    public JButton button2;
    public JButton button3;
    public JButton button4;
    public JButton button5;
    public JButton button6;
    public JButton button7;
    public JButton button8;
    public JButton button9;

    private JButton startWithRandomAIButton;
    private JButton startWithDefensiveAIButton;
    private JRadioButton classicRadioButton;
    private JRadioButton forestRadioButton;
    private JRadioButton highContrastRadioButton;
    private JPanel Panel_board;

    Display display = new Display(mainPanel);


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    tic_tac_toe() {
        hash1.put(00, button1);
        hash1.put(01, button2);
        hash1.put(02, button3);
        hash1.put(10, button4);
        hash1.put(11, button5);
        hash1.put(12, button6);
        hash1.put(20, button7);
        hash1.put(21, button8);
        hash1.put(22, button9);

        InitializeArray();
        InitialGamePanel();

        flower = new ImageIcon("F:\\IUT\\3rd semester\\OOC\\tic-tac-toe-swe-18\\solutions\\26-sadman\\src\\flower_icon_actual (1).png");
        fruit = new ImageIcon("F:\\IUT\\3rd semester\\OOC\\tic-tac-toe-swe-18\\solutions\\26-sadman\\src\\fruit_icon_actual (1).png");

        gameState = new GameState(game_move);
        display.Method();
        startWithRandomAIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                buttonInitialize();
                InitializeArray();
                gamePanelLoad();

                ai = new RandomAI(game_move);
                AI_type = 1;

            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                applyMove(0, 0);

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                applyMove(0, 1);

            }

        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                applyMove(0, 2);

        }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                applyMove(1, 0);

            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                applyMove(1, 1);

            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                applyMove(1, 2);

            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                applyMove(2, 0);

            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                applyMove(2, 1);

            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                applyMove(2, 2);

            }
        });
        classicRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                theme = new ClassicTheme(Panel_board, hash1);
                load_Theme();
                theme();
                themeChange();

            }
        });
        forestRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                theme = new ForestTheme(Panel_board, hash1, fruit, flower);

                load_Theme();
                theme();
                themeChange();
            }
        });
        highContrastRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                theme = new HighContrastTheme(Panel_board, hash1);

                load_Theme();
                theme();
                themeChange();
            }
        });


        startWithDefensiveAIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                buttonInitialize();
                //StartGamePanel();
                InitializeArray();
                gamePanelLoad();

                ai = new DefensiveAI(game_move);
                AI_type = 2;


            }
        });
    }

    boolean playerMove(int x, int y){
        if(game_move[x][y]=='\0'){
            game_move[x][y] = 'X';
            return true;
        }
        else
            return false;
    }

    void applyThemeAi(int n){
        theme.applyThemeAi(n);
    }



    void applyThemePlayer(int n){
        theme.applyThemePlayer(n);
    }


    void theme(){
        theme.theme();
    }

    void themeChange(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(game_move[i][j]!='\0'){
                    if(game_move[i][j]=='X'){
                        String str = String.valueOf(i) + String.valueOf(j);
                        int t = Integer.parseInt(str);
                        applyThemePlayer(t);
                    }
                    else{
                        String str = String.valueOf(i) + String.valueOf(j);
                        int t = Integer.parseInt(str);
                        applyThemeAi(t);
                    }
                }
            }
        }
    }

    void load_Theme(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String str = String.valueOf(i) + String.valueOf(j);
                int t = Integer.parseInt(str);
                hash1.get(t).setText("");
                hash1.get(t).setIcon(null);
                hash1.get(t).setBackground(null);
            }
        }
    }

    void gamePanelLoad(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String str = String.valueOf(i) + String.valueOf(j);
                int t = Integer.parseInt(str);
                hash1.get(t).setText("");
                hash1.get(t).setIcon(null);
                game_move[i][j] = '\0';

                hash1.get(t).setEnabled(true);
            }
        }
        theme();

    }
    int RandomAI() {

                int t = ai.AImove(3);
                applyThemeAi(t);
                return t;

    }

    public int defensiveAI(int n) {
        int defensiveAiMove = ai.AImove(3);
        if(defensiveAiMove != -1)
            applyThemeAi(defensiveAiMove);
            return defensiveAiMove;
    }

    int arrayIndexMappingWithButton(int x,int y) {
        return 3*x+y+1;
    }
    void InitializeArray() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game_move[i][j] = '\0';
            }
        }
    }

    void InitialGamePanel() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String str;
                int temp;
                str = String.valueOf(i) + String.valueOf(j);
                temp = Integer.parseInt(str);
                hash1.get(temp).setEnabled(false);
            }
        }
    }

    void buttonInitialize(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String str;
                int temp;
                str = String.valueOf(i) + String.valueOf(j);
                temp = Integer.parseInt(str);

                hash1.get(temp).setEnabled(true);
                hash1.get(temp).setText("");
            }
        }
    }

    boolean GameEndingCheck(int n){

        boolean b = gameState.GameEndingCheck(3);

        if(b){
            disableButton();
            return true;
        }
        return false;
    }

    void applyMove(int x, int y){
        boolean b2 = playerMove(x, y);
        if (b2) {
            String str = String.valueOf(x) + String.valueOf(y);
            int temp = Integer.parseInt(str);
            applyThemePlayer(temp);
            boolean b1 = GameEndingCheck(3);
            if (!b1) {
                if (AI_type == 1) {
                    RandomAI();
                } else
                    defensiveAI(3);

                GameEndingCheck(3);
            }
        }
    }

    void disableButton(){
        for (int i = 0; i < 3; i++) {
            for(int j=0; j < 3; j++) {
                String str = String.valueOf(i) + String.valueOf(j);
                int temp = Integer.parseInt(str);

                hash1.get(temp).setEnabled(false);
            }
        }
    }
    public boolean verticalEndingCheck(int n) {
        int flag=1,i,j;
        for(j=0;j<n;j++){
            flag=1;
            for( i=0;i<n-1;i++){
                if(game_move[i][j]!=game_move[i+1][j] || game_move[i][j]=='\0' || game_move[i+1][j]=='\0'){
                    flag=0;
                    break;
                }
            }
            if(flag==1){

                disableButton();
                if(game_move[i][j]=='X') {
                    JOptionPane.showMessageDialog(null, "Player Win!!");
                    System.out.println("player win");
                    check=1;
                }
                else {
                    check=2;
                    JOptionPane.showMessageDialog(null, "AI win!!");
                    System.out.println("Ai win");
                }
                //  disableButton(9);
                return true;
            }
        }
        return false;
    }

    public boolean horizontalEndingCheck(int n) {
        int flag=1,i,j;
        for(i=0;i<n;i++){
            flag=1;
            for(j=0;j<n-1;j++){
                if(game_move[i][j]!=game_move[i][j+1] || game_move[i][j]=='\0' || game_move[i][j+1]=='\0'){
                    flag=0;
                    break;
                }
            }
            if(flag==1){

                disableButton();
                if(game_move[i][j]=='X') {
                    JOptionPane.showMessageDialog(null, "Player Win!!");
                    System.out.println("player win");
                    check=1;
                }
                else {
                    JOptionPane.showMessageDialog(null, "AI Win!!");
                    System.out.println("Ai win");
                    check=2;
                }
                return true;
            }
        }
        return false;

    }
    public boolean diagonalEndingCheck(int n) {
        int flag=1,i,j;
        for(i=0, j=0 ; i<n-1 && j<n-1 ; i++,j++){
            if(game_move[i][j]!=game_move[i+1][j+1] || game_move[i][j]=='\0' || game_move[i+1][j+1]=='\0'){
                flag=0;
                break;
            }
        }
        if(flag==1){
            disableButton();
            if(game_move[i][j]=='X') {
                JOptionPane.showMessageDialog(null, "Player Win!!");
                System.out.println("player win");
                check=1;
            }
            else {
                JOptionPane.showMessageDialog(null, "AI Win!!");
                System.out.println("Ai win");
                check=2;;
            }
            return true;
        }
        flag=1;
        for(i=0, j=n-1 ; i<n-1 && j>0 ; i++,j--){
            if(game_move[i][j]!=game_move[i+1][j-1] || game_move[i][j]=='\0' || game_move[i+1][j-1]=='\0'){
                flag=0;
                break;
            }
        }
        if(flag==1){
            disableButton();
            if(game_move[i][j]=='X') {
                JOptionPane.showMessageDialog(null, "Player Win!!");
                System.out.println("player win");
                check=1;
            }
            else {
                JOptionPane.showMessageDialog(null, "AI Win!!");
                System.out.println("Ai win");
                check=2;
            }
            return true;
        }
        return false;
    }
    public boolean drawCheck(int n) {
        int flag=1,i,j;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(game_move[i][j]=='\0'){
                    flag=0;
                    break;
                }
            }
        }
        if(flag==1) {
            disableButton();
            JOptionPane.showMessageDialog(null, "Match Draw :(");
            System.out.println("Draw!");
            check=3;
            return true;
        }
        return false;
    }

}