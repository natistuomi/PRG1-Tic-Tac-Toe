import javax.swing.*;

public class game {

    public static void main(String[] args){
        int A = setA();
        int winner = playGame(A);
        JOptionPane.showMessageDialog(whoWon(winner));
    }

    public static int setA(){
        while(true){
            int a = 3;
            if(a == 3 || a == 4 || a == 5){
                return a;
            }
        }
    }

    public static int playGame(int a){
        char[][] spelplan = new char[a][a];
        for(int i = 0; i < a; i++){
            for(int u = 0; u < a; u++){
                spelplan[i][u] = '-';
            }
        }
        for(int i = 0; i < a*a; i++){
            int s = pickSquare(a);
        }
    }

    public static int pickSquare(int a){
        while(true){
            int s = Integer.parseInt(JOptionPane.showInputDialog("Välj koordinater mellan 0 och " + a + ". Skriv kooridnaterna som ett tvåsiffrigt tal, ex. '01', '32' eller '30'. "));
            if(sIsValid(s)){
                return s;
            }
        }
    }

    public static String whoWon(int a){
        String s;
        if(player1Won(a)){
            s = "Player 1 (X's) won";
        }
        else if(player2Won(a)){
            s = "Player 2 (O's) won";
        }
        else{
            s = "It was a draw";
        }
    }

    public static boolean player1Won(int a){
        return a == 1;
    }

    public static boolean player2Won(int a){
        return a == 2;
    }

}
