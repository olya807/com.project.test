public class CalculatePiMonteCarlo {

    public CalculatePiMonteCarlo() {
        
    }

    public static void main(String[] args) {
        int totalPoints = 1000000; // Общее количество точек для генерации
        int insideCircle = 0;

        for (int i = 0; i < totalPoints; i++) {
            double x = Math.random(); // Генерация случайной координаты x
            double y = Math.random(); // Генерация случайной координаты y
// Проверяем, находится ли точка внутри круга
            if (x * x + y * y <= 1) {
                insideCircle++;
            }
        }
// Вычисляем значение числа π
        double pi = 4.0 * insideCircle / totalPoints;
        System.out.println("Приближенное значение числа π: " + pi);
    }
}