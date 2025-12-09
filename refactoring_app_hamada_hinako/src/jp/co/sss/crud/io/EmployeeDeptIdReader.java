package jp.co.sss.crud.io;

import static jp.co.sss.crud.util.ConstantValue.*;

import java.text.MessageFormat;

import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeDeptIdReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return MessageFormat.format(ConstantMsg.MSG_INPUT_NUMBER_ERROR, DEPT_ID_MIN, DEPT_ID_MAX);
	}

	@Override
	public boolean isValid(String inputString) {
		return inputString.matches("^[1-3１-３]{1}$");
	}

	@Override
	public boolean isParseInt() {
		return true;
	}

}
