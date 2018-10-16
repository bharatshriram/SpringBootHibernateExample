/**
 * 
 */
package com.hanbit.SpringBootHibernateExample.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hanbit.SpringBootHibernateExample.model.Employee;
import com.hanbit.SpringBootHibernateExample.model.LoginVO;
import com.hanbit.SpringBootHibernateExample.service.EmployeeService;
import com.hanbit.SpringBootHibernateExample.service.LoginBO;

/**
 * @author Bharat Kumar
 *
 */

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	//Gson gson = new Gson();
	
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homePage() throws IOException {
		System.out.println("===>");

		return new ModelAndView("redirect:/login");
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listEmployee(ModelAndView model) throws IOException {

		List<Employee> listEmployee = employeeService.getAllEmployees();

		model.addObject("listEmployee", listEmployee);

		System.out.println("==============>>>>" + listEmployee);

		model.setViewName("home");

		return model;
	}

	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Employee employee = new Employee();
		model.addObject("employee", employee);
		model.setViewName("EmployeeForm");
		return model;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		if (employee.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			employeeService.addEmployee(employee);
		} else {
			employeeService.updateEmployee(employee);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		employeeService.deleteEmployee(employeeId);
		return new ModelAndView("redirect:/list");
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeService.getEmployee(employeeId);
		ModelAndView model = new ModelAndView("EmployeeForm");
		model.addObject("employee", employee);

		return model;
	}

}
