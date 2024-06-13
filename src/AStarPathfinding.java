import java.util.Comparator;
import java.util.PriorityQueue;

public class AStarPathfinding {

    public static class Cell {
        int heuristicCost = 0; // Эвристическая стоимость
        int finalCost = 0; // G + H
        int i, j;
        Cell parent;

        Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    // Параметры лабиринта
    private final Cell[][] grid;
    private final PriorityQueue<Cell> openCells;
    private final boolean[][] closedCells;
    private int startI, startJ;
    private int endI, endJ;

    public AStarPathfinding(int width, int height, int si, int sj, int ei, int ej, int[][] blocks) {
        grid = new Cell[width][height];
        closedCells = new boolean[width][height];
        openCells = new PriorityQueue<>(Comparator.comparingInt((Cell c) -> c.finalCost));
        startCell(si, sj);
        endCell(ei, ej);

        // Инициализация лабиринта
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                grid[i][j] = new Cell(i, j);
                grid[i][j].heuristicCost = Math.abs(i - endI) + Math.abs(j - endJ);
            }
        }
        grid[startI][startJ].finalCost = 0;

        // Устанавливаем блоки в лабиринте
        for (int[] block : blocks) {
            addBlockOnCell(block[0], block[1]);
        }
    }

    public void startCell(int i, int j) {
        startI = i;
        startJ = j;
    }

    public void endCell(int i, int j) {
        endI = i;
        endJ = j;
    }

    public void addBlockOnCell(int i, int j) {
        grid[i][j] = null;
    }

    public void updateCostIfNeeded(Cell current, Cell t, int cost) {
        if (t == null || closedCells[t.i][t.j]) return;
        int tFinalCost = current.finalCost + cost + t.heuristicCost;

        boolean isOpen = openCells.contains(t);
        if (!isOpen || tFinalCost < t.finalCost) {
            t.finalCost = tFinalCost;
            t.parent = current;
            if (!isOpen) openCells.add(t);
        }
    }

    public void process() {
        // Добавляем начальную точку в открытый список
        openCells.add(grid[startI][startJ]);

        Cell current;

        while (true) {
            current = openCells.poll();
            if (current == null) break;
            closedCells[current.i][current.j] = true;

            if (current.equals(grid[endI][endJ])) {
                return;
            }

            Cell t;
            if (current.i - 1 >= 0) {
                t = grid[current.i - 1][current.j];
                updateCostIfNeeded(current, t, 1);
            }

            if (current.j - 1 >= 0) {
                t = grid[current.i][current.j - 1];
                updateCostIfNeeded(current, t, 1);
            }

            if (current.j + 1 < grid[0].length) {
                t = grid[current.i][current.j + 1];
                updateCostIfNeeded(current, t, 1);
            }

            if (current.i + 1 < grid.length) {
                t = grid[current.i + 1][current.j];
                updateCostIfNeeded(current, t, 1);
            }
        }
    }

    public void printPath() {
        if (closedCells[endI][endJ]) {
            System.out.println("Путь найден");
            Cell current = grid[endI][endJ];
            while (current.parent != null) {
                System.out.println("[" + current.i + ", " + current.j + "]");
                current = current.parent;
            }
            System.out.println("[" + startI + ", " + startJ + "]");
        } else {
            System.out.println("Путь не найден");
        }
    }

    public static void main(String[] args) {
        AStarPathfinding aStar = new AStarPathfinding(5, 5, 0, 0, 3, 3,
                new int[][]{{0, 4}, {2, 2}, {3, 1}, {3, 3}});
        aStar.process();
        aStar.printPath();
    }
}