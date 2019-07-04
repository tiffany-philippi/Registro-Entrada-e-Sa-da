package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ResponsavelController;
import model.Responsavel;

import java.awt.TextArea;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RespRemoverView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String cpfResp;
	
	ResponsavelController respControl = new ResponsavelController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RespRemoverView frame = new RespRemoverView();
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
	public RespRemoverView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemoverResponsvel = new JLabel("Remover respons\u00E1vel");
		lblRemoverResponsvel.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoverResponsvel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRemoverResponsvel.setBounds(88, 43, 285, 23);
		contentPane.add(lblRemoverResponsvel);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(77, 116, 46, 14);
		contentPane.add(lblCpf);
		
		textField = new JTextField();
		textField.setBounds(133, 113, 224, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(209, 198, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnRemover = new JButton("Remover");		
		btnRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		
				cpfResp = textField.getText();
				
				try {
					respControl.excluir(cpfResp);					
					MessageSucess msgSucesso = new MessageSucess();							
					msgSucesso.setVisible(true);	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					MessageError msgError = new MessageError();
					msgError.setVisible(true);
					e.printStackTrace();
				}	
			}
		});
		
		
		btnRemover.setBounds(308, 198, 89, 23);
		contentPane.add(btnRemover);
	}
}
