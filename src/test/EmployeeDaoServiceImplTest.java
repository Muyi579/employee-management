package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

import entity.DeptEmployee;
import entity.Employee;
import service.EmployeeServiceImpl;

public class EmployeeDaoServiceImplTest {
	Scanner scanner = new Scanner(System.in);
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
	boolean cur = false;

	/**
	 * @author 添加员工
	 * 
	 */
	@Test
	public void addEmployee() {
		Employee emp = null;
		DeptEmployee deptEmployee = new DeptEmployee();
		System.out.println("添加员工");
		System.out.println("请输入员工姓名");
		String empName = scanner.next();
		System.out.println("请输入员工性别");
		String gender = scanner.next();
		System.out.println("入职日期");
		String hiredate = scanner.next();
		System.out.println("工资");
		Float salary = scanner.nextFloat();
		System.out.println("员工部门编号");
		Integer deptId = scanner.nextInt();
		emp = new Employee(null, empName, gender, hiredate, salary);
		deptEmployee.setDeptId(deptId);
		emp.setDept(deptEmployee);
		cur = employeeService.addEmployee(emp);
		System.out.println(cur == true ? "添加成功" : "添加失败");
	}

	/**
	 * @author 删除员工
	 */
	@Test
	public void deleteEmployee() {
		System.out.println("请输入你要删除的员工编号");
		Integer empId = scanner.nextInt();
		List<Employee> employeeAll = employeeService.getEmployeeAll();
		for (Employee employee : employeeAll) {
			if (employee.getEmpId() == empId) {
				cur = employeeService.deleteEmployeeNum(empId);
				System.out.println(cur == true ? "删除成功" : "删除失败");
			}
		}

	}

	/**
	 * 修改员工
	 */
	@Test
	public void updateEmployee() {
		Employee emp = null;
		DeptEmployee deptEmployee = new DeptEmployee();
		System.out.println("请输入你要修改的员工编号");
		Integer empId = scanner.nextInt();
		List<Employee> employeeAll = employeeService.getEmployeeAll();
		for (Employee employee : employeeAll) {
			if (employee.getEmpId() == empId) {
				System.out.println("请输入要修改的员工姓名");
				String empName = scanner.next();
				System.out.println("请输入修改的员工性别");
				String gender = scanner.next();
				System.out.println("入职日期");
				String hiredate = scanner.next();
				System.out.println("工资");
				Float salary = scanner.nextFloat();
				System.out.println("员工部门编号");
				Integer deptId = scanner.nextInt();
				emp = new Employee(empId, empName, gender, hiredate, salary);
				deptEmployee.setDeptId(deptId);
				emp.setDept(deptEmployee);
				cur = employeeService.updateEmployee(emp);
				System.out.println(cur == true ? "修改成功" : "修改失败");
			}
		}

	}

	/**
	 * @return 查询所有员工
	 */
	@Test
	public void getEmployeeAll() {
		System.out.println("查询所有员工");
		System.out.println("员工编号\t员工姓名\t性别\t入职日期\t\t工资\t部门");
		List<Employee> list = employeeService.getEmployeeAll();
		for (Employee employee : list) {
			System.out.println(employee.getEmpId() + "\t" + employee.getEmpName() + "\t" + employee.getGender() + "\t"
					+ employee.getHiredate() + "\t" + employee.getSalary() + "\t" + employee.getDept().getDeptId());

		}
	}

	/**
	 * @return 根据员工编号查询员工
	 */
	@Test
	public void getEmployeeNum() {
		System.out.println("请输入要查询的员工编号");
		Integer empId = scanner.nextInt();
		Employee emp = employeeService.getEmployeeNum(empId);
		System.out.println("员工编号\t员工姓名\t性别\t入职日期\t\t工资\t部门");
		System.out.println(emp.getEmpId() + "\t" + emp.getEmpName() + "\t" + emp.getGender() + "\t" + emp.getHiredate()
				+ "\t" + emp.getSalary() + "\t" + emp.getDept().getDeptId());
	}

	/**
	 * @return 获取员工个数
	 */
	@Test
	public void getEmployeeTote() {
		Integer n = employeeService.EmployeeTote();
		System.out.println("共有员工：" + n + "个");
	}

	/**
	 * 调用业务层方法
	 * 
	 * @return 根据员工列表数据升序 多情况升序显示员工列表(根据入职时间,工资,入职时间+工资升序3种情况）使用map作为参数
	 */
	@Test
	public void EmployeeOrderbyAsc() {
		System.out.println("请输入需要什么排序：工资 / 入职日期 / 工资加入职日期");
		String orderby = scanner.next();
		List<Employee> list = employeeService.EmployeeOrderByAsc(orderby);
		System.out.println("员工编号\t员工姓名\t性别\t入职日期\t\t工资\t部门");
		for (Employee employee : list) {
			System.out.println(employee.getEmpId() + "\t" + employee.getEmpName() + "\t" + employee.getGender() + "\t"
					+ employee.getHiredate() + "\t" + employee.getSalary() + "\t" + employee.getDept().getDeptId());
		}
	}

