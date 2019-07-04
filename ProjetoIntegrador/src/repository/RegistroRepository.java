package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exception.RepositoryException;
import model.Passagem;
import model.Registro;

public class RegistroRepository {

	// CODIGO Ti
	/* public void persistir(Registro registro) throws SQLException {
		
		
	
		String sql = "INSERT INTO prontuario VALUES (null, '"+ registro.getMatricula() + "','" + registro.getPassagem() + "','" + 
		java.sql.Date.valueOf(registro.getDatePront()) + "','" + java.sql.Time.valueOf(registro.getTimePront()) + "');";
		
		
//		System.out.println(sql);
		try (Connection conn = ConexaoBD.getConexao()) {
			Statement stmtInsert = conn.createStatement();
			stmtInsert.executeUpdate(sql);
			System.out.println("Registro inserido.");
		} catch (SQLException e) {
			throw new RepositoryException(e);
		}
	} */
	
	public void persistir(Registro registro) throws SQLException {
		
		
		String prontSql = "INSERT INTO prontuario " + "(matricula, passagem, data_pront, time_pront)"
				+ "VALUES (?, ?, ?, ?)";
		
		try (Connection conn = ConexaoBD.getConexao()) {
			
			PreparedStatement stmtInsert = conn.prepareStatement(prontSql);
		
			stmtInsert.setString(1, registro.getMatricula());
			stmtInsert.setString(2, registro.getPassagem().toString());
			stmtInsert.setDate(3, java.sql.Date.valueOf(registro.getDatePront()));
			stmtInsert.setTime(4, java.sql.Time.valueOf(registro.getTimePront()));
			
			
			stmtInsert.executeUpdate();
			
			System.out.println("Registro inserido.");
		} catch (SQLException e) {
			throw new RepositoryException(e);
		}
	}
	
	public Registro consultar(String matricula) {
		Statement stmt = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM prontuario WHERE matricula = " + matricula + ";";
		Registro reg = null;
		
		try (Connection conn = ConexaoBD.getConexao()) {
		stmt = conn.createStatement();
		resultSet = stmt.executeQuery(sql);
		
		int codPront = 0;
		Passagem passagem = null;
		String dataPront = null;
		String timePront = null;
		
			while(resultSet.next()) {
				codPront = Integer.parseInt(resultSet.getString("cod_pront"));
				matricula = resultSet.getString("matricula");
				passagem = Passagem.valueOf(resultSet.getString("passagem"));
				dataPront = resultSet.getString("data_pront");
				timePront = resultSet.getString("time_pront");
				
				reg = new Registro(codPront, matricula, passagem, dataPront, timePront);
			}
		}
				catch (SQLException e) {
					throw new RepositoryException(e);
		}
		return reg;
	} 
	
	
	
	public void remover(String codPront) throws SQLException {
		String sql = "DELETE FROM prontuario WHERE cod_pront = '" + codPront + "';";
		Statement stmtUpdate;
		try (Connection conn = ConexaoBD.getConexao()){
			stmtUpdate = conn.createStatement();
			stmtUpdate.executeUpdate(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}

