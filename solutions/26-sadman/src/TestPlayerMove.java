import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;

public class TestPlayerMove {
    @Test

        public void testing(){
        tic_tac_toe ticTacToe = new tic_tac_toe();

        boolean b1 = ticTacToe.playerMove(0, 0);
        Assertions.assertEquals(true, b1);

        boolean b2 = ticTacToe.playerMove(0, 0);
        Assertions.assertEquals(false, b2);
    }
}
