package ui;

import java.util.Scanner;

public class UI {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		EmployeeUi emp = new EmployeeUi();
		DeptUi  dept = new DeptUi();
		while (true) {
			System.out.println("请选择系统 1：员工管理系统  2： 部门管理系统 0 :退出系统");
			Integer key = scanner.nextInt();
			switch (key) {
			case 1:
				emp.Employee();
				break;
			case 2:
				dept.Dept();
				break;
			case 0:
				System.exit(0);
			default:
				break;
			}
		}
	}
}
