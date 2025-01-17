package controller;

import javax.swing.JButton;

import view.VMenu;

public class CMenu {
	
	private VMenu vMenu;
	
	public CMenu() {
		vMenu = new VMenu();
		vMenu.setVisible(true);
		
		start();
	}

	private void start() {

		
		setListeners();
	}

	private void setListeners() {
		JButton btnOrdutegiaKontsultatu = vMenu.getBtnOrdutegiaKontsultatu();
		JButton btnBesteOrdutegiaKontsultatu = vMenu.getBtnBesteOrdutegiaKontsultatu();
		JButton btnBilerakKontsultatu = vMenu.getBtnBilerakKontsultatu();
		JButton btnLogout = vMenu.getBtnLogout();
		
		btnOrdutegiaKontsultatu.addActionListener(e -> {
			vMenu.dispose();
			COrdutegiaKontsultatu cOrdutegiaKontsultatu = new COrdutegiaKontsultatu();
		});
		
		btnBesteOrdutegiaKontsultatu.addActionListener(e -> {
			vMenu.dispose();
			CBesteOrdutegiaKontsultatu cBesteOrdutegiaKontsultatu = new CBesteOrdutegiaKontsultatu();
		});
		
		btnBilerakKontsultatu.addActionListener(e -> {
			vMenu.dispose();
			CBilerakKontsultatu cBilerakKontsultatu = new CBilerakKontsultatu();
		});
		
		btnLogout.addActionListener(e -> {
			vMenu.dispose();
			CLogin cLogin = new CLogin();
		});
	}
	
}
