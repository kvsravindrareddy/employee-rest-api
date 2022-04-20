package com.basha.service;

import com.basha.data.EmployeeData;
import com.basha.entity.Employee;
import com.basha.mapper.EmployeeMapper;
import com.basha.repo.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * This class holds the Employee business logic with all the Crud operations.
 */
@Service
public class EmployeeService {

    private EmployeeRepo employeeRepo;

    private EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepo employeeRepo, EmployeeMapper employeeMapper) {
        this.employeeRepo = employeeRepo;
        this.employeeMapper = employeeMapper;
    }

    /**
     * This method performs the business logic to store the employee into Data base {@code Employee}
     * @param employeeData
     * @return {@code EmployeeData}
     */
    public EmployeeData createEmployee(EmployeeData employeeData) {
        Employee employee= employeeMapper.empDataToEmpEntity(employeeData);
        return employeeMapper.empEntityToEmpData(employeeRepo.save(employee));
    }

    /**
     * This method gets the {@code EmployeeData} from database for the given employee id
     * @param id
     * @return {@code EmployeeData}
     */
    public EmployeeData findByEmployeeId(long id) {
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        EmployeeData employeeData = null;
        if(employeeOptional.isPresent())
        {
            employeeData = employeeMapper.empEntityToEmpData(employeeOptional.get());
        }
        return employeeData;
    }

    public EmployeeData updateEmployeeById(EmployeeData employeeData, long id) {
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        EmployeeData employeeDataResult = null;
        if(employeeOptional.isPresent())
        {
            Employee employee = new Employee();
            employee.setId(id);
            employee.setFirstName(employeeData.getFirstName());
            employee.setMiddleName(employeeData.getMiddleName());
            employee.setLastName(employeeData.getLastName());
            employee.setSalary(employeeData.getSalary());
            employee.setDepartment(employeeData.getDepartment());
            Employee employeeResult = employeeRepo.save(employee);
            employeeDataResult = employeeMapper.empEntityToEmpData(employeeResult);
        }
        return employeeDataResult;
    }

    public void deleteEmployee(long id) {
        employeeRepo.deleteById(id);
    }
}