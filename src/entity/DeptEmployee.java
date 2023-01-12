package entity;

import java.util.List;

/**
 * @author 部门实体类
 *
 */
public class DeptEmployee {
	private Integer deptId; // 部门编号
	private String deptName; // 部门名称
	private List<Employee> emp;// 关联员工

	//无参
	public DeptEmployee() {
		super();
	}

	//有参
	public DeptEmployee(Integer deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}

	//set/get
	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmp() {
		return emp;
	}

	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}

	//重写tostring
	@Override
	public String toString() {
		return "DeptEmployee [deptId=" + deptId + ", deptName=" + deptName + ", emp=" + emp + "]";
	}
	
}
