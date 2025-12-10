package jp.co.sss.crud.util;

/**
 * 性別ENUM
 */
public enum Gender {
	
	NO_ANSWER(0, "回答なし"),
	MALE(1, "男性"),
	FEMALE(2, "女性"),
	OTHER(9, "その他");
	
	/** 性別に割り振られた番号 */
	private final int genderNo;
	/** 性別（日本語） */
	private final String gender;
	
	private Gender(int genderNo, String gender) {
		this.genderNo = genderNo;
		this.gender = gender;
	}
	
	public int getGenderNo() {
		return genderNo;
	}
	
	public String getGender() {
		return gender;
	}

	/**
	 * 性別番号から性別を取得して返す
	 * 
	 * @param genderNo	性別に割り振られた番号
	 * @return	性別（日本語）
	 */
	public static Gender getByGenderNo(int genderNo) {
		
		for(Gender gender : Gender.values()) {
			if (gender.getGenderNo() == genderNo) {
				return gender;
			}
		}
		return null;
	}
}
