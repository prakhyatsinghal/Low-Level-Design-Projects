package TicTacToe;

// Move class
//This class represents a move made by a player. 
// It contains a reference to the player who made the move, 
// and the row and column indices where the player placed their symbol.
public class Move {
    private Player player;
    private int row;
    private int col;

    public Move(Player player, int row, int col) {
        this.player = player;
        this.row = row;
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}