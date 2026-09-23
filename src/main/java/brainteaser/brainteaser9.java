package brainteaser;

public class brainteaser9 {
    static int fun() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(fun());
    }
}