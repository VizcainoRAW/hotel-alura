package com.vizcainoraw.hotelalura.dto.employee;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.vizcainoraw.hotelalura.model.Employee;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper {
    
    @Mapping(source = "employeeId", target = "id")
    EmployeeDto employeeToDto(Employee employee);

    @InheritInverseConfiguration
    Employee DtoToEmployee(EmployeeDto employeeDto);
}