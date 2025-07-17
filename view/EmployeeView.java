package employeeManagement.view;

import employeeManagement.dto.EmployeeRequest;
import employeeManagement.dto.EmployeeResponse;
import employeeManagement.exception.EmployeeException;
import employeeManagement.mapper.EmployeeMapper;
import employeeManagement.repository.EmployeeRepository;
import employeeManagement.service.EmployeeService;
import employeeManagement.service.EmployeeServiceImpl;
import employeeManagement.utils.TableUtils;

import java.util.Optional;
import java.util.Scanner;

public class EmployeeView {

    private final static Scanner scanner = new Scanner(System.in);
    private final static TableUtils tableUtils = new TableUtils();

    private final EmployeeService employeeService;

    public EmployeeView(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private void label() {
        System.out.println(
                """
            ██╗███████╗████████╗ █████╗ ██████╗          ██╗ █████╗ ██╗   ██╗ █████╗     
            ██║██╔════╝╚══██╔══╝██╔══██╗██╔══██╗         ██║██╔══██╗██║   ██║██╔══██╗    
            ██║███████╗   ██║   ███████║██║  ██║         ██║███████║██║   ██║███████║    
            ██║╚════██║   ██║   ██╔══██║██║  ██║    ██   ██║██╔══██║╚██╗ ██╔╝██╔══██║    
            ██║███████║   ██║   ██║  ██║██████╔╝    ╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║    
            ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═════╝      ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝"""
        );
    }

    private void showMenu() {
        System.out.println("========| Employee Management |========");
        System.out.println("1. Add Employee");
        System.out.println("2. Update Employee by ID");
        System.out.println("3. Delete Employee by ID");
        System.out.println("4. Get all employees");
        System.out.println("5. Get employee by ID");
        System.out.println("0. Exit Program");
    }

    public void start() {
        int op;
        while (true) {
            try {
                showMenu();
                System.out.print("Enter an option -> ");
                op = Integer.parseInt(scanner.nextLine());
                if (op == 0) System.exit(0);
                switch (op) {
                    case 1 -> addEmployee();
                    case 2 -> updateEmployee();
                    case 3 -> deleteEmployee();
                    case 4 -> getAllEmployees();
                    case 5 -> getEmployeeById();
                    default -> System.out.println("Invalid option!");
                }
            } catch (EmployeeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void addEmployee() {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        if (name.isBlank()) {
            throw new EmployeeException("Name cannot be blank");
        }

        System.out.print("Enter employee email: ");
        String email = scanner.nextLine();

        System.out.print("Enter employee salary: ");
        Double salary = Double.parseDouble(scanner.nextLine());

        EmployeeRequest request = new EmployeeRequest(
                name, email, salary
        );

        System.out.println(
                tableUtils.renderEmployee(
                        employeeService.create(request)
                )
        );

    }

    private void updateEmployee() {}

    private void deleteEmployee() {}

    private void getAllEmployees() {
        System.out.println(
                tableUtils.renderEmployeeList(
                        employeeService.getAllEmployees()
                )
        );
    }

    private void getEmployeeById() {
        System.out.print("Enter id: ");
        String id = scanner.nextLine();
        Optional<EmployeeResponse> response = employeeService.getEmployeeById(
                id
        );

        if (response.isPresent()) {
            System.out.println(tableUtils.renderEmployee(response.get()));
        }

    }

}
