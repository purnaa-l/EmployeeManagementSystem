package net.javaguides.demo.ems.backend.mapper;

import net.javaguides.demo.ems.backend.dto.EmployeeDto;
import net.javaguides.demo.ems.backend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),               // Pass the ID
                employeeDto.getFirstName(),        // Pass the first name
                employeeDto.getLastName(),         // Pass the last name
                employeeDto.getEmail()             // Pass the email
        );
    }
}
