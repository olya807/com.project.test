public class Factorial {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int number = 5;
        System.out.println("Факториал числа " + number + " равен " + factorial(number));
    }
}