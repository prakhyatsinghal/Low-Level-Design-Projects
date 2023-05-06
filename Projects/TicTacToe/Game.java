package TicTacToe;

import java.util.Scanner;

// Game class
/*/
This class represents the game itself. It contains a reference to the game board,
 the two players, and the current player. The play method runs the game loop, 
 where the players take turns making moves until a win or a tie is achieved. T
 he currentPlayerMove method prompts the current player to enter their move and 
 returns a Move object. The checkWin method checks if the current player has won.
  The switchPlayer method switches the current player after each turn. */
  
public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(Player player1, Player player2) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    public void play() {
        while (true) {
            board.display();
            Move move = currentPlayerMove();
            boolean validMove = board.makeMove(move);
            if (!validMove) {
                System.out.println("Invalid move. Try again.");
                continue;
            }
            if (checkWin()) {
                board.display();
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }
            if (board.isFull()) {
                board.display();
                System.out.println("Tie game!");
                break;
            }
            switchPlayer();
        }
    }

    private Move currentPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(currentPlayer.getName() + ", enter row (0-2): ");
        int row = scanner.nextInt();
        System.out.println(currentPlayer.getName() + ", enter column (0-2): ");
        int col = scanner.nextInt();
        return new Move(currentPlayer, row, col);
    }

    private boolean checkWin() {
        char symbol = currentPlayer.getSymbol();
        for (int i = 0; i < 3; i++) {
            if (board.getCell(i, 0) == symbol && board.getCell(i, 1) == symbol && board.getCell(i, 2) == symbol) {
                return true;
            }
            if (board.getCell(0, i) == symbol && board.getCell(1, i) == symbol && board.getCell(2, i) == symbol) {
                return true;
            }
        }
        if (board.getCell(0, 0) == symbol && board.getCell(1, 1) == symbol && board.getCell(2, 2) == symbol) {
            return true;
        }
        if (board.getCell(2, 0) == symbol && board.getCell(1, 1) == symbol && board.getCell(0, 2) == symbol) {
            return true;
        }
        return false;
    }

    private void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
}
       
