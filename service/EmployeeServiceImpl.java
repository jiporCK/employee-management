package employeeManagement.service;

import employeeManagement.dto.EmployeeRequest;
import employeeManagement.dto.EmployeeResponse;
import employeeManagement.exception.EmployeeException;
import employeeManagement.mapper.EmployeeMapper;
import employeeManagement.model.Employee;
import employeeManagement.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository repository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository repository, EmployeeMapper employeeMapper) {
        this.repository = repository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeResponse create(EmployeeRequest request) {

        Employee employee = employeeMapper.fromRequest(request);

        repository.getEmployees().add(employee);

        return null;
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return List.of();
    }

    @Override
    public Optional<EmployeeResponse> getEmployeeById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<EmployeeResponse> updateById(String id, EmployeeRequest request) {
        return Optional.empty();
    }

    @Override
    public boolean deleteEmployeeById(String id) {
        return false;
    }
}
