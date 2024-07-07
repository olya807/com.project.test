import java.util.Arrays;

public class Guess {

    public Guess() {
    }

    public static void main(String[] args) {
        String[] words = {"компьютер", "программа", "java", "игра", "код"};
        String secretWord = words[(int) (Math.random() * words.length)];
        char[] hiddenWord = new char[secretWord.length()];
        Arrays.fill(hiddenWord, '*');
        System.out.println("Я загадал слово, попробуй угадать его. Вот подсказка: " + new String(hiddenWord));
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (!new String(hiddenWord).equals(secretWord)) {
            System.out.print("Введи букву или слово: ");
            String guess = scanner.nextLine();
            if (guess.length() == 1) {
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == guess.charAt(0)) {
                        hiddenWord[i] = guess.charAt(0);
                    }
                }
            } else if (guess.equals(secretWord)) {
                break;
            }
            System.out.println("Текущее состояние слова: " + new String(hiddenWord));
        }
        System.out.println("Поздравляю, ты угадал слово: " + secretWord + "!");
        scanner.close();
    }
}
