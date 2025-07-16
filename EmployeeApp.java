package employeeManagement;

import employeeManagement.mapper.EmployeeMapper;
import employeeManagement.repository.EmployeeRepository;
import employeeManagement.service.EmployeeService;
import employeeManagement.service.EmployeeServiceImpl;
import employeeManagement.utils.TableUtils;

public class EmployeeApp {


    public static void main(String[] args) {

        TableUtils tableUtils = new TableUtils();

        EmployeeRepository repository = new EmployeeRepository();
        EmployeeMapper employeeMapper = new EmployeeMapper();
        EmployeeService employeeService = new EmployeeServiceImpl(repository, employeeMapper);

        System.out.println(
                tableUtils.renderEmployeeList(
                        employeeService.getAllEmployees()
                )
        );

    }

}
