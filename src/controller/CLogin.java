package controller;

import javax.swing.JButton;
import javax.swing.JTextField;

import model.MLogin;
import model.Utilities;
import view.VLogin;

public class CLogin {

	private VLogin vLogin;
	private MLogin mLogin;
	
	public CLogin() {
		vLogin = new VLogin();
		vLogin.setVisible(true);
		
		mLogin = new MLogin();
		
		start();
	}
	
	private void start() {
		setListeners();
	}
	
	private void setListeners() {
		JButton btnLogin = vLogin.getBtnLogin();
		JTextField txtEmail = vLogin.getTxtEmail();
		JTextField txtPassword = vLogin.getTxtPassword();
		
		btnLogin.addActionListener(e -> {
			boolean isUser = mLogin.checkLogin(txtEmail.getText(), txtPassword.getText());
			if (isUser) {
				this.vLogin.dispose();
				CMenu cMenu = new CMenu();
			} else {
				System.out.println("Usuario no logeado");
			}
			
		});
    }
	
}
