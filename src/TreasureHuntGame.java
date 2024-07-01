import java.util.Random;
import java.util.Scanner;

public class TreasureHuntGame {
    private static final int GRID_SIZE = 10;
    private static final int TREASURES = 5;
    private static final int TRAPS = 3;
    private static final char EMPTY = '-';
    private static final char PLAYER = 'P';
    private static final char TREASURE = 'T';
    private static final char TRAP = 'X';

    private char[][] grid = new char[GRID_SIZE][GRID_SIZE];
    private int playerX = 0;
    private int playerY = 0;
    private int treasuresCollected = 0;

    public static void main(String[] args) {
        TreasureHuntGame game = new TreasureHuntGame();
        game.setupGrid();
        game.placeTreasuresAndTraps();
        game.startGame();
    }

    private void setupGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = EMPTY;
            }
        }
        grid[playerX][playerY] = PLAYER;
    }

    private void placeTreasuresAndTraps() {
        Random random = new Random();

        for (int i = 0; i < TREASURES; i++) {
            int x, y;
            do {
                x = random.nextInt(GRID_SIZE);
                y = random.nextInt(GRID_SIZE);
            } while (grid[x][y] != EMPTY);
            grid[x][y] = TREASURE;
        }

        for (int i = 0; i < TRAPS; i++) {
            int x, y;
            do {
                x = random.nextInt(GRID_SIZE);
                y = random.nextInt(GRID_SIZE);
            } while (grid[x][y] != EMPTY);
            grid[x][y] = TRAP;
        }
    }

    private void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printGrid();
            System.out.println("Use W (up), A (left), S (down), D (right) to move:");
            char move = scanner.next().charAt(0);

            if (!movePlayer(move)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            if (grid[playerX][playerY] == TREASURE) {
                treasuresCollected++;
                System.out.println("You found a treasure! Total treasures collected: " + treasuresCollected);
                grid[playerX][playerY] = EMPTY;
            } else if (grid[playerX][playerY] == TRAP) {
                System.out.println("You stepped on a trap! Game over.");
                break;
            }

            if (treasuresCollected == TREASURES) {
                System.out.println("Congratulations! You collected all the treasures.");
                break;
            }
        }
        scanner.close();
    }

    private boolean movePlayer(char direction) {
        int newX = playerX, newY = playerY;

        switch (direction) {
            case 'W': case 'w':
                newX = playerX - 1;
                break;
            case 'A': case 'a':
                newY = playerY - 1;
                break;
            case 'S': case 's':
                newX = playerX + 1;
                break;
            case 'D': case 'd':
                newY = playerY + 1;
                break;
            default:
                return false;
        }

        if (newX < 0 || newY < 0 || newX >= GRID_SIZE || newY >= GRID_SIZE) {
            return false;
        }

        grid[playerX][playerY] = EMPTY;
        playerX = newX;
        playerY = newY;
        grid[playerX][playerY] = PLAYER;
        return true;
    }

    private void printGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
