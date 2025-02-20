package TicTacToe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    TicTacToeGame() {
        initializeGame();
    }

    public void initializeGame() {

        players = new LinkedList<>();
        PlayingPieceX cross = new PlayingPieceX(PieceType.X);
        Player player1 = new Player("Player 1", cross);

        PlayingPieceO circle = new PlayingPieceO(PieceType.O);
        Player player2 = new Player("Player 2", circle);

        players.add(player1);
        players.add(player2);
        gameBoard = new Board(3);
    }

    public String startGame() {
        boolean noWinner = true;
        while (noWinner) {
            Player currentPlayer = players.removeFirst();
            gameBoard.printBoard();
            List<Board.Pair> freeCells = gameBoard.getFreeCells();
            if (freeCells.isEmpty()) {
                noWinner = false;
                return "Tie";
            }
            System.out.println("Player: " + currentPlayer.getName() + " Enter row,column: ");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            String[] values = s.split(",");
            int row = Integer.parseInt(values[0]);
            int col = Integer.parseInt(values[1]);

            boolean isPieceAddedSuccessfully = gameBoard.addPiece(row, col, currentPlayer.getPlayingPiece());
            if (!isPieceAddedSuccessfully) {
                System.out.println("Invalid position chosen, please try again");
                players.addFirst(currentPlayer);
            }
            players.addLast(currentPlayer);

            boolean winner = isWinnerPresent(row, col, currentPlayer.getPlayingPiece());
            if (winner) {
                return currentPlayer.getName();
            }
        }
        return "tie";
    }

    private boolean isWinnerPresent(int row, int col, PlayingPiece playingPiece) {
        boolean rowWin = true;
        for (int j = 0; j < gameBoard.size; j++) {
            if (gameBoard.board[row][j] == null || gameBoard.board[row][j].pieceType != playingPiece.getPieceType()) {
                rowWin = false;
                break;
            }
        }

        // Check Column
        boolean colWin = true;
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][col] == null || gameBoard.board[i][col].pieceType != playingPiece.getPieceType()) {
                colWin = false;
                break;
            }
        }

        // Check Primary Diagonal (Top-left to bottom-right)
        boolean primaryDiagonalWin = true;
        for (int i = 0, j = 0; i < gameBoard.size; i++, j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != playingPiece.getPieceType()) {
                primaryDiagonalWin = false;
                break;
            }
        }

        // Check Secondary Diagonal (Top-right to bottom-left)
        boolean secondaryDiagonalWin = true;
        for (int i = gameBoard.size - 1, j = gameBoard.size - 1; i >= 0; i--, j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != playingPiece.getPieceType()) {
                secondaryDiagonalWin = false;
                break;
            }
        }

        // If any condition is met, return true
        return rowWin || colWin || primaryDiagonalWin || secondaryDiagonalWin;
    }
}