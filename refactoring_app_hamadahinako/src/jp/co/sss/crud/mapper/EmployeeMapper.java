package jp.co.sss.crud.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;


/**
 * EmployeeDTOに値をセットするクラス
 */
public class EmployeeMapper {
	
	/**
	 * 検索結果をEmployeeDTOの配列にセットする
	 * 
	 * @param resultSet 検索結果
	 * @return	検索結果がセットされたEmployeeDTO配列
	 * @throws SQLException
	 */
	public static List<Employee> setValuesToEmployeeList(ResultSet resultSet) throws SQLException {
		List<Employee> employees = new ArrayList<Employee>();
		while (resultSet.next()) {
			Employee employee = new Employee();
			Department department = new Department();
			employee.setEmpId(resultSet.getInt("emp_id"));
			employee.setEmpName(resultSet.getString("emp_name"));
			employee.setGender(resultSet.getInt("gender"));
			employee.setBirthday(resultSet.getString("birthday"));
			department.setDeptName(resultSet.getString("dept_name"));
			employee.setDepartment(department);
			employees.add(employee);
		}
		
		return employees;
	}
	
	/**
	 * 社員ID以外の値をEmployeeDTOにセットする
	 * 
	 * @param empName 社員名
	 * @param gender 性別
	 * @param birthday 生年月日
	 * @param deptId 部署ID
	 * @return 社員ID以外の値を持つEmployeeDTO
	 */
	public static Employee setValuesToEmployee(String empName, int gender, String birthday, int deptId) {
		Employee employee = new Employee();
		Department department = new Department();
		employee.setEmpName(empName);
		employee.setGender(gender);
		employee.setBirthday(birthday);
		department.setDeptId(deptId);
		employee.setDepartment(department);
		
		return employee;
	}
	
}
