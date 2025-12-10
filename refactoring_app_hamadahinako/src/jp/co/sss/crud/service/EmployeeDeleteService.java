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

/**
 * 社員削除用サービスクラス
 */
public class EmployeeDeleteService implements IEmployeeService{

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeEmpIdReader empIdReader = new EmployeeEmpIdReader();
		
		//対象者を確認
		ConsoleWriter.showMessage(EMP_ID_DELETE + MSG_INPUT);
		int empId = (int) empIdReader.input();
		List<Employee> employees = employeeDAO.findByEmpId(empId);

		//対象者がいない場合中断
		if (employees.isEmpty()) {
			ConsoleWriter.showMessageLine(MSG_NO_TARGET);
			return;
		}
		
		//対象者の削除実行し、成功時は完了メッセージ表示
		Integer result = employeeDAO.delete(empId);
		if(result.equals(SUCCESS)) {
			ConsoleWriter.showMessageLine(EMP_INFO + MSG_DELETE_COMPLETE);
		}
		
	}

}
