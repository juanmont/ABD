package p1admin.adminDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.sql.DataSource;
import java.sql.Connection;

public class DataAccessor {
	
	private DataSource ds;
	private ResultSet lastKey;

	public DataAccessor(DataSource ds) {
		this.ds = ds;
	}

	public Integer insertRow(String tableName, String[] fields, Object[] values) {
		String sql = generateInsertStatement(tableName, fields);
		
		try(Connection con = this.ds.getConnection();
				PreparedStatement pst = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
		
			for (int i = 0; i < values.length; i++) {
				pst.setObject(i + 1, values[i]);
			}
			@SuppressWarnings("unused")
			int numRows = pst.executeUpdate();
			lastKey = pst.getGeneratedKeys();
			System.out.println(lastKey.toString());
			if(lastKey.next())
				return new Integer(lastKey.getInt(1));
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
		
	}

	private String generateInsertStatement(String tableName, String[] fields) {
		String fieldList = String.join(",", fields);
		String[] marks = new String[fields.length];
		Arrays.fill(marks, "?");
		String markList = String.join(",", marks);
		
		return "INSERT INTO " + tableName 
				+ " (" + fieldList + ") VALUES ("
				+ markList + ")";
		
	}
	
	public boolean deleteRows(String tableName, String[] key, Object[] values) {
		String sql = generateDeleteStatement(tableName, key);
		
		try(Connection con = this.ds.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {
		
			for (int i = 0; i < values.length; i++) {
				pst.setObject(i + 1, values[i]);
			}
			
			int numRows = pst.executeUpdate();
			return (numRows == 1);
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	private String generateDeleteStatement(String tableName, String[] key) {
		String sentencia = "DELETE FROM " + tableName+ " WHERE ";
		for(int i = 0; i < key.length-1 ; i++){
			sentencia += key[i] + " = ? AND ";
		}
		sentencia += key[key.length] + " = ?";
		
		return sentencia;
		
	}
	
	public boolean updateRows(String tableName, String[] keys, Object[] values, String[] cols, Object[] newValues) {
		String sql = generateUpdateStatement(tableName, keys, cols);
		
		try(Connection con = this.ds.getConnection();
				PreparedStatement pst = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
		
			
			for (int i = 0; i < newValues.length; i++) {
				pst.setObject(i + 1, newValues[i]);
			}
			
			for (int i = 0; i < values.length; i++) {
				pst.setObject(i + newValues.length + 1, values[i]);
			}
			
			int numRows = pst.executeUpdate();
			return (numRows == 1);
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	private String generateUpdateStatement(String tableName, String[] keys, String[] cols) {
		String sentencia = "UPDATE " + tableName+ " SET ";
		for(int i = 0; i < cols.length-1 ; i++){
			sentencia += cols[i] + " = ?,";
		}
		sentencia += cols[cols.length-1] + " = ?";
		
		sentencia += " WHERE ";
		for(int i = 0; i < keys.length-1 ; i++) {
			sentencia += keys[i] + " = ? AND ";
		}
		sentencia += keys[keys.length-1] + " = ?";
		
		return sentencia;
	}
}
