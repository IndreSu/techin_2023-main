package lt.techin.zoo.service;

import lt.techin.zoo.api.dto.EmployeeDto;
import lt.techin.zoo.api.dto.mapper.EmployeeMapper;
import lt.techin.zoo.dao.EmployeeRepository;
import lt.techin.zoo.model.Employee;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

import static lt.techin.zoo.model.EmployeeType.*;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getById(Long id) {
        return employeeRepository.findById(id);
    }


    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(Long id, Employee employee) {
        employee.setId(id);//FIXME will improve later

        return employeeRepository.save(employee);
    }

    public boolean deleteById(Long id) {
        try {
            employeeRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
    }

    @PostConstruct
    //FIXME for dev purpose
    public void loadInitialEmployees() {
        var initialEmployeesToAdd = List.of(
                new EmployeeDto(null, "Petras", MANAGER, ""),
                new EmployeeDto(null, "Jonas", ASSISTANT, ""),
                new EmployeeDto(null, "Tomas", DIRECTOR, "")
        );

        initialEmployeesToAdd.stream()
                .map(EmployeeMapper::toEmployee)
                .forEach(employeeRepository::save);
    }



}