	/**
	 * @return 返回所有员工信息加部门信息集合map
	 */
	@Test
	public void getEmployeeDeptAll1() {
		List<Map<String, Object>> list = employeeService.getEmployeeDeptAll1();
		System.out.println("员工编号\t员工姓名\t性别\t入职日期\t\t工资\t部门\t部门名");
		for (Map<String, Object> map : list) {
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
	 * @return 返回员工信息加部门信息集合list
	 */
	@Test
	public void getEmployeeDeptAll2() {
		List<Employee> list = employeeService.getEmployeeDeptAll2();
		System.out.println("员工编号\t员工姓名\t性别\t入职日期\t\t工资\t部门\t部门名");
		for (Employee employee : list) {
			System.out.println(employee.getEmpId() + "\t" + employee.getEmpName() + "\t" + employee.getGender() + "\t"
					+ employee.getHiredate() + "\t" + employee.getSalary() + "\t" + employee.getDept().getDeptId()
					+ "\t" + employee.getDept().getDeptName());
		}
	}

	/**
	 * @return 返回员工信息
	 */
	@Test
	public void getEmployeeDeptNum() {
		System.out.println("请输入要查询的员工编号");
		Integer empId = scanner.nextInt();
		Employee emp = employeeService.getEmployeeDeptNum(empId);
		System.out.println("员工编号\t员工姓名\t性别\t入职日期\t\t工资\t部门\t部门名");
		System.out.println(emp.getEmpId() + "\t" + emp.getEmpName() + "\t" + emp.getGender() + "\t" + emp.getHiredate()
				+ "\t" + emp.getSalary() + "\t" + emp.getDept().getDeptId() + "\t" + emp.getDept().getDeptName());
	}

	/**
	 * @return 返回排序方式
	 */
	@Test
	public void EmployeeOrderBy() {
		System.out.println("请输入需要什么排序:升序/降序");
		String orderby = scanner.next();
		List<Employee> list = new ArrayList<Employee>(); 
		Map<String, String> params = null;
		if (orderby.equals("升序")) {
			System.out.println("升序按照：工资 / 入职日期 / 工资加入职日期");
			String asc = scanner.next();
			if (asc.equals("工资")) {
				params = new HashMap<String, String>();
				params.put("orderby", "asc");
				params.put("salary", "salary");
				params.put("hiredate", null);
				list = employeeService.EmployeeOrderBy(params);
			} else if (asc.equals("入职日期")) {
				params = new HashMap<String, String>();
				params.put("orderby", "asc");
				params.put("salary", null);
				params.put("hiredate", "hiredate");
				list = employeeService.EmployeeOrderBy(params);
			} else if (asc.equals("工资加入职日期")) {
				params = new HashMap<String, String>();
				params.put("orderby", "asc");
				params.put("salary", "salary");
				params.put("hiredate", "hiredate");
				list = employeeService.EmployeeOrderBy(params);
			}
		}
		if (orderby.equals("降序")) {
			System.out.println("降序按照：工资 / 入职日期 / 工资加入职日期");
			String desc = scanner.next();
			if (desc.equals("工资")) {
				params = new HashMap<String, String>();
				params.put("orderby", "desc");
				params.put("salary", "salary");
				params.put("hiredate", null);
				list = employeeService.EmployeeOrderBy(params);
			} else if (desc.equals("入职日期")) {
				params = new HashMap<String, String>();
				params.put("orderby", "desc");
				params.put("salary", null);
				params.put("hiredate", "hiredate");
				list = employeeService.EmployeeOrderBy(params);
			} else if (desc.equals("工资加入职日期")) {
				params = new HashMap<String, String>();
				params.put("orderby", "desc");
				params.put("salary", "salary");
				params.put("hiredate", "hiredate");
				list = employeeService.EmployeeOrderBy(params);
			}
		}
		 list = employeeService.EmployeeOrderBy(params);
		System.out.println("员工编号\t员工姓名\t性别\t入职日期\t\t工资\t部门\t部门名");
		for (Employee employee : list) {
			System.out.println(employee.getEmpId() + "\t" + employee.getEmpName() + "\t" + employee.getGender() + "\t"
					+ employee.getHiredate() + "\t" + employee.getSalary() + "\t" + employee.getDept().getDeptId() + "\t" +employee.getDept().getDeptName());
		}
	}
}
