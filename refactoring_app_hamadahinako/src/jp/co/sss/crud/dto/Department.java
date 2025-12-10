package jp.co.sss.crud.dto;

/**
 * 部署テーブル用DTO
 */
public class Department {

	/** 部署ID */
	private int deptId;
	
	/** 部署名 */
	private String deptName;
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
}
