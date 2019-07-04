package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.ResponsavelController;
import model.Responsavel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class RespCadastroView extends JFrame {

	private JPanel contentPane;
	private JTextField txtnomeResp;
	private JTextField txtFoneResp;
	private JTextField txtEmailResp;
	private JTextField txtEndResp;
	private JTextField txtcpfResp;
	
	private String cpfResp;
	private String nomeResp;
	private String telefoneResp;
	private String enderecoResp;
	private String emailResp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RespCadastroView frame = new RespCadastroView();
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
	public RespCadastroView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPreenchaTodosOs = new JLabel("Preencha todos os campos");
		lblPreenchaTodosOs.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPreenchaTodosOs.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreenchaTodosOs.setBounds(85, 11, 279, 14);
		contentPane.add(lblPreenchaTodosOs);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(62, 55, 46, 14);
		contentPane.add(lblCpf);
		
		txtcpfResp = new JTextField();
		txtcpfResp.setColumns(10);
		txtcpfResp.setBounds(118, 53, 222, 20);
		contentPane.add(txtcpfResp);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(62, 80, 46, 14);
		contentPane.add(lblNome);
		
		txtnomeResp = new JTextField();
		txtnomeResp.setColumns(10);
		txtnomeResp.setBounds(118, 78, 222, 20);
		contentPane.add(txtnomeResp);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndereo.setBounds(10, 105, 98, 14);
		contentPane.add(lblEndereo);
		
		txtEndResp = new JTextField();
		txtEndResp.setColumns(10);
		txtEndResp.setBounds(118, 103, 222, 20);
		contentPane.add(txtEndResp);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefone.setBounds(20, 130, 88, 14);
		contentPane.add(lblTelefone);
		
		txtFoneResp = new JTextField();
		txtFoneResp.setColumns(10);
		txtFoneResp.setBounds(118, 128, 222, 20);
		contentPane.add(txtFoneResp);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(30, 155, 78, 14);
		contentPane.add(lblEmail);
		
		txtEmailResp = new JTextField();
		txtEmailResp.setColumns(10);
		txtEmailResp.setBounds(118, 153, 222, 20);
		contentPane.add(txtEmailResp);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(133, 209, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnInserir = new JButton("Inserir");	
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				cpfResp = txtcpfResp.getText();
				nomeResp = txtnomeResp.getText();
				telefoneResp = txtFoneResp.getText();
				enderecoResp = txtEndResp.getText();
				emailResp = txtEmailResp.getText();
	
				Responsavel resp = new Responsavel(cpfResp, nomeResp, telefoneResp, enderecoResp, emailResp);
				ResponsavelController contr = new ResponsavelController();
				try {
					contr.persistir(resp);					
					btnInserir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
							MessageSucess msgSucesso = new MessageSucess();
							
							msgSucesso.setVisible(true);
						}
					});
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					btnInserir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
							MessageError msgError = new MessageError();
							
							msgError.setVisible(true);
						}
					});
					e.printStackTrace();
				}			
			}
		});
		
		btnInserir.setBounds(232, 209, 89, 23);
		contentPane.add(btnInserir);
	
	}
}
