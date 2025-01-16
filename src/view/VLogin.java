package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JButton btnLogin;

	public VLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(97, 66, 86, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(97, 97, 86, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(97, 144, 89, 23);
		contentPane.add(btnLogin);
	}
	
	public JTextField getTxtEmail() {
		return txtEmail;
	}
	
	public JTextField getTxtPassword() {
		return txtPassword;
	}
	
	public JButton getBtnLogin() {
		return btnLogin;
	}
}
