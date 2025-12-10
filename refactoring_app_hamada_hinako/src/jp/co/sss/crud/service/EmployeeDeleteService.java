package jp.co.sss.crud.service;

import static jp.co.sss.crud.util.ConstantMsg.*;
import static jp.co.sss.crud.util.ConstantValue.*;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeEmpIdReader;

public class EmployeeDeleteService implements IEmployeeService{

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeEmpIdReader empIdReader = new EmployeeEmpIdReader();
		
		ConsoleWriter.showMessage(EMP_ID_DELETE + MSG_INPUT);
		int empId = (int) empIdReader.input();
		List<Employee> employees = employeeDAO.findByEmpId(empId);

		if (employees.isEmpty()) {
			ConsoleWriter.showMessageLine(MSG_NO_TARGET);
			return;
		}
		
		Integer result = employeeDAO.delete(empId);
		
		if(result.equals(SUCCESS)) {
			ConsoleWriter.showMessageLine(EMP_INFO + MSG_DELETE_COMPLETE);
		}
		
	}

}
