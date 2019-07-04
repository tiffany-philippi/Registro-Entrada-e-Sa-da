package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.AlunoController;
import model.Aluno;
import model.Periodo;
import model.SimNao;

public class AlunoEditView extends JFrame {

	private JPanel contentPane;
	private JTextField txtaMat;
	private JTextField txtNomeAluno;
	private JTextField txtEndAluno;
	private JTextField txtEmailAluno;
	private JTextField txtCursando;
	private JTextField txtTranspp;
	private JTextField txtPeriodo;
	
	private String matricula;
	private String cpfResp;
	private String foneResp;
	private String nome;
	private String endereco;
	private String email;
	private SimNao cursando;
	private Periodo periodo;
	private SimNao transpp;
	

	AlunoController alunoControl = new AlunoController();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoEditView frame = new AlunoEditView();
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
	public AlunoEditView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 748, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblPreenchaOsDados = new JLabel("Preencha todos os campos para atualizar corretamente.");
		lblPreenchaOsDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreenchaOsDados.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPreenchaOsDados.setBounds(96, 11, 517, 14);
		contentPane.add(lblPreenchaOsDados);
				
		JLabel lblCpf = new JLabel("Matr\u00EDcula:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(10, 60, 98, 14);
		contentPane.add(lblCpf);
		
		txtaMat = new JTextField();
		txtaMat.setBounds(118, 58, 222, 20);
		contentPane.add(txtaMat);
		txtaMat.setColumns(10);
		
		JLabel lblAviso = new JLabel("AVISO: O campo matr\u00EDcula deve permacener igual ao atual, n\u00E3o podendo ser alterado.");
		lblAviso.setForeground(new Color(165, 42, 42));
		lblAviso.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblAviso.setBounds(116, 81, 494, 23);
		contentPane.add(lblAviso);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(21, 143, 88, 14);
		contentPane.add(lblNome);
		
		txtNomeAluno = new JTextField();
		txtNomeAluno.setColumns(10);
		txtNomeAluno.setBounds(119, 141, 222, 20);
		contentPane.add(txtNomeAluno);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndereo.setBounds(11, 168, 98, 14);
		contentPane.add(lblEndereo);
		
		txtEndAluno = new JTextField();
		txtEndAluno.setColumns(10);
		txtEndAluno.setBounds(119, 166, 222, 20);
		contentPane.add(txtEndAluno);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(31, 193, 78, 14);
		contentPane.add(lblEmail);
		
		txtEmailAluno = new JTextField();
		txtEmailAluno.setColumns(10);
		txtEmailAluno.setBounds(119, 191, 222, 20);
		contentPane.add(txtEmailAluno);
		
		JLabel lblCursando = new JLabel("Cursando:");
		lblCursando.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCursando.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCursando.setBounds(527, 164, 78, 14);
		contentPane.add(lblCursando);
		
		JComboBox cbCursando = new JComboBox();
		cbCursando.setModel(new DefaultComboBoxModel(SimNao.values()));
		cbCursando.setBounds(615, 161, 78, 23);
		contentPane.add(cbCursando);
		
		JLabel lblPerodo = new JLabel("Per\u00EDodo:");
		lblPerodo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerodo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPerodo.setBounds(527, 139, 78, 14);
		contentPane.add(lblPerodo);
		
		JComboBox cbPeriodo = new JComboBox();
		cbPeriodo.setModel(new DefaultComboBoxModel(Periodo.values()));
		cbPeriodo.setBounds(615, 136, 78, 23);
		contentPane.add(cbPeriodo);
		
		JLabel lblTransportePblico = new JLabel("Transp. p\u00FAblico:");
		lblTransportePblico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTransportePblico.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTransportePblico.setBounds(507, 189, 98, 14);
		contentPane.add(lblTransportePblico);
		
		JComboBox cbTransp = new JComboBox();
		cbTransp.setModel(new DefaultComboBoxModel(SimNao.values()));
		cbTransp.setBounds(615, 186, 78, 23);
		contentPane.add(cbTransp);
	
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
			Aluno aluno = new Aluno(matricula, cpfResp, foneResp, nome, endereco, email, periodo, cursando, transpp);
			
			matricula = txtaMat.getText();
			nome = txtNomeAluno.getText();
			endereco = txtEndAluno.getText();
			email = txtEmailAluno.getText();
			cursando = (SimNao) cbCursando.getSelectedItem();
			periodo = (Periodo) cbPeriodo.getSelectedItem();
			transpp = (SimNao) cbTransp.getSelectedItem();
			
			
			try {
				alunoControl.atualizar(aluno);				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				MessageError msgError = new MessageError();
				msgError.setVisible(true);
			}
		}
			
		});		
	
		btnAlterar.setBounds(606, 243, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(507, 243, 89, 23);
		contentPane.add(btnVoltar);
		
	
	}

}
