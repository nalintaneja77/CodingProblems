package DSAQuestions;

import org.example.Employee;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamOfEmployeesQuestions {

    public static void main(String[] args) {
        List<Employeess> employees = Arrays.asList(

                new Employeess(101, "Nalin", 75000, "IT"),
                new Employeess(102, "Rohan", 75000, "HR"),
                new Employeess(103, "Amit", 85000, "IT"),
                new Employeess(104, "Priya", 85000, "Finance"),
                new Employeess(105, "Neha", 90000, "HR"),
                new Employeess(104, "Rahul", 65000, "Finance"),
                new Employeess(107, "Sneha", 95000, "IT"),
                new Employeess(108, "Ankit", 70000, "Sales"),
                new Employeess(108, "Pooja", 88000, "Sales"),
                new Employeess(109, "Karan", 92000, "IT"));

        //group employees by department

        employees.stream().collect(Collectors.groupingBy(Employeess::department,
                Collectors.collectingAndThen(Collectors.toList(), n->n.stream().map(Employeess::name)
                        .sorted()))).entrySet().stream()
                .forEach(d-> System.out.println(d.getKey()+"->"+d.getValue().toList()));


        employees.stream().collect(Collectors.groupingBy(Employeess::department,
                Collectors.counting())).entrySet().stream()
                .forEach(t-> System.out.println(t.getKey()+"->"+t.getValue()));


        //sort employees by salary in each department
        employees.stream().collect(Collectors.groupingBy(Employeess::department,
                        Collectors.collectingAndThen(Collectors.toList(),
                                n->n.stream().sorted(Comparator.comparing(Employeess::salary).reversed())
                                .map(Employeess::name))))
                .entrySet().stream()
                .forEach(d-> System.out.println(d.getKey()+"->"+d.getValue().toList()));


        System.out.println();
        System.out.println();
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employeess::department,
                Collectors.counting())));

        //top two peoplle with salaries in each department
        employees.stream().collect(Collectors.groupingBy(Employeess::department,Collectors.collectingAndThen(
                Collectors.toList(),x->x.stream().sorted(Comparator.comparing(Employeess::salary).reversed())
                        .limit(2).toList()))).entrySet().stream().forEach(s->System.out.println(s.getKey()+"->"+s.getValue().stream().map(Employeess::salary).toList()));

        Map<Integer,Employeess> xxx =
                employees.stream().collect(Collectors.toMap(
                        Employeess::id,
                        e->e,
                        (e1,e2)->{
                            if(e1.salary()>=e2.salary())
                            {
                                return e1;
                            }
                            return e2;
                        }

                ));

        xxx.entrySet().forEach(c-> System.out.println(c.getKey()+" ->"+c.getValue().salary()));

        List<EmployeeSkills> employeeSkillsList = Arrays.asList(
                new EmployeeSkills(1,"Amit",Arrays.asList("Java","Spring","Docker")),
                  new EmployeeSkills(2,"Neha",Arrays.asList("Java","Kafka")),
                new EmployeeSkills(3,"Ravi",Arrays.asList("Aws","Docker","Spring")));

        System.out.println(employeeSkillsList.stream().flatMap(s->s.skills().stream()).sorted().distinct().toList());

        List<Integer> numberslist = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(numberslist.stream().collect(Collectors.partitioningBy(integer -> integer % 2 == 0)));

        List<EmployeeSalary> employeeSalaryList =  Arrays.asList(new EmployeeSalary("nalin",80000),
                new EmployeeSalary("rohan",90000),
                new EmployeeSalary("mohit",80000),
                 new EmployeeSalary("neha",95000));

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX"+employeeSalaryList.stream().max(Comparator.comparing(EmployeeSalary::salary)));
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX"+employeeSalaryList.stream().sorted(Comparator
                .comparing(EmployeeSalary::salary).reversed()).skip(1).findFirst());


//        employeeSalaryList.stream().sorted(((Comparator<EmployeeSalary>) (o1, o2) -> {
//            if (o1.salary() > o2.salary()) {
//                return 1;
//            } else if (o1.salary() < o2.salary()) {
//                return -1;
//            }
//            return o2.name().compareTo(o1.name());
//        }).reversed()).toList().forEach(x-> System.out.println(x.name()+"->"+x.salary()));



        employeeSalaryList.stream().sorted(Comparator.comparing(EmployeeSalary::salary).reversed()
                .thenComparing(x->x.name().toLowerCase())).toList()
                .forEach(s-> System.out.println(s.name()+"->"+s.salary()));


        List<EmployeeJoiningYear> employeeJoiningYearList =
                Arrays.asList(new EmployeeJoiningYear("John",2018),
                new EmployeeJoiningYear("Mike",2021),
                new EmployeeJoiningYear("Alex",2023),
                new EmployeeJoiningYear("David",2019));


        employeeJoiningYearList.stream().filter(s->s.year()>2020).toList()
                .forEach(c-> System.out.println(c.name()+"->"+c.year()));



        List<Integer> nums = Arrays.asList(6, 1, 9, 6, 5, 7, 3, 3, 2, 2, 1);
        System.out.println(nums.stream().distinct().sorted().toList());

        //Create a list of size 10 where each element increases by 3 starting from 0. Print to validate your solution.

        IntStream.iterate(0,x->x+3).limit(10).forEach(s-> System.out.print(s+" "));
        System.out.println();
        System.out.println();
        Set<Integer> list1 = new HashSet<>();
        list1.add(4);
        list1.add(5);
        list1.add(6);
        List<Integer> list2 = List.of(1,2,3,4,5);
       list2.forEach(list1::remove);
        System.out.println(list2);

        List<Integer> numbers = IntStream.iterate(0,x->x+1).limit(10).boxed().toList();
        System.out.println(numbers);

        numbers.parallelStream().forEachOrdered(c-> System.out.println(c+" "));

        List<Integer> vv = Arrays.asList(1,2,3,4);
        vv.add(6);




    }








}
