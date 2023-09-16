package com.tech.immovable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.immovable.bean.Employee;
import com.tech.immovable.bean.Response;
import com.tech.immovable.dao.EmployeeDaoImpl;

/**
 * --------------------------------------------------------------------------------------
 * --------------Copyright-(c)-Immovable-Technologies.-All-rights-reserved.--------------
 * ----------------------------User:immovabletech@gmail.com_-----------------------------
 * --------------------------------------------------------------------------------------
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDaoImpl employeeDaoImpl;

	@Override
	public List<Employee> getListOfEmployees() {
		return employeeDaoImpl.getListOfEmployees();
	}

	@Override
	public Response createEmployee(Employee employee, Response response) {
		System.out.println("Inside EmployeService.createEmployee() method");
		return employeeDaoImpl.addEmployee(employee, response);
	}

	@Override
	public Response updateEmployee(Employee employee, Response response) throws Exception {
		return employeeDaoImpl.updateEmployee(employee, response);
	}

	@Override
	public Response removeEmployee(String empId) throws Exception {
		return employeeDaoImpl.removeEmployee(empId);
	}

	@Override
	public Employee getEmployeeById(String empId) throws Exception {
		return employeeDaoImpl.getEmployeeById(empId);
	}

}
