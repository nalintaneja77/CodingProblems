package DSAQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class altimetriktest2 {
    static void main() {

        List<EmployeeSkillsAndSalary> employeeSkillsAndSalaryList = Arrays
                .asList(new EmployeeSkillsAndSalary("Divya", "IT", Arrays.asList("Java", "Kafka", "AWS"), 120000),
                        new EmployeeSkillsAndSalary("Arun", "IT", Arrays.asList("Java", "Spring", "Kafka"), 90000),
                        new EmployeeSkillsAndSalary("Gokul", "IT", Arrays.asList("Spring", "Docker"), 85000),
                        new EmployeeSkillsAndSalary("Esha", "HR", Arrays.asList("Recruitment", "Java"), 80000),
                        new EmployeeSkillsAndSalary("Priya", "HR", Arrays.asList("Java", "Spring", "AWS"), 110000),
                        new EmployeeSkillsAndSalary("Fahad", "Finance", Arrays.asList("Excel", "SQL"), 95000),
                        new EmployeeSkillsAndSalary("Kiran", "Finance", Arrays.asList("SQL", "Java", "Excel"), 105000));



        Map<String, DepartmentSummary> bb = employeeSkillsAndSalaryList.stream()
                .filter(x -> x.salary() >= 90000)
                .collect(Collectors.groupingBy(EmployeeSkillsAndSalary::department, Collectors.collectingAndThen(Collectors.toList(),
                        employeeSkillsAndSalaries -> {
                            int count = employeeSkillsAndSalaries.size();
                            double totalSalary = employeeSkillsAndSalaries.stream().mapToDouble(EmployeeSkillsAndSalary::salary).sum();
                            double avgSalary = totalSalary / count;
                            List<String> namesOfEmployees = employeeSkillsAndSalaries.stream()
                                    .sorted(Comparator.comparing(EmployeeSkillsAndSalary::salary).reversed())
                                    .map(EmployeeSkillsAndSalary::name)
                                    .toList();
                            return new DepartmentSummary(count, totalSalary, avgSalary, namesOfEmployees);
                        }
                )));

        bb.entrySet().stream()
                .sorted(Map.Entry.<String,DepartmentSummary>comparingByValue(Comparator.comparing(DepartmentSummary::avgSalary)).reversed())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,
                        (a,b)->a,LinkedHashMap::new)).entrySet().forEach(
                                x-> System.out.println(x.getKey()+" -> "+x.getValue())
                );
    }


}

