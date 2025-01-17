package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VBilerakKontsultatu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JButton btnLogout;
	
	public VBilerakKontsultatu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		btnLogout = new JButton("btnLogout");
		btnLogout.setBounds(10, 227, 89, 23);
		contentPane.add(btnLogout);

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public JButton getBtnLogout() {
		return btnLogout;
	}

}
