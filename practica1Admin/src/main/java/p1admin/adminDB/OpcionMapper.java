package p1admin.adminDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import p1admin.model.Opcion;
import p1admin.model.Pregunta;

public class OpcionMapper extends AbstractMapper<Opcion, String>{

	public OpcionMapper(DataSource ds) {
		super(ds);
	}

	@Override
	protected Opcion buildObject(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getFindIdSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getTableName() {
		return "Respuestas";
	}

	@Override
	protected String[] getColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getKeyColumnName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObject(Opcion object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getKey(Opcion object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
