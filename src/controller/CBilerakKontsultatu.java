package controller;

import java.util.ArrayList;

import javax.swing.JButton;

import model.GlobalVariables;
import model.Horarios;
import model.MBilerakKontsultatu;
import model.MOrdutegiaKontsultatu;
import model.Reuniones;
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
		
		btnLogout.addActionListener(e -> {
			vBilerakKontsultatu.dispose();
			CMenu cMenu = new CMenu();
		});
	}

}
