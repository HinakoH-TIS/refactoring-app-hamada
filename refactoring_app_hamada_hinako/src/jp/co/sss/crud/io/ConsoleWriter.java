package jp.co.sss.crud.io;

import static jp.co.sss.crud.util.ConstantMsg.*;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.Menu;

/**
 * コンソール出力用クラス
 */
public class ConsoleWriter {

	public static void showMenu() {
		// メニューの表示
		System.out.println(MENU_TITLE);

		for (Menu menu : Menu.values()) {
			System.out.println(menu.getMenuNo() + "." + menu.getMenuName());
		}
		System.out.print(MENU_NO + MSG_INPUT);
	}

	public static void showHeader() {
		System.out.println(SEARCH_RESULT_HEADER);
	}

	public static void showEmployees(List<Employee> employees) {

		if (employees.isEmpty()) {
			System.out.println(MSG_NO_RESULT);
		} else {
			System.out.println();
			showHeader();
			for (Employee employee : employees) {
				System.out.println(employee.toString());
			}
			System.out.println();
		}
	}

	public static void showMessage(String message) {

		System.out.println(message);
	}

}
