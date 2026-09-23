package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class EmployeePrepareStreams {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(

                new Employee(101, "Nalin", 75000, "IT"),
                new Employee(102, "Rohan", 75000, "HR"),
                new Employee(103, "Amit", 85000, "IT"),
                new Employee(104, "Priya", 85000, "Finance"),
                new Employee(105, "Neha", 90000, "HR"),
                new Employee(106, "Rahul", 65000, "Finance"),
                new Employee(107, "Sneha", 95000, "IT"),
                new Employee(108, "Xersis", 95000, "IT"),
                new Employee(109, "Ankit", 70000, "Sales"),
                new Employee(110, "Pooja", 88000, "Sales"),
                new Employee(111, "Karan", 92000, "IT"));

        //highest paid employee

        
        Map<String, Double> employeeWithSalaries = employees.stream()
                .collect(Collectors.toMap(Employee::name,Employee::salary));
        System.out.println("kkkk"+employees.stream().filter(s->s.salary()>90000).map(Employee::department).toList());

        System.out.println(employeeWithSalaries.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new))
                .reversed().toString());

        //System.out.println(employeeWithSalaries);
        System.out.println(employees.stream().max(Comparator.comparing(Employee::salary)));

        //second highest salary
        System.out.println(employees.stream().sorted(Comparator.comparing(Employee::salary).reversed()).skip(1).findFirst());

        //count employees in each department
        Map<String,Long> countofemployeesineachdepartment = employees.stream().collect(Collectors.groupingBy(Employee::department,Collectors.counting()));
        System.out.println(countofemployeesineachdepartment);

        //group employees by each department

        Map<String,List<String>> groupemployeesbydepartment = employees.stream().collect(Collectors.groupingBy(Employee::department,
                Collectors.collectingAndThen(Collectors.toList(), employees1 -> {
                    List<String> ss = new ArrayList<>();
                    for (Employee employee : employees1) {
                        ss.add(employee.name());
                    }
                    return ss;
                })));

        System.out.println(groupemployeesbydepartment);

        List<List<String>> phones = List.of(
                List.of("111", "222"),
                List.of("333", "444"),
                List.of("555")
        );

        System.out.println(phones.stream().flatMap(list->list.stream()).toList());
        System.out.println();
        System.out.println();

