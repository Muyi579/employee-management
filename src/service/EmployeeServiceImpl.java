package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.EmployeeDaoImpl;
import entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	static Scanner scanner = new Scanner(System.in);
	EmployeeDaoImpl empdaoimpl = new EmployeeDaoImpl();
	Integer cur = 0;

	@Override
	public boolean addEmployee(Employee emp) {
		cur = empdaoimpl.addEmployee(emp);
		return cur > 0 ? true : false;
	}

	@Override
	public boolean deleteEmployeeNum(Integer empId) {
		cur = empdaoimpl.deleteEmployeeNum(empId);
		return cur > 0 ? true : false;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		cur = empdaoimpl.updateEmployee(emp);
		return cur > 0 ? true : false;
	}

	@Override
	public List<Employee> getEmployeeAll() {

		return empdaoimpl.getEmployeeAll();
	}

	@Override
	public Employee getEmployeeNum(Integer empId) {
		return empdaoimpl.getEmployeeNum(empId);
	}

	@Override
	public Integer EmployeeTote() {

		return empdaoimpl.EmployeeTote();
	}

	@Override
	public List<Employee> EmployeeOrderByAsc(String orderby) {
		List<Employee> list = new ArrayList<Employee>();
		Map<String, String> params = new HashMap<String, String>();
		if (orderby.equals("工资")) {
			params.put("salary", "salary");
			params.put("hiredate", null);
			list = empdaoimpl.EmployeeOrderByAsc(params);
		} else if (orderby.equals("入职日期")) {
			params.put("salary", null);
			params.put("hiredate", "hiredate");
			list = empdaoimpl.EmployeeOrderByAsc(params);
		} else if (orderby.equals("工资加入职日期")) {
			params.put("salary", "salary");
			params.put("hiredate", "hiredate");
			list = empdaoimpl.EmployeeOrderByAsc(params);
		}

		return list;
	}

	@Override
	public List<Map<String, Object>> getEmployeeDeptAll1() {
		return empdaoimpl.getEmployeeDeptAll1();
	}

	@Override
	public List<Employee> getEmployeeDeptAll2() {
		return empdaoimpl.getEmployeeDeptAll2();
	}

	@Override
	public Employee getEmployeeDeptNum(Integer empId) {
		return empdaoimpl.getEmployeeNum(empId);
	}

	@Override
	public List<Employee> EmployeeOrderBy(Map<String, String> params) {
		
		return empdaoimpl.EmployeeOrderBy(params);
	}

}
