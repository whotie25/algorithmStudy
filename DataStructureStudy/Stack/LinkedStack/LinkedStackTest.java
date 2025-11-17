package Stack.LinkedStack;

public class LinkedStackTest {
    public static void main(String[] args) {
        LinkedStack<Integer> ls = new LinkedStack<>();
        
        ls.push(3);
        ls.push(5);
        ls.push(2);

        System.out.println(ls);

        ls.clear();

        System.out.println(ls);

        ls.push(12);
        ls.push(7);
        ls.pop();
        ls.push(4);
        ls.push(9);
        ls.push(10);

        System.out.println(ls);
        System.out.println(ls.search(1));
        System.out.println(ls.search(9));
    }
}