//remove duplicates and sort in descending order
        List<Integer>  list  = new ArrayList<>(Arrays.asList(5,3,1,3,2,5,4));

        System.out.println(list.stream().sorted(Comparator.reverseOrder()).distinct().toList());

        //find odd numbers and return squares
        List<Integer> values = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(values.stream().filter(n->n%2==1).map(s->s*s).toList());

        //get 2nd and 3rd element from list and return in a list
        List<Integer> integerList  = new ArrayList<>(Arrays.asList(10,20,30,40,50));
        System.out.println(integerList.stream().skip(1).limit(2).toList());

        //second highest number in a list
        List<Integer> integerList1 = new ArrayList<>(Arrays.asList(20,10,10,45,30,45,5,20));
        System.out.println(integerList1.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get());


        //divide numbers into even and odd
        List<Integer> integerList2 = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        System.out.println(integerList2.stream().collect(Collectors.partitioningBy(s->s%2==1)));

        //find the longest string
        List<String> stringList = new ArrayList<>(Arrays.asList("Java","SpringBoot","API"));
        System.out.println(stringList.stream().collect(Collectors.toMap(Function.identity(),String::length))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());
        System.out.println(stringList.stream().max(Comparator.comparing(s->s.length())));



        //person salary which is just greater than 50000
        System.out.println(employees.stream().filter(s->s.salary()>50000).sorted(Comparator.comparing(Employee::salary)).findFirst().get());

        //top 2 highest paid employees
        System.out.println(employees.stream().sorted(Comparator.comparing(Employee::salary).reversed()).limit(2).toList());


        //sort employees by salary and then by name
        System.out.println(employees.stream().collect(Collectors.toMap(Employee::name,Employee::salary))
                .entrySet().stream().sorted((o1, o2) -> {
                    if (o1.getValue() > o2.getValue()) {
                        return 1;
                    } else if (o1.getValue() < o2.getValue()) {
                        return -1;
                    } else {
                        o1.getKey().compareTo(o2.getKey());
                    }
                    return 0;
                }).toList());
        System.out.println("HHHHHHHHHHHHHHH"+employees.stream().sorted(Comparator
                .comparing(Employee::salary).thenComparing(Employee::name)).map(Employee::name).toList());

        //frequency of element in the list

        List<Integer> integerList3 = new ArrayList<>(Arrays.asList(3,2,3,4,4,1,2,1,1,1,5,6,5));
        System.out.println(integerList3.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

        //frequency of characters in this string
        String s = "abaccada";
        Map<Character, Long> countofcharacters = s.chars().mapToObj(m->(char)m)
                .collect(Collectors.groupingBy(v->v,Collectors.counting()));
        System.out.println(countofcharacters);

        //employee count in each department

        Map<String,Long> employeecountineachdepartment  = employees.stream().collect(Collectors.groupingBy(Employee::department,Collectors.collectingAndThen(Collectors.toList(),
                m->m.stream().count())));
        System.out.println(employeecountineachdepartment);


        //transaction total per category
        List<Transaction> transactionList = Arrays.asList(
                new Transaction("Food",100),
                new Transaction("Food",200),
                new Transaction("Food",150),
                new Transaction("Shopping",300),
                new Transaction("Shopping",250),
                new Transaction("Shopping",100),
                new Transaction("Utilities",400),
                new Transaction("Utilities",300),
                new Transaction("Entertainment",500),
                new Transaction("Entertainment",200),
                new Transaction("Travel",700),
                new Transaction("Travel",300)
        );

  Map<String,Integer> transactionamountpercategory = transactionList.stream()
          .collect(Collectors.groupingBy(Transaction::item,
             Collectors.summingInt(Transaction::amount)));
        System.out.println(transactionamountpercategory);
        System.out.println("VVVVVVVVVVVVVVVVVVVV"+transactionList.stream().collect(Collectors.groupingBy(Transaction::item,Collectors.collectingAndThen(
          Collectors.toList(),x->x.stream().mapToInt(Transaction::amount).sum()
          ))));



        //avg salary of employee in each department

        Map<String,Double> avgsalaryineachdepartment = employees.stream().collect(Collectors.groupingBy(Employee::department,
                Collectors.averagingInt(v-> (int) v.salary())));

        System.out.println(avgsalaryineachdepartment);




        //highest paid employee in each department
        Map<String,List<String>> highestPaidEmployee = employees.stream().collect(Collectors.groupingBy(Employee::department,
                Collectors.collectingAndThen(Collectors.toList(), employees2 -> {
                    List<String> names = new ArrayList<>();
                    double maxsalary = employees2.stream().mapToDouble(Employee::salary).max().orElse(0);
                    employees2.stream().filter(s1 -> s1.salary() == maxsalary).forEach(v -> names.add(v.name()));
                    return names;
                })));

        System.out.println(highestPaidEmployee);

        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::department,Collectors.maxBy(Comparator.comparing(Employee::salary)))));

        //employees at end should be having comma

        System.out.println(employees.stream().map(Employee::name).collect(Collectors.joining(",")));

        //common elements in the list

        List<Integer> vv1 = Arrays.asList(1,2,3,4);
        List<Integer> vv2 = Arrays.asList(3,4,5,6);
        Set<Integer> s1= new HashSet<>(vv1);

        System.out.println( vv2.stream().filter(s1::contains).toList());

        //top 10 paid employees
        Map<String,Double> employeewithhighestsalary = employees.stream().limit(10)
                .collect(Collectors.toMap(Employee::name,Employee::salary));

        System.out.println(employeewithhighestsalary.entrySet().stream().sorted((o1, o2) -> {
            if(o1.getValue()>o2.getValue())
            {
                return 1;
            }
            else if(o1.getValue()<o2.getValue())
            {
                return -1;
            }
            return 0;
        }).toList().reversed());


        Map<String,Double> employeewithSecondhighestsalary = employees.stream()
                .collect(Collectors.toMap(Employee::name,Employee::salary));
        System.out.println(employeewithSecondhighestsalary);
        System.out.println(employeewithSecondhighestsalary.entrySet().stream().sorted(((Comparator<Map.Entry<String, Double>>) (o1, o2) -> {
            if (o1.getValue() > o2.getValue()) {
                return 1;
            } else if (o1.getValue() < o2.getValue()) {
                return -1;
            }
            return 0;
        }).reversed()).limit(3).skip(2).toList());

        /// salaries in each department

        Map<String,List<Double>> salariesineachdepartment = employees.stream().collect(Collectors.groupingBy(Employee::department,Collectors.collectingAndThen(
                Collectors.toList(),v->v.stream().map(Employee::salary).toList())));
        System.out.println(salariesineachdepartment);

        System.out.println(salariesineachdepartment.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,x->x.getValue().stream()
                .sorted(Comparator.reverseOrder()).toList().stream().skip(1).findFirst().get())));


        List<String> names = List.of("Alice","Bob","Charlie","David","Alex");


             ///   names.stream().collect(Collectors.groupingBy(x->x.startsWith("A")));
        System.out.println(names.stream().collect(Collectors.groupingBy(x->x.startsWith("A"))).toString());

        List<Integer> list1 = List.of(1,2,3,4,5);

        System.out.println(list1.stream().reduce(0, Integer::sum));


        IntSummaryStatistics intSummaryStatistics = list1.stream()
                .mapToInt(x-> x).summaryStatistics();
        System.out.println(intSummaryStatistics);

        //find median salaries

        List<Integer> salaries = List.of(65000,85000,95000,75000,90000,100000);

        List<Integer> newlistsalaries = salaries.stream().sorted().toList();
        System.out.println(newlistsalaries);

        int n = newlistsalaries.size();

        if(n%2==0)
        {

            System.out.println((newlistsalaries.get(n/2-1)+newlistsalaries.get(n/2))/2);

        }
        else
        {
            System.out.println(newlistsalaries.get(n/2));
        }



    }
}
