/**
 * 
 */
package com.hanbit.SpringBootHibernateExample.dao;

import java.util.List;

import com.hanbit.SpringBootHibernateExample.model.Employee;


/**
 * @author Bharat Kumar
 *
 */
public interface EmployeeDAO {
	
	
	public void addEmployee(Employee employee);
	 
    public List<Employee> getAllEmployees();
 
    public void deleteEmployee(Integer employeeId);
 
    public Employee updateEmployee(Employee employee);
 
    public Employee getEmployee(int employeeid);

}
