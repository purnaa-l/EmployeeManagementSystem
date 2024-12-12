package net.javaguides.demo.ems.backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.demo.ems.backend.dto.EmployeeDto;
import net.javaguides.demo.ems.backend.entity.Employee;
import net.javaguides.demo.ems.backend.exception.ResourceNotFoundException;
import net.javaguides.demo.ems.backend.mapper.EmployeeMapper;
import net.javaguides.demo.ems.backend.repository.EmployeeRepository;
import net.javaguides.demo.ems.backend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
    Employee employee=employeeRepository.findById(employeeId)
            .orElseThrow(()->new ResourceNotFoundException(("Employee Not Exist with this id"+employeeId)));
    return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .toList();
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee does not exist with the given ID")
        );
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setLastName(updatedEmployee.getLastName());
        Employee updatedEmployeeObj=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee does not exist with the given ID")
        );
        employeeRepository.deleteById(employeeId);
    }
}
