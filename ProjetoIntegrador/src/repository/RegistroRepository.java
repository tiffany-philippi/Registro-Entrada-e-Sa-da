package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import exception.RepositoryException;
import model.Registro;

public class RegistroRepository {

	public void persistir(Registro registro) throws SQLException {
		String sql = "INSERT INTO prontuario VALUES ('null, '"+ registro.getMatricula() + "','" + registro.getPassagem() + "','" + registro.getDataPront() + "','" + registro.getTimePront() + "');";
//		System.out.println(sql);
		try (Connection conn = ConexaoBD.getConexao()) {
			Statement stmtInsert = conn.createStatement();
			stmtInsert.executeUpdate(sql);
			System.out.println("Registro inserido.");
		} catch (SQLException e) {
			throw new RepositoryException(e);
		}
	}
	
	public Registro consultar(String matcons) {
		Statement stmt = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM prontuario WHERE matricula = '" + matcons + "';";
		Registro reg = null;
		
		try (Connection conn = ConexaoBD.getConexao()) {
		stmt = conn.createStatement();
		resultSet = stmt.executeQuery(sql);
		
		String codPront = null;
		String matricula = null;
		String passagem = null;
		Date dataPront = null;
		Time timePront = null;
		
			while(resultSet.next()) {
				codPront = resultSet.getString("cod_pront");
				matricula = resultSet.getString("matricula");
				passagem = resultSet.getString("passagem");
				dataPront = resultSet.getDate("date_pront");
				timePront = resultSet.getTime("time_pront");

				reg = new Registro();
				System.out.println("Código: " + codPront + "\nMatrícula: " + matricula + 
						"\nTipo de passagem: " + passagem + "\nData: " + dataPront 
						+ "\nHora: " + timePront +"\n");
			}
			
		} catch (SQLException e) {
			throw new RepositoryException(e);
		}
		return reg;
	}
	
	public void remover(String matremov) throws SQLException {
		String sql = "DELETE FROM prontuario WHERE matricula = '" + matremov + "';";
		Statement stmtUpdate;
		try (Connection conn = ConexaoBD.getConexao()){
			stmtUpdate = conn.createStatement();
			stmtUpdate.executeUpdate(sql);
			System.out.println("Registro excluído.");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
