package model.view;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JTable;

import model.Horarios;
import model.Reuniones;

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
	
	public void fillTableReuniones(JTable table, ArrayList<Reuniones> reunionesList) {
		ArrayList<String> weekDates = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);

        // Add dates for the whole week
        for (int i = 0; i < 5; i++) {
            weekDates.add(startOfWeek.plusDays(i).toString());
        }
        
		for (int i = 0; i < reunionesList.size(); i++) {
			for (int j = 0; j < weekDates.size(); j++) {
				System.out.println("unos sysos antes");
				String[] separado = reunionesList.get(i).getFecha().toString().split(" ");
			
				if (separado[0].equals(weekDates.get(j))) {
					System.out.println("unos sysos");
					table.setValueAt(reunionesList.get(i).getTitulo(), parseHora(reunionesList.get(i).getFecha().getHours()) , j );
				}
			}
		}
        
        System.out.println(weekDates.get(0));
	
	}
		
	private int parseHora (int hora) {
		int horaNum = 0;
		
        if (hora == 8) {
        	horaNum = 0;
		} else if (hora == 9) {
			horaNum = 1;
		} else if (hora == 10) {
			horaNum = 2;
		} else if (hora == 11) {
			horaNum = 3;
		} else if (hora == 12) {
			horaNum = 4;
		} else if (hora == 13) {
			horaNum = 5;
		}
        
        return horaNum;		
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
