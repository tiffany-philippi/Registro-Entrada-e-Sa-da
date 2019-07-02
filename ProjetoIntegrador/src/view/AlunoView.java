package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlunoView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoView frame = new AlunoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AlunoView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlunoConsultView alunoConsult = new AlunoConsultView();
				alunoConsult.setVisible(true);
			}
		});
		btnConsultar.setBounds(165, 60, 89, 23);
		contentPane.add(btnConsultar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlunoEditView alunoEdit = new AlunoEditView();
				alunoEdit.setVisible(true);
			}
		});
		btnEditar.setBounds(165, 94, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlunoRemovView alunoRemov = new AlunoRemovView();
				alunoRemov.setVisible(true);
			}
		});
		btnRemover.setBounds(165, 129, 89, 23);
		contentPane.add(btnRemover);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroAlunoView alunoInserir = new CadastroAlunoView();
				alunoInserir.setVisible(true);
			}
		});
		btnNewButton.setBounds(165, 163, 89, 23);
		contentPane.add(btnNewButton);
	}

}
