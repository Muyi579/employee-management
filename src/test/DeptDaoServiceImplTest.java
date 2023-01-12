package test;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

import entity.DeptEmployee;
import entity.Employee;
import service.DeptServiceImpl;

public class DeptDaoServiceImplTest {
	Scanner Scanner = new Scanner(System.in);
	DeptServiceImpl deptservice = new DeptServiceImpl();
	DeptEmployee dept = null;

	/**
	 * 添加部门
	 */
	@Test
	public void addDept() {
		System.out.println("请输入你要添加的部门名");
		String deptName = Scanner.next();
		dept = new DeptEmployee();
		dept.setDeptName(deptName);
		boolean cur = deptservice.addDept(dept);
		System.out.println(cur == true ? "添加成功" : "添加失败");
	}

	/**
	 * @return 删除部门
	 */
	@Test
	public void deleteDept() {
		System.out.println("请输入你要删除的部门编号");
		Integer deptId = Scanner.nextInt();
		List<DeptEmployee> dept2 = deptservice.getDept();
		for (DeptEmployee deptEmployee : dept2) {
			if (deptEmployee.getDeptId() == deptId) {
				boolean cur = deptservice.deleteDept(deptId);
				System.out.println(cur == true ? "删除成功" : "删除失败");
			}
		}

	}

	/**
	 * 修改部门
	 */
	@Test
	public void updateDept() {
		System.out.println("请输入你要修改的部门编号");
		Integer deptId = Scanner.nextInt();
		List<DeptEmployee> dept2 = deptservice.getDept();
		for (DeptEmployee deptEmployee : dept2) {
			if (deptEmployee.getDeptId() == deptId) {
				System.out.println("请输入要修改的部门名");
				String deptName = Scanner.next();
				dept = new DeptEmployee(deptId, deptName);
				boolean cur = deptservice.updateDept(dept);
				System.out.println(cur == true ? "修改成功" : "修改失败");
			}
		}

	}

	/**
	 * 查询部门
	 */
	@Test
	public void getDept() {
		List<DeptEmployee> list = deptservice.getDept();
		System.out.println("部门编号\t部门名");
		for (DeptEmployee deptEmployee : list) {
			System.out.println(deptEmployee.getDeptId() + "\t" + deptEmployee.getDeptName());
		}
	}

	/**
	 * 查询单个部门下所有员工map
	 */
	@Test
	public void getDeptEmployeeNum1() {
		System.out.println("请输入要查询的部门名");
		String deptName = Scanner.next();
		List<Map<String, Object>> deptEmployee = deptservice.getDeptEmployeeNum1(deptName);
		System.out.println("员工编号\t员工姓名\t性别\t入职日期\t\t工资\t部门\t部门名");
		for (Map<String, Object> map : deptEmployee) {
			System.out.print(map.get("empId") + "\t");
			System.out.print(map.get("empName") + "\t");
			System.out.print(map.get("gender") + "\t");
			System.out.print(map.get("hiredate") + "\t");
			System.out.print(map.get("salary") + "\t");
			System.out.print(map.get("deptId") + "\t");
			System.out.print(map.get("deptName") + "\t");
			System.out.println();
		}
	}

	/**
	 * 查询单个部门下所有员工
	 */
	@Test
	public void getDeptEmployeeNum2() {
		System.out.println("请输入要查询的部门名");
		String deptName = Scanner.next();
		DeptEmployee deptEmployee = deptservice.getDeptEmployeeNum2(deptName);
		System.out.println("部门编号\t部门名");
		System.out.println(deptEmployee.getDeptId() + "\t" + deptEmployee.getDeptName());
		System.out.println("======================");
		System.out.println("员工编号\t员工姓名\t性别\t入职日期\t\t工资");
		List<Employee> emp = deptEmployee.getEmp();
		for (Employee employee : emp) {
			System.out.println(employee.getEmpId() + "\t" + employee.getEmpName() + "\t" + employee.getGender() + "\t"
					+ employee.getHiredate() + "\t" + employee.getSalary());
		}

	}

	/**
	 * 查询所有部门跟部门下员工
	 */
	@Test
	public void getDeptEmployeeAll() {
		Map<Integer, DeptEmployee> dept = deptservice.getDeptEmployee();
		for (Integer i : dept.keySet()) {
			DeptEmployee deptEmployee = dept.get(i);
			System.out.println("部门编号\t部门名");
			System.out.println(deptEmployee.getDeptId() + "\t" + deptEmployee.getDeptName());
			System.out.println("======================");
			System.out.println("员工编号\t员工姓名\t性别\t入职日期\t\t工资");
			List<Employee> emp = deptEmployee.getEmp();
			for (Employee employee : emp) {
				System.out.println(employee.getEmpId() + "\t" + employee.getEmpName() + "\t" + employee.getGender()
						+ "\t" + employee.getHiredate() + "\t" + employee.getSalary());
			}
			System.out.println("-------------");
		}
	}

}
