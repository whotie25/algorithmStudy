package Stack.LinkedStack;

public class LinkedStack<E> implements Stack.StackInterface<E> {
    // PRIVATE CLASS : NODE
    private static class Node<E> {
        private E item;
        private Node<E> next;

        public Node(E _item, Node<E> _next) {
            item = _item;
            next = _next;
        }
    }

    // FIELDS
    private Node<E> top;
    private int size;

    // CONSTRUCTOR
    public LinkedStack() {
        top = null;
        size = 0;
    }

    // UTILITIES
    public String toString() {
        if(size == 0) return "[]";

        String stredStack = "]";

        Node<E> tempNode = top;
        for(int i = 0; i < size-1; i++) {
            stredStack = ", " + tempNode.item + stredStack;
            tempNode = tempNode.next;
        }

        return "[" + tempNode.item + stredStack;
    }





    // METHODS
    public E peek() {
        if(size == 0) throw new RuntimeException("Stack is empty");

        return top.item;
    }

    public E push(E item) {
        top = new Node<E>(item, top);
        size++;

        return top.item;
    }

    public E pop() {
        if(size == 0) throw new RuntimeException("Stack is empty");

        Node<E> poppedNode = top;
        E poppedItem = poppedNode.item;

        top = top.next;
        poppedNode.item = null;
        poppedNode.next = null;
        size--;

        return poppedItem;
    }





    public boolean empty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }

    public void clear() {
        if(size == 0) return;

        Node<E> removedNode = top;
        for(int i = 0; i < size; i++) {
            Node<E> tempNode = removedNode;
            removedNode = removedNode.next;
            tempNode.item = null;
            tempNode.next = null;
        }

        size = 0;
    }





    public int search(Object obj) {
        Node<E> tempNode = top;

        if(obj == null) {
            for(int i = 0; i < size; i++) {
                if(tempNode.item == null) return i + 1;
                tempNode = tempNode.next;
            }
        } else {
            for(int i = 0; i < size; i++) {
                if(tempNode.item.equals(obj)) return i + 1;
                tempNode = tempNode.next;
            }
        }

        return -1;
    }
}