package brainteaser;

public class brainteaser10 {
    static void modify(int[] arr) {
        arr[0] = 99;
        arr = new int[]{1, 2, 3};
        arr[0] = 100;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7};
        modify(arr);

        System.out.println(arr[0]);
    }
}