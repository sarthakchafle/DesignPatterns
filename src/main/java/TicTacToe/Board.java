package TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    static class Pair {
        int a,b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public int size;
    public PlayingPiece[][] board;

    public Board(int size) {
        this.size=size;
        board = new PlayingPiece[size][size];
    }
    public boolean addPiece(int row,int col,PlayingPiece playingPiece){
        if(board[row][col]!=null){
            return false;
        }
        board[row][col] = playingPiece;
        return true;
    }
    public List<Pair> getFreeCells(){
        List<Pair> freeCells = new ArrayList<>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null){
                    Pair p = new Pair(i, j);
                    freeCells.add(p);
                }
            }
        }
        return freeCells;
    }
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].getPieceType() + " "); // Print enum value (X or O)
                } else {
                    System.out.print("- "); // Placeholder for empty cells
                }
            }
            System.out.println(); // New line for each row
        }
    }
}
