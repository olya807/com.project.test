import java.util.Random;

public class SimpleGeneticAlgorithm {

    public static final int POPULATION_SIZE = 100;
    public static final int GENOME_SIZE = 10;
    public static final int MAX_GENERATIONS = 50;
    public static final double MUTATION_RATE = 0.05;
    public static final Random random = new Random();

    public SimpleGeneticAlgorithm() {
    }

    // Оценка приспособленности генома
    private static int evaluate(int[] genome) {
        int fitness = 0;
        for (int gene : genome) {
            if (gene == 1) {
                fitness++;
            }
        }
        return fitness;
    }

    // Селекция родителя для размножения
    private static int select(int[] fitness) {
        int totalFitness = 0;
        for (int fit : fitness) {
            totalFitness += fit;
        }
        int rand = random.nextInt(totalFitness);
        int runningSum = 0;
        for (int i = 0; i < fitness.length; i++) {
            runningSum += fitness[i];
            if (rand < runningSum) {
                return i;
            }
        }
        return fitness.length - 1;
    }

    // Кроссовер двух геномов
    private static int[] crossover(int[] parent1, int[] parent2) {
        int[] child = new int[GENOME_SIZE];
        int crossoverPoint = random.nextInt(GENOME_SIZE);
        System.arraycopy(parent1, 0, child, 0, crossoverPoint);
        System.arraycopy(parent2, crossoverPoint, child, crossoverPoint, GENOME_SIZE - crossoverPoint);
        return child;
    }

    // Мутация генома
    private static void mutate(int[] genome) {
        for (int i = 0; i < GENOME_SIZE; i++) {
            if (random.nextDouble() < MUTATION_RATE) {
                genome[i] = 1 - genome[i]; // Переключение между 0 и 1
            }
        }
    }

    public static void main(String[] args) {
        int[][] population = new int[POPULATION_SIZE][GENOME_SIZE];
        int[] fitness = new int[POPULATION_SIZE];

// Инициализация популяции
        for (int i = 0; i < POPULATION_SIZE; i++) {
            for (int j = 0; j < GENOME_SIZE; j++) {
                population[i][j] = random.nextInt(2);
            }
        }

// Генетический алгоритм
        for (int generation = 0; generation < MAX_GENERATIONS; generation++) {
// Оценка приспособленности
            for (int i = 0; i < POPULATION_SIZE; i++) {
                fitness[i] = evaluate(population[i]);
            }

// Селекция и создание новой популяции
            int[][] newPopulation = new int[POPULATION_SIZE][GENOME_SIZE];
            for (int i = 0; i < POPULATION_SIZE; i++) {
                int parent1 = select(fitness);
                int parent2 = select(fitness);
                int[] child = crossover(population[parent1], population[parent2]);
                mutate(child);
                newPopulation[i] = child;
            }
            population = newPopulation;
        }

// Нахождение лучшего решения
        int bestIndex = 0;
        for (int i = 1; i < POPULATION_SIZE; i++) {
            if (fitness[i] > fitness[bestIndex]) {
                bestIndex = i;
            }
        }

        System.out.println("Лучшее решение: ");
        for (int gene : population[bestIndex]) {
            System.out.print(gene);
        }
    }
}