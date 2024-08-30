package kh.com.acledabank.bakong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public static String selectTrx(String url, String user, String password) {
		String query = "SELECT instruction_ref FROM incoming_trx";
		String result = "";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String instruction_ref = resultSet.getString("instruction_ref");
				result += instruction_ref + "\n";
			}
			
			statement.close();
			connection.close();

		} catch (SQLException | ClassNotFoundException e) {
			result = e.getMessage();
		}
		return result;
	}

	public static String insertTrx(String url, String user, String password, String instruction_ref, String original_create_time, String insertdb_time) {
		// Insert record script
		String insertScript = "INSERT INTO incoming_trx VALUES ('" + instruction_ref + "', '" + original_create_time + "', '" + insertdb_time + "')";
		String result = "";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			// Create a prepared statement for the insert script
			PreparedStatement preparedStatement = connection.prepareStatement(insertScript);

			// Execute the insert statement
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				result = "Record inserted successfully.";
			} else {
				result = "Failed to insert record.";
			}
			
			// Close the resources
            preparedStatement.close();
            connection.close();

		} catch (SQLException | ClassNotFoundException e) {
			result = e.getMessage();
		}
		return result;
	}
	
	public static String deleteTrx(String url, String user, String password, String instruction_ref) {
		// Delete record script
		String deleteScript = "DELETE FROM incoming_trx WHERE instruction_ref = '" + instruction_ref + "'";
		String result = "";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			// Create a prepared statement for the delete script
			PreparedStatement preparedStatement = connection.prepareStatement(deleteScript);

			// Execute the delete statement
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				result = "Record deleted successfully.";
			} else {
				result = "No record found to delete.";
			}
			
			// Close the resources
            preparedStatement.close();
            connection.close();

		} catch (SQLException | ClassNotFoundException e) {
			result = e.getMessage();
		}
		return result;
	}
	
	public static String updateTrx(String url, String user, String password, String old_instruction_ref, String new_instruction_ref) {
		// Update record script
		String updateScript = "UPDATE incoming_trx SET instruction_ref = '" + new_instruction_ref + "' WHERE instruction_ref = '" + old_instruction_ref + "'";
		String result = "";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			// Create a prepared statement for the update script
			PreparedStatement preparedStatement = connection.prepareStatement(updateScript);

			// Execute the update statement
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				result = "Record updated successfully.";
			} else {
				result = "No record found to update.";
			}
			
			// Close the resources
            preparedStatement.close();
            connection.close();

		} catch (SQLException | ClassNotFoundException e) {
			result = e.getMessage();
		}
		return result;
	}

}
