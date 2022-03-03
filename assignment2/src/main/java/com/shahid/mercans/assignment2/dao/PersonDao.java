package com.shahid.mercans.assignment2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.shahid.mercans.assignment2.models.SalaryComponent;
import com.shahid.mercans.assignment2.utils.DBUtils;

/**
 * Class responsible for interacting with database and executing queries
 * 
 * @author Shahid Farooq
 *
 */
public class PersonDao {

	/**
	 * Method insert the Person record in person table
	 * 
	 * @param person
	 * @return
	 */
	public int insertPerson(PersonEntity person) {
		String insertPersonQuery = "insert into person (id,full_name,gender,birthdate,employee_code,hire_date,termination_date) values (null,?,?,?,?,?,?)";
		int id = 0;
		try (Connection connection = DBUtils.getConnection();) {
			try (PreparedStatement preparedStatement = connection.prepareStatement(insertPersonQuery,
					Statement.RETURN_GENERATED_KEYS)) {
				preparedStatement.setString(1, person.getFullName());
				preparedStatement.setString(2, person.getGender());
				preparedStatement.setString(3, person.getBirthDate());
				preparedStatement.setString(4, person.getEmployeeCode());
				preparedStatement.setString(5, person.getHireDate());
				preparedStatement.setString(6, person.getTerminationDate());
				preparedStatement.executeUpdate();
				try (ResultSet resultSet = preparedStatement.getGeneratedKeys();) {
					while (resultSet.next())
						id = resultSet.getInt(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * Method updates the termination date based on employee_code
	 * 
	 * @param person
	 * @return
	 */
	public int terminatePerson(PersonEntity person) {
		String insertPersonQuery = "update person set termination_date=? where employee_code=?";
		int id = 0;
		try (Connection connection = DBUtils.getConnection();) {
			try (PreparedStatement preparedStatement = connection.prepareStatement(insertPersonQuery,
					Statement.RETURN_GENERATED_KEYS)) {
				preparedStatement.setString(1, person.getTerminationDate());
				preparedStatement.setString(2, person.getEmployeeCode());
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * Method updates the fields which are new
	 * 
	 * @param person
	 * @return
	 */
	public int changePerson(PersonEntity person) {
		String insertPersonQuery = "update person set full_name=CASE when ? is not null and length(?)>0 then ? else full_name end, birthdate=case when ? is not null and length(?)>0 then ? else birthdate end, gender=case when ? is not null and length(?)>0 then ? else gender end, hire_date=case when ? is not null and length(?)>0 then ? else hire_date end , termination_date=case when ? is not null and length(?)>0 then ? else termination_date end where employee_code=?";
		int id = 0;
		try (Connection connection = DBUtils.getConnection();) {
			try (PreparedStatement preparedStatement = connection.prepareStatement(insertPersonQuery,
					Statement.RETURN_GENERATED_KEYS)) {
				preparedStatement.setString(1, person.getFullName());
				preparedStatement.setString(2, person.getFullName());
				preparedStatement.setString(3, person.getFullName());
				preparedStatement.setString(4, person.getBirthDate());
				preparedStatement.setString(5, person.getBirthDate());
				preparedStatement.setString(6, person.getBirthDate());
				preparedStatement.setString(7, person.getGender());
				preparedStatement.setString(8, person.getGender());
				preparedStatement.setString(9, person.getGender());
				preparedStatement.setString(10, person.getHireDate());
				preparedStatement.setString(11, person.getHireDate());
				preparedStatement.setString(12, person.getHireDate());
				preparedStatement.setString(13, person.getTerminationDate());
				preparedStatement.setString(14, person.getTerminationDate());
				preparedStatement.setString(15, person.getTerminationDate());
				preparedStatement.setString(16, person.getEmployeeCode());
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * Method to insert salary for new employees
	 * 
	 * @param salaryComponent
	 * @param personId
	 */
	public void insertSalary(SalaryComponent salaryComponent, int personId) {
		String insertPersonQuery = "insert into salary_component (id,person_id,amount,currency,start_date,end_date) values (null,?,?,?,?,?)";
		try (Connection connection = DBUtils.getConnection();) {
			try (PreparedStatement preparedStatement = connection.prepareStatement(insertPersonQuery,
					Statement.RETURN_GENERATED_KEYS)) {
				preparedStatement.setInt(1, personId);
				preparedStatement.setDouble(2, salaryComponent.getAmount());
				preparedStatement.setString(3, salaryComponent.getCurrency());
				preparedStatement.setString(4, salaryComponent.getStartDate());
				preparedStatement.setString(5, salaryComponent.getEndDate());
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to check if user already exist in database based on employee_code
	 * 
	 * @param person
	 * @return
	 */
	public boolean getPersonByCode(PersonEntity person) {
		boolean flag = true;
		String insertPersonQuery = "select employee_code from person where employee_code=?";
		try (Connection connection = DBUtils.getConnection();) {
			try (PreparedStatement preparedStatement = connection.prepareStatement(insertPersonQuery,
					Statement.RETURN_GENERATED_KEYS)) {
				preparedStatement.setString(1, person.getEmployeeCode());
				try (ResultSet resultSet = preparedStatement.executeQuery();) {
					while (resultSet.next())
						flag = false;
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
