package jp.co.sss.crud.io;

import static jp.co.sss.crud.util.ConstantValue.*;

import java.text.MessageFormat;

import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeEmpIdReader implements IConsoleReader{

	@Override
	public String getErrorMsg() {
		return MessageFormat.format(ConstantMsg.MSG_INPUT_NUMBER_ERROR, EMP_ID_MIN, EMP_ID_MAX);
	}

	@Override
	public boolean isValid(String inputString) {
		return inputString.matches("^[1-9１-９]{1}[0-9１-９]{0,3}$");
	}

	@Override
	public boolean isParseInt() {
		return true;
	}

}
