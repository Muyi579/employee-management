package ui;

import java.util.Scanner;

import test.DeptDaoServiceImplTest;

public class DeptUi {
	Scanner scanner = new Scanner(System.in);

	/**
	 * @return 部门ui菜单
	 */
	public void Dept() {

		while (true) {
			System.out.println("请选择你需要的功能 : ①：添加部门 ②：删除部门 ③：修改部门 ④：获取部门列表 ⑤：根据指定部门获取详细信息 ⑥：获取每一个部门详细信息加员工信息 0：退出当前页面");
			Integer key = scanner.nextInt();
			DeptDaoServiceImplTest ui = new DeptDaoServiceImplTest();
			switch (key) {
			case 1:
				ui.addDept();
				break;
			case 2:
				ui.deleteDept();
				break;
			case 3:
				ui.updateDept();
				break;
			case 4:
				ui.getDept();
				break;
			case 5:
				ui.getDeptEmployeeNum2();
				break;
			case 6:
				ui.getDeptEmployeeAll();
				break;
			case 0:
				return;
			default:
				break;
			}
		}
	}
}
