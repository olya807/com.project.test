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

        String[] additionalTips = {
                "Постарайся избегать стресса и отвлекающих факторов.",
                "Слушай музыку, которая тебе нравится, на протяжении всего дня.",
                "Время от времени делай перерывы, чтобы прислушаться к своим ощущениям и нуждам."
        };

        System.out.println("План на расслабляющий день:");
        System.out.println("\nУтро:");
        for (String activity : morningActivities) {
            System.out.println(activity);
        }

        System.out.println("\nДень:");
        for (String activity : dayActivities) {
            System.out.println(activity);
        }

        System.out.println("\nВечер:");
        for (String activity : eveningActivities) {
            System.out.println(activity);
        }

        System.out.println("\nЗавершение:");
        System.out.println("Прими расслабляющий душ или ванну перед сном, чтобы помочь своему телу и уму полностью расслабиться и подготовиться ко сну.");

        System.out.println("\nДополнительные советы:");
        for (String tip : additionalTips) {
            System.out.println(tip);
        }
    }
}