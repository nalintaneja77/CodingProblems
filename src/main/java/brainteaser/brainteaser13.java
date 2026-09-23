package brainteaser;

class Animal {
    String name = "Animal";

    String getName() {
        return "Animal";
    }
}

class Dog extends Animal {
    String name = "Dog";


    String getName() {
        return "Dog";
    }
}

public class brainteaser13 {
    public static void main(String[] args) {
        Animal a = new Dog();

        System.out.println(a.name);
        System.out.println(a.getName());
    }
}
