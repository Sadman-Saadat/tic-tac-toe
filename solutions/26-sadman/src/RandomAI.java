import java.util.Random;

public class RandomAI implements AI{

    char game_move[][]= new char[3][3];
    RandomAI(char [][]game_move){
        this.game_move = game_move;
    }
    public int AImove(int n) {
        int temp, flag = 0;
        String str = null;

        while (true){
            Random random = new Random();
            int random1 = random.nextInt(3);
            int random2 = random.nextInt(3);

            if(game_move[random1][random2]=='\0'){
                game_move[random1][random2] = 'O';

                String s = String.valueOf(random1) + String.valueOf(random2);
                int t = Integer.parseInt(s);

                return t;
            }


        }
    }


    }

