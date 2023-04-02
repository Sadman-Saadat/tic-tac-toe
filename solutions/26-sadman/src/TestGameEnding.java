import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestGameEnding {
    @Test
    public void verticalEndingTest(){
        tic_tac_toe ticTacToe = new tic_tac_toe();
        GameState gameState = new GameState(ticTacToe.game_move);

        ticTacToe.playerMove(0, 0);
        ticTacToe.playerMove(1, 0);
        ticTacToe.playerMove(2, 0);

        boolean b1 = gameState.GameEndingCheck(3);
        Assertions.assertEquals(true, b1);
    }

    @Test
    public void horizontalEndingTest(){
        tic_tac_toe ticTacToe2 = new tic_tac_toe();
        GameState gameState2 = new GameState(ticTacToe2.game_move);

        ticTacToe2.playerMove(0, 0);
        ticTacToe2.playerMove(0, 1 );
        ticTacToe2.playerMove(0, 2);

        boolean b2 = gameState2.GameEndingCheck(3);
        Assertions.assertEquals(true, b2);
    }

    @Test
    public void diagonalEndingTest(){
        tic_tac_toe ticTacToe3 = new tic_tac_toe();
        GameState gameState3 = new GameState(ticTacToe3.game_move);

        ticTacToe3.playerMove(0, 0);
        ticTacToe3.playerMove(1,1);
        ticTacToe3.playerMove(2, 2);

        boolean b3 = gameState3.GameEndingCheck(3);
        Assertions.assertEquals(true, b3);
    }

    @Test
    public void drawTest(){
        tic_tac_toe ticTacToe4 = new tic_tac_toe();
        GameState gameState4 = new GameState(ticTacToe4.game_move);

        ticTacToe4.playerMove(0, 0);
        ticTacToe4.playerMove(0, 1);
        ticTacToe4.playerMove(1, 1);
        ticTacToe4.playerMove(1, 2);
        ticTacToe4.playerMove(2,0);

        ticTacToe4.RandomAI();
        ticTacToe4.RandomAI();
        ticTacToe4.RandomAI();
        ticTacToe4.RandomAI();

        boolean b4 = gameState4.GameEndingCheck(3);
        Assertions.assertEquals(true, b4);
    }
}
