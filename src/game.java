import java.util.Scanner;

public class game {

    public static void main(String[] args){
        int i = 0;
        String score = "0 - 0";
        while( i == 0){
            int boardwidth = setBoardwidth();
            int winner = playGame(boardwidth-1);
            score = makeScore(score, winner);
            System.out.println("Poängställning: " + score);
            if(dontPlayAgain()){
                i = 1;
            }
        }
    }



    public static int setBoardwidth(){
        Scanner tgb = new Scanner(System.in);
        while(true){
            System.out.print("Välj brädstorlek 3, 4 eller 5: ");
            int a = Integer.parseInt(tgb.nextLine());
            System.out.println();
            if(a == 3 || a == 4 || a == 5){
                return a;
            }
        }
    }

    public static int playGame(int a){
        int currentleader = 0;
        char[][] board = new char[a+1][a+1];
        for(int i = 0; i <= a; i++){
            for(int u = 0; u <= a; u++){
                board[i][u] = '-';
            }
        }
        for(int i = 0; i < (a+1)*(a+1); i++){
            System.out.println(currentBoard(board, a));
            int[] koo = pickSquare(a, i);
            if(freeSquare(board, koo)){
                if(player1(i)){
                    board[koo[0]][koo[1]] = 'X';
                }
                else{
                    board[koo[0]][koo[1]] = 'O';
                }
                currentleader = whoIsWinning(board, a);
            }
            else{
                i -= takenSquare();
            }
            if(currentleader != 0){
                System.out.println(currentBoard(board, a));
                return currentleader;
            }
        }
        return 0;
    }

    public static String makeScore(String s, int a){
        int[] score = new int[2];
        score[0] = Integer.parseInt(s.substring(0, s.indexOf(' ')));
        score[1] = Integer.parseInt(s.substring(s.lastIndexOf(' ')+1));
        System.out.println(whoWon(a));
        if(player1Won(a)){
            score[0] += 1;
        }
        else if(player2Won(a)){
            score[1] += 1;
        }
        return score[0] + " - " + score[1];
    }

    public static boolean dontPlayAgain(){
        Scanner tgb = new Scanner(System.in);
        System.out.print("Spela igen? j/n ");
        return tgb.nextLine().equals("n");
    }



    public static String currentBoard(char[][] place, int a){
        for(int i = 0; i <= a; i++){
            for(int j = 0; j <= a; j++){
                System.out.print(place[i][j] + " ");
            }
            System.out.println();
        }
        return "";
    }

    public static int[] pickSquare(int a, int i){
        Scanner tgb = new Scanner(System.in);
        while(true){
            System.out.println(whooseTurn(i));
            int[] koordinat = new int[2];
            System.out.print("Vilken rad? 1 - " + (a+1) + ": ");
            koordinat[0] = Integer.parseInt(tgb.nextLine())-1;
            System.out.print("Vilken kolumn? 1 - " + (a+1) + ": ");
            koordinat[1] = Integer.parseInt(tgb.nextLine())-1;
            System.out.println();
            if(validCoordinates(koordinat, a)){
                return koordinat;
            }
            else{
                System.out.println("Ogiltiga koordinater!");
                System.out.println();
            }
        }
    }

    public static boolean freeSquare (char[][] place, int[] koo){
        return place[koo[0]][koo[1]] == '-';
    }

    public static boolean player1(int a){
        return a % 2 == 0;
    }

    public static int whoIsWinning(char[][] place, int a){
        char[] line = new char[a+1];
        for(int i = 0; i <= a; i++){
            for(int j = 0; j <= a; j++){
                line[j] = place[i][j];
            }
            if(match(line, a)){
                return correctValue(line);
            }
        }
        for(int i = 0; i <= a; i++){
            for(int j = 0; j <= a; j++){
                line[j] = place[j][i];
            }
            if(match(line, a)){
                return correctValue(line);
            }
        }
        for(int i = 0; i <= a; i++){
            line[i] = place[i][i];
        }
        if(match(line, a)){
            return correctValue(line);
        }
        for(int i = 0; i <= a; i++){
            line[i] = place[a-i][i];
        }
        if(match(line, a)){
            return correctValue(line);
        }
        return 0;
    }

    public static int takenSquare(){
        System.out.println("Den rutan är upptagen!");
        System.out.println();
        return 1;
    }

    public static String whoWon(int a){
        String s;
        if(player1Won(a)){
            s = "Spelare 1 (X) vann!";
        }
        else if(player2Won(a)){
            s = "Spelare 2 (O) vann!";
        }
        else{
            s = "Oavgjort!";
        }
        return s;
    }



    public static String whooseTurn(int a){
        if(player1(a)){
            return "Spelare 1:";
        }
        return "Spelare 2:";
    }

    public static boolean validCoordinates(int[] koo, int a){
        return koo[0] <= a && koo[0] >= 0 && koo[1] <= a && koo[1] >= 0;
    }

    public static boolean match(char[] line, int a){
        for(int i = 1; i <= a; i++){
            if(line[0] != line[i] || line[0] == '-'){
                return false;
            }
        }
        return true;
    }

    public static int correctValue(char[] line){
        if(line[0] == 'X'){
            return 1;
        }
        else{
            return 2;
        }
    }

    public static boolean player1Won(int a){
        return a == 1;
    }

    public static boolean player2Won(int a){
        return a == 2;
    }

}
