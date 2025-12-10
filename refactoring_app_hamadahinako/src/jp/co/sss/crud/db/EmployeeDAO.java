package jp.co.sss.crud.db;

import static jp.co.sss.crud.util.ConstantMsg.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.mapper.EmployeeMapper;
import jp.co.sss.crud.util.ConstantSQL;

/**
 * 社員CRUD機能用DAO
 */
public class EmployeeDAO implements IEmployeeDAO {

	/**
	 * 全件検索
	 * @return 検索結果の社員リスト
	 */
	@Override
	public List<Employee> findAll() throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<Employee>();

		try {
			//データベース接続とSQL文の準備
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行し、検索結果をEmployeeDTO配列にセット
			resultSet = preparedStatement.executeQuery();
			employees = EmployeeMapper.setValuesToEmployeeList(resultSet);

		} catch (SQLException | ClassNotFoundException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);
		} finally {

			try {
				DBManager.close(resultSet);
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employees;
	}

	/**
	 * 社員名検索
	 * @return 検索結果の社員リスト
	 */
	@Override
	public List<Employee> findByEmployeeName(String searchName) throws SystemErrorException {
		List<Employee> employees = new ArrayList<Employee>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			//データベース接続とSQL文の準備
			connection = DBManager.getConnection();
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);
			preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setString(1, "%" + searchName + "%");

			// SQL文を実行し、検索結果をEmployeeDTO配列にセット
			resultSet = preparedStatement.executeQuery();
			employees = EmployeeMapper.setValuesToEmployeeList(resultSet);

		} catch (SQLException | ClassNotFoundException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);
		} finally {
			try {
				DBManager.close(resultSet);
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employees;

	}

	/**
	 * 部署ID検索
	 * @return 検索結果の社員リスト
	 */
	@Override
	public List<Employee> findByDeptId(int deptId) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<Employee>();

		try {
			//データベース接続とSQL文の準備
			connection = DBManager.getConnection();
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(1, deptId);

			// SQL文を実行し、検索結果をEmployeeDTO配列にセット
			resultSet = preparedStatement.executeQuery();
			employees = EmployeeMapper.setValuesToEmployeeList(resultSet);

		} catch (SQLException | ClassNotFoundException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);
		} finally {
			try {
				DBManager.close(resultSet);
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employees;

	}

	/**
	 * 社員登録
	 */
	@Override
	public void insert(Employee employee) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			//データベース接続とSQL文の準備
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, employee.getGender());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(employee.getBirthday()), Types.DATE);
			preparedStatement.setInt(4, employee.getDepartment().getDeptId());

			// SQL文を実行
			preparedStatement.executeUpdate();

		} catch (SQLException | ClassNotFoundException | ParseException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);
		} finally {
			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 社員更新
	 * @return 更新件数（失敗時は0）
	 */
	@Override
	public Integer update(Employee employee) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			//データベース接続とSQL文の準備
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			// 入力値をバインド
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, employee.getGender());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(employee.getBirthday()), Types.DATE);
			preparedStatement.setInt(4, employee.getDepartment().getDeptId());
			preparedStatement.setInt(5, employee.getEmpId());

			return preparedStatement.executeUpdate();

		} catch (SQLException | ClassNotFoundException | ParseException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);
		} finally {

			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	/**
	 * 社員削除
	 * @return 削除件数（失敗時は0）
	 */
	@Override
	public Integer delete(Integer empId) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			//データベース接続とSQL文の準備
			connection = DBManager.getConnection();
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(1, empId);

			// SQL文の実行(失敗時は戻り値0)
			return preparedStatement.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);

		} finally {
			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 社員ID検索
	 * @return 検索結果の社員リスト
	 */
	@Override
	public List<Employee> findByEmpId(int empId) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<Employee>();

		try {
			//データベース接続とSQL文の準備
			connection = DBManager.getConnection();
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_ID);
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(1, empId);

			// SQL文を実行し、検索結果をEmployeeDTO配列にセット
			resultSet = preparedStatement.executeQuery();
			employees = EmployeeMapper.setValuesToEmployeeList(resultSet);

		} catch (SQLException | ClassNotFoundException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);
		} finally {
			try {
				DBManager.close(resultSet);
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return employees;
	}

}
