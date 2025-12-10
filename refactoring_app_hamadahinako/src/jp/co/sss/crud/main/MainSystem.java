package jp.co.sss.crud.main;

import static jp.co.sss.crud.util.ConstantMsg.*;
import static jp.co.sss.crud.util.ConstantValue.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.IEmployeeService;

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
	 * @throws IllegalInputException 
	 * @throws SystemErrorException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException,
			SystemErrorException, IllegalInputException {

		//メニュー番号入力用クラス生成
		MenuNoReader menuNoReader = new MenuNoReader();
		int menuNo = 0;

		do {
			try {
				ConsoleWriter.showMenu();
				menuNo = (int) menuNoReader.input();
				IEmployeeService service = IEmployeeService.getInstanceByMenuNo(menuNo);
				
				//サービスインスタンスがある場合、実行（システム終了を選んだ場合作成されない）
				if(service != null) {
					service.execute();
				}
				
			} catch (IllegalInputException e) {//不正な入力があった場合、ループに戻る
				System.out.println(e.getMessage());
				System.out.println();
				continue;
			} catch (SystemErrorException e) {//継続不能なエラーの場合、ループを抜ける
				System.out.println(e.getMessage());
				e.printStackTrace();
				break;
			}

		} while (menuNo != MENU_QUIT);
		ConsoleWriter.showMessageLine(MSG_QUIT);
	}
}
