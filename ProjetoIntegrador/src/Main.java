import java.sql.SQLException;

import controller.ResponsavelController;
import model.Responsavel;
import repository.ConexaoBD;

public class Main {

	public static void main(String[] args0) throws SQLException {
		//executarAluno();
	//	executarResponsavel();
		ConexaoBD.getConexao();
	}
	
	protected static void executarResponsavel() throws SQLException {
		//criar o objeto Responsável
		Responsavel pai = new Responsavel();
		ResponsavelController controller = new ResponsavelController();
		controller.persistir(pai);
	}
	
	protected static void executarAluno() {
		
	}
}
