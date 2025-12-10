package jp.co.sss.crud.util;

public enum Menu {
	SHOW_ALL(1, "全件表示"), 
	SEARCH_BY_NAME(2, "社員名検索"),
	SEARCH_BY_DEPT_ID(3, "部署名検索"), 
	INSERT_EMP(4, "新規登録"),
	UPDATE_EMP(5, "更新"),
	DELETE_EMP(6, "削除"), 
	QUIT(7, "終了");

	private final int menuNo;
	private final String menuName;

	private Menu(int menuNo, String menuName) {
		this.menuNo = menuNo;
		this.menuName = menuName;
	}

	public int getMenuNo() {
		return menuNo;
	}

	public String getMenuName() {
		return menuName;
	}

	public static Menu getByMenuNo(int menuNo) {

		for (Menu menu : Menu.values()) {
			if (menu.getMenuNo() == menuNo) {
				return menu;
			}
		}
		return null;
	}
}
