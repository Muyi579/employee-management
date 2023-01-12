package entity;

/**
 * @author 员工实体类
 *
 */
public class Employee {

	private Integer empId; // 员工编号
	private String empName; // 员工姓名
	private String gender; // 员工性别
	private String hiredate; // 入职日期
	private Float salary; // 工资
	private DeptEmployee dept; // 关联部门

	// 无参构造
	public Employee() {
		super();
	}

	// 有参构造
	public Employee(Integer empId, String empName, String gender, String hiredate, Float salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.hiredate = hiredate;
		this.salary = salary;
	}

	// set/get
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public DeptEmployee getDept() {
		return dept;
	}

	public void setDept(DeptEmployee dept) {
		this.dept = dept;
	}

	// 重写tostring
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", gender=" + gender + ", hiredate=" + hiredate
				+ ", salary=" + salary + ", dept=" + dept + "]";
	}

}
