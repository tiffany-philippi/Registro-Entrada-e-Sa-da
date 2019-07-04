package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlunoController;
import controller.RegistroController;
import model.Aluno;
import model.Registro;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RegistroRemovView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String cod_pront;

	RegistroController regisControl = new RegistroController();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroRemovView frame = new RegistroRemovView();
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
	public RegistroRemovView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 401, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigoDoRegistro = new JLabel("C\u00F3digo do registro que ser\u00E1 exclu\u00EDdo:");
		lblCdigoDoRegistro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdigoDoRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdigoDoRegistro.setBounds(2, 26, 371, 20);
		contentPane.add(lblCdigoDoRegistro);
		
		JLabel lblCd = new JLabel("C\u00F3d.:");
		lblCd.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCd.setBounds(43, 100, 79, 21);
		contentPane.add(lblCd);
		
		textField = new JTextField();
		textField.setBounds(132, 101, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
				cod_pront = textField.getText();
				
				try {
					regisControl.excluir(cod_pront);
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
		btnRemover.setBounds(228, 100, 89, 23);
		contentPane.add(btnRemover);
		
		JButton btnVoltar = new JButton("Cancelar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(284, 170, 89, 23);
		contentPane.add(btnVoltar);
	}

}
