package Queue.LinkedQueue;

public class LinkedQueueTest {
    public static void main(String[] args) {
        LinkedQueue<Integer> lq = new LinkedQueue<>();

        lq.add(1); lq.add(2); lq.add(3);    //[1, 2, 3]
        lq.remove();                                         //[2, 3]

        System.out.println(lq);

        System.out.print(lq.contains(null) + " ");
        System.out.print(lq.contains(1) + " ");
        System.out.println(lq.contains(3));
    }
}
