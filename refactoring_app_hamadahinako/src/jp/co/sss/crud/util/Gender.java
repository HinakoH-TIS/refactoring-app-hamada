package jp.co.sss.crud.util;

public enum Gender {
	
	NO_ANSWER(0, "回答なし"),
	MALE(1, "男性"),
	FEMALE(2, "女性"),
	OTHER(9, "その他");
	
	private final int genderNo;
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

	public static Gender getByGenderNo(int genderNo) {
		
		for(Gender gender : Gender.values()) {
			if (gender.getGenderNo() == genderNo) {
				return gender;
			}
		}
		return null;
	}
}
