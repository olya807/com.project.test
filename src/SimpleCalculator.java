import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Простой текстовый калькулятор. Введите 'стоп' для выхода.");

        while (true) {
            System.out.print("Введите выражение (например, 2 + 3): ");
            String input = scanner.nextLine();

            if ("стоп".equalsIgnoreCase(input)) {
                System.out.println("Калькулятор завершил работу.");
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length < 3) {
                System.out.println("Неверный формат ввода. Попробуйте снова.");
                continue;
            }

            int num1 = Integer.parseInt(parts[0]);
            int num2 = Integer.parseInt(parts[2]);
            int result;

            switch (parts[1]) {
                case "+" -> result = num1 + num2;
                case "-" -> result = num1 - num2;
                default -> {
                    System.out.println("Неподдерживаемая операция: " + parts[1]);
                    continue;
                }
            }

            System.out.println("Результат: " + result);
        }

        scanner.close();
    }
}
