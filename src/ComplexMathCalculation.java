public class ComplexMathCalculation {

    public ComplexMathCalculation() {

    }

    public static void main(String[] args) {
        double lowerLimit = 0;
        double upperLimit = Math.PI;
        int intervals = 1000;

        double result = simpsonsRule(lowerLimit, upperLimit, intervals);
        System.out.println("Result of the integral: " + result);
    }

    // Функция, которую мы интегрируем
    public static double function(double x) {
        return Math.sin(x) * Math.exp(-x);
    }

    // Метод Симпсона для численного интегрирования
    public static double simpsonsRule(double lowerLimit, double upperLimit, int intervals) {
        if (intervals % 2 != 0) {
            intervals++; // Убедимся, что количество интервалов четное
        }

        double h = (upperLimit - lowerLimit) / intervals;
        double sum = function(lowerLimit) + function(upperLimit);

        for (int i = 1; i < intervals; i += 2) {
            sum += 4 * function(lowerLimit + i * h);
        }

        for (int i = 2; i < intervals - 1; i += 2) {
            sum += 2 * function(lowerLimit + i * h);
        }

        return (h / 3) * sum;
    }
}