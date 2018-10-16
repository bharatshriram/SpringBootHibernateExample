/**
 * 
 */
package com.hanbit.SpringBootHibernateExample.service;

import java.util.List;

import com.hanbit.SpringBootHibernateExample.model.Employee;

/**
 * @author Bharat Kumar
 *
 */
public interface EmployeeService {
	 
    public void addEmployee(Employee employee);
 
    public List<Employee> getAllEmployees();
 
    public void deleteEmployee(Integer employeeId);
 
    public Employee getEmployee(int employeeid);
 
    public Employee updateEmployee(Employee employee);
    
    
}
