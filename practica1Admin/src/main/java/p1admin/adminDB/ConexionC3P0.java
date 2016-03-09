package p1admin.adminDB;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConexionC3P0 {

	DataSource ds;
	
	public ConexionC3P0() {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setJdbcUrl("jdbc:mysql://localhost/Practica_505");
		
		ds = cpds;
	}

	public DataSource getDs() {
		return ds;
	}

}
