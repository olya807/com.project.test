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

    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2])) || (checkRowCol(board[0][2], board[1][1], board[2][0])));
    }

    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != EMPTY) && (c1 == c2) && (c2 == c3));
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

            game.gameEnded = game.checkForWin() || game.isBoardFull();
            if (game.gameEnded) {
                if (game.checkForWin()) {
                    game.changePlayer(); // To display the correct winner
                    System.out.println("Player " + game.currentPlayerMark + " wins!");
                } else {
                    System.out.println("Game over! It's a tie!");
                }
            } else {
                game.changePlayer();
            }
        }
        scanner.close();
        game.printBoard();
    }
}
