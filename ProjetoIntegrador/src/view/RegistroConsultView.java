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
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.RegistroController;
import model.Registro;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class RegistroConsultView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCod;
	private final JSeparator separator = new JSeparator();
	private JTable table;
	
	private String cod;
	
	RegistroController registroControl = new RegistroController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroConsultView frame = new RegistroConsultView();
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
	public RegistroConsultView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 447, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane); 
		contentPane.setLayout(null);
		
		JLabel lblInsiraOCdigo = new JLabel("Insira a matr\u00EDcula do aluno");
		lblInsiraOCdigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInsiraOCdigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOCdigo.setBounds(99, 11, 249, 37);
		contentPane.add(lblInsiraOCdigo);
		
		JLabel lblCd = new JLabel("Matricula:");
		lblCd.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCd.setBounds(39, 62, 89, 14);
		contentPane.add(lblCd);
		
		txtCod = new JTextField();
		txtCod.setBounds(132, 60, 117, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				cod = txtCod.getText();				
				Registro reg = null;
				
				try {
					reg = registroControl.consultar(cod);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					MessageError msgError = new MessageError();
					msgError.setVisible(true);

				}

				if (reg != null) {
					table.setModel(new DefaultTableModel(
							new Object[][] {
								{reg.getCodPront(), reg.getMatricula(), reg.getPassagem(), reg.getDatePront(), reg.getTimePront()},
							},
							new String[] {
									"Cod.", "Matricula", "Passagem", "Data", "Hora"
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
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 119, 414, 48);
        contentPane.add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
               new Object[][] {
                     {null, null, null, null, null},
               },
               new String[] {
                     "Cod.", "Matricula", "Passagem", "Data", "Hora"
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
		btnConsultar.setBounds(259, 59, 89, 23);
		contentPane.add(btnConsultar);
		separator.setBounds(0, 106, 434, 2);
		contentPane.add(separator);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(335, 241, 89, 23);
		contentPane.add(btnVoltar);
		
		
	}
}
