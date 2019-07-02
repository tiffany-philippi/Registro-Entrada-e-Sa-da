package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResponsavelView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResponsavelView frame = new ResponsavelView();
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
	public ResponsavelView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			RespConsultView respConsult = new RespConsultView();
			respConsult.setVisible(true);
		}
	});
		btnConsultar.setBounds(165, 60, 89, 23);
		contentPane.add(btnConsultar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RespEditView respEdit = new RespEditView();
				respEdit.setVisible(true);
			}
		});
		btnEditar.setBounds(165, 94, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RespRemoverView respRv = new RespRemoverView();
				respRv.setVisible(true);
			}
		});
		btnRemover.setBounds(165, 129, 89, 23);
		contentPane.add(btnRemover);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RespCadastroView respCd = new RespCadastroView();
				respCd.setVisible(true);
			}
		});
		btnInserir.setBounds(165, 163, 89, 23);
		contentPane.add(btnInserir);
	}

}
