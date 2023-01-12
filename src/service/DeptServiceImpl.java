package service;

import java.util.List;
import java.util.Map;

import dao.DeptDaoImpl;
import entity.DeptEmployee;

public class DeptServiceImpl implements DeptService{

	DeptDaoImpl deptdaoimpl = new DeptDaoImpl();
	@Override
	public boolean addDept(DeptEmployee dept) {
		Integer cur = deptdaoimpl.addDept(dept);
		return cur > 0 ? true : false;
	}

	@Override
	public boolean deleteDept(Integer deptId) {
		Integer cur = deptdaoimpl.deleteDept(deptId);
		return cur > 0 ? true : false;
	}

	@Override
	public boolean updateDept(DeptEmployee dept) {
		Integer cur = deptdaoimpl.updateDept(dept);
		return cur > 0 ? true : false;
	}

	@Override
	public List<DeptEmployee> getDept() {
		return deptdaoimpl.getDept();
	}

	@Override
	public List<Map<String, Object>> getDeptEmployeeNum1(String deptName) {
		return deptdaoimpl.getDeptEmployeeNum1(deptName);
	}

	@Override
	public DeptEmployee getDeptEmployeeNum2(String deptName) {
		return deptdaoimpl.getDeptEmployeeNum2(deptName);
	}

	@Override
	public Map<Integer, DeptEmployee> getDeptEmployee() {
		return deptdaoimpl.getDeptEmployee();
	}

}
