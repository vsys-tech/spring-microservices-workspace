package postgre.app.services;

import org.springframework.stereotype.Service;
import postgre.app.entities.Employee;
import postgre.app.repository.EmployeeRepository;
import postgre.app.specifications.EmployeeSpecification;
import postgre.app.specifications.SearchCriteria;

import java.util.List;

@Service

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private EmployeeSpecification employeeSpecification;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> find() {
        SearchCriteria criteria = new SearchCriteria("fName", "=", "sam");
        employeeSpecification = new EmployeeSpecification(criteria);
        List<Employee> empList = employeeRepository.findAll(employeeSpecification);

        empList.stream().forEach(emp -> {
            System.out.println(emp.toString());
        });
        return empList;
    }


}
