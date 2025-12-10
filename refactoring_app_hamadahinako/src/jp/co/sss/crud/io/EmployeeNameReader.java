package jp.co.sss.crud.io;

import static jp.co.sss.crud.util.ConstantValue.*;

import java.text.MessageFormat;

import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeNameReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return MessageFormat.format(ConstantMsg.MSG_INPUT_STRING_ERROR, EMP_NAME_MIN, EMP_NAME_MAX) ;
	}

	@Override
	public boolean isValid(String inputString) {
		if (EMP_NAME_MIN <= inputString.length() && inputString.length() <= EMP_NAME_MAX) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isParseInt() {
		return false;
	}

}
