package com.tech.immovable.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.immovable.bean.Employee;
import com.tech.immovable.bean.Response;
import com.tech.immovable.util.EmployeeUtil;

/**
 * --------------------------------------------------------------------------------------
 * --------------Copyright-(c)-Immovable-Technologies.-All-rights-reserved.--------------
 * ----------------------------User:immovabletech@gmail.com_-----------------------------
 * --------------------------------------------------------------------------------------
 */

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	EmployeeUtil employeeUtil;

	@Override
	public List<Employee> getListOfEmployees() {
		return employeeUtil.getEmployeeList();
	}

	@Override
	public Response addEmployee(Employee employee, Response response) {
		return employeeUtil.addEmployee(employee, response);
	}

	@Override
	public Response updateEmployee(Employee employee, Response response) throws Exception {
		return employeeUtil.updateEmployee(employee, response);
	}

	@Override
	public Response removeEmployee(String empId) throws Exception {
		return employeeUtil.removeEmployee(empId);
	}

	@Override
	public Employee getEmployeeById(String empId) throws Exception {
		return employeeUtil.getEmployeeById(empId);
	}

}
