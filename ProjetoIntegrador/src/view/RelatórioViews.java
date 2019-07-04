package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.RelatorioController;


public class RelatórioViews extends JFrame {

	private JPanel contentPane;
	
	RelatorioController relatorioControl = new RelatorioController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatórioViews frame = new RelatórioViews();
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
	public RelatórioViews() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnListaDeAlunos = new JButton("Lista de Alunos");
		btnListaDeAlunos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AlunoRelatView alunoView = new AlunoRelatView();
				
				alunoView.setVisible(true);
			}
		});
		btnListaDeAlunos.setBounds(144, 45, 133, 28);
		contentPane.add(btnListaDeAlunos);
		
		

	
	

		
		
	}

}
