package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import exception.RepositoryException;
import model.Passagem;
import model.Registro;

public class RegistroRepository {

	public void persistir(Registro registro) throws SQLException {
	
		String sql = "INSERT INTO prontuario VALUES (null, '"+ registro.getMatricula() + "','" + registro.getPassagem() + "','" + registro.getDatePront() + "','" + registro.getTimePront() + "');";
//		System.out.println(sql);
		try (Connection conn = ConexaoBD.getConexao()) {
			Statement stmtInsert = conn.createStatement();
			stmtInsert.executeUpdate(sql);
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
		String sql = "DELETE FROM prontuario WHERE cpd_pront = '" + codPront + "';";
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

