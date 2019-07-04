package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.Aluno;
import repository.RelatorioRepository;

public class RelatorioController {
	
	private RelatorioRepository repository;

	public RelatorioController() {
		this.repository = new RelatorioRepository();
	}

	public void RelatorioAluno(File relatorio) {
		gravarAluno(relatorio, this.repository.RelatorioAluno());
		
	}
		
     protected void gravarAluno(File arquivo, List<Aluno> alunos) {
		  
			try (FileWriter fw = new FileWriter(arquivo)){
				
				
				fw.write("Matricula;Nome;CPF responsavel;Telefone responsavel;Endereço;Email;Período;Cusando;Transporte Público\r\n");
				for (int i = 0; i < alunos.size(); i++) {
					
					Aluno aluno = null;
					aluno = alunos.get(i);
		
					
					fw.write(aluno.getMatricula() + ";" + aluno.getNome() + ";" + aluno.getCpf_resp() + ";" + aluno.getTelefone_resp() + ";" + aluno.getEndereco_aluno() + ";" + aluno.getEmail_aluno() + ";" + aluno.getPeriodo() + ";" +  aluno.getCursando() + ";" + aluno.getTransPublico() + ";" + "\r\n");
					
					
				}				
				fw.flush();
			} catch (IOException ex) {	
				// TODO: handle exception
			}
		
		};

}
