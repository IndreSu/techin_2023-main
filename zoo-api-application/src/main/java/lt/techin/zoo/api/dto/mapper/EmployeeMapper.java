package lt.techin.zoo.api.dto.mapper;

import lt.techin.zoo.api.dto.EmployeeDto;
import lt.techin.zoo.model.Employee;

public class EmployeeMapper {

    public static EmployeeDto toEmployeeDto(Employee employee) {
        var employeeDto = new EmployeeDto();

        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setType(employee.getType());
        employeeDto.setDescription(employee.getDescription());

        return employeeDto;
    }

    public static Employee toEmployee(EmployeeDto employeeDto) {
        var employee = new Employee();

        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setType(employeeDto.getType());
        employee.setDescription(employeeDto.getDescription());

        return employee;
    }

}
