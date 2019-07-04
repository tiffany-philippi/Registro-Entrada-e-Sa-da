package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ResponsavelController;
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
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class RespEditView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpf;
	private JTextField txtNomeResp;
	private JTextField txtEndResp;
	private JTextField txtEmailResp;
	private JTextField txtFoneResp;
	
	private String cpfResp;
	private String foneResp;
	private String nomeResp;
	private String enderecoResp;
	private String emailResp;


	ResponsavelController responsContr = new ResponsavelController();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RespEditView frame = new RespEditView();
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
	public RespEditView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 738, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPreenchaOsDados = new JLabel("Preencha todos os campos para atualizar corretamente.");
		lblPreenchaOsDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreenchaOsDados.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPreenchaOsDados.setBounds(116, 26, 517, 14);
		contentPane.add(lblPreenchaOsDados);
				
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(10, 73, 98, 14);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(118, 71, 222, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblAviso = new JLabel("AVISO: O campo CPF deve permacener igual ao atual, n\u00E3o podendo ser alterado.");
		lblAviso.setForeground(new Color(165, 42, 42));
		lblAviso.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblAviso.setBounds(116, 91, 494, 23);
		contentPane.add(lblAviso);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(22, 158, 88, 14);
		contentPane.add(lblNome);
		
		txtNomeResp = new JTextField();
		txtNomeResp.setColumns(10);
		txtNomeResp.setBounds(118, 156, 222, 20);
		contentPane.add(txtNomeResp);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndereo.setBounds(350, 160, 98, 14);
		contentPane.add(lblEndereo);
		
		txtEndResp = new JTextField();
		txtEndResp.setColumns(10);
		txtEndResp.setBounds(458, 158, 222, 20);
		contentPane.add(txtEndResp);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(370, 185, 78, 14);
		contentPane.add(lblEmail);
		
		txtEmailResp = new JTextField();
		txtEmailResp.setColumns(10);
		txtEmailResp.setBounds(458, 183, 222, 20);
		contentPane.add(txtEmailResp);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefone.setBounds(34, 185, 78, 14);
		contentPane.add(lblTelefone);
		
		txtFoneResp = new JTextField();
		txtFoneResp.setColumns(10);
		txtFoneResp.setBounds(118, 183, 222, 20);
		contentPane.add(txtFoneResp);
		
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
			Responsavel resp = new Responsavel(cpfResp, nomeResp, enderecoResp, foneResp, emailResp);
			
			cpfResp = txtCpf.getText();
			nomeResp = txtNomeResp.getText();
			enderecoResp = txtEndResp.getText();
			emailResp = txtEmailResp.getText();
			foneResp = txtFoneResp.getText();
			
			
			try {
				responsContr.atualizar(resp);					
				MessageSucess msgSucesso = new MessageSucess();
				msgSucesso.setVisible(true);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				MessageError msgError = new MessageError();
				msgError.setVisible(true);
					
			}
			}
		});		
	
		btnAlterar.setBounds(602, 245, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(503, 245, 89, 23);
		contentPane.add(btnVoltar);
		

	}
}
