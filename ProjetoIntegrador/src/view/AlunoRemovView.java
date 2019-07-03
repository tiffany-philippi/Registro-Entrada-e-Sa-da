package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlunoController;
import model.Aluno;

import java.awt.TextArea;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AlunoRemovView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String matricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoRemovView frame = new AlunoRemovView();
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
	public AlunoRemovView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemoverAluno = new JLabel("Remover aluno");
		lblRemoverAluno.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoverAluno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRemoverAluno.setBounds(88, 43, 285, 23);
		contentPane.add(lblRemoverAluno);
		
		JLabel lblMat = new JLabel("Matr\u00EDcula:");
		lblMat.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMat.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMat.setBounds(10, 116, 113, 14);
		contentPane.add(lblMat);
		
		textField = new JTextField();
		textField.setBounds(133, 113, 224, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(209, 198, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnRemover = new JButton("Remover");		
		btnRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				AlunoRemovView frame = new AlunoRemovView();
				matricula = textField.getText();
				AlunoController contr = new AlunoController();
				
				try {
					contr.excluir(matricula);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}					
				btnRemover.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						MessageSucess msgSucesso = new MessageSucess();							
						msgSucesso.setVisible(true);
					}
				});	
			}
		});
		
		
		btnRemover.setBounds(308, 198, 89, 23);
		contentPane.add(btnRemover);
	}
}
