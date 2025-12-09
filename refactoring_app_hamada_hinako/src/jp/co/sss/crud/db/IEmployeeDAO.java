package jp.co.sss.crud.db;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;

public interface IEmployeeDAO {

	List<Employee> findAllEmp() throws SystemErrorException;

}
