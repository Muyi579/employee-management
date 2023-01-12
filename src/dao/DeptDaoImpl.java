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

public class DeptDaoImpl implements DeptDao{

	@Override
	public Integer addDept(DeptEmployee dept) {
		return DBUT.doUpdate("insert into dept values(null,?)", dept.getDeptName());
	}

	@Override
	public Integer deleteDept(Integer deptId) {
		return DBUT.doUpdate("delete from dept where dept_id = ?",deptId);
	}

	@Override
	public Integer updateDept(DeptEmployee dept) {
		return DBUT.doUpdate("update dept set dept_name = ? where dept_id = ?", dept.getDeptName(),dept.getDeptId());
	}

	@Override
	public List<DeptEmployee> getDept() {
		List<DeptEmployee> list = new ArrayList<DeptEmployee>();
		DeptEmployee deptEmployee = null;
		ResultSet rs = DBUT.doQuery("select * from dept");
		try {
			while (rs.next()) {
				Integer deptId = rs.getInt("dept_id");
				String deptName = rs.getString("dept_name");
				deptEmployee = new DeptEmployee(deptId, deptName);
				list.add(deptEmployee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getDeptEmployeeNum1(String deptName) {
		List<Map<String, Object>> list = new ArrayList<>();
		ResultSet rs = DBUT.doQuery("select A.emp_id,A.emp_name,A.gender,A.hiredate,A.salary,B.dept_id,B.dept_name from emp A  inner join dept B on A.dept_id = B.dept_id where dept_name = ?",deptName);
		try {
			while (rs.next()) {
				Integer empId = rs.getInt("emp_id");
				String empName = rs.getString("emp_name");
				String gender = rs.getString("gender");
				String hiredate = rs.getString("hiredate");
				Float salary = rs.getFloat("salary");
				Integer deptId = rs.getInt("dept_id");
				deptName = rs.getString("dept_name");
				Map<String, Object> map = new HashMap<String, Object>();
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
	public DeptEmployee getDeptEmployeeNum2(String deptName) {
		ResultSet rs = DBUT.doQuery("select A.emp_id,A.emp_name,A.gender,A.hiredate,A.salary,B.dept_id,B.dept_name from emp A  inner join dept B on A.dept_id = B.dept_id where dept_name = ?",deptName);
		DeptEmployee deptEmployee = null;
		List<Employee> list = new ArrayList<>();
		try {
			while (rs.next()) {
				Integer empId = rs.getInt("emp_id");
				String empName = rs.getString("emp_name");
				String gender = rs.getString("gender");
				String hiredate = rs.getString("hiredate");
				Float salary = rs.getFloat("salary");
				Integer deptId = rs.getInt("dept_id");
				deptName = rs.getString("dept_name");
				deptEmployee = new DeptEmployee(deptId, deptName);
				Employee emp = new Employee(empId, empName, gender, hiredate, salary);
				list.add(emp);
				deptEmployee.setEmp(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deptEmployee;
	}

	@Override
	public Map<Integer, DeptEmployee> getDeptEmployee() {
		Map<Integer, DeptEmployee> map = new HashMap<>();
		List<DeptEmployee> dept = getDept();
		for (DeptEmployee deptEmployee2 : dept) {
			DeptEmployee deptEmployeeNum2 = getDeptEmployeeNum2(deptEmployee2.getDeptName());
			map.put(deptEmployee2.getDeptId(), deptEmployeeNum2);
		}
		return map;
	}

}
