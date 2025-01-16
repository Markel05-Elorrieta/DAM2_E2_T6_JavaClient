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
		
		btnOrdutegiaKontsultatu.addActionListener(e -> {
			COrdutegiaKontsultatu cOrdutegiaKontsultatu = new COrdutegiaKontsultatu();
		});
		
		btnBesteOrdutegiaKontsultatu.addActionListener(e -> {
			System.out.println("Beste Ordutegia Kontsultatu");
		});
		
		btnBilerakKontsultatu.addActionListener(e -> {
			System.out.println("Bilerak Kontsultatu");
		});
	}
	
}
