package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.RegistroController;
import controller.ResponsavelController;
import model.Registro;
import model.Responsavel;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RegistroCadastroView extends JFrame {

	private JPanel contentPane;
	private JTextField txtMat;
	private JTextField txtPass;
	private JTextField txtDate;
	private JTextField txtTime;

	private String matricula;
	private String passagem;
	private String data;
	private String hora;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroCadastroView frame = new RegistroCadastroView();
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
	public RegistroCadastroView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 568, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPreenchaOsCampos = new JLabel("Preencha os campos para registrar:");
		lblPreenchaOsCampos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPreenchaOsCampos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreenchaOsCampos.setBounds(124, 11, 315, 31);
		contentPane.add(lblPreenchaOsCampos);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula:");
		lblMatrcula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMatrcula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMatrcula.setBounds(31, 94, 68, 14);
		contentPane.add(lblMatrcula);
		
		txtMat = new JTextField();
		txtMat.setBounds(105, 92, 166, 20);
		contentPane.add(txtMat);
		txtMat.setColumns(10);
		
		JLabel lblPassagem = new JLabel("Passagem:");
		lblPassagem.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassagem.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassagem.setBounds(31, 121, 68, 14);
		contentPane.add(lblPassagem);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(105, 119, 166, 20);
		contentPane.add(txtPass);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setBounds(282, 94, 68, 14);
		contentPane.add(lblData);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(356, 92, 166, 20);
		contentPane.add(txtDate);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHora.setBounds(282, 121, 68, 14);
		contentPane.add(lblHora);
		
		txtTime = new JTextField();
		txtTime.setColumns(10);
		txtTime.setBounds(356, 119, 166, 20);
		contentPane.add(txtTime);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				RegistroCadastroView frame = new RegistroCadastroView();

				Registro reg = new Registro();
				
				matricula = reg.setMatricula(txtMat.getText());
				passagem = reg.setPassagem(txtPass.getText());
				data = reg.setDataPront(txtDate.getText());
				hora = reg.setTimePront(txtTime.getText());
				
				RegistroController contr = new RegistroController();
				
				try {
					contr.persistir(reg);					
					btnRegistrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							MessageSucess msgSucesso = new MessageSucess();
							msgSucesso.setVisible(true);
						}
					});
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					btnRegistrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							MessageError msgError = new MessageError();
							msgError.setVisible(true);
						}
					});
					e.printStackTrace();
				}			
			}
		});
		btnRegistrar.setBounds(453, 173, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(356, 173, 89, 23);
		contentPane.add(btnCancelar);
	}
	//14 2014101005 SAÍDA 2014-12-03 0:15:00
}
