package algorithms;

import java.util.Comparator;

public class SortingAlgorithms {
    public static <T> void combSort(T[] arr, Comparator<? super T> comparator) {
        int length = arr.length;
        double shrink = 1.3;
        int gap = length;
        boolean sorted = false;

        while (!sorted) {
            gap = (int) Math.floor(gap / shrink);
            if (gap <= 1) {
                sorted = true;
                gap = 1;
            }

            for (int i = 0; i < length - gap; i++) {
                int sm = gap + i;
                if (comparator.compare(arr[i], arr[sm]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[sm];
                    arr[sm] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static <T> void bubbleSort(T[] arr, Comparator<? super T> comparator) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (comparator.compare(arr[j - 1], arr[j]) > 0) {
                    T temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
