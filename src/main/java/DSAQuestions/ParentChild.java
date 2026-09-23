package DSAQuestions;

public class ParentChild {

    public static void main(String[] args) {

        Parent p =new Child();
        ((Child) p).greetMe();

    }
}
