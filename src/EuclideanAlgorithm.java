public class EuclideanAlgorithm {

    // Метод для нахождения НОД двух чисел
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int number1 = 48; // Пример числа 1
        int number2 = 18; // Пример числа 2
        System.out.println("Наибольший общий делитель чисел " + number1 + " и " + number2 + " равен: " + gcd(number1, number2));
    }
}