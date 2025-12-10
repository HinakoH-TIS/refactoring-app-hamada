package jp.co.sss.crud.service;

import static jp.co.sss.crud.util.ConstantMsg.*;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;

/**
 * 部署ID検索用サービスクラス
 */
public class EmployeeFindByDeptIdService implements IEmployeeService{

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		EmployeeDeptIdReader empDeptIdReader = new EmployeeDeptIdReader();
		EmployeeDAO employeeDAO = new EmployeeDAO();

		//検索する部署IDを取得
		ConsoleWriter.showMessage(DEPT_ID + MSG_INPUT);
		int deptId =  (int) empDeptIdReader.input();

		//検索を実行して結果を出力させる
		List<Employee> employees = employeeDAO.findByDeptId(deptId);
		ConsoleWriter.showEmployees(employees);
		
	}

}
