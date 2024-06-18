import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int number = random.nextInt(100) + 1; // Загадываем число от 1 до 100
        int tries = 0;
        int guess = 0;
        System.out.println("Угадайте число от 1 до 100.");

        while (guess != number) {
            System.out.print("Введите ваше число: ");
            guess = scanner.nextInt();
            tries++;

            if (guess < number) {
                System.out.println("Загаданное число больше!");
            } else if (guess > number) {
                System.out.println("Загаданное число меньше!");
            } else {
                System.out.println("Поздравляем, вы угадали число с " + tries + " попытки!");
            }
        }
    }
}