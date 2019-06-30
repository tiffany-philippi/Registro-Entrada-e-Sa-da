package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JProgressBar;

public class CadastroAlunoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtaMat;
	private JTextField txtNomeAluno;
	private JTextField txtEndAluno;
	private JTextField txtEmailAluno;
	private JTextField txtCursando;
	private JTextField txtTranspp;
	private JTextField txtPeriodo;
	private JTextField txtcpfResp;
	private JTextField txtFoneResp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAlunoView frame = new CadastroAlunoView();
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
	public CadastroAlunoView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 727, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPreenchaOsDados = new JLabel("Preencha os dados do aluno:");
		lblPreenchaOsDados.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPreenchaOsDados.setBounds(134, 21, 216, 14);
		contentPane.add(lblPreenchaOsDados);
				
		JLabel lblCpf = new JLabel("Matr\u00EDcula:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(20, 58, 98, 14);
		contentPane.add(lblCpf);
		
		txtTranspp = new JTextField();
		txtTranspp.setColumns(10);
		txtTranspp.setBounds(128, 206, 222, 20);
		contentPane.add(txtTranspp);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(30, 83, 88, 14);
		contentPane.add(lblNome);
		
		txtPeriodo = new JTextField();
		txtPeriodo.setColumns(10);
		txtPeriodo.setBounds(128, 156, 222, 20);
		contentPane.add(txtPeriodo);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndereo.setBounds(20, 108, 98, 14);
		contentPane.add(lblEndereo);
		
		txtNomeAluno = new JTextField();
		txtNomeAluno.setColumns(10);
		txtNomeAluno.setBounds(128, 81, 222, 20);
		contentPane.add(txtNomeAluno);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(40, 133, 78, 14);
		contentPane.add(lblEmail);
		
		txtaMat = new JTextField();
		txtaMat.setBounds(128, 56, 222, 20);
		contentPane.add(txtaMat);
		txtaMat.setColumns(10);
		
		JLabel lblCursando = new JLabel("Cursando:");
		lblCursando.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCursando.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCursando.setBounds(40, 183, 78, 14);
		contentPane.add(lblCursando);
		
		txtEmailAluno = new JTextField();
		txtEmailAluno.setColumns(10);
		txtEmailAluno.setBounds(128, 131, 222, 20);
		contentPane.add(txtEmailAluno);
		
		JLabel lblPerodo = new JLabel("Per\u00EDodo:");
		lblPerodo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerodo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPerodo.setBounds(40, 158, 78, 14);
		contentPane.add(lblPerodo);
		
		txtEndAluno = new JTextField();
		txtEndAluno.setColumns(10);
		txtEndAluno.setBounds(128, 106, 222, 20);
		contentPane.add(txtEndAluno);
		
		JLabel lblTransportePblico = new JLabel("Transp. p\u00FAblico:");
		lblTransportePblico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTransportePblico.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTransportePblico.setBounds(20, 208, 98, 14);
		contentPane.add(lblTransportePblico);
		
		txtCursando = new JTextField();
		txtCursando.setColumns(10);
		txtCursando.setBounds(128, 181, 222, 20);
		contentPane.add(txtCursando);
		
		JLabel lblPreenchaOsDados_1 = new JLabel("Preencha os dados do respons\u00E1vel:");
		lblPreenchaOsDados_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPreenchaOsDados_1.setBounds(445, 95, 243, 14);
		contentPane.add(lblPreenchaOsDados_1);
		
		JLabel lblCpf_1 = new JLabel("CPF:");
		lblCpf_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf_1.setBounds(348, 129, 98, 14);
		contentPane.add(lblCpf_1);
		
		txtcpfResp = new JTextField();
		txtcpfResp.setColumns(10);
		txtcpfResp.setBounds(456, 127, 222, 20);
		contentPane.add(txtcpfResp);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefone.setBounds(360, 152, 88, 14);
		contentPane.add(lblTelefone);
		
		txtFoneResp = new JTextField();
		txtFoneResp.setColumns(10);
		txtFoneResp.setBounds(456, 152, 222, 20);
		contentPane.add(txtFoneResp);
		
		
		JButton btnInserir = new JButton("Inserir");
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
