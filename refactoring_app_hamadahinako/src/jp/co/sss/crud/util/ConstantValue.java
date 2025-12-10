package jp.co.sss.crud.util;

public class ConstantValue {
	
	public static final int MENU_SELECT_ALL = 1;
	public static final int MENU_SEARCH_EMP_NAME = 2;
	public static final int MENU_SEARCH_DEPT_ID = 3;
	public static final int MENU_INSERT = 4;
	public static final int MENU_UPDATE = 5;
	public static final int MENU_DELETE = 6;
	public static final int MENU_QUIT = 7;
	
	
	public static final int EMP_NAME_MAX = 30;
	public static final int EMP_NAME_MIN = 1;
	
	public static final int DEPT_ID_MAX = 3;
	public static final int DEPT_ID_MIN = 1;
	
	public static final int EMP_ID_MAX = 9999;
	public static final int EMP_ID_MIN = 1;
	
	public static final int SUCCESS = 1;
	public static final int FAILURE = 0;
	
	public static final String DATE_FORMAT = "yyyy/MM/dd";
	
	public static final String REGEX_DEPT_ID = "^[1-3１-３]{1}$";
	public static final String REGEX_EMP_ID = "^[1-9１-９]{1}[0-9１-９]{0,3}$";
	public static final String REGEX_GENDER = "^[0129０１２９]{1}$";
	
}
