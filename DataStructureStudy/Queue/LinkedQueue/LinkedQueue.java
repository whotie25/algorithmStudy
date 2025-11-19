package Queue.LinkedQueue;

public class LinkedQueue<E> implements Queue.QueueInterface<E> {
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
    private Node<E> head;
    private Node<E> tail;
    private int size;

    // CONSTRUCTOR
    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    // UTILITIES
    public String toString() {
        if(size == 0) return "[]";

        String stredStack = "[";

        Node<E> tmp = head;
        for(int i = 0; i < size-1; i++) {
            stredStack += tmp.item + ", ";
            tmp = tmp.next;
        }

        return stredStack + tmp.item + "]";
    }





    // METHODS
    public E element() /* peek() */ {
        if(size == 0) throw new RuntimeException("Queue is empty");

        return head.item;
    }

    public E add(E item) /* offer() */ {
        Node<E> newNode = new Node<E>(item, null);

        if(size == 0) head = newNode;
        else tail.next = newNode;

        tail = newNode;

        size++;

        return item;
    }

    public E remove() /* poll() */ {
        if(size == 0) throw new RuntimeException("Queue is empty");

        E removedItem = head.item;
        Node<E> newHeadNode = head.next;

        head.item = null;
        head.next = null;

        head = newHeadNode;
        size--;

        return removedItem;
    }

    



    public boolean empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for(Node<E> tmp = head; tmp != null; ) {
            Node<E> nextTmp = tmp.next;

            tmp.item = null;
            tmp.next = null;
            tmp = nextTmp;
        }

        size = 0;
        head = tail = null;
    }





    public boolean contains(Object obj) {
        for(Node<E> tmp = head; tmp != null; tmp = tmp.next) {
            if(tmp.item.equals(obj)) return true;
        }

        return false;
    }
}
