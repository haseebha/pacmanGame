import java.util.Scanner;
public class PacmanGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board gameBoard = new Board();
        Pacman player = new Pacman(1, 1);
        Enemy ghost = new Enemy(8, 8);

        boolean running = true;

        System.out.println("--- OOP PACMAN CLI ---");
        System.out.println("Controls: W (Up), S (Down), A (Left), D (Right)");

        while (running) {
            gameBoard.draw(player, ghost);

            System.out.print("Move: ");
            String inputStr = scanner.next().toUpperCase();
            if (inputStr.isEmpty()) continue;
            char input = inputStr.charAt(0);

            int nextR = player.row;
            int nextC = player.col;

            if (input == 'W') nextR--;
            else if (input == 'S') nextR++;
            else if (input == 'A') nextC--;
            else if (input == 'D') nextC++;

            // Handle Pacman Movement & Food
            if (gameBoard.isNotWall(nextR, nextC)) {
                player.move(nextR, nextC);

                if (gameBoard.isFood(player.row, player.col)) {
                    player.addScore();
                    gameBoard.removeFood(player.row, player.col);
                }
            }

            // Move Enemy
            ghost.moveRandomly(gameBoard);

            // Check Collision
            if (player.row == ghost.row && player.col == ghost.col) {
                gameBoard.draw(player, ghost);
                System.out.println("\nGAME OVER! The Enemy (E) caught Pacman (P).");
                System.out.println("Final Score: " + player.score);
                running = false;
            }
        }
        scanner.close();
    }
}