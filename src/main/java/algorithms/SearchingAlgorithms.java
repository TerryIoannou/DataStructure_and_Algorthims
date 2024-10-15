package algorithms;

import java.util.Arrays;

public class SearchingAlgorithms {

    public static <T extends Comparable<T>> Pair<T> binarySearch(T[] arr, T item) {
        System.out.println("DEBUG: Starting binary search...");
        System.out.println("DEBUG: Array: " + Arrays.toString(arr));
        System.out.println("DEBUG: Search item: " + item);

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            System.out.println("DEBUG: Comparing at index " + mid + ": " + arr[mid]);

            if (arr[mid].compareTo(item) == 0) {
                System.out.println("DEBUG: Found item at index " + mid);
                return new Pair<>(arr[mid], mid);  // Correct order: first element, then index
            }

            if (arr[mid].compareTo(item) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("DEBUG: Item not found.");
        return null;  // Return null if not found
    }

    public static <T extends Comparable<T>> Pair<T> linearSearch(T[] array, T item) {
        System.out.println("DEBUG: Starting linear search...");
        System.out.println("DEBUG: Array: " + Arrays.toString(array));
        System.out.println("DEBUG: Search item: " + item);

        for (int i = 0; i < array.length; i++) {
            System.out.println("DEBUG: Checking index " + i + ": " + array[i]);
            if (array[i].equals(item)){
                System.out.println("DEBUG: Found item at index " + i);
                return new Pair<>(array[i], i);  // Found, return pair with element and index
            }
        }
        System.out.println("DEBUG: Item not found.");
        return null;  // Not found
    }
}
