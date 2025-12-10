package jp.co.sss.crud.exception;

/**
 * 独自例外クラス（入力チェックエラー）
 */
public class IllegalInputException extends Exception{

	public IllegalInputException(String message) {
		super(message);
	}

	
}
