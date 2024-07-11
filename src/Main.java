import java.util.*;

public class Main {

    private static final Map<Integer, List<Integer>> graph = new HashMap<>();
    private static final Set<Integer> visited = new HashSet<>();

    public Main() {

    }

    public static void main(String[] args) {
// Инициализация графа
        graph.put(1, Arrays.asList(2, 3, 4));
        graph.put(2, List.of(5));
        graph.put(3, Arrays.asList(6, 7));
        graph.put(4, List.of());
        graph.put(5, List.of());
        graph.put(6, List.of());
        graph.put(7, List.of());

// Запуск DFS из вершины 1
        dfs(1);
    }

    public static void dfs(int node) {
        if (visited.contains(node)) {
            return;
        }

// Посещаем узел и добавляем в набор посещенных
        visited.add(node);
        System.out.println("Посещен узел: " + node);

// Рекурсивный вызов для всех соседей
        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            dfs(neighbor);
        }
    }
}