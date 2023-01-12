package service;

import java.util.List;
import java.util.Map;

import entity.Employee;

/**
 * @author 员工业务接口
 *
 */
public interface EmployeeService {

	/**
	 * @author 添加员工
	 * @return boolean是否添加成功
	 */
	boolean addEmployee(Employee emp);

	/**
	 * @author 删除员工
	 * @return boolean是否删除成功
	 */
	boolean deleteEmployeeNum(Integer empId);

	/**
	 * @author 修改员工
	 * @return boolean是否修改成功
	 */
	boolean updateEmployee(Employee emp);

	/**
	 * @author 获取所有员工
	 * @return 员工集合
	 */
	List<Employee> getEmployeeAll();

	/**
	 * @author 根据工号查询员工信息
	 * @return 返回员工信息
	 */
	Employee getEmployeeNum(Integer empId);

	/**
	 * @author 获取员工个数
	 * @return int类型，员工个数
	 */
	Integer EmployeeTote();

	/**
	 * @author 根据员工列表数据升序 多情况升序显示员工列表(根据入职时间,工资,入职时间+工资升序3种情况）使用map作为参数
	 * @return 员工排序集合
	 */
	List<Employee> EmployeeOrderByAsc(String orderby);

	/**
	 * @author 获取所有员工信息列表1 获取所有员工详情列表(员工信息+所在部门信息) 使用map存储数据
	 * @return list集合map参数
	 */
	List<Map<String, Object>> getEmployeeDeptAll1();

	/**
	 * @author 获取所有员工信息列表2 获取所有员工详情列表(员工信息+所在部门信息) 使用实体类存储数据
	 * @return list集合
	 */
	List<Employee> getEmployeeDeptAll2();

	/**
	 * @author 根据工号获取员工信息 通过员工工号获取单个员工详情列表(员工信息+所在部门信息)
	 * @return 返回员工信息
	 */
	Employee getEmployeeDeptNum(Integer empId);

	/**
	 * @author 根据员工列表中数据排序 多情况排序显示员工详情列表(员工信息+所在部门信息) (根据入职时间,工资,入职时间+工资3种情况 升序/降序
	 * @return list集合排序方式
	 */
	List<Employee> EmployeeOrderBy(Map<String, String> params);
}

