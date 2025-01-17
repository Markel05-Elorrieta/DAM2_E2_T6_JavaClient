package view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Horarios;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VOrdutegiaKontsultatu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JButton btnLogout;
	
	public VOrdutegiaKontsultatu(ArrayList<Horarios> horariosList) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		System.out.println(horariosList.size());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnLogout = new JButton("btnLogout");
		btnLogout.setBounds(10, 227, 89, 23);
		contentPane.add(btnLogout);
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}
}
