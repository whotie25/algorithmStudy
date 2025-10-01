package DataStructureStudy.ListStackQueue;
import java.util.Arrays;
import java.util.EmptyStackException;

public class DS_005_ArrayStackImplementation{
    public static void main(String[] args) {
        
    }
}

interface Stack<E> {
	public void push(E item);
	public E pop();
	public E peek();
	public boolean isEmpty();
	public int size();
}

class ArrayStack<E> implements Stack<E> {
	//consts
	private static final Object[] EMPTY_ARRAY = {};
	private static final int DEFAULT_SIZE = 8;
	
	//vars
	private Object[] array;
	private int size;
	
	//constructor
	public ArrayStack() {
		this.array = EMPTY_ARRAY;
		this.size = 0;
	}
	public ArrayStack(int _capacity) {
		this.array = new Object[_capacity];
		this.size = 0;
	}
	
	//inner method (resize)
	private void resize() {
		if(Arrays.equals(array, EMPTY_ARRAY)) {
			array = new Object[DEFAULT_SIZE];
			return;
		}
		
		int curCapacity = array.length;
		
		if(size == curCapacity) {
			int newSize = curCapacity * 2;
			array = Arrays.copyOf(array, newSize);
			return;
		}
		if(size < curCapacity/2) {
			int newSize = curCapacity / 2;
			array = Arrays.copyOf(array, Math.max(DEFAULT_SIZE, newSize));
		}
	}
	
	//public methods
	//push - O(1)
	public void push(E item) {
		if(size == array.length) resize();
		
		array[size] = item;
		size++;
	}
	
	//pop - O(1)
	public E pop() {
		if(size == 0) throw new EmptyStackException();
		
		@SuppressWarnings("unchecked")
		E popped = (E) array[size-1];
		array[size-1] = null;
		size--;
		
		resize();
		
		return popped;
	}
	
	//peek - O(1)
	@SuppressWarnings("unchecked")
	public E peek() {
		if(size == 0) throw new EmptyStackException();
		
		return (E) array[size-1];
	}
	
	//isEmpty - O(1)
	public boolean isEmpty(){return size == 0;}
	
	//size - O(1)
	public int size(){return size;}
}