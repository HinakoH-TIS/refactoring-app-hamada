package jp.co.sss.crud.exception;

/**
 * 独自例外クラス（システムエラー）
 */
public class SystemErrorException extends Exception{

	public SystemErrorException(String message, Exception e) {
		super(message);
	}
	
	public SystemErrorException(String message) {
		super(message);
	}

}
