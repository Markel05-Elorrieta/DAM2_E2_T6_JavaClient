package controller;

import java.util.ArrayList;

import javax.swing.JButton;

import model.Horarios;
import model.Reuniones;
import model.modals.MBilerakKontsultatu;
import model.modals.MOrdutegiaKontsultatu;
import model.utilities.GlobalVariables;
import view.VBilerakKontsultatu;

public class CBilerakKontsultatu {
	
	private MOrdutegiaKontsultatu mOrdutegiaKontsultatu;
	private MBilerakKontsultatu mBilerakKontsultatu;
	
	private VBilerakKontsultatu vBilerakKontsultatu;
	
	private ArrayList<Horarios> horariosList;
	private ArrayList<Reuniones> bilerakList;
	
	public CBilerakKontsultatu() {
		mOrdutegiaKontsultatu = new MOrdutegiaKontsultatu();
		horariosList = mOrdutegiaKontsultatu.getHorariosByIrakasleId(GlobalVariables.loggedUser.getId());
		mBilerakKontsultatu = new MBilerakKontsultatu();
		bilerakList = mBilerakKontsultatu.bilerakByTeacher(GlobalVariables.loggedUser.getId());
		
		vBilerakKontsultatu = new VBilerakKontsultatu(horariosList, bilerakList);
		vBilerakKontsultatu.setVisible(true);
		
		start();
	}
	
	private void start() {
		setListeners();
	}
	
	private void setListeners() {
		JButton btnLogout = vBilerakKontsultatu.getBtnLogout();
		JButton btnAtzera = vBilerakKontsultatu.getBtnAtzera();
		JButton btnNewBilera = vBilerakKontsultatu.getBtnNewBilera();
		
		btnLogout.addActionListener(e -> {
			vBilerakKontsultatu.dispose();
			GlobalVariables.loggedUser = null;
			CLogin cLogin = new CLogin();
		});
		
		btnAtzera.addActionListener(e -> {
			vBilerakKontsultatu.dispose();
			CMenu cMenua = new CMenu();
		});
		
		btnNewBilera.addActionListener(e -> {
			vBilerakKontsultatu.dispose();
			CBilerakSortu cBilerakSortu = new CBilerakSortu();
		});
	}

}
