package com.basha.controller;

import com.basha.data.EmployeeData;
import com.basha.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

/**
 * This the Rest Controller to perform the Employee Crud Operations
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {

    /**Create {@code EmployeeService} reference*/
    private EmployeeService employeeService;

    /**
     * Constructor injection
     * @param {@code {@code EmployeeService}} employeeService
     */
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    /**
     * This method to create the new Employee
     * @param employeeData
     * @return {@code EmployeeData}
     */
    @PostMapping(value="/add")
    public EmployeeData createEmployee(@RequestBody EmployeeData employeeData)
    {
        return employeeService.createEmployee(employeeData);
    }

    /**
     * This method used find the employee by id
     * @param id
     * @return {@code EmployeeData}
     */
    @GetMapping("/find")
    public EmployeeData findByEmployeeId(@RequestParam("id")long id)
    {
        return employeeService.findByEmployeeId(id);
    }

    @PutMapping("/update")
    public EmployeeData updateEmployeeById(@RequestBody EmployeeData employeeData,@RequestParam("id")long id)
    {
        return employeeService.updateEmployeeById(employeeData, id);
    }

    @DeleteMapping("/delete")
    public void deleteEmployee(@RequestParam("id")long id)
    {
        employeeService.deleteEmployee(id);
    }
}