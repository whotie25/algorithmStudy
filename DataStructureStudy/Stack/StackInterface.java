package Stack;

public interface StackInterface<E> {
    public E peek();
    public E push(E item);
    public E pop();

    public boolean empty();
    public int size();
    public void clear();

    public int search(Object obj);
}
