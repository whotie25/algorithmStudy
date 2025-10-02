package DataStructureStudy.ListStackQueue;
import java.util.Arrays;

public class DS_002_ArrayListImplementation {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            list.add(2*i+1);
        }
        System.out.println(list.returnList());                  //[1, 3, 5, 7, 9]

        list.addFirst(-3);
        list.add(1, -1);
        System.out.print(list.returnList());                    //[-3, -1, 1, 3, 5, 7, 9]
        System.out.println(", list[3] = " + list.get(3));   //list[3] = 3

        list.clear();
        System.out.println("[ List cleared ] -> list = " + list.returnList());
        System.out.println("is List empty? : " + list.isEmpty() + "\n");   //true

        list.add(1);
        for(int i = 2; i < 10; i++) {
            list.add(2*i + 1);
            list.set(i-2, list.get(i-2)*i);
        }
        System.out.println(list.returnList());                  //[2, 15, 28, 45, 66, 91, 120, 153, 19]

        if(list.indexOf(0) == -1) System.out.println("\'0\' is not element of list");
        else System.out.println("\'0\' is element of list. index of \'0\' : " + list.indexOf(0));

        if(list.indexOf(45) == -1) System.out.println("\'45\' is not element of list");
        else System.out.println("\'45\' is element of list. index of \'45\' : " + list.indexOf(45));
    }
}

interface List<E>{
    public void add(E item);          //O(1)
    public void add(int idx, E item); //O(n)
    public void addFirst(E item);     //O(n)

    public void clear();              //o(n)

    public E get(int idx);            //O(1)

    public int indexOf(E item);       //O(n)
    public int lastIndexOf(E item);   //O(n)

    public void set(int idx, E item); //O(1)

    public E remove(int idx);         //O(1)
    public boolean remove(E item);    //O(n)

    public boolean isEmpty();         //O(1)
    public int size();                //O(1)
}

class ArrayList<E> implements List<E> {
    //consts
    private static final Object[] EMPTY_ARRAY = {};
    private static final int DEFAULT_CAPACITY = 8;

    //vars
    private Object[] array;
    private int size;

    //constructor
    public ArrayList() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }
    public ArrayList(int _capacity) {
        this.array = new Object[_capacity];
        this.size = 0;
    }

    //inner method (resize)
    private void resize() {
        if(Arrays.equals(array, EMPTY_ARRAY)) {
			array = new Object[DEFAULT_CAPACITY];
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
			array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newSize));
		}
    }

    //public methods
    //add - O(1)
    public void add(E item) {
        if(size == array.length) resize();

        array[size] = item;
        size++;
    }
    //add - O(n)
    public void add(int idx, E item) {
        if(idx < 0 || idx > size) throw new IndexOutOfBoundsException();

        if(idx == size) add(item);
        else {
            if(size == array.length) resize();

            for(int i = size; i > idx; i--) {
                array[i] = array[i-1];
            }
            array[idx] = item;
            size++;
        }
    }
    //addFirst - O(n)
    public void addFirst(E item) {
        add(0, item);
    }

    //clear - O(n)
    public void clear() {
        for(int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        resize();
    }

    //get - O(1)
    @SuppressWarnings("unchecked")
    public E get(int idx) {
        if(idx < 0 || idx >= size) throw new IndexOutOfBoundsException();

        return (E) array[idx];
    }

    //indexOf - O(n)
    public int indexOf(E item) {
        for(int i = 0; i < size; i++) {
            if(array[i] == item) return i;
        }
        return -1;
    }
    //lastIndexOf - O(n)
    public int lastIndexOf(E item) {
        for(int i = size-1; i > 0; i--) {
            if(array[i] == item) return i;
        }
        return -1;
    }

    //set - O(1)
    public void set(int idx, E item) {
        if(idx < 0 || idx >= size) throw new IndexOutOfBoundsException();

        array[idx] = item;
    }

    //remove - O(n)
    @SuppressWarnings("unchecked")
    public E remove(int idx) {
        if(idx < 0 || idx >= size) throw new IndexOutOfBoundsException();

        E removed = (E) array[idx];
        for(int i = idx; i < size-1; i++) {
            array[idx] = array[idx+1];
        }
        array[size-1] = null;
        size--;

        return removed;
    }
    //remove - O(n)
    public boolean remove(E item) {
        for(int i = 0; i < size; i++) {
            if(array[i] == item){
                remove(i);
                return true;
            }
        }
        return false;
    }

    //isEmpty - O(1)
    public boolean isEmpty() {return size == 0;}
    
    //size - O(1)
    public int size() {return size;}


    //some methods
    public String returnList() {
        if(size() == 0) return "[]";
    
        String res = "[";
        for(int i = 0; i < size()-1; i++) {
            res += get(i) + ", ";
        }
        res += get(size()-1) + "]";

        return res;
    }
}