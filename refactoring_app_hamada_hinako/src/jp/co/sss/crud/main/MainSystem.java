package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.service.EmployeeAllFindService;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.Menu;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int menuNo = 0;

		do {
			// メニューの表示
			System.out.println("=== 社員管理システム ===");

			for (Menu menu : Menu.values()) {
				System.out.println(menu.getMenuNo() + "." + menu.getMenuName());
			}
			System.out.print(ConstantMsg.MENU_NO + ConstantMsg.MSG_INPUT);

			// メニュー番号の入力
			String menuNoStr = br.readLine();
			menuNo = Integer.parseInt(menuNoStr);

			Menu menu = Menu.getByMenuNo(menuNo);

			// 機能の呼出
			switch (menu) {
			case SHOW_ALL:
				// 全件表示機能の呼出
//				DBController.findAllEmp();
				EmployeeAllFindService.execute();
				
				break;

			case SEARCH_BY_NAME:
				// 社員名検索
				System.out.print(ConstantMsg.EMP_NAME + ":");

				// 検索機能の呼出
				DBController.findByEmpName();
				break;

			case SEARCH_BY_DEPT_ID:
				// 検索する部署IDを入力
				System.out.print(ConstantMsg.DEPT_ID + ConstantMsg.MSG_INPUT);
				String deptId = br.readLine();

				// 検索機能の呼出
				DBController.findByDeptId(deptId);
				break;

			case INSERT_EMP:
				// 登録する値を入力
				System.out.print(ConstantMsg.EMP_NAME + ":");
				String empName = br.readLine();
				System.out.print(ConstantMsg.GENDER + ":");
				String gender = br.readLine();
				System.out.print(ConstantMsg.BIRTHDAY + ":");
				String birthday = br.readLine();
				System.out.print(ConstantMsg.DEPT_ID + ":");
				deptId = br.readLine();

				// 登録機能の呼出
				DBController.insertEmp(empName, gender, birthday, deptId);
				break;

			case UPDATE_EMP:
				// 更新する社員IDを入力
				System.out.print("更新する社員の社員ID" + ConstantMsg.MSG_INPUT);

				// 更新する値を入力する
				String empId = br.readLine();
				Integer.parseInt(empId);

				// 更新機能の呼出
				DBController.updateEmp(empId);
				System.out.println(ConstantMsg.EMP_INFO + ConstantMsg.MSG_UPDATE_COMPLETE);

				break;

			case DELETE_EMP:
				// 削除する社員IDを入力
				System.out.print("削除する社員の社員ID" + ConstantMsg.MSG_INPUT);

				// 削除機能の呼出
				DBController.deleteEmp();
				break;

			case QUIT:
				break;
			}
		} while (menuNo != Menu.QUIT.getMenuNo());
		System.out.println(ConstantMsg.MSG_QUIT);
	}
}
