package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * コンソール出力用クラス
 */
public class ConsoleWriter {
	
	public static void showHeader() {
		System.out.println("社員ID\t社員名\t性別\t生年月日\t部署名");
	}
	
	public static void showEmployees(List<Employee> employees) {
		
		if(employees.isEmpty()) {
			System.out.println(ConstantMsg.MSG_NO_RESULT);
		}
		
		System.out.println();
		showHeader();
		for(Employee employee : employees) {
			System.out.println(employee.toString());
		}
		System.out.println();
		
	}

}
