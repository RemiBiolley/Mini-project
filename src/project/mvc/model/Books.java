package project.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class Books {
	
	//////////////////////////////////////////////////////////
	// Method called to check if a book is already reserved //
	//////////////////////////////////////////////////////////
	public boolean checkOwner(Reservation res){
		boolean isOwned = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}
		
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			String query="SELECT owner_book FROM books WHERE name_book= ?";
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project", "root", "");
			preparedStatement = connexion.prepareStatement(query);
			preparedStatement.setString(1, res.getBookName());
			result=preparedStatement.executeQuery();
			while(result.next()) {
				String owner = result.getString("owner_book");
				if(owner!=null) {
					isOwned=true;
				}
				
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
		return isOwned;
	}
	
	///////////////////////////////////////////////////
	// Method called to check if a book is in the db //
	///////////////////////////////////////////////////
	public boolean bookInList(String bookName){
		boolean isPresent=false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}
		
		Connection connexion = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project", "root", "");
			statement = connexion.createStatement();
			
			result = statement.executeQuery("SELECT name_book FROM books;");
			while(result.next()) {
				String name = result.getString("name_book");
				if(Objects.equals(name, bookName)) {
					isPresent=true;
				}
			}
			
		} catch (SQLException e) {
		} finally {
			try {
				if(result!=null)
					result.close();
				if(statement!=null)
					statement.close();
				if(connexion!=null)
					connexion.close();
			} catch (SQLException ignore) {
			}
		}
		return isPresent;
	}
	
	
	/////////////////////////////////////
	// Method called to reserve a book //
	/////////////////////////////////////
	public void changeOwner(String newOwner, Reservation res){
		boolean isOwned = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}
		
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			String query = "UPDATE books SET owner_book= ? WHERE name_book= ?";
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project", "root", "");
			preparedStatement = connexion.prepareStatement(query);
			preparedStatement.setString(1, newOwner);
			preparedStatement.setString(2, res.getBookName());
			preparedStatement.executeUpdate();

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
	}
}
