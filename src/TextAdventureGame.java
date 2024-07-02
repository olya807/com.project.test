import java.util.Random;
import java.util.Scanner;

public class TextAdventureGame {
    private static final int WORLD_SIZE = 5;
    private static final char EMPTY = '.';
    private static final char PLAYER = 'P';
    private static final char MONSTER = 'M';
    private static final char ITEM = 'I';
    private static final char WALL = '#';

    private char[][] world = new char[WORLD_SIZE][WORLD_SIZE];
    private int playerX = 0;
    private int playerY = 0;
    private int playerHealth = 100;
    private int playerAttack = 10;
    private int itemsCollected = 0;
    private boolean gameOver = false;

    public static void main(String[] args) {
        TextAdventureGame game = new TextAdventureGame();
        game.setupWorld();
        game.startGame();
    }

    private void setupWorld() {
        for (int i = 0; i < WORLD_SIZE; i++) {
            for (int j = 0; j < WORLD_SIZE; j++) {
                world[i][j] = EMPTY;
            }
        }
        world[playerX][playerY] = PLAYER;
        placeMonsters();
        placeItems();
        placeWalls();
    }

    private void placeMonsters() {
        Random random = new Random();
        int monsters = WORLD_SIZE - 1;

        for (int i = 0; i < monsters; i++) {
            int x, y;
            do {
                x = random.nextInt(WORLD_SIZE);
                y = random.nextInt(WORLD_SIZE);
            } while (world[x][y] != EMPTY);
            world[x][y] = MONSTER;
        }
    }

    private void placeItems() {
        Random random = new Random();
        int items = WORLD_SIZE - 1;

        for (int i = 0; i < items; i++) {
            int x, y;
            do {
                x = random.nextInt(WORLD_SIZE);
                y = random.nextInt(WORLD_SIZE);
            } while (world[x][y] != EMPTY);
            world[x][y] = ITEM;
        }
    }

    private void placeWalls() {
        Random random = new Random();
        int walls = WORLD_SIZE - 1;

        for (int i = 0; i < walls; i++) {
            int x, y;
            do {
                x = random.nextInt(WORLD_SIZE);
                y = random.nextInt(WORLD_SIZE);
            } while (world[x][y] != EMPTY);
            world[x][y] = WALL;
        }
    }

    private void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            printWorld();
            System.out.println("Player Health: " + playerHealth + ", Attack: " + playerAttack + ", Items Collected: " + itemsCollected);
            System.out.println("Enter direction (WASD): ");
            char move = scanner.next().charAt(0);

            if (!movePlayer(move)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            checkPosition();
            if (itemsCollected == (WORLD_SIZE - 1)) {
                System.out.println("Congratulations! You have collected all the items and won the game!");
                gameOver = true;
            }
        }
        scanner.close();
    }

    private void printWorld() {
        for (int i = 0; i < WORLD_SIZE; i++) {
            for (int j = 0; j < WORLD_SIZE; j++) {
                System.out.print(world[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean movePlayer(char direction) {
        int newX = playerX, newY = playerY;

        switch (direction) {
            case 'W':
            case 'w':
                newX = playerX - 1;
                break;
            case 'A':
            case 'a':
                newY = playerY - 1;
                break;
            case 'S':
            case 's':
                newX = playerX + 1;
                break;
            case 'D':
            case 'd':
                newY = playerY + 1;
                break;
            default:
                return false;
        }

        if (newX < 0 || newY < 0 || newX >= WORLD_SIZE || newY >= WORLD_SIZE || world[newX][newY] == WALL) {
            return false;
        }

        world[playerX][playerY] = EMPTY;
        playerX = newX;
        playerY = newY;
        world[playerX][playerY] = PLAYER;
        return true;
    }

    private void checkPosition() {
        if (world[playerX][playerY] == MONSTER) {
            engageCombat();
        } else if (world[playerX][playerY] == ITEM) {
            itemsCollected++;
            System.out.println("You found an item! Items collected: " + itemsCollected);
            world[playerX][playerY] = EMPTY;
        }
    }

    private void engageCombat() {
        Random random = new Random();
        int monsterHealth = 50;
        int monsterAttack = 5;

        System.out.println("A wild monster appears! Prepare for combat!");

        while (playerHealth > 0 && monsterHealth > 0) {
            int playerDamage = random.nextInt(playerAttack);
            int monsterDamage = random.nextInt(monsterAttack);

            System.out.println("You attack the monster for " + playerDamage + " damage.");
            monsterHealth -= playerDamage;

            if (monsterHealth > 0) {
                System.out.println("The monster attacks you for " + monsterDamage + " damage.");
                playerHealth -= monsterDamage;
            }

            if (playerHealth <= 0) {
                System.out.println("You have been defeated by the monster. Game Over.");
                gameOver = true;
                return;
            }
        }

        if (monsterHealth <= 0) {
            System.out.println("You have defeated the monster!");
            world[playerX][playerY] = EMPTY;
        }
    }
}

