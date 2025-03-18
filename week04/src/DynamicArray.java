public class DynamicArray {
    private int[] array;
    private int size;

    public DynamicArray() {
        array = new int[2];
        size = 0;
    }

    public void add(int element) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        array[size++] = element;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        if (size > 0 && size <= array.length / 4) {
            resize(array.length / 2);
        }
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return array.length;
    }

    private void resize(int newCapacity) {
        int[] newArray = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
