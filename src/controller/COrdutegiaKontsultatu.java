package controller;

import java.util.ArrayList;

import javax.swing.JButton;

import model.GlobalVariables;
import model.Horarios;
import model.MOrdutegiaKontsultatu;
import view.VOrdutegiaKontsultatu;

public class COrdutegiaKontsultatu {
	
	private VOrdutegiaKontsultatu vOrdutegiaKontsult;
	private MOrdutegiaKontsultatu mOrdutegiaKontsult;
	
	private ArrayList<Horarios> horariosList;
	
	public COrdutegiaKontsultatu() {
		
		mOrdutegiaKontsult = new MOrdutegiaKontsultatu();
		horariosList = mOrdutegiaKontsult.getHorariosByIrakasleId(GlobalVariables.loggedUser.getId());
		
		vOrdutegiaKontsult = new VOrdutegiaKontsultatu(horariosList);
		vOrdutegiaKontsult.setVisible(true);
		
		start();
	}
	
	private void start() {

		setListeners();
	}
	
	private void setListeners() {
		JButton btnLogout = vOrdutegiaKontsult.getBtnLogout();
		
		btnLogout.addActionListener(e -> {
			vOrdutegiaKontsult.dispose();
			CMenu cMenu = new CMenu();
		});
	}
}
