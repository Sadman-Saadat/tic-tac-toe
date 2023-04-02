import javax.swing.*;

public class GameState {

    char game_move[][] = new char[3][3];

    public GameState(char[][] game_move) {
        this.game_move = game_move;
    }

    boolean GameEndingCheck(int n){

        boolean b1,b2,b3,b4;
        b1= verticalEndingCheck(n);
        b2= horizontalEndingCheck(n);
        b3= diagonalEndingCheck(n);

        if(b1 || b2 || b3)
            return true;
        else {
            b4=drawCheck(n);
            if(b4)
                return true;
        }
        return false;
    }

    private boolean verticalEndingCheck(int n) {
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

                //disableButton();
                if(game_move[i][j]=='X') {
                    JOptionPane.showMessageDialog(null, "Player Win!!");
                    System.out.println("player win");
                    //check=1;
                }
                else {
                    //check=2;
                    JOptionPane.showMessageDialog(null, "AI win!!");
                    System.out.println("Ai win");
                }
                //  disableButton(9);
                return true;
            }
        }
        return false;
    }

    private boolean horizontalEndingCheck(int n) {
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

                //disableButton();
                if(game_move[i][j]=='X') {
                    JOptionPane.showMessageDialog(null, "Player Win!!");
                    System.out.println("player win");
                    //  check=1;
                }
                else {
                    JOptionPane.showMessageDialog(null, "AI Win!!");
                    System.out.println("Ai win");
                    //check=2;
                }
                // disableButton(9);
                return true;
            }
        }
        return false;

    }

    private boolean diagonalEndingCheck(int n) {
        int flag=1,i,j;
        for(i=0, j=0 ; i<n-1 && j<n-1 ; i++,j++){
            if(game_move[i][j]!=game_move[i+1][j+1] || game_move[i][j]=='\0' || game_move[i+1][j+1]=='\0'){
                flag=0;
                break;
            }
        }
        if(flag==1){
            //disableButton();
            if(game_move[i][j]=='X') {
                JOptionPane.showMessageDialog(null, "Player Win!!");
                System.out.println("player win");
                //  check=1;
            }
            else {
                JOptionPane.showMessageDialog(null, "AI Win!!");
                System.out.println("Ai win");
                //check=2;;
            }
            // disableButton(9);
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
            //disableButton();
            if(game_move[i][j]=='X') {
                JOptionPane.showMessageDialog(null, "Player Win!!");
                System.out.println("player win");
                //  check=1;
            }
            else {
                JOptionPane.showMessageDialog(null, "AI Win!!");
                System.out.println("Ai win");
                //check=2;
            }
            //   disableButton(9);
            return true;
        }
        return false;
    }

    private boolean drawCheck(int n) {
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
            //disableButton();
            JOptionPane.showMessageDialog(null, "Match Draw :(");
            System.out.println("Draw!");
            //check=3;
            // disableButton(9);
            return true;
        }
        return false;
    }


}
