package jp.co.sss.crud.service;

import static jp.co.sss.crud.util.ConstantMsg.*;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeNameReader;

public class EmployeeFindByEmpNameService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		EmployeeNameReader empNameReader = new EmployeeNameReader();
		EmployeeDAO employeeDAO = new EmployeeDAO();

		ConsoleWriter.showInputMessage(EMP_NAME + MSG_INPUT);
		String empName = (String) empNameReader.input();

		List<Employee> employees = employeeDAO.findByEmployeeName(empName);
		ConsoleWriter.showEmployees(employees);
	}

}
