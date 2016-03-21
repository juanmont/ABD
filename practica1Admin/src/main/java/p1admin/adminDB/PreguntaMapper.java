package p1admin.adminDB;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import p1admin.model.Opcion;
import p1admin.model.Pregunta;

public class PreguntaMapper extends AbstractMapper<Pregunta, Integer>{
	
	public PreguntaMapper(DataSource ds) {
		super(ds);
	}

	@Override
	protected Pregunta buildObject(ResultSet rs) throws SQLException {
		Pregunta result = new Pregunta();
		Integer id = rs.getInt("id");
		String enunciado = rs.getString("enunciado");
		result.setId(id);
		result.setEnunciado(enunciado);
		for (int i = 0; i < result.getNumOpciones(); i++) {
			Opcion o = new Opcion();
			o.setPreguntaMadre(result);
			result.addOpcion(o);
		}
		return result;
	}

	@Override
	protected String getFindIdSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getTableName() {
		return "preguntas";
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"id", "enunciado"};
	}

	@Override
	protected String[] getKeyColumnName() {
		return new String[] {"id"};
	}

	@Override
	protected Object[] serializeObject(Pregunta object) {
		return new Object[] {object.getId(), object.getEnunciado()};
	}

	@Override
	protected Object[] serializeKey(Integer key) {
		return new Object[] {key};
	}

	@Override
	protected Integer getKey(Pregunta object) {
		return object.getId();
	}
	
	protected List<Pregunta> getAll(Integer id){
		List<Pregunta> lista = new LinkedList<Pregunta>();
		String sql = "SELECT * FROM preguntas";
		Pregunta p;
		try(Connection con = this.ds.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {
		ResultSet rs = pst.executeQuery();
				 while (rs.next()) {
					 p = new Pregunta();
					 p.setId(rs.getInt("id"));
					 p.setEnunciado(rs.getString("enunciado"));
					 lista.add(p);
				 }
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return lista;
		
	}

	@Override
	protected void setKeyTransfer(Pregunta transfer, Integer key) {
		transfer.setId(key);
	}
}
