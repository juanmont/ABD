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

public class PreguntaMapper extends AbstractMapper<Pregunta, String>{
	
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
		return null;
	}

	@Override
	protected String getFindIdSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getTableName() {
		return "Preguntas";
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"id", "enunciado", "opciones"};
	}

	@Override
	protected String[] getKeyColumnName() {
		return new String[] {"id"};
	}

	@Override
	protected Object[] serializeObject(Pregunta object) {
		return new Object[] {object.getId(), object.getEnunciado(), object.getOpciones()};
	}

	@Override
	protected Object[] serializeKey(String key) {
		return new Object[] {key};
	}

	@Override
	protected String getKey(Pregunta object) {
		return String.valueOf(object.getId());
	}
	
	public List<Pregunta> getAllQuestions(){
		List<Pregunta> lista = new ArrayList<Pregunta>();
		String sql = "SELECT * FROM Preguntas";
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

}
