package jp.co.sss.crud.io;

import static jp.co.sss.crud.util.ConstantMsg.*;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.Menu;

/**
 * コンソール出力用クラス
 */
public class ConsoleWriter {

	/**
	 * メニュー表示
	 */
	public static void showMenu() {
		System.out.println(MENU_TITLE);

		for (Menu menu : Menu.values()) {
			System.out.println(menu.getMenuNo() + "." + menu.getMenuName());
		}
		System.out.print(MENU_NO + MSG_INPUT);
	}

	/**
	 * 検索結果のヘッダー表示
	 */
	public static void showHeader() {
		System.out.println(SEARCH_RESULT_HEADER);
	}

	/**
	 * 社員の検索結果表示
	 * @param employees 社員リスト
	 */
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

	/**
	 * 改行有りのメッセージ表示
	 * @param message	表示するメッセージ
	 */
	public static void showMessageLine(String message) {
		System.out.println(message);
	}
	
	/**
	 * 改行無しのメッセージ表示
	 * @param message	表示するメッセージ
	 */
	public static void showMessage(String message) {
		System.out.print(message);
	}

}
