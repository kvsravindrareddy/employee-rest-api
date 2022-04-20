package com.basha.mapper;

import com.basha.data.EmployeeData;
import com.basha.entity.Employee;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee empDataToEmpEntity(EmployeeData employeeData);
    EmployeeData empEntityToEmpData(Employee employee);
}