package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

	public static Connection getConexao() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost/escola?user=root&password=Alascag22");
	}
}


