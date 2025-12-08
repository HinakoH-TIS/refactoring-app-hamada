package jp.co.sss.crud.db;

import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.dto.Employee;

public interface IEmployeeDAO {

	List<Employee> findAllEmp() throws ClassNotFoundException, SQLException;

}
