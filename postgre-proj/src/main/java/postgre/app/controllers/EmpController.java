package postgre.app.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import postgre.app.entities.Employee;
import postgre.app.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

    private final EmployeeService employeeService;

    public EmpController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public List<Employee> findIt() {
        return employeeService.find();
    }

}
