package controller;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

import model.Horarios;
import model.Users;
import model.modals.MBesteOrdutegiaKontsultatu;
import model.utilities.GlobalVariables;
import model.view.TableUtils;
import view.VBesteOrdutegiaKontsultatu;

public class CBesteOrdutegiaKontsultatu {
	
	private VBesteOrdutegiaKontsultatu vBesteOrdutegiaKontsult;
	private MBesteOrdutegiaKontsultatu mBesteOrdutegiaKontsult;
	private TableUtils tableUtils = new TableUtils();
	
	private ArrayList<Horarios> horariosList;
	private ArrayList<Users> irakasleak;
	
	public CBesteOrdutegiaKontsultatu() {
		
		mBesteOrdutegiaKontsult = new MBesteOrdutegiaKontsultatu();
		irakasleak = mBesteOrdutegiaKontsult.getIrakasleak();
		
		vBesteOrdutegiaKontsult = new VBesteOrdutegiaKontsultatu(irakasleak);
		vBesteOrdutegiaKontsult.setVisible(true);
		start();
	}
	
	private void start() {

		setListeners();
	}
	
	private void setListeners() {
		JButton btnAtzera = vBesteOrdutegiaKontsult.getBtnAtzera();
		JButton btnLogout = vBesteOrdutegiaKontsult.getBtnLogout();
		JComboBox comboBox = vBesteOrdutegiaKontsult.getComboBox();
		JTable table = vBesteOrdutegiaKontsult.getTable();
		
		btnAtzera.addActionListener(e -> {
			vBesteOrdutegiaKontsult.dispose();
			CMenu cMenu = new CMenu();
		});
		
		btnLogout.addActionListener(e -> {
			vBesteOrdutegiaKontsult.dispose();
            GlobalVariables.loggedUser = null;
            CLogin cLogin = new CLogin();
		});
		
		comboBox.addActionListener(e -> {
			int index = comboBox.getSelectedIndex();
			Users selectedUser = irakasleak.get(index);
			horariosList = mBesteOrdutegiaKontsult.getHorariosByIrakasleId(selectedUser.getId());
			tableUtils.fillTable(table, horariosList);
		});
           
	}
	
	

}
