import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double rateUSDToEUR = 0.85; // Примерный курс конвертации, нужно обновлять

        System.out.println("Введите сумму в долларах США для конвертации в евро:");
        double amountInUSD = scanner.nextDouble();

        double amountInEUR = convertUSDtoEUR(amountInUSD, rateUSDToEUR);
        System.out.printf("Сумма в евро: %.2f EUR%n", amountInEUR);
    }

    public static double convertUSDtoEUR(double amount, double rate) {
        return amount * rate;
    }
}