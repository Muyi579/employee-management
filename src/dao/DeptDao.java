package dao;

import java.util.List;
import java.util.Map;

import entity.DeptEmployee;

/**
 * @author 部门dao层接口操作数据库
 *
 */
public interface DeptDao {
	/**
	 * 
	 * @param 添加部门
	 * @return 是否添加成
	 */
	Integer addDept(DeptEmployee dept);

	/**
	 * 
	 * @param deptId
	 *            根据部门编号删除部门
	 * @return 是否删除成功
	 */
	Integer deleteDept(Integer deptId);

	/**
	 * 
	 * @param dept修改部门
	 * @return 是否修改成功
	 */
	Integer updateDept(DeptEmployee dept);

	/**
	 * 获取全部部门列表
	 * 
	 * @return 部门列表集合
	 */
	List<DeptEmployee> getDept();

	/**
	 * 
	 * @param deptName
	 *            根据部门名查询部门里详细信息加员工信息
	 * @return 信息集合map
	 */
	List<Map<String, Object>> getDeptEmployeeNum1(String deptName);

	/**
	 * 
	 * @param deptName
	 *            根据部门名查询部门里详细信息加员工信息
	 * @return 部门信息
	 */
	DeptEmployee getDeptEmployeeNum2(String deptName);

	/**
	 * 获取全部部门信息加员工信息
	 * 
	 * @return 部门信息集合
	 */
	Map<Integer, DeptEmployee> getDeptEmployee();

}
