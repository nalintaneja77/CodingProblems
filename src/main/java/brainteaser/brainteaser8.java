package brainteaser;

class Counter {
    static int count = 0;

    Counter() {
        count++;
    }
}

class brainteaser8 {
    static void main(String[] args) {
        new Counter();
        new Counter();
        Counter c3 = new Counter();

        System.out.println(Counter.count);
        System.out.println(c3.count);
    }
}