package data_structures;

import java.util.Arrays;

public class ArrayList<T> {
    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        data = (T[]) new Object[10];
        size = 0;
    }

    public void add(T item) {
        if (size == data.length) {
            data = Arrays.copyOf(data, size * 2);
        }
        data[size++] = item;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];
    }

    public int size() {
        return size;
    }

    public T[] toArray(T[] a) {
        if (a.length < size) {
            return Arrays.copyOf(data, size, (Class<? extends T[]>) a.getClass());
        }
        System.arraycopy(data, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    public void clear() {
        data = (T[]) new Object[10];
        size = 0;
    }

}
