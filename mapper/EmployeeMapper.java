package employeeManagement.mapper;

import employeeManagement.dto.EmployeeResponse;
import employeeManagement.model.Employee;

import java.util.List;

public class EmployeeMapper {

    public EmployeeResponse toResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .salary(employee.getSalary())
                .build();
    }

    public List<EmployeeResponse> toReponseList(List<Employee> employees) {
        return employees.stream()
                .map(employee -> EmployeeResponse.builder()
                        .id(employee.getId())
                        .name(employee.getName())
                        .email(employee.getEmail())
                        .salary(employee.getSalary())
                        .build()
                )
                .toList();
    }

}
