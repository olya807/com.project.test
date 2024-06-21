import java.util.Scanner;

public class TicTacToeGame {
    private static final char EMPTY = ' ';
    private static final char CROSS = 'X';
    private static final char NOUGHT = 'O';
    private final char[][] board;
    private char currentPlayerMark;
    private boolean gameEnded;

    public TicTacToeGame() {
        board = new char[3][3];
        currentPlayerMark = CROSS;
        gameEnded = false;
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public void changePlayer() {
        currentPlayerMark = (currentPlayerMark == CROSS) ? NOUGHT : CROSS;
    }

    public boolean placeMark(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY) {
            board[row][col] = currentPlayerMark;
            return true;
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-----");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToeGame game = new TicTacToeGame();

        while (!game.gameEnded) {
            System.out.println("Current board layout:");
            game.printBoard();
            int row;
            int col;
            do {
                System.out.println("Player " + game.currentPlayerMark + ", enter an empty row and column to place your mark!");
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;
            } while (!game.placeMark(row, col));
            game.changePlayer();
            game.gameEnded = game.isBoardFull(); // This is a simple end condition, you can add more!
        }
        scanner.close();
        System.out.println("Game over! No more moves left.");
        game.printBoard();
    }
}