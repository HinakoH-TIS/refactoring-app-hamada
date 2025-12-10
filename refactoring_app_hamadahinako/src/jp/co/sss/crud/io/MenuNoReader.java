package jp.co.sss.crud.io;
import static  jp.co.sss.crud.util.ConstantValue.*;

import java.text.MessageFormat;

import jp.co.sss.crud.util.ConstantMsg;

/**
 * メニュー番号入力用リーダークラス
 */
public class MenuNoReader implements IConsoleReader{

	@Override
	public String getErrorMsg() {
		return MessageFormat.format(ConstantMsg.MSG_INPUT_NUMBER_ERROR, MENU_SELECT_ALL, MENU_QUIT);
	}

	@Override
	public boolean isValid(String inputString) {
		return  inputString.matches(REGEX_MENU_NO);
	}

	@Override
	public boolean isParseInt() {
		return true;
	}


}
