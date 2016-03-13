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

public class OpcionMapper extends AbstractMapper<Opcion, Integer>{

	public OpcionMapper(DataSource ds) {
		super(ds);
	}

	@Override
	protected Opcion buildObject(ResultSet rs) throws SQLException {
		Opcion result = new Opcion();
		Integer numOrden = rs.getInt("numeroOrden");
		String texto = rs.getString("texto");
		result.setNumeroOrden(numOrden);
		result.setTexto(texto);
		for (int i = 0; i < result.getPreguntaMadre().getNumOpciones(); i++) {
			Pregunta p = new Pregunta();
			p.addOpcion(result);
			result.setPreguntaMadre(p);
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
		return "opciones";
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"id", "texto", "idPregunta", "num_pregunta"};
	}

	@Override
	protected String[] getKeyColumnName() {
		return new String[] {"id"};
	}

	@Override
	protected Object[] serializeObject(Opcion object) {
		return new Object[] {object.getIdOpcion(), object.getTexto() , object.getPreguntaMadre().getId(), object.getNumeroOrden()};
	}

	@Override
	protected Integer getKey(Opcion object) {
		return object.getIdOpcion();
	}

	@Override
	protected Object[] serializeKey(Integer key) {
		return new Object[] {key, };
	}

	@Override
	protected List<Opcion> getAll() {
		List<Opcion> lista = new LinkedList<Opcion>();
		String sql = "SELECT * FROM Respuestas WHERE idP=";
		Opcion o;
		try(Connection con = this.ds.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {
		ResultSet rs = pst.executeQuery();
				 while (rs.next()) {
					 o = new Opcion();
					 o.setNumeroOrden(rs.getInt("numeroOrden"));
					 o.setTexto(rs.getString("texto"));
					 lista.add(o);
				 }
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return lista;
	}

	@Override
	protected void setKeyTransfer(Opcion transfer) {
		try {
			transfer.setIdOpcion(new Integer(super.da.getLastKey().getInt("id")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
