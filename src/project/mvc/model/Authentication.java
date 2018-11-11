package project.mvc.model;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authentication {
	public boolean checkUser(String login, String password){
		boolean exists = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}
		
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			String query="SELECT * FROM users WHERE login= ? AND password= ?";
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project", "root", "");
			preparedStatement = connexion.prepareStatement(query);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
			result=preparedStatement.executeQuery();
			if(result.next()) {
					exists=true;
			}
		} catch (SQLException e) {
		} finally {
			try {
				if(result!=null)
					result.close();
				if(preparedStatement!=null)
					preparedStatement.close();
				if(connexion!=null)
					connexion.close();
			} catch (SQLException ignore) {
			}
		}
		return exists;
	}
}
