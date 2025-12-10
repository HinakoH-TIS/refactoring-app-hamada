package jp.co.sss.crud.util;

/**
 *  設定値をまとめたクラス(メッセージ)
 */
public class ConstantMsg {

	/** 入力をうながすメッセージ */
	public static final String MSG_INPUT = "を入力してください:";
	/** システム終了メッセージ */
	public static final String MSG_QUIT = "システムを終了します。";
	/** 検索結果なしのメッセージ */
	public static final String MSG_NO_RESULT = "該当者はいませんでした";
	/** 対象者なしのメッセージ */
	public static final String MSG_NO_TARGET = "対象者はいませんでした";
	/** 更新完了メッセージ */
	public static final String MSG_UPDATE_COMPLETE = "を更新しました";
	/** 登録完了メッセージ */
	public static final String MSG_INSERT_COMPLETE = "を登録しました";
	/** 削除完了メッセージ */
	public static final String MSG_DELETE_COMPLETE = "を削除しました";
	/** システムエラーメッセージ */
	public static final String MSG_SYSTEM_ERROR = "システムエラーです";
	
	
	//バリデーションエラー
	/** 数値チェックエラーメッセージ */
	public static final String MSG_INPUT_NUMBER_ERROR = "{0}以上{1}以下の整数を入力してください：";
	/** 文字列チェックエラーメッセージ */
	public static final String MSG_INPUT_STRING_ERROR = "{0}文字以上{1}文字以下の文字列を入力してください：";
	/** 性別チェックエラーメッセージ */
	public static final String MSG_INPUT_GENDER_ERROR = "0,1,2,9のいずれかを入力してください：";
	/** 日付チェックエラーメッセージ */
	public static final String MSG_INPUT_DATE_ERROR = "正しい形式(西暦年/月/日)で日付を入力してください：";

	//パーツ
	/** 入力させる時の文末パーツ */
	public static final String INPUT_END = ":";
	/** 社員情報パーツ */
	public static final String EMP_INFO = "社員情報";
	/** 更新時の社員IDパーツ */
	public static final String EMP_ID_UPDATE = "更新する社員の社員ID";
	/** 削除時の社員IDパーツ */
	public static final String EMP_ID_DELETE = "削除する社員の社員ID";
	/** メニュー番号パーツ */
	public static final String MENU_NO = "メニュー番号";
	/** 社員名パーツ */
	public static final String EMP_NAME = "社員名";
	/** 部署情報パーツ */
	public static final String DEPT_ID = "部署ID(1:営業部、2:経理部、3:総務部)";
	/**	生年月日パーツ */
	public static final String BIRTHDAY = "生年月日(西暦年/月/日)";	
	/** 性別パーツ */
	public static final String GENDER = "性別(0:回答しない, 1:男性, 2:女性, 9:その他)";
	
	
	/** メニュー表示のタイトル */
	public static final String MENU_TITLE = "=== 社員管理システム ===";
	/** 社員検索の結果表示用ヘッダー */
	public static final String SEARCH_RESULT_HEADER = "社員ID\t社員名\t性別\t生年月日\t部署名";
	
}
