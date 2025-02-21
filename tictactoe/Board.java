package tictactoe;

public class Board {
    private char board[][];

    public Board(){
        board = new char[3][3];

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                board[i][j] = '_';
            }
        }

    }

    public void printboard(){
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                System.out.print(board[i][j]);
                if(j == 2){
                    System.out.println();
                } else{
                    System.out.print(" ");
                }
            }
        }
    }

    public boolean isfull(){
        for(int i = 0; i<3; i++){
            for(int j = 0; j <3; j++){
                if(board[i][j] == '_'){
                    return false;
                }
            }
        }
        return true;
    }

    public char iswinner(){
        // baris
        for(int i = 0; i<3; i++){
            if(board[i][0] != '_' && board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                return board[i][0];
            }
        }
        // kolom
        for(int i = 0; i<3; i++){
            if(board[0][i] != '_' && board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                return board[0][i];
            }
        }
        // diagonal
        if(board[0][0] != '_' && board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            return board[0][0];
        }
        if(board[0][2] != '_' && board[0][2] == board[1][1] && board[1][1] == board[2][0]){
            return board[0][2];
        }

        return '_';
    }

    public boolean setMarker(int x, int y, char marker){
        if(board[y][x] == '_'){
            board[y][x] = marker;
            return true;
        } else{
            return false;
        }
    }

}
