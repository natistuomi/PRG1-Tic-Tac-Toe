import javax.swing.*;
import java.util.Scanner;

public class game {

    public static void main(String[] args){
        int A = setA();
        int winner = playGame(A);
        System.out.println(whoWon(winner));
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
        int currentleader = 0;
        char[][] spelplan = new char[a][a];
        for(int i = 0; i < a; i++){
            for(int u = 0; u < a; u++){
                spelplan[i][u] = '-';
            }
        }
        for(int i = 0; i < a*a; i++){
            System.out.println(currentBoard(spelplan, a));
            int[] koo = pickSquare(a);
            if(freeSquare(spelplan, koo)){
                if(player1(i)){
                    spelplan[koo[0]][koo[1]] = 'X';
                }
                else{
                    spelplan[koo[0]][koo[1]] = 'O';
                }
                currentleader = whoIsWinning(spelplan, a);
            }
            else{
                i -= takenSquare();
            }
            if(currentleader != 0){
                return currentleader;
            }
        }
        return 0;
    }

    public static int[] pickSquare(int a){
        Scanner tgb = new Scanner(System.in);
        while(true){
            int[] koordinat = new int[2];
            System.out.print("Vilken rad? 0 - " + (a-1) + ":");
            koordinat[0] = Integer.parseInt(tgb.nextLine());
            System.out.print("Vilken kolumn? 0 - " + (a-1) + ":");
            koordinat[1] = Integer.parseInt(tgb.nextLine());
            if(koordinat[0] <= 9 && koordinat[0] >= 0){
                if(koordinat[1] <= 9 && koordinat[1] >= 0){
                    return koordinat;
                }
            }
        }
    }

    public static String currentBoard(char[][] place, int a){
        for(int i = 0; i < a; i++){
            for(int j = 0; j < a; j++){
                System.out.print(place[i][j] + " ");
            }
            System.out.println();
        }
        return "";
    }

    public static boolean freeSquare (char[][] place, int[] koo){
        return place[koo[0]][koo[1]] == '-';
    }

    public static int takenSquare(){
        System.out.println("That square is already taken!");
        return 1;
    }
    
    public static boolean player1(int a){
        return a % 2 == 0;
    }
    
    public static int whoIsWinning(char[][] place, int a){
        char[] line = new char[a];
        System.out.println(currentBoard(place, a));
        for(int i = 0; i < a; i++){
            for(int j = 0; j < a; j++){
                line[j] = place[i][j];
            }
            if(match(line, a)){
                if(line[0] == 'X'){
                    return 1;
                }
                else if(line[0] == 'O'){
                    return 2;
                }
            }
        }
        for(int i = 0; i < a; i++){
            for(int j = 0; j < a; j++){
                line[j] = place[j][i];
            }
            if(match(line, a)){
                if(line[0] == 'X'){
                    return 1;
                }
                else if(line[0] == 'O'){
                    return 2;
                }
            }
        }
        for(int i = 0; i < a; i++){
            line[i] = place[i][i];
            if(match(line, a)){
                if(line[0] == 'X'){
                    return 1;
                }
                else if(line[0] == 'O'){
                    return 2;
                }
            }
        }
        for(int i = 0; i < a; i++){
            line[i] = place[a-i][i];
            if(match(line, a)){
                if(line[0] == 'X'){
                    return 1;
                }
                else if(line[0] == 'O'){
                    return 2;
                }
            }
        }
        return 0;
    }
    
    public static boolean match(char[] line, int a){
        for(int i = 1; i < a; i++){
            if(line[0] != line[i]){
                return false;
            }
        }
        return true;
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
        return s;
    }

    public static boolean player1Won(int a){
        return a == 1;
    }

    public static boolean player2Won(int a){
        return a == 2;
    }

}
