package main;
import java.util.Scanner;

import tictactoe.Board;

public class tic {
    Boolean turn = true; // true for player one & false for player two

    public tic(){
        Board board = new Board();
        board.printboard();

        Scanner Input = new Scanner(System.in);
        int x, y;
        char marker;
        char winner = '_';
        
        while(winner == '_' && board.isfull() == false){
            if(turn == true){
                System.out.print("Player 1 move: ");
                marker = 'O';
            } else{
                System.out.print("Player 2 move: ");
                marker = 'X';
            }
            
            try{
                x = Input.nextInt();
                y = Input.nextInt();
                if(x < 0 || x > 2 || y < 0 || y > 2){
                    System.out.println("Invalid");
                } else if(board.setMarker(x,y,marker) == true){
                    turn = !turn;
                    board.printboard();
                    winner = board.iswinner();
                    
                    if(winner != '_'){
                        System.out.println((winner == 'O' ? "Player 1": "Player 2") + " Win");
                        break;
                    }
                } else{
                    System.out.println("Invalid");
                }
            } catch(Exception e){
                System.out.println("Invalid");
                Input.nextLine();
            }
        }
        if(winner == '_' && board.isfull() == true){
            System.out.println("Draw");
        }

       Input.close();
    }

    public static void main(String[] args){
        new tic();
    }
}
