public class DefensiveAI implements AI{

    char a[][]= new char[3][3];
    DefensiveAI(char [][]a){
        this.a = a;
    }

    public int AImove(int n) {
        int  defensiveAiMove= verticleDefensiveAi(n);
        System.out.println(defensiveAiMove);
        if(defensiveAiMove==-1){
            defensiveAiMove=horizontalDefensiveAi(n);
            System.out.println(defensiveAiMove);
        }
        if(defensiveAiMove==-1){

            defensiveAiMove=diagonalDefensiveAi(n);
            System.out.println(defensiveAiMove);
        }
        if(defensiveAiMove==-1){

            RandomAI randomAI = new RandomAI(a);
            defensiveAiMove = randomAI.AImove(3);
            System.out.println(defensiveAiMove);
        }
        return defensiveAiMove;
    }

    private int verticleDefensiveAi(int n) {
        for(int i=0,j=0;j<n;j++){
            for(int k=i;k<n-1;k++){
                for(int l=k+1;l<n;l++){
                    if(a[k][j]==a[l][j] && a[k][j]!='\0' && a[l][j]!='\0'){
                        int temp=(n)-(k+l);
                        if(a[temp][j]=='\0') {
                            a[temp][j] = 'O';
                            String str = String.valueOf(temp)+ String.valueOf(j);
                            int t = Integer.parseInt(str);


                            return t;
                        }

                    }
                }
            }
        }
        return -1;
    }
    private int horizontalDefensiveAi(int n) {
        for(int i=0,j=0;i<n;i++){
            for(int k=j;k<n-1;k++){
                for(int l=k+1;l<n;l++){
                    if(a[i][k]==a[i][l] && a[i][k]!='\0' && a[i][l]!='\0'){
                        int temp=(n)-(k+l);
                        if(a[i][temp]=='\0') {
                            a[i][temp] = 'O';
                            String str = String.valueOf(i)+ String.valueOf(temp);
                            int t = Integer.parseInt(str);

                            return t;
                        }
                    }
                }
            }
        }
        return -1;
    }
    private int diagonalDefensiveAi(int n) {
        for(int i=0,j=0;i<n-1;i++,j++){
            for(int k=i,m=j;k<n-1;k++,m++){
                for(int l=k+1,o=m+1;l<n;l++,o++){
                    if(a[k][m]==a[l][o] && a[k][m]!='\0' && a[l][o]!='\0'){
                        int temp1=(n)-(k+l);
                        int temp2=(n)-(m+o);
                        System.out.println(temp1);
                        System.out.println(temp2);
                        if(a[temp1][temp2]=='\0') {
                            a[temp1][temp2] = 'O';
                            String str = String.valueOf(temp1)+ String.valueOf(temp2);
                            int t = Integer.parseInt(str);
                            return t;
                        }
                    }
                }
            }
        }
        for(int i=0,j=n-1;i<n-1;i++,j--){
            for(int k=i,m=j;k<n-1;k++,m--){
                for(int l=k+1,o=m-1;l<n;l++,o--){
                    if(a[k][m]==a[l][o] && a[k][m]!='\0' && a[l][o]!='\0'){
                        int temp1=(n)-(k+l);
                        int temp2=(n)-(m+o);
                        if(a[temp1][temp2]=='\0') {
                            a[temp1][temp2] = 'O';
                            String str = String.valueOf(temp1)+ String.valueOf(temp2);
                            int t = Integer.parseInt(str);
                            return t;
                        }


                    }
                }
            }
        }
        return -1;
    }
}

