package jp.co.sss.crud.dto;

import jp.co.sss.crud.util.Gender;

public class Employee {
	
	/** 社員ID */
	private int empId;
	
	/** 社員名 */
	private String empName;
	
	/** 性別 */
	private int gender;
	
	/** 生年月日 */
	private String birthday;
	
	/** 部署DTO */
	private Department department;
	

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 *	検索結果表示用にフィールドの値をString型にする
	 *
	 *	@return Stringにまとめたフィールドの値
	 */
	@Override
	public String toString() {
		return empId + "\t" + empName + "\t" + Gender.getByGenderNo(gender).getGender() + "\t" + birthday
				+ "\t" + department.getDeptName();
	}

}
