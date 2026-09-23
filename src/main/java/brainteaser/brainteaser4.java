package brainteaser;


class Employee {
    int salary;

    Employee(int salary) {
        this.salary = salary;
    }
}
public class brainteaser4 {
    static void main() {
        Employee e1 = new Employee(100);
        Employee e2 = e1;

        e2.salary = 200;

        System.out.println(e1.salary);
    }
}
