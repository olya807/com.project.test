public class BubbleSortExample {

    public static void main(String[] args) {
        int[] array = {3, 60, 35, 2, 45, 320, 5};
        bubbleSort(array);
        System.out.println("Отсортированный массив:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] > array[j]) {
//swap elements
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}