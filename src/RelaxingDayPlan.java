import java.util.Scanner;

public class RelaxingDayPlan {

    public RelaxingDayPlan() {

    }

    public static void main(String[] args) {
        String[] morningActivities = {
                "7:00 - 8:00: Медитация и дыхательные практики",
                "8:00 - 9:00: Легкая йога или растяжка",
                "9:00 - 10:00: Завтрак"
        };

        String[] dayActivities = {
                "10:00 - 12:00: Прогулка на природе",
                "12:00 - 13:00: Чтение книги",
                "13:00 - 14:00: Обед",
                "14:00 - 16:00: Спа-процедуры"
        };

        String[] eveningActivities = {
                "16:00 - 18:00: Время с близкими",
                "18:00 - 19:00: Творческие занятия",
                "19:00 - 20:00: Ужин",
                "20:00 - 21:00: Вечерняя медитация или релаксация",
                "21:00 - 22:00: Тишина и уединение"
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите время дня (утро, день, вечер):");
        String timeOfDay = scanner.nextLine().trim().toLowerCase();

        System.out.println("\nРекомендации для " + timeOfDay + ":");
        switch (timeOfDay) {
            case "утро":
                for (String activity : morningActivities) {
                    System.out.println(activity);
                }
                break;
            case "день":
                for (String activity : dayActivities) {
                    System.out.println(activity);
                }
                break;
            case "вечер":
                for (String activity : eveningActivities) {
                    System.out.println(activity);
                }
                break;
            default:
                System.out.println("Некорректное время дня. Пожалуйста, введите одно из следующих: утро, день, вечер.");
        }

        scanner.close();
    }
}