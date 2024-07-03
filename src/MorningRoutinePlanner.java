import java.util.Scanner;

public class MorningRoutinePlanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Доброе утро! Давайте составим ваш утренний распорядок для повышения продуктивности.");

        System.out.print("Во сколько вы обычно просыпаетесь по утрам? (введите время в формате ЧЧ:ММ): ");
        String wakeUpTime = scanner.nextLine();

        System.out.print("Как вы чувствуете себя по утрам? (1 - очень устал, 5 - очень бодр): ");
        int morningFeeling = scanner.nextInt();
        scanner.nextLine(); // consume the remaining newline

        System.out.print("Есть ли у вас обязательства или дела сразу после пробуждения? (да/нет): ");
        String hasObligations = scanner.nextLine();

        if (hasObligations.equalsIgnoreCase("да")) {
            System.out.print("Пожалуйста, перечислите свои обязательства: ");
            String obligations = scanner.nextLine();
            System.out.println("Ваши обязательства: " + obligations);
        }

        System.out.print("Какие активности заряжают вас энергией по утрам? (например, физическая активность, медитация, чтение): ");
        String energizingActivities = scanner.nextLine();

        System.out.print("Есть ли утренние привычки, которые вы хотите изменить или добавить? (да/нет): ");
        String wantsChange = scanner.nextLine();

        String newHabits = null;
        if (wantsChange.equalsIgnoreCase("да")) {
            System.out.print("Какие привычки вы хотите изменить или добавить?: ");
            newHabits = scanner.nextLine();
            System.out.println("Вы хотите изменить или добавить следующие привычки: " + newHabits);
        }

        System.out.print("Какие задачи или цели вы обычно стараетесь выполнить в течение дня?: ");
        String dailyGoals = scanner.nextLine();

        System.out.println("\nВаш индивидуальный утренний распорядок:");
        System.out.println("1. Проснитесь в " + wakeUpTime + ".");
        if (morningFeeling <= 2) {
            System.out.println("2. Начните день с легкой растяжки или медитации, чтобы разбудить тело.");
        } else if (morningFeeling <= 4) {
            System.out.println("2. Выполните зарядку или легкую физическую активность.");
        } else {
            System.out.println("2. Можно начать день с интенсивной тренировки.");
        }

        if (hasObligations.equalsIgnoreCase("да")) {
            System.out.println("3. Выполните свои обязательства.");
        }

        System.out.println("4. Занимайтесь следующими активностями, которые заряжают вас энергией: " + energizingActivities + ".");
        System.out.println("5. Если есть новые привычки, которые вы хотите добавить, уделите им время: " + (wantsChange.equalsIgnoreCase("да") ? newHabits : "нет").toLowerCase() + ".");
        System.out.println("6. Пересмотрите свои задачи и цели на день: " + dailyGoals + ".");

        scanner.close();
    }
}
