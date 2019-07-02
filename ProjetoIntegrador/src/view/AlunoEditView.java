package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AlunoController;
import model.Aluno;

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
	private String cursando;
	private String periodo;
	private String transpp;
	private JTable table;

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
		setBounds(100, 100, 741, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPreenchaOsDados = new JLabel("Preencha todos os campos para atualizar corretamente.");
		lblPreenchaOsDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreenchaOsDados.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPreenchaOsDados.setBounds(116, 11, 517, 14);
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
		lblCursando.setBounds(381, 166, 78, 14);
		contentPane.add(lblCursando);
		
		txtCursando = new JTextField();
		txtCursando.setColumns(10);
		txtCursando.setBounds(469, 164, 222, 20);
		contentPane.add(txtCursando);
		
		JLabel lblPeríodo = new JLabel("Per\u00EDodo:");
		lblPeríodo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeríodo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPeríodo.setBounds(381, 141, 78, 14);
		contentPane.add(lblPeríodo);
		
		txtPeriodo = new JTextField();
		txtPeriodo.setColumns(10);
		txtPeriodo.setBounds(469, 139, 222, 20);
		contentPane.add(txtPeriodo);
		
		JLabel lblTransportePblico = new JLabel("Transp. p\u00FAblico:");
		lblTransportePblico.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTransportePblico.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTransportePblico.setBounds(361, 191, 98, 14);
		contentPane.add(lblTransportePblico);
		
		txtTranspp = new JTextField();
		txtTranspp.setColumns(10);
		txtTranspp.setBounds(469, 189, 222, 20);
		contentPane.add(txtTranspp);
		
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			AlunoEditView frame = new AlunoEditView();
			
			Aluno aluno = new Aluno();
			
			matricula = aluno.setMatricula(txtaMat.getText());
			nome = aluno.setNomeAluno(txtNomeAluno.getText());
			endereco = aluno.setEnderecoAluno(txtEndAluno.getText());
			email = aluno.setEmailAluno(txtEmailAluno.getText());
			cursando = aluno.setCursando(txtCursando.getText());
			periodo = aluno.setPeriodo(txtPeriodo.getText());
			transpp = aluno.setTranspPublico(txtTranspp.getText());
			
			AlunoController contr = new AlunoController();
			
			try {
				contr.alterar(aluno);					
				btnAlterar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						MessageSucess msgSucesso = new MessageSucess();
						msgSucesso.setVisible(true);
					}
				});
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				btnAlterar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						MessageError msgError = new MessageError();
						msgError.setVisible(true);
					}
				});
				e.printStackTrace();
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 300, 725, 45);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(240, 255, 240));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Matr\u00EDcula", "CPF respons.", "Fone respons.", "Nome", "Endere\u00E7o", "Email", "Per\u00EDodo", "Cursando", "Transp. p\u00FAblico"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnVer = new JButton("Ver altera\u00E7\u00F5es");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnVer.setBackground(new Color(240, 255, 240));
		btnVer.setBounds(576, 359, 139, 23);
		contentPane.add(btnVer);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(105, 105, 105));
		separator.setBackground(new Color(169, 169, 169));
		separator.setBounds(0, 287, 725, 2);
		contentPane.add(separator);
		

	}
}
