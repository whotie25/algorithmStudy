package Queue;

public interface QueueInterface<E> {
    public E element();     // peek()
    public E add(E item);   // offer()
    public E remove();      // poll()

    public boolean empty();
    public int size();
    public void clear();

    public boolean contains(Object obj);
}
