package com.basha.mapper;

import com.basha.data.EmployeeData;
import com.basha.entity.Employee;
import org.mapstruct.Mapper;

/**
 * Mapper interface generates the Spring component implementation class for the Employee
 */
@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    /**
     * This provides the object transformation from {@code EmployeeData} to {@code Employee}
     * @param {@code EmployeeData}
     * @return {@code Employee}
     */
    Employee empDataToEmpEntity(EmployeeData employeeData);

    /**
     * This provides the object transformation from {@code Employee} to {@code EmployeeData}
     * @param {@code Employee}
     * @return {@code EmployeeData}
     */
    EmployeeData empEntityToEmpData(Employee employee);
}