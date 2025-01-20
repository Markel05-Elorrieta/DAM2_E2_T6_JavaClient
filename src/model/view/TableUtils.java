package model.view;

import java.util.ArrayList;

import javax.swing.JTable;

import model.Horarios;

public class TableUtils {
	public void fillTable(JTable table, ArrayList<Horarios> horariosList) {
			
		this.clearTable(table);

		for (int i = 0; i < horariosList.size(); i++) {
			Horarios horario = horariosList.get(i);
			switch (horario.getId().getDia()) {
				case "L/A":
					table.setValueAt(horario.getModulos().getNombre(), charToInt(horario.getId().getHora()), 0);
					break;
				case "M/A":
					table.setValueAt(horario.getModulos().getNombre(), charToInt(horario.getId().getHora()), 1);
					break;
				case "X":
					table.setValueAt(horario.getModulos().getNombre(), charToInt(horario.getId().getHora()), 2);
					break;
				case "J/O":
					table.setValueAt(horario.getModulos().getNombre(), charToInt(horario.getId().getHora()), 3);
					break;
				case "V/O":
					table.setValueAt(horario.getModulos().getNombre(), charToInt(horario.getId().getHora()), 4);
					break;
				default:
					System.err.println("Day not found -> " + horario.getId().getDia());
					break;
			}
		}
	}
		
	private int charToInt(char c) {
		return c - '1';
	}
	
	public void clearTable(JTable table) {
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				table.setValueAt("", row, col);
			}
		}
	}
}
