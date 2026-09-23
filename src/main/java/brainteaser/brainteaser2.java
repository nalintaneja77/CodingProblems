package brainteaser;

public class brainteaser2 {
    static void fun(int n) {
        if (n > 0) {
            fun(n - 1);
            System.out.println(n);
            fun(n - 1);
        }
    }

    static void main(String[] args) {
        fun(2);
    }
}
