package Stack.ArrayStack;

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack<Integer> as = new ArrayStack<>();

        System.out.printf("pushed item : %d\n", as.push(3));
        System.out.printf("pushed item : %d\n", as.push(8));
        System.out.printf("pushed item : %d\n", as.push(5));

        System.out.println("\ncurrent stack : " + as + "\n");

        as.clear();

        System.out.println("current stack : " + as);
    }
}
