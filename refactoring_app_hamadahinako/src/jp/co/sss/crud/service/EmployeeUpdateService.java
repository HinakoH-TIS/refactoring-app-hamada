package jp.co.sss.crud.service;

import static jp.co.sss.crud.util.ConstantMsg.*;
import static jp.co.sss.crud.util.ConstantValue.*;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.mapper.EmployeeMapper;

public class EmployeeUpdateService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		EmployeeEmpIdReader empIdReader = new EmployeeEmpIdReader();
		EmployeeNameReader empNameReader = new EmployeeNameReader();
		EmployeeGenderReader empGenderReader = new EmployeeGenderReader();
		EmployeeBirthdayReader empBirthdayReader = new EmployeeBirthdayReader();
		EmployeeDeptIdReader empDeptIdReader = new EmployeeDeptIdReader();

		EmployeeDAO employeeDAO = new EmployeeDAO();

		//更新する社員IDを取得
		ConsoleWriter.showMessage(EMP_ID_UPDATE + MSG_INPUT);
		int empId = (int) empIdReader.input();
		List<Employee> employees = employeeDAO.findByEmpId(empId);

		if (employees.isEmpty()) {
			ConsoleWriter.showMessageLine(MSG_NO_TARGET);
			return;
		}

		ConsoleWriter.showMessage(EMP_NAME + ":");
		String empName = (String) empNameReader.input();
		
		ConsoleWriter.showMessage(GENDER + ":");
		int gender = (int) empGenderReader.input();
		
		ConsoleWriter.showMessage(BIRTHDAY + ":");
		String birthday = (String) empBirthdayReader.input();
		
		ConsoleWriter.showMessage(DEPT_ID + ":");
		int deptId = (int) empDeptIdReader.input();
		
		//EmployeeDTOに値をセット
		Employee employee = EmployeeMapper.setValuesToEmployee(empName, gender, birthday, deptId);
		employee.setEmpId(empId);
		
		Integer result = employeeDAO.update(employee);
		
		if (result.equals(SUCCESS)) {
			ConsoleWriter.showMessageLine(EMP_INFO + MSG_UPDATE_COMPLETE);
		}
	}

}
