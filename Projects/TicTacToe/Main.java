package TicTacToe;

import java.util.Scanner;

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create players
        System.out.println("Enter name for player 1: ");
        String name1 = scanner.nextLine();
        Player player1 = new Player(name1, 'X');
        System.out.println("Enter name for player 2: ");
        String name2 = scanner.nextLine();
        Player player2 = new Player(name2, 'O');

        // Start game
        Game game = new Game(player1, player2);
        game.play();
    }
}
