package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DBUT.DBUT;
import entity.DeptEmployee;
import entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Integer addEmployee(Employee emp) {
		return DBUT.doUpdate("insert into emp values(null,?,?,?,?,?)", emp.getEmpName(), emp.getGender(),
				emp.getHiredate(), emp.getSalary(), emp.getDept().getDeptId());
	}

	@Override
	public Integer deleteEmployeeNum(Integer empId) {
		return DBUT.doUpdate("delete from emp where emp_id = ?", empId);
	}

	@Override
	public Integer updateEmployee(Employee emp) {
		return DBUT.doUpdate("update emp set emp_name = ?,gender = ?,hiredate=?,salary=?,dept_id=? where emp_id = ?",
				emp.getEmpName(), emp.getGender(), emp.getHiredate(), emp.getSalary(), emp.getDept().getDeptId(),
				emp.getEmpId());
	}

	@Override
	public List<Employee> getEmployeeAll() {
		List<Employee> list = new ArrayList<Employee>();
		Employee emp = null;
		DeptEmployee dept = new DeptEmployee();
		ResultSet rs = DBUT.doQuery("select * from emp");
		try {
			while (rs.next()) {
				Integer empId = rs.getInt("emp_id");
				String empName = rs.getString("emp_name");
				String gender = rs.getString("gender");
				String hiredate = rs.getString("hiredate");
				Float salary = rs.getFloat("salary");
				Integer deptId = rs.getInt("dept_id");
				emp = new Employee(empId, empName, gender, hiredate, salary);
				dept.setDeptId(deptId);
				emp.setDept(dept);
				list.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Employee getEmployeeNum(Integer empId) {
		ResultSet rs = DBUT.doQuery("select * from emp where emp_id = ?", empId);
		Employee emp = null;
		try {
			while (rs.next()) {
				empId = rs.getInt("emp_id");
				String empName = rs.getString("emp_name");
				String gender = rs.getString("gender");
				String hiredate = rs.getString("hiredate");
				Float salary = rs.getFloat("salary");
				Integer deptId = rs.getInt("dept_id");
				emp = new Employee(empId, empName, gender, hiredate, salary);
				DeptEmployee dept = new DeptEmployee();
				dept.setDeptId(deptId);
				emp.setDept(dept);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public Integer EmployeeTote() {
		ResultSet rs = DBUT.doQuery("select count(*) from emp");
		Integer tote = 0;
		try {
			while (rs.next()) {
				tote = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tote;
	}

	@Override
	public List<Employee> EmployeeOrderByAsc(Map<String, String> params) {
		List<Employee> list = new ArrayList<>();
		ResultSet rs = null;
		if (params.get("salary") != null && params.get("hiredate") == null) {
			rs = DBUT.doQuery("select * from emp order by salary asc");
		}
		if (params.get("salary") == null &&  params.get("hiredate") != null) {
			rs = DBUT.doQuery("select * from emp order by hiredate asc");
		}
		if (params.get("salary") != null &&  params.get("hiredate") != null) {
			rs = DBUT.doQuery("select * from emp order by hiredate asc,salary asc");
		}
		try {
			while (rs.next()) {
				Integer empId = rs.getInt("emp_id");
				String empName = rs.getString("emp_name");
				String gender = rs.getString("gender");
				String hiredate = rs.getString("hiredate");
				Float salary = rs.getFloat("salary");
				Integer deptId = rs.getInt("dept_id");
				// 包装成一个对象
				Employee emp = new Employee(empId, empName, gender, hiredate, salary);
				DeptEmployee dept = new DeptEmployee();
				dept.setDeptId(deptId);
				emp.setDept(dept);
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public List<Map<String, Object>> getEmployeeDeptAll1() {
		List<Map<String, Object>> list = new ArrayList<>();
		ResultSet rs = DBUT.doQuery("select A.emp_id,A.emp_name,A.gender,A.hiredate,A.salary,B.dept_id,B.dept_name from emp A  inner join dept B on A.dept_id = B.dept_id");
		try {
			while (rs.next()) {
				Integer empId = rs.getInt("emp_id");
				String empName = rs.getString("emp_name");
				String gender = rs.getString("gender");
				String hiredate = rs.getString("hiredate");
				Float salary = rs.getFloat("salary");
				Integer deptId = rs.getInt("dept_id");
				String deptName = rs.getString("dept_name");
				Map<String, Object> map = new HashMap<>();
				map.put("empId", empId);
				map.put("empName", empName);
				map.put("gender", gender);
				map.put("hiredate", hiredate);
				map.put("salary", salary);
				map.put("deptId", deptId);
				map.put("deptName", deptName);
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Employee> getEmployeeDeptAll2() {
		List<Employee> list = new ArrayList<>();
		Employee employee = null;
		DeptEmployee deptEmployee = null;
		ResultSet rs = DBUT.doQuery("select A.emp_id,A.emp_name,A.gender,A.hiredate,A.salary,B.dept_id,B.dept_name from emp A  inner join dept B on A.dept_id = B.dept_id");
		try {
			while (rs.next()) {
				Integer empId = rs.getInt("emp_id");
				String empName = rs.getString("emp_name");
				String gender = rs.getString("gender");
				String hiredate = rs.getString("hiredate");
				Float salary = rs.getFloat("salary");
				Integer deptId = rs.getInt("dept_id");
				String deptName = rs.getString("dept_name");
				employee = new Employee(empId, empName, gender, hiredate, salary);
				deptEmployee = new DeptEmployee(deptId, deptName);
				employee.setDept(deptEmployee);
				list.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Employee getEmployeeDeptNum(Integer empId) {
		Employee employee = null;
		ResultSet rs = DBUT.doQuery("select A.emp_id,A.emp_name,A.gender,A.hiredate,A.salary,B.dept_id,B.dept_name from emp A  inner join dept B on A.dept_id = B.dept_id Where emp_id = ?",empId);
		try {
			while (rs.next()) {
				empId = rs.getInt("emp_id");
				String empName = rs.getString("emp_name");
				String gender = rs.getString("gender");
				String hiredate = rs.getString("hiredate");
				Float salary = rs.getFloat("salary");
				Integer deptId = rs.getInt("dept_id");
				String deptName = rs.getString("dept_name");
				employee = new Employee(empId, empName, gender, hiredate, salary);
				DeptEmployee  deptEmployee = new DeptEmployee(deptId, deptName);
				employee.setDept(deptEmployee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employee;
	}

	@Override
	public List<Employee> EmployeeOrderBy(Map<String, String> params) {
		List<Employee> list = new ArrayList<>();
		ResultSet rs = null;
		if ("asc".equals(params.get("orderby"))) {
			if (params.get("salary") != null && params.get("hiredate") == null) {
				rs = DBUT.doQuery("select A.emp_id,A.emp_name,A.gender,A.hiredate,A.salary,B.dept_id,B.dept_name from emp A inner join dept B on A.dept_id = B.dept_id order by salary asc");
			}
			if (params.get("salary") == null &&  params.get("hiredate") != null) {
				rs = DBUT.doQuery("select A.emp_id,A.emp_name,A.gender,A.hiredate,A.salary,B.dept_id,B.dept_name from emp A inner join dept B on A.dept_id = B.dept_id order by hiredate asc");
			}
			if (params.get("salary") != null &&  params.get("hiredate") != null) {
				rs = DBUT.doQuery("select A.emp_id,A.emp_name,A.gender,A.hiredate,A.salary,B.dept_id,B.dept_name from emp A inner join dept B on A.dept_id = B.dept_id order by hiredate asc,salary asc");
			}
		}
		if ("desc".equals(params.get("orderby"))) {
			if (params.get("salary") != null && params.get("hiredate") == null) {
				rs = DBUT.doQuery("select A.emp_id,A.emp_name,A.gender,A.hiredate,A.salary,B.dept_id,B.dept_name from emp A inner join dept B on A.dept_id = B.dept_id order by salary desc");
			}
			if (params.get("salary") == null &&  params.get("hiredate") != null) {
				rs = DBUT.doQuery("select A.emp_id,A.emp_name,A.gender,A.hiredate,A.salary,B.dept_id,B.dept_name from emp A inner join dept B on A.dept_id = B.dept_id order by hiredate desc");
			}
			if (params.get("salary") != null &&  params.get("hiredate") != null) {
				rs = DBUT.doQuery("select A.emp_id,A.emp_name,A.gender,A.hiredate,A.salary,B.dept_id,B.dept_name from emp A inner join dept B on A.dept_id = B.dept_id order by hiredate desc,salary desc");
			}
		}
		try {
			while (rs.next()) {
				Integer empId = rs.getInt("emp_id");
				String empName = rs.getString("emp_name");
				String gender = rs.getString("gender");
				String hiredate = rs.getString("hiredate");
				Float salary = rs.getFloat("salary");
				Integer deptId = rs.getInt("dept_id");
				String deptName = rs.getString("dept_name");
				// 包装成一个对象
				Employee emp = new Employee(empId, empName, gender, hiredate, salary);
				DeptEmployee dept = new DeptEmployee(deptId, deptName);
				emp.setDept(dept);
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

}
