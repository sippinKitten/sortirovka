//Выполнил студент группы 2А Иванов Данил

public class SortingBenchmark {
    public static void main(String[] args) {
        // Генерация небольшого массива
        int[] smallArray = generateArray(100);
        
        // Генерация крупного массива
        int[] largeArray = generateArray(10000);
        
        // Замер времени выполнения сортировки пузырьком для небольшого массива
        long startTime = System.currentTimeMillis();
        bubbleSort(smallArray);
        long endTime = System.currentTimeMillis();
        long smallArrayBubbleSortTime = endTime - startTime;

        // Замер времени выполнения сортировки пузырьком для крупного массива
        startTime = System.currentTimeMillis();
        bubbleSort(largeArray);
        endTime = System.currentTimeMillis();
        long largeArrayBubbleSortTime = endTime - startTime;

        System.out.println("Bubble Sort:");
        System.out.println("Small array sorting time: " + smallArrayBubbleSortTime + " ms");
        System.out.println("Large array sorting time: " + largeArrayBubbleSortTime + " ms");

        // Замер времени выполнения сортировки слиянием для небольшого массива
        startTime = System.currentTimeMillis();
        mergeSort(smallArray);
        endTime = System.currentTimeMillis();
        long smallArrayMergeSortTime = endTime - startTime;

        // Замер времени выполнения сортировки слиянием для крупного массива
        startTime = System.currentTimeMillis();
        mergeSort(largeArray);
        endTime = System.currentTimeMillis();
        long largeArrayMergeSortTime = endTime - startTime;

        System.out.println("Merge Sort:");
        System.out.println("Small array sorting time: " + smallArrayMergeSortTime + " ms");
        System.out.println("Large array sorting time: " + largeArrayMergeSortTime + " ms");
    }

    // Метод для генерации случайного массива заданного размера
    public static int[] generateArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

    // Реализация сортировки пузырьком
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Реализация сортировки слиянием
    public static void mergeSort(int[] arr) {
        // Базовый случай: если массив имеет длину 1 или меньше, он уже отсортирован
        if (arr.length <= 1) {
            return;
        }
        
        // Разделение массива на две половины
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, mid, right, 0, right.length);
        
        // Рекурсивная сортировка обеих половин
        mergeSort(left);
        mergeSort(right);
        
        // Слияние отсортированных половин
        merge(left, right, arr);
    }

    // Метод для слияния двух отсортированных массивов
    public static void merge(int[] left, int[] right, int[] arr) {
        int i = 0, j = 0, k = 0;
        
        // Пока есть элементы в обоих массивах
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                // Присваиваем текущий элемент из левого массива
                arr[k++] = left[i++];
            } else {
                // Присваиваем текущий элемент из правого массива
                arr[k++] = right[j++];
            }
        }
        
        // Добавляем оставшиеся элементы из левого массива (если они есть)
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        
        // Добавляем оставшиеся элементы из правого массива (если они есть)
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
