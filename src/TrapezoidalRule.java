public class TrapezoidalRule {

    public TrapezoidalRule() {

    }

    // Функция, которую мы интегрируем
    public static double function(double x) {
        return Math.sin(x); // Пример функции
    }

    // Метод трапеций для вычисления интеграла
    public static double trapezoidalRule(double a, double b, int n) {
        double h = (b - a) / n;
        double sum = 0.5 * (function(a) + function(b));
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += function(x);
        }
        return sum * h;
    }

    public static void main(String[] args) {
        double a = 0; // Нижний предел интегрирования
        double b = Math.PI; // Верхний предел интегрирования
        int n = 1000; // Количество разбиений

        double result = trapezoidalRule(a, b, n);
        System.out.println("Результат интегрирования: " + result);
    }
}