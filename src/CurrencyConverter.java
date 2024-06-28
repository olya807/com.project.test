import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private static final Map<String, Map<String, Double>> exchangeRates = new HashMap<>();

    static {
        Map<String, Double> usdRates = new HashMap<>();
        usdRates.put("EUR", 0.92);
        usdRates.put("JPY", 110.0);
        usdRates.put("BYN", 2.5);
        exchangeRates.put("USD", usdRates);

        Map<String, Double> eurRates = new HashMap<>();
        eurRates.put("USD", 1.09);
        eurRates.put("JPY", 120.0);
        eurRates.put("BYN", 2.7);
        exchangeRates.put("EUR", eurRates);

// Добавьте другие валюты и их курсы здесь
    }

    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (exchangeRates.containsKey(fromCurrency)) {
            Map<String, Double> rates = exchangeRates.get(fromCurrency);
            if (rates.containsKey(toCurrency)) {
                return amount * rates.get(toCurrency);
            }
        }
        throw new IllegalArgumentException("Курс конвертации не найден.");
    }

    public static void main(String[] args) {
        double amountToConvert = 1000; // Сумма для конвертации
        String fromCurr = "USD"; // Исходная валюта
        String toCurr = "EUR"; // Целевая валюта

        try {
            double convertedAmount = convertCurrency(amountToConvert, fromCurr, toCurr);
            System.out.printf("%.2f %s равны %.2f %s%n", amountToConvert, fromCurr, convertedAmount, toCurr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
