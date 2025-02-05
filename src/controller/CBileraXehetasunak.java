package controller;

import javax.swing.JButton;
import javax.swing.JTextField;

import model.Ikastetxeak;
import model.Reuniones;
import model.modals.MBileraXehetasunak;
import model.modals.MLogin;
import model.utilities.GlobalVariables;
import view.VBileraXehetasunak;
import view.VLogin;

public class CBileraXehetasunak {
	private VBileraXehetasunak vBileraXehetasunak;
	private MBileraXehetasunak mBileraXehetasunak;
	
	Ikastetxeak ikas = new Ikastetxeak();

	public CBileraXehetasunak(Reuniones r) {
		mBileraXehetasunak = new MBileraXehetasunak();
		
		System.out.println(r);
		
		ikas = mBileraXehetasunak.getIkastetxeByCCEN(r);
		
		vBileraXehetasunak = new VBileraXehetasunak(r, ikas);
		vBileraXehetasunak.setVisible(true);
		
		start();
	}

	private void start() {
		setListeners();
	}

	private void setListeners() {
		
		JButton btnAtzera = vBileraXehetasunak.getBtnAtzera();
		JButton btnLogout = vBileraXehetasunak.getBtnLogout();

		btnAtzera.addActionListener(e -> {
			vBileraXehetasunak.dispose();
			CBilerakKontsultatu cBilerakKontsultatu = new CBilerakKontsultatu();
		});
		
		btnLogout.addActionListener(e -> {
			vBileraXehetasunak.dispose();
			GlobalVariables.loggedUser = null;
			CLogin cLogin = new CLogin();
		});
		

	}
}
