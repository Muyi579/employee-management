package ui;

import java.util.Scanner;

import test.EmployeeDaoServiceImplTest;

public class EmployeeUi {
	Scanner scanner = new Scanner(System.in);

	/**
	 * @return 员工ui菜单
	 */
	public void Employee() {

		while (true) {
			System.out.println(
					"请选择你需要的功能 : ①：添加员工 ②：删除员工 ③：修改员工 ④：获取员工列表 ⑤：按照员工工号获取员工信息 ⑥：获取员工总数 ⑦：多情况升序 ⑧：获取员工详细信息+部门信息 ⑨：通过员工编号获取详细信息 ⑩：多情况排序 0：退出当前页面");
			Integer key = scanner.nextInt();
			EmployeeDaoServiceImplTest ui = new EmployeeDaoServiceImplTest();
			switch (key) {
			case 1:
				ui.addEmployee();
				break;
			case 2:
				ui.deleteEmployee();
				break;
			case 3:
				ui.updateEmployee();
				break;
			case 4:
				ui.getEmployeeAll();
				break;
			case 5:
				ui.getEmployeeNum();
				break;
			case 6:
				ui.getEmployeeTote();
				break;
			case 7:
				ui.EmployeeOrderbyAsc();
				break;
			case 8:
				ui.getEmployeeDeptAll2();
				break;
			case 9:
				ui.getEmployeeDeptNum();
				break;
			case 10:
				ui.EmployeeOrderBy();
				break;
			case 0:
				return;
			default:
				break;
			}
		}
	}
}
