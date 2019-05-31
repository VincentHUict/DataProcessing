package dao_1_op_veel_relatie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleBaseDao {
	protected Connection getConnection() throws SQLException {
			Connection myConn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "OVCHIPKAART", "ovchipkaart");
	    return myConn;
	}
	
	public void closeConnection() throws SQLException {
		Connection myConn = getConnection();
		myConn .close();
	}
}