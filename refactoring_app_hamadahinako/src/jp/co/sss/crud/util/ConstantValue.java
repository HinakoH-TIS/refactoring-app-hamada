package jp.co.sss.crud.util;
/**
 *  設定値をまとめたクラス(数値、形式、正規表現パターン)
 */
public class ConstantValue {
	
	//メニュー番号
	public static final int MENU_SELECT_ALL = 1;
	public static final int MENU_SEARCH_EMP_NAME = 2;
	public static final int MENU_SEARCH_DEPT_ID = 3;
	public static final int MENU_INSERT = 4;
	public static final int MENU_UPDATE = 5;
	public static final int MENU_DELETE = 6;
	public static final int MENU_QUIT = 7;
	
	//社員名の文字数制限
	public static final int EMP_NAME_MAX = 30;
	public static final int EMP_NAME_MIN = 1;
	
	//部署IDの数値制限
	public static final int DEPT_ID_MAX = 3;
	public static final int DEPT_ID_MIN = 1;
	
	//社員IDの数値制限
	public static final int EMP_ID_MAX = 9999;
	public static final int EMP_ID_MIN = 1;
	
	//更新・登録実行時の実行件数
	/** 成功（1件） */
	public static final int SUCCESS = 1;
	/** 失敗（0件） */
	public static final int FAILURE = 0;
	
	//バリデーション時のパターン
	public static final String DATE_FORMAT = "yyyy/MM/dd";
	public static final String REGEX_DEPT_ID = "^[1-3１-３]{1}$";
	public static final String REGEX_EMP_ID = "^[1-9１-９]{1}[0-9１-９]{0,3}$";
	public static final String REGEX_GENDER = "^[0129０１２９]{1}$";
	public static final String REGEX_MENU_NO = "^[1-7１-７]$";
}
