import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestRandomAI {

    @Test
    public void testing(){
        tic_tac_toe ticTacToe = new tic_tac_toe();
        RandomAI randomAI = new RandomAI(ticTacToe.game_move);

        ticTacToe.playerMove(0, 0);
        ticTacToe.playerMove(0, 1);
        ticTacToe.playerMove(0, 2);
        ticTacToe.playerMove(1, 0);
        ticTacToe.playerMove(1, 1);
        ticTacToe.playerMove(1, 2);

        int random_ai = randomAI.AImove(3);
        boolean b = true;
        int flag = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                String str = String.valueOf(i) + String.valueOf(j);
                int temp = Integer.parseInt(str);

                if (random_ai == temp){
                    flag = 1;
                    break;
                }
            }
            if(flag == 1)
                break;
        }
        if(flag == 1){
            b = false;
        }

        Assertions.assertEquals(true, b);
    }
}
