package TicTacToe;

// Board class
/*This class represents the game board. It contains a 2D array of 
characters to represent the state of the game board. The isValidMove method 
checks if a given move is valid (i.e., if the cell is empty). 
The makeMove method places a player's symbol on the board if the move is valid. 
The getCell method returns the symbol at a given cell. The isFull method checks
 if the board is full (i.e., if there are no empty cells). The display method displays 
 the current state of the board on the console. */
 
public class Board {
    private char[][] grid = new char[3][3];

    public boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        return grid[row][col] == 0;
    }

    public boolean makeMove(Move move) {
        int row = move.getRow();
        int col = move.getCol();
        if (!isValidMove(row, col)) {
            return false;
        }
        grid[row][col] = move.getPlayer().getSymbol();
        return true;
    }

    public char getCell(int row, int col) {
        return grid[row][col];
    }

    public boolean isFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (grid[row][col] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void display() {
        System.out.println("  0 1 2");
        for (int row = 0; row < 3; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < 3; col++) {
                char symbol = grid[row][col];
                if (symbol == 0) {
                    System.out.print("- ");
                } else {
                    System.out.print(symbol + " ");
                }
            }
            System.out.println();
        }
    }
}
