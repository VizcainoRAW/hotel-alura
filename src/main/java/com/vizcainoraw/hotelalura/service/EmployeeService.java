package com.vizcainoraw.hotelalura.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.vizcainoraw.hotelalura.dto.employee.EmployeeDto;
import com.vizcainoraw.hotelalura.dto.employee.EmployeeMapper;
import com.vizcainoraw.hotelalura.model.Employee;
import com.vizcainoraw.hotelalura.repository.EmployeeRepository;

import lombok.NonNull;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    public EmployeeService(EmployeeRepository repository, EmployeeMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    
    public List<EmployeeDto> findAllEmployees(){
        return repository.findAll().stream()
        .map(employee -> mapper.employeeToDto(employee))
        .collect(Collectors.toList());
    }

    public EmployeeDto findEmployeeById(@NonNull Long id){
        return repository.findById(id)
            .map(employee -> mapper.employeeToDto(employee))
            .orElseThrow(() -> new ResourceNotFoundException( "no found employee with id (%s)".formatted(id) )
            );
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        Employee employee = mapper.DtoToEmployee(employeeDto);
        if (employee == null) {
            throw new IllegalArgumentException("Failed to create Employee");
        }

        return mapper.employeeToDto(
            repository.save(employee));
    }

    public EmployeeDto updateEmployee(@NonNull Long id, EmployeeDto updatedEmployeeDto){
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException(
                "no found emplyee with id(%s) to update".formatted(id));
        }
        Employee employeeToUpdate = repository.findById(id).get();

        employeeToUpdate.setFirstName( updatedEmployeeDto.firstName() );
        employeeToUpdate.setLastName( updatedEmployeeDto.lastName() );
        employeeToUpdate.setSalary( updatedEmployeeDto.salary() );
        
        return mapper.employeeToDto(
            repository.save(employeeToUpdate)
        );
    }

    public void deleteEmployee(@NonNull Long id){
        if(!repository.existsById(id)) {
            throw new ResourceNotFoundException("no found Employee with id(%s) to delete".formatted(id));
        }

        repository.deleteById(id);
    }
}