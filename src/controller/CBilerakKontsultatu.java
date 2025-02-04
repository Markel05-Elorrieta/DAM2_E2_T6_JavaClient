package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;

import model.Horarios;
import model.Reuniones;
import model.modals.MBilerakKontsultatu;
import model.modals.MOrdutegiaKontsultatu;
import model.utilities.GlobalVariables;
import model.utilities.Utilities;
import view.VBilerakKontsultatu;

public class CBilerakKontsultatu {
	
	private MOrdutegiaKontsultatu mOrdutegiaKontsultatu;
	private MBilerakKontsultatu mBilerakKontsultatu;
	
	private VBilerakKontsultatu vBilerakKontsultatu;
	
	private Utilities utils = new Utilities();
	
	private ArrayList<Horarios> horariosList;
	private ArrayList<Reuniones> bilerakList;
    ArrayList<ArrayList<Reuniones>> reunioak = new ArrayList<ArrayList<Reuniones>>();
	
	public CBilerakKontsultatu() {
		mOrdutegiaKontsultatu = new MOrdutegiaKontsultatu();
		horariosList = mOrdutegiaKontsultatu.getHorariosByIrakasleId(GlobalVariables.loggedUser.getId());
		mBilerakKontsultatu = new MBilerakKontsultatu();
		bilerakList = mBilerakKontsultatu.bilerakByTeacher(GlobalVariables.loggedUser.getId());
		reunioak = utils.fillArray(bilerakList);
		
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
		JTable table = vBilerakKontsultatu.getTable();
		
		btnLogout.addActionListener(e -> {
			vBilerakKontsultatu.dispose();
			GlobalVariables.loggedUser = null;
			CLogin cLogin = new CLogin();
		});
		
		btnAtzera.addActionListener(e -> {
			vBilerakKontsultatu.dispose();
			CMenu cMenua = new CMenu();
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				int row = table.rowAtPoint(evt.getPoint());
				int col = table.columnAtPoint(evt.getPoint());
				if (row >= 0 && col >= 0) {
					Reuniones r = reunioak.get(col).get(row);
					vBilerakKontsultatu.dispose();
					CBileraXehetasunak cBileraXehetasunak = new CBileraXehetasunak(r);
				}
			}
		});
		
	}

}
