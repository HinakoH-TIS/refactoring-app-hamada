package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

/**
 * 全件検索用サービスクラス
 */
public class EmployeeAllFindService implements IEmployeeService{
	
	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
	
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		//検索を実行して結果を出力させる
		List<Employee> employees = employeeDAO.findAll();
		ConsoleWriter.showEmployees(employees);
	}

}
