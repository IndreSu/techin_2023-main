package lt.techin.zoo.api.dto;

import lt.techin.zoo.model.EmployeeType;

import java.util.Objects;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {

    private Long id;

    private String name;

    private EmployeeType type;

    private String description;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String name, EmployeeType type, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDto employeeDto = (EmployeeDto) o;
        return Objects.equals(id, employeeDto.id) && Objects.equals(name, employeeDto.name) && type == employeeDto.type && Objects.equals(description, employeeDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, description);
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                '}';
    }

}
