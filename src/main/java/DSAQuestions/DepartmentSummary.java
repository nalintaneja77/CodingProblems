package DSAQuestions;

import java.util.List;

public record DepartmentSummary(int employeeCount, double totalSalary, double avgSalary,
                                List<String> employeeNames) {
}
