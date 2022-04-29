package com.basha.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.basha.data.EmployeeData;
import com.basha.entity.Employee;
import com.basha.mapper.EmployeeMapper;
import com.basha.repo.EmployeeRepo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmployeeService.class})
@ExtendWith(SpringExtension.class)
class EmployeeServiceTest {
    @MockBean
    private EmployeeMapper employeeMapper;

    @MockBean
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeService employeeService;

    @Test
    void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setDepartment("Department");
        employee.setFirstName("Jane");
        employee.setId(123L);
        employee.setLastName("Doe");
        employee.setMiddleName("Middle Name");
        employee.setSalary(10.0);
        when(this.employeeRepo.save((Employee) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setDepartment("Department");
        employee1.setFirstName("Jane");
        employee1.setId(123L);
        employee1.setLastName("Doe");
        employee1.setMiddleName("Middle Name");
        employee1.setSalary(10.0);

        EmployeeData employeeData = new EmployeeData();
        employeeData.setDepartment("Department");
        employeeData.setFirstName("Jane");
        employeeData.setId(123L);
        employeeData.setLastName("Doe");
        employeeData.setMiddleName("Middle Name");
        employeeData.setSalary(10.0);
        when(this.employeeMapper.empEntityToEmpData((Employee) any())).thenReturn(employeeData);
        when(this.employeeMapper.empDataToEmpEntity((EmployeeData) any())).thenReturn(employee1);

        EmployeeData employeeData1 = new EmployeeData();
        employeeData1.setDepartment("Department");
        employeeData1.setFirstName("Jane");
        employeeData1.setId(123L);
        employeeData1.setLastName("Doe");
        employeeData1.setMiddleName("Middle Name");
        employeeData1.setSalary(10.0);
        assertSame(employeeData, this.employeeService.createEmployee(employeeData1));
        verify(this.employeeRepo).save((Employee) any());
        verify(this.employeeMapper).empDataToEmpEntity((EmployeeData) any());
        verify(this.employeeMapper).empEntityToEmpData((Employee) any());
    }

    @Test
    void testFindByEmployeeId() {
        Employee employee = new Employee();
        employee.setDepartment("Department");
        employee.setFirstName("Jane");
        employee.setId(123L);
        employee.setLastName("Doe");
        employee.setMiddleName("Middle Name");
        employee.setSalary(10.0);
        Optional<Employee> ofResult = Optional.of(employee);
        when(this.employeeRepo.findById((Long) any())).thenReturn(ofResult);

        EmployeeData employeeData = new EmployeeData();
        employeeData.setDepartment("Department");
        employeeData.setFirstName("Jane");
        employeeData.setId(123L);
        employeeData.setLastName("Doe");
        employeeData.setMiddleName("Middle Name");
        employeeData.setSalary(10.0);
        when(this.employeeMapper.empEntityToEmpData((Employee) any())).thenReturn(employeeData);
        assertSame(employeeData, this.employeeService.findByEmployeeId(123L));
        verify(this.employeeRepo).findById((Long) any());
        verify(this.employeeMapper).empEntityToEmpData((Employee) any());
    }

    @Test
    void testFindByEmployeeId_case2() {
        when(this.employeeRepo.findById((Long) any())).thenReturn(Optional.empty());
        EmployeeData employeeData = new EmployeeData();
        employeeData.setDepartment("Department");
        employeeData.setFirstName("Jane");
        employeeData.setId(123L);
        employeeData.setLastName("Doe");
        employeeData.setMiddleName("Middle Name");
        employeeData.setSalary(10.0);
        when(this.employeeMapper.empEntityToEmpData((Employee) any())).thenReturn(employeeData);
        assertNull(this.employeeService.findByEmployeeId(123L));
        verify(this.employeeRepo).findById((Long) any());
    }

    @Test
    void testUpdateEmployeeById() {
        Employee employee = new Employee();
        employee.setDepartment("Department");
        employee.setFirstName("Jane");
        employee.setId(123L);
        employee.setLastName("Doe");
        employee.setMiddleName("Middle Name");
        employee.setSalary(10.0);
        Optional<Employee> ofResult = Optional.of(employee);

        Employee employee1 = new Employee();
        employee1.setDepartment("Department");
        employee1.setFirstName("Jane");
        employee1.setId(123L);
        employee1.setLastName("Doe");
        employee1.setMiddleName("Middle Name");
        employee1.setSalary(10.0);
        when(this.employeeRepo.save((Employee) any())).thenReturn(employee1);
        when(this.employeeRepo.findById((Long) any())).thenReturn(ofResult);

        EmployeeData employeeData = new EmployeeData();
        employeeData.setDepartment("Department");
        employeeData.setFirstName("Jane");
        employeeData.setId(123L);
        employeeData.setLastName("Doe");
        employeeData.setMiddleName("Middle Name");
        employeeData.setSalary(10.0);
        when(this.employeeMapper.empEntityToEmpData((Employee) any())).thenReturn(employeeData);

        EmployeeData employeeData1 = new EmployeeData();
        employeeData1.setDepartment("Department");
        employeeData1.setFirstName("Jane");
        employeeData1.setId(123L);
        employeeData1.setLastName("Doe");
        employeeData1.setMiddleName("Middle Name");
        employeeData1.setSalary(10.0);
        assertSame(employeeData, this.employeeService.updateEmployeeById(employeeData1, 123L));
        verify(this.employeeRepo).findById((Long) any());
        verify(this.employeeRepo).save((Employee) any());
        verify(this.employeeMapper).empEntityToEmpData((Employee) any());
    }

    @Test
    void testUpdateEmployeeById_case2() {
        Employee employee = new Employee();
        employee.setDepartment("Department");
        employee.setFirstName("Jane");
        employee.setId(123L);
        employee.setLastName("Doe");
        employee.setMiddleName("Middle Name");
        employee.setSalary(10.0);
        when(this.employeeRepo.save((Employee) any())).thenReturn(employee);
        when(this.employeeRepo.findById((Long) any())).thenReturn(Optional.empty());

        EmployeeData employeeData = new EmployeeData();
        employeeData.setDepartment("Department");
        employeeData.setFirstName("Jane");
        employeeData.setId(123L);
        employeeData.setLastName("Doe");
        employeeData.setMiddleName("Middle Name");
        employeeData.setSalary(10.0);
        when(this.employeeMapper.empEntityToEmpData((Employee) any())).thenReturn(employeeData);

        EmployeeData employeeData1 = new EmployeeData();
        employeeData1.setDepartment("Department");
        employeeData1.setFirstName("Jane");
        employeeData1.setId(123L);
        employeeData1.setLastName("Doe");
        employeeData1.setMiddleName("Middle Name");
        employeeData1.setSalary(10.0);
        assertNull(this.employeeService.updateEmployeeById(employeeData1, 123L));
        verify(this.employeeRepo).findById((Long) any());
    }

    @Test
    void testDeleteEmployee() {
        doNothing().when(this.employeeRepo).deleteById((Long) any());
        this.employeeService.deleteEmployee(123L);
        verify(this.employeeRepo).deleteById((Long) any());
    }
}

