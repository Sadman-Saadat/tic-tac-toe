import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestDefensiveAI {
    @Test
    public void verticalCheckTest(){
        tic_tac_toe ticTacToe = new tic_tac_toe();
        DefensiveAI defensiveAI1 = new DefensiveAI(ticTacToe.game_move);

        ticTacToe.playerMove(0, 0);
        ticTacToe.playerMove(1, 0);

        String str = String.valueOf(2) + String.valueOf(0);
        int temp = Integer.parseInt(str);

        int verticle_check = defensiveAI1.AImove(3);
        Assertions.assertEquals(temp, verticle_check);
    }

    @Test
    public void horizontalCheckTest(){
        tic_tac_toe ticTacToe1 = new tic_tac_toe();
        DefensiveAI defensiveAI2 = new DefensiveAI(ticTacToe1.game_move);

        ticTacToe1.playerMove(0, 0);
        ticTacToe1.playerMove(0, 1 );

        String str2 = String.valueOf(0) + String.valueOf(2);
        int temp2 = Integer.parseInt(str2);

        int horizontal_check = defensiveAI2.AImove(3);
        Assertions.assertEquals(temp2, horizontal_check);
    }

    @Test
    public void diagonalCheckTest(){
        tic_tac_toe ticTacToe2 = new tic_tac_toe();
        DefensiveAI defensiveAI3 = new DefensiveAI(ticTacToe2.game_move);

        ticTacToe2.playerMove(0, 0);
        ticTacToe2.playerMove(1,1);

        String str3 = String.valueOf(2) + String.valueOf(2);
        int temp3 = Integer.parseInt(str3);

        int horizontal_check = defensiveAI3.AImove(3);
        Assertions.assertEquals(temp3, horizontal_check);
    }
}
