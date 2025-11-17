package Stack.ArrayStack;
import java.util.Arrays;

public class ArrayStack<E> implements Stack.StackInterface<E> {
    // CONSTANTS
    private static final int DEFAULT_CAPACITY = 8;
    private static final Object[] EMPTY_ARRAY = {};

    // FIELDS
    private Object[] array;
    private int size;

    // CONSTRUCTORS
    public ArrayStack() {
        array = EMPTY_ARRAY;
        size = 0;
    }
    public ArrayStack(int _capacity) {
        array = new Object[_capacity];
        size = 0;
    }

    // UTILITIES
    private void resize() {
        if(Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        int capacity = array.length;

        if(size == capacity) {
            array = Arrays.copyOf(array, capacity*2);
            return;
        }
        if(size < capacity/2) {
            array = Arrays.copyOf(array, capacity/2);
            return;
        }
    }

    public String toString() {
        if(size == 0) return "[]";

        String stredStack = "[";

        for(int i = 0; i < size-1; i++) {
            stredStack += array[i] + ", ";
        }

        return stredStack + array[size-1] + "]";
    }





    // METHODS
    @SuppressWarnings("unchecked")
    public E peek() {
        if(size == 0) throw new RuntimeException("Stack is empty");

        return (E) array[size - 1];
    }

    public E push(E item) {
        if(size == array.length) resize(); //throw new RuntimeException("Stack is full");

        array[size] = item;
        size++;

        return item;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if(size == 0) throw new RuntimeException("Stack is empty");

        E poppedItem = (E) array[size - 1]; //if we don't consider memory security, [size - 1] -> [--size].
        array[size--] = null;

        resize();

        return poppedItem;
    }





    public boolean empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for(int i = 0; i < size; i++) array[i] = null;
        size = 0;

        resize();
    }





    public int search(Object obj) {
        if(obj == null) {
            for(int i = size-1; i >= 0; i--) {
                if(array[i] == null) return size-i;
            }
        } else {
            for(int i = size-1; i >= 0; i--) {
                if(array[i].equals(obj)) return size-i;
            }
        }

        return -1;
    }
}
