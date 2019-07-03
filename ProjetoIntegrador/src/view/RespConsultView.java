package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ResponsavelController;
import model.Responsavel;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RespConsultView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpf;
	private JTable table;
	private String cpf;
	
	ResponsavelController respControl = new ResponsavelController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RespConsultView frame = new RespConsultView();
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
	public RespConsultView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 618, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTXT = new JLabel("Preencha o campo com o CPF do respons\u00E1vel que deseja consultar");
		lblTXT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTXT.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTXT.setBounds(42, 21, 514, 14);
		contentPane.add(lblTXT);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(104, 63, 46, 14);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(160, 58, 244, 26);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 175, 582, 43);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"CPF", "Nome", "Endere\u00E7o", "Telefone", "Email"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				cpf = txtCpf.getText();
				Responsavel resp = null;
				try {
					resp = respControl.consultar(cpf);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					MessageError msgError = new MessageError();
					msgError.setVisible(true);

				}

				if (resp != null) {
					table.setModel(new DefaultTableModel(
							new Object[][] {
								{resp.getCPFResp(), resp.getNomeResp(), resp.getEndereco(), resp.getFoneResp(), resp.getEmail()},
							},
							new String[] {
								"CPF", "Nome", "Endere\u00E7o", "Telefone", "Email"
							}
						) {
							boolean[] columnEditables = new boolean[] {
								false, false, false, false, false
							};
							public boolean isCellEditable(int row, int column) {
								return columnEditables[column];
							}
						});
				} else {
					
				}
			}
		});
		btnConsultar.setBounds(414, 60, 89, 23);
		contentPane.add(btnConsultar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 148, 602, 2);
		contentPane.add(separator);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(503, 232, 89, 23);
		contentPane.add(btnVoltar);
	}
}
