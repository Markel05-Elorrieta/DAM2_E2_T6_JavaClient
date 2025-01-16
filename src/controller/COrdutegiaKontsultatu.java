package controller;

import view.VOrdutegiaKontsultatu;

public class COrdutegiaKontsultatu {
	
	private VOrdutegiaKontsultatu vOrdutegiaKontsult;
	
	public COrdutegiaKontsultatu() {
		vOrdutegiaKontsult = new VOrdutegiaKontsultatu();
		vOrdutegiaKontsult.setVisible(true);
		
		start();
	}
	
	private void start() {

		setListeners();
	}
	
	private void setListeners() {

	}
}
