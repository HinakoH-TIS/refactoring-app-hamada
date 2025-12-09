package jp.co.sss.crud.service;

import static jp.co.sss.crud.util.ConstantMsg.*;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;

public class EmployeeFindByDeptIdService implements IEmployeeService{

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		EmployeeDeptIdReader empDeptIdReader = new EmployeeDeptIdReader();
		EmployeeDAO employeeDAO = new EmployeeDAO();

		ConsoleWriter.showInputMessage(DEPT_ID + MSG_INPUT);
		int deptId =  (int) empDeptIdReader.input();

		List<Employee> employees = employeeDAO.findByDeptId(deptId);
		ConsoleWriter.showEmployees(employees);
		
	}

}
