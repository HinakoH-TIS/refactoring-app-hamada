package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantSQL;

public class EmployeeDAO implements IEmployeeDAO {

	public List<Employee> findAll() throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			List<Employee> employees = new ArrayList<Employee>();

			//結果をEmployeeDTOの配列ににセットして返す
			while (resultSet.next()) {
				Employee employee = new Employee();
				Department department = new Department();
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				department.setDeptName(resultSet.getString("dept_name"));
				employee.setDepartment(department);
				employees.add(employee);
			}

			return employees;

		} catch (Exception e) {
			throw new SystemErrorException();
		} finally {

			try {
				// ResultSetをクローズ
				DBManager.close(resultSet);
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}
	}

	@Override
	public List<Employee> findByEmployeeName(String searchName) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setString(1, "%" + searchName + "%");

			resultSet = preparedStatement.executeQuery();

			List<Employee> employees = new ArrayList<Employee>();

			//結果をEmployeeDTOの配列ににセットして返す
			while (resultSet.next()) {
				Employee employee = new Employee();
				Department department = new Department();
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				department.setDeptName(resultSet.getString("dept_name"));
				employee.setDepartment(department);
				employees.add(employee);
			}

			return employees;

		} catch (Exception e) {
			throw new SystemErrorException();
		} finally {
			try {
				// ResultSetをクローズ
				DBManager.close(resultSet);
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Employee> findByDeptId(int deptId) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(1, deptId);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();
			List<Employee> employees = new ArrayList<Employee>();

			//結果をEmployeeDTOの配列ににセットして返す
			while (resultSet.next()) {
				Employee employee = new Employee();
				Department department = new Department();
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				department.setDeptName(resultSet.getString("dept_name"));
				employee.setDepartment(department);
				employees.add(employee);
			}
			return employees;

		} catch (Exception e) {
			throw new SystemErrorException();
		} finally {
			try {
				// ResultSetをクローズ
				DBManager.close(resultSet);
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

	@Override
	public void insert(Employee employee) throws SystemErrorException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public Integer update(Employee employee) throws SystemErrorException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Integer delete(Integer empId) throws SystemErrorException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
