package com.tech.immovable.dao;

import java.util.List;

import com.tech.immovable.bean.Employee;
import com.tech.immovable.bean.Response;

/**
 * --------------------------------------------------------------------------------------
 * --------------Copyright-(c)-Immovable-Technologies.-All-rights-reserved.--------------
 * ----------------------------User:immovabletech@gmail.com_-----------------------------
 * --------------------------------------------------------------------------------------
 */

public interface EmployeeDao {
	public List<Employee> getListOfEmployees();

	public Response addEmployee(Employee employee, Response response);

	public Response updateEmployee(Employee employee, Response response) throws Exception;

	public Response removeEmployee(String empId) throws Exception;
	
	public Employee getEmployeeById(String empId) throws Exception;
}
