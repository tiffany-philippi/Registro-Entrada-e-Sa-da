package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainView extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemVindo = new JLabel("BEM VINDO!");
		lblBemVindo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBemVindo.setBounds(167, 57, 123, 14);
		contentPane.add(lblBemVindo);
		
		JButton btnRegistro = new JButton("Registro ");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RegistroView RegistroView = new RegistroView();
				
				RegistroView.setVisible(true);
			}
		});
		btnRegistro.setBounds(152, 112, 123, 23);
		contentPane.add(btnRegistro);
		
		JButton btnResp = new JButton("Respons\u00E1vel");
		btnResp.setBounds(152, 146, 123, 23);
		contentPane.add(btnResp);
		
		btnResp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResponsavelView ResponsavelView = new ResponsavelView();
				ResponsavelView.setVisible(true);
			}
		});
		
		JButton btnaluno = new JButton("Aluno");
		btnaluno.setBounds(152, 180, 123, 23);
		contentPane.add(btnaluno);
		
		btnaluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlunoView AlunoView = new AlunoView();
				AlunoView.setVisible(true);
			}
		});
		
	}

}
