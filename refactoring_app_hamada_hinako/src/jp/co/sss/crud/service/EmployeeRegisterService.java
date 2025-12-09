package jp.co.sss.crud.service;

import static jp.co.sss.crud.util.ConstantMsg.*;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;

public class EmployeeRegisterService implements IEmployeeService{

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		EmployeeNameReader empNameReader = new EmployeeNameReader();
		EmployeeGenderReader empGenderReader = new EmployeeGenderReader();
		EmployeeBirthdayReader empBirthdayReader = new EmployeeBirthdayReader();
		EmployeeDeptIdReader empDeptIdReader = new EmployeeDeptIdReader();
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		//登録する値を入力させる（入力チェックエラーの場合、メニュー番号表示に戻る）
		ConsoleWriter.showMessage(EMP_NAME + MSG_INPUT);
		String empName = (String) empNameReader.input();
		
		ConsoleWriter.showMessage(GENDER + MSG_INPUT);
		int gender = (int) empGenderReader.input();
		
		ConsoleWriter.showMessage(BIRTHDAY + MSG_INPUT);
		String birthday = (String) empBirthdayReader.input();
		
		ConsoleWriter.showMessage(DEPT_ID + MSG_INPUT);
		int deptId = (int) empDeptIdReader.input();
		
		//EmployeeDtoにセットしてEmployeeDAOに渡す
		Employee employee = new Employee();
		Department department = new Department();
		employee.setEmpName(empName);
		employee.setGender(gender);
		employee.setBirthday(birthday);
		department.setDeptId(deptId);
		employee.setDepartment(department);
		
		employeeDAO.insert(employee);
		
		ConsoleWriter.showMessage(EMP_INFO + MSG_INSERT_COMPLETE);
	}

}
