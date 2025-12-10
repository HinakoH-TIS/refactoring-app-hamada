package jp.co.sss.crud.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

/**
 * 生年月日入力用リーダークラス
 */
public class EmployeeBirthdayReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return ConstantMsg.MSG_INPUT_DATE_ERROR;
	}

	@Override
	public boolean isValid(String inputString) {
		SimpleDateFormat sdf = new SimpleDateFormat(ConstantValue.DATE_FORMAT);
		sdf.setLenient(false);
		try {
			sdf.parse(inputString);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	@Override
	public boolean isParseInt() {
		return false;
	}

}
