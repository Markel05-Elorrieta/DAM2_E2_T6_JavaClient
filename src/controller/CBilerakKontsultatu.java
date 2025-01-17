package controller;

import javax.swing.JButton;

import view.VBilerakKontsultatu;

public class CBilerakKontsultatu {
	
	private VBilerakKontsultatu vBilerakKontsultatu;
	
	public CBilerakKontsultatu() {
		vBilerakKontsultatu = new VBilerakKontsultatu();
		vBilerakKontsultatu.setVisible(true);
		
		start();
	}
	
	private void start() {
		setListeners();
	}
	
	private void setListeners() {
		JButton btnLogout = vBilerakKontsultatu.getBtnLogout();
		
		btnLogout.addActionListener(e -> {
			vBilerakKontsultatu.dispose();
			CMenu cMenu = new CMenu();
		});
	}

}
