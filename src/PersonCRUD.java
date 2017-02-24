import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

public class PersonCRUD extends BaseMySQLAccess {

	public void AddInfo(String name, String surname, String city,String password) throws SQLException, NamingException {
		/*
		 * Birden fazla baglantı icin Connection objesi her metod icin
		 * datamember olarak tutulur.
		 */
		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {
			connect = Access();
			String insertTableSQL = "INSERT INTO Persons (surname,name,city,password) VALUES(?,?,?,?)";
			preparedStatement = connect.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, surname);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, city);
			preparedStatement.setString(4, password);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.getMessage();

		} finally {
			CloseConnection(connect, preparedStatement);

		}

	}

	public void DeleteInfo(String name, String surname, String city,String password) throws SQLException, NamingException {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		try {
			connect = Access();

			String deleteQuery = "DELETE FROM Persons WHERE surname=? AND name=? AND City=? AND password=?";
			preparedStatement = connect.prepareStatement(deleteQuery);
			preparedStatement.setString(1, surname);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, city);
			preparedStatement.setString(4, password);		
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.getMessage();

		} finally {
			CloseConnection(connect, preparedStatement);

		}

	}

	public void UpdateInfo(String newname, String newsurname, String newCity,String password) throws SQLException, NamingException {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		try {
			connect = Access();
			String updateQuery = "UPDATE Persons SET City = ?  WHERE name = ? AND surname=? AND password = ?";
			preparedStatement = connect.prepareStatement(updateQuery);
			preparedStatement.setString(4, password);
			preparedStatement.setString(3, newsurname);
			preparedStatement.setString(2, newname);
			preparedStatement.setString(1, newCity);
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
			e.getMessage();

		} finally {
			CloseConnection(connect, preparedStatement);
		}

	}
	/*public boolean isItValidPassword(String name,String enteredPass) throws SQLException, NamingException{
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean ans=false ;
		try{
			connect = Access();
			
			String getPasswordQuery = "SELECT count(*) AS ROWCOUNT FROM Persons WHERE name=? AND password = ?";	
			preparedStatement = connect.prepareStatement(getPasswordQuery);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, enteredPass);
			resultSet=preparedStatement.executeQuery();
		
			resultSet.next();
			int counter = resultSet.getInt(1);
			System.out.println("counterrrrrrrr"+counter);
			if(counter==1)
				ans=true;
			else 
				ans=false;
		}catch (SQLException e) {
			e.getMessage();

		} finally {
			CloseConnection(connect, preparedStatement);
		}
		return ans;
		
	}*/
}
