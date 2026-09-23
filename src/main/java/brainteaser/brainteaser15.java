package brainteaser;

public class brainteaser15 {
    public static void main(String[] args) {
        String a = "hello";
        String b = "hel" + "lo";
        String c = "hel";
        String d = c + "lo";

        System.out.println(a == b);
        System.out.println(a == d);
    }
}
