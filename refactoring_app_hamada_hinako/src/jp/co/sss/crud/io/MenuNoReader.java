package jp.co.sss.crud.io;
import java.text.MessageFormat;

import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;
/**
 * メニュー番号入力用クラス
 */
public class MenuNoReader implements IConsoleReader{

	@Override
	public String getErrorMsg() {
		return MessageFormat.format(ConstantMsg.MSG_INPUT_NUMBER_ERROR, ConstantValue.MENU_SELECT_ALL, ConstantValue.MENU_QUIT);
	}

	@Override
	public boolean isValid(String inputString) {
		return  inputString.matches("^[1-7１-７]$");
	}

	@Override
	public boolean isParseInt() {
		return true;
	}


}
