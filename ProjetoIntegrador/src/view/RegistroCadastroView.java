package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.RegistroController;
import controller.ResponsavelController;
import model.Passagem;
import model.Registro;
import model.Responsavel;
import model.SimNao;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;

public class RegistroCadastroView extends JFrame {

	private JPanel contentPane;
	private JTextField txtMat;

	private String matricula;
	private Passagem passagem;
	private String data;
	private String hora;
	
	RegistroController registroControl = new RegistroController();
	
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
		
		JComboBox cbPass = new JComboBox();
		cbPass.setModel(new DefaultComboBoxModel(Passagem.values()));
		cbPass.setBounds(105, 118, 166, 20);
		contentPane.add(cbPass);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setBounds(282, 94, 68, 14);
		contentPane.add(lblData);		
		
		JFormattedTextField txtData = new JFormattedTextField();
		txtData.setBounds(360, 92, 139, 20);
		contentPane.add(txtData);
		
		try {
			// CRIA A MASCARA
			MaskFormatter mask = new MaskFormatter("##/##/####");
			// INSTALA A MASCARA NO CAMPO "txtData"
			mask.install(txtData);
		} catch (Exception excecao) {
			excecao.printStackTrace();
		}
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHora.setBounds(282, 121, 68, 14);
		contentPane.add(lblHora);
		
		
		JFormattedTextField txtHora = new JFormattedTextField();
		txtHora.setBounds(360, 119, 139, 20);
		contentPane.add(txtHora);
		
		try {
			// CRIA A MASCARA
			MaskFormatter mask = new MaskFormatter("##:##:##");
			// INSTALA A MASCARA NO CAMPO "txtHora"
			mask.install(txtHora);
		} catch (Exception excecao) {
			excecao.printStackTrace();
		}
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				matricula = txtMat.getText();
				passagem = (Passagem) cbPass.getSelectedItem();
				data = txtData.getText();
				hora = txtHora.getText();
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate date = LocalDate.parse(data, formatter);
				
				DateTimeFormatter horaformatter = DateTimeFormatter.ofPattern("HH:mm:ss");
				LocalTime time = LocalTime.parse(hora, horaformatter);
				
				Registro reg = new Registro(matricula, passagem, date, time);
				
				
				try {
					registroControl.persistir(reg);					
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
}
