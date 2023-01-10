package lt.techin.zoo.api;

import lt.techin.zoo.api.dto.EmployeeDto;
import lt.techin.zoo.api.dto.mapper.EmployeeMapper;
import lt.techin.zoo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.techin.zoo.api.dto.mapper.EmployeeMapper.toEmployee;
import static lt.techin.zoo.api.dto.mapper.EmployeeMapper.toEmployeeDto;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    @ResponseBody
    public List<EmployeeDto> getEmployees() {
        return employeeService.getAll().stream()
                .map(EmployeeMapper::toEmployeeDto)
                .collect(toList());
        //return ResponseEntity.ok(animalRepository.getAll());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long employeeId) {
        var employeeOptional = employeeService.getById(employeeId);

        var responseEntity = employeeOptional
                .map(employee -> ok(toEmployeeDto(employee)))
                .orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
        boolean deleted = employeeService.deleteById(employeeId);
        if(deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
        //return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //TODO create
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        //FIXME temp
        employeeDto.setId(null);

        var createdEmployee = employeeService.create(toEmployee(employeeDto));

        return ok(toEmployeeDto(createdEmployee));
    }

    //TODO update

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeDto employeeDto) {
        //FIXME temp
        employeeDto.setId(null);

        var updatedEmployee = employeeService.update(employeeId, toEmployee(employeeDto));

        return ok(toEmployeeDto(updatedEmployee));
    }

}
