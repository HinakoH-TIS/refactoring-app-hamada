package jp.co.sss.crud.io;

import static jp.co.sss.crud.util.ConstantValue.*;

import jp.co.sss.crud.util.ConstantMsg;

/**
 * 性別入力用リーダークラス
 */
public class EmployeeGenderReader implements IConsoleReader{

	@Override
	public String getErrorMsg() {
		return ConstantMsg.MSG_INPUT_GENDER_ERROR;
	}

	@Override
	public boolean isValid(String inputString) {
		return inputString.matches(REGEX_GENDER);
	}

	@Override
	public boolean isParseInt() {
		return true;
	}

}
