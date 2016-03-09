package p1admin.adminDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public abstract class AbstractMapper<T,K> {

	DataSource ds;
	DataAccessor da;
	
	protected abstract T buildObject(ResultSet rs) throws SQLException;

	protected abstract String getFindIdSQL();
	
	protected abstract String getTableName();
	
	protected abstract String[] getColumnNames();

	protected abstract String[] getKeyColumnName();
	
	protected abstract Object[] serializeObject(T object);

	protected abstract Object[] serializeKey(K key);
	
	protected abstract K getKey(T object);
	
	protected abstract List<T> getAll();
	
	public AbstractMapper(DataSource ds) {
		this.ds = ds;
		this.da = new DataAccessor(this.ds);
	}
	
	public boolean insert(T transfer) {
		String tableName = getTableName();
		String[] fields = getColumnNames();
		Object[] values = serializeObject(transfer);
		boolean sql = this.da.insertRow(tableName, fields, values);
		
		return sql;
		
	}
	
	public boolean update(T transfer) {
		String tableName = getTableName();
		String[] fields = getColumnNames();
		String[] key = getKeyColumnName();
		Object[] values = serializeObject(transfer);
		Object[] newValues = serializeKey(getKey(transfer)); 
		
		boolean sql = this.da.updateRows(tableName, key, values, fields, newValues);
		
		return sql;
	}
	
	public boolean delete(T transfer) {
		String tableName = getTableName();
		String[] key = getKeyColumnName();
		Object[] values = serializeObject(transfer);
		boolean sql = this.da.deleteRows(tableName, key, values);
		
		return sql;
	}
	
	public T findById(K key) {
		ResultSet rs = null;
		T result = null;
		try (Connection con = ds.getConnection();
			PreparedStatement pst = con.prepareStatement(getFindIdSQL())){
			pst.setObject(1, key);
			rs = pst.executeQuery();
			if (rs.next()) {
				result = buildObject(rs);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

}
