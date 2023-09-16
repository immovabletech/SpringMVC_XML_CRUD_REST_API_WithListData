package com.tech.immovable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.immovable.bean.Employee;
import com.tech.immovable.bean.Response;
import com.tech.immovable.service.EmployeeService;

/**
 * --------------------------------------------------------------------------------------
 * --------------Copyright-(c)-Immovable-Technologies.-All-rights-reserved.--------------
 * ----------------------------User:immovabletech@gmail.com------------------------------
 * --------------------------------------------------------------------------------------
 */

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	public List<Employee> listOfEmployee() {
		List<Employee> employeeList = employeeService.getListOfEmployees();
		System.out.println(employeeList.toString());
		System.out.println(employeeList.size());
		return employeeList;
	}

	@ResponseBody
	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	public Response createEmployee(@RequestBody Employee employee) {
		Response response = new Response();
		response.setReqStatus(HttpStatus.NOT_ACCEPTABLE);
		try {
			if (employee != null) {
				System.out.println("Validating Employee email ID : " + employee.getEmpId().trim().isEmpty());
				if (employee.getEmail().trim().isEmpty() || employee.getFirstName().trim().isEmpty()) {
					response.setReqMsg("Employee first name & emailID's are mandatory");
					return response;
				}
				if (!employee.getEmail().trim().endsWith("@immovable.com")) {
					response.setReqMsg("Employee Email ID must be end with @immovable.com");
					return response;
				}
				return employeeService.createEmployee(employee, response);
			}
		} catch (Exception e) {
			response.setReqMsg("Please provide employee data in json format");
		}
		return response;
	}

	@RequestMapping(value = "/getEmployeeByID/{empId}", method = RequestMethod.GET)
	public Object getEmployeeByID(@PathVariable("empId") String empId) {
		Response response = new Response();
		response.setReqStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		System.out.println("EmpID: " + empId);
		try {
			if(empId != null && !empId.isEmpty()) {
				if(empId.startsWith("IT")) {
					if(empId != null && !empId.isEmpty()) {
						Employee emp = employeeService.getEmployeeById(empId);
						if(emp == null) {
							response.setReqMsg("Employee ID '" + empId + "' not found");
							response.setReqStatus(HttpStatus.NOT_FOUND);
							return response;
						}
						return emp;
					} 
				} else {
					response.setReqMsg("Employee ID should be start with 'IT'; Ex: IT000");
				}
			} else {
				response.setReqMsg("Employee ID can't be null or empty");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
	public @ResponseBody Response updateEmployee(@RequestBody Employee employee) {
		Response response = new Response();
		response.setReqStatus(HttpStatus.NOT_ACCEPTABLE);
		try {
			if(employee != null) {
				if(employee.getEmpId().trim().equals("") || !employee.getEmpId().trim().startsWith("IT")) {
					response.setReqMsg("Employee ID should be start with 'IT'; Ex: IT000");	
					return response;
				}
				if (employee.getEmail().trim().isEmpty() || employee.getFirstName().trim().isEmpty()) {
					response.setReqMsg("Employee first name & emailID's are mandatory");
					return response;
				}
				if (!employee.getEmail().trim().endsWith("@immovable.com")) {
					response.setReqMsg("Employee Email ID must be end with @immovable.com");
					return response;
				}
				return employeeService.updateEmployee(employee, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@RequestMapping(value = "/deleteEmployee/{empId}", method = RequestMethod.DELETE)
	public @ResponseBody Object deleteEmployee(@PathVariable("empId") String empId) {
		Response response = new Response();
		response.setReqStatus(HttpStatus.NOT_ACCEPTABLE);
		response.setReqMsg("Employee ID can't be null or empty");
		try {
			if(empId != null) {
				if(empId.trim().equals("") || !empId.trim().startsWith("IT")) {
					response.setReqMsg("Employee ID should be start with 'IT'; Ex: IT000");	
				} else {
					return employeeService.removeEmployee(empId);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return response;
		}
		return response;
	}

}
