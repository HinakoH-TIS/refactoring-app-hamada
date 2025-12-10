package jp.co.sss.crud.service;

import static jp.co.sss.crud.util.ConstantMsg.*;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeNameReader;

/**
 * 社員名検索用サービスクラス
 */
public class EmployeeFindByEmpNameService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		EmployeeNameReader empNameReader = new EmployeeNameReader();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		//検索する社員名を取得
		ConsoleWriter.showMessage(EMP_NAME + MSG_INPUT);
		String empName = (String) empNameReader.input();

		//検索を実行して結果を出力させる
		List<Employee> employees = employeeDAO.findByEmployeeName(empName);
		ConsoleWriter.showEmployees(employees);
	}

}
