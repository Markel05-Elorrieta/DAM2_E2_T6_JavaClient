package controller;

import javax.swing.JButton;

import view.VBesteOrdutegiaKontsultatu;

public class CBesteOrdutegiaKontsultatu {
	
	private VBesteOrdutegiaKontsultatu vBesteOrdutegiaKontsultatu;
	
	public CBesteOrdutegiaKontsultatu() {
		vBesteOrdutegiaKontsultatu = new VBesteOrdutegiaKontsultatu();
		vBesteOrdutegiaKontsultatu.setVisible(true);
		
		start();
	}
	
	private void start() {

		setListeners();
	}
	
	private void setListeners() {
		JButton btnLogout = vBesteOrdutegiaKontsultatu.getBtnLogout();
		
		btnLogout.addActionListener(e -> {
			vBesteOrdutegiaKontsultatu.dispose();
			CMenu cMenu = new CMenu();
		});
	}
}
