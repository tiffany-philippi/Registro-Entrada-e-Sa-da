package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.AlunoController;
import controller.ResponsavelController;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import model.SimNao;
import model.Aluno;
import model.Periodo;
import model.Responsavel;

public class AlunoInsertView extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtaMat;
	private JTextField txtNomeAluno;
	private JTextField txtEndAluno;
	private JTextField txtEmailAluno;
	private JTextField txtcpfResp;
	
	private String matricula;
	private String cpfResp;
	private String foneResp;
	private String nome;
	private String endereco;
	private String email;
	private SimNao cursando;
	private Periodo periodo;
	private SimNao transpp;
	
	ResponsavelController respControl = new ResponsavelController(); // Controller responsável pelas interações de Responsável 
	AlunoController alunoControl = new AlunoController(); // Controller responsável pelas interações de Aluno 
	private JTextField txtFone;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoInsertView frame = new AlunoInsertView();
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
	public AlunoInsertView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 727, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPreenchaOsDados = new JLabel("Preencha os dados do aluno:");
		lblPreenchaOsDados.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPreenchaOsDados.setBounds(267, 92, 216, 14);
		contentPane.add(lblPreenchaOsDados);
				
		JLabel lblMat = new JLabel("Matr\u00EDcula:");
		lblMat.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMat.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMat.setBounds(20, 137, 98, 14);
		contentPane.add(lblMat);
		
		txtaMat = new JTextField();
		txtaMat.setBounds(128, 135, 222, 20);
		contentPane.add(txtaMat);
		txtaMat.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(30, 162, 88, 14);
		contentPane.add(lblNome);
		
		txtNomeAluno = new JTextField();
		txtNomeAluno.setColumns(10);
		txtNomeAluno.setBounds(128, 160, 222, 20);
		contentPane.add(txtNomeAluno);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndereo.setBounds(20, 187, 98, 14);
		contentPane.add(lblEndereo);
		
		txtEndAluno = new JTextField();
		txtEndAluno.setColumns(10);
		txtEndAluno.setBounds(128, 185, 222, 20);
		contentPane.add(txtEndAluno);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(40, 212, 78, 14);
		contentPane.add(lblEmail);
		
		txtEmailAluno = new JTextField();
		txtEmailAluno.setColumns(10);
		txtEmailAluno.setBounds(128, 210, 222, 20);
		contentPane.add(txtEmailAluno);
		
		JLabel lblCursando = new JLabel("Cursando:");
		lblCursando.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCursando.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCursando.setBounds(460, 165, 78, 14);
		contentPane.add(lblCursando);
		
		JComboBox cbCursando = new JComboBox();
		cbCursando.setModel(new DefaultComboBoxModel(SimNao.values()));
		cbCursando.setBounds(548, 162, 78, 23);
		contentPane.add(cbCursando);
		
		JLabel lblPerodo = new JLabel("Per\u00EDodo:");
		lblPerodo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerodo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPerodo.setBounds(460, 140, 78, 14);
		contentPane.add(lblPerodo);
		
		JComboBox cbPeriodo = new JComboBox();
		cbPeriodo.setModel(new DefaultComboBoxModel(Periodo.values()));
		cbPeriodo.setBounds(548, 137, 78, 23);
		contentPane.add(cbPeriodo);
		
		JLabel lblTransportePblico = new JLabel("Transp. p\u00FAblico:");
		lblTransportePblico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTransportePblico.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTransportePblico.setBounds(440, 190, 98, 14);
		contentPane.add(lblTransportePblico);
		
		JComboBox cbTransp = new JComboBox();
		cbTransp.setModel(new DefaultComboBoxModel(SimNao.values()));
		cbTransp.setBounds(548, 187, 78, 23);
		contentPane.add(cbTransp);
		
		JLabel lblPreenchaOsDados_1 = new JLabel("Preencha os dados do respons\u00E1vel:");
		lblPreenchaOsDados_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPreenchaOsDados_1.setBounds(240, 11, 243, 14);
		contentPane.add(lblPreenchaOsDados_1);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setBounds(10, 52, 98, 14);
		contentPane.add(lblCpf);
		
		txtcpfResp = new JTextField();
		txtcpfResp.setColumns(10);
		txtcpfResp.setBounds(118, 50, 222, 20);
		contentPane.add(txtcpfResp);
		

		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			AlunoInsertView frame = new AlunoInsertView();
			
//			Responsavel busca_responsavel = respControl.consultar(cpfResp);
//			foneResp = busca_responsavel.getFoneResp();
			
			matricula = txtaMat.getText();
			cpfResp = txtcpfResp.getText();
			foneResp = txtFone.getText();
			nome = txtNomeAluno.getText();
			endereco = txtEndAluno.getText();
			email = txtEmailAluno.getText();
			cursando = (SimNao) cbCursando.getSelectedItem();
			periodo = (Periodo) cbPeriodo.getSelectedItem();
			transpp = (SimNao) cbTransp.getSelectedItem();


			Aluno aluno = new Aluno(matricula, cpfResp, foneResp, nome, endereco, email, periodo, cursando, transpp);
			
			try {
				alunoControl.persistir(aluno);					
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
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefone.setBounds(337, 54, 98, 14);
		contentPane.add(lblTelefone);
		
		txtFone = new JTextField();
		txtFone.setColumns(10);
		txtFone.setBounds(445, 50, 222, 20);
		contentPane.add(txtFone);
		btnInserir.setBounds(602, 245, 89, 23);
		contentPane.add(btnInserir);
		
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
