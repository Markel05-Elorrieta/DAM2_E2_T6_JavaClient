package model.view;

import java.awt.Component;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JTable;

import model.Horarios;
import model.Reuniones;
import model.utilities.Utilities;

public class TableUtils {
	public void fillTable(JTable table, ArrayList<Horarios> horariosList) {
			
		this.clearTable(table);

		for (int i = 0; i < horariosList.size(); i++) {
			Horarios horario = horariosList.get(i);
			switch (horario.getId().getDia()) {
				case "L/A":
					table.setValueAt(nameToCode(horario.getModulos().getNombre()), charToInt(horario.getId().getHora()), 0);
					break;
				case "M/A":
					table.setValueAt(nameToCode(horario.getModulos().getNombre()), charToInt(horario.getId().getHora()), 1);
					break;
				case "X":
					table.setValueAt(nameToCode(horario.getModulos().getNombre()), charToInt(horario.getId().getHora()), 2);
					break;
				case "J/O":
					table.setValueAt(nameToCode(horario.getModulos().getNombre()), charToInt(horario.getId().getHora()), 3);
					break;
				case "V/O":
					table.setValueAt(nameToCode(horario.getModulos().getNombre()), charToInt(horario.getId().getHora()), 4);
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
				String[] separado = reunionesList.get(i).getFecha().toString().split(" ");
			
				if (separado[0].equals(weekDates.get(j))) {
					if(table.getValueAt(parseHora(reunionesList.get(i).getFecha().getHours()), j) == "" || table.getValueAt(parseHora(reunionesList.get(i).getFecha().getHours()), j) == null || table.getValueAt(parseHora(reunionesList.get(i).getFecha().getHours()), j) == " ") {
						table.setValueAt(reunionesList.get(i).getTitulo(), parseHora(reunionesList.get(i).getFecha().getHours()) , j );	
					}else {
						table.setValueAt(table.getValueAt(parseHora(reunionesList.get(i).getFecha().getHours()), j) + "\n" + reunionesList.get(i).getTitulo(), parseHora(reunionesList.get(i).getFecha().getHours()), j);
					}
				}
				
			}
			
		}
		adjustRowHeights(table);
	}

	public void adjustRowHeights(JTable table) {
	    for (int row = 0; row < table.getRowCount(); row++) {
	        int rowHeight = table.getRowHeight(row);

	        for (int column = 0; column < table.getColumnCount(); column++) {
	            Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
	            rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
	        }

	        table.setRowHeight(row, rowHeight);
	    }
	}
		
	private int parseHora (int hora) {
		int horaNum = 0;
		
        if (hora == 9) {
        	horaNum = 0;
		} else if (hora == 10) {
			horaNum = 1;
		} else if (hora == 11) {
			horaNum = 2;
		} else if (hora == 12) {
			horaNum = 3;
		} else if (hora == 13) {
			horaNum = 4;
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
	
	private String nameToCode(String name) {
		switch (name) {
        case "Tutoria":
            return "T";
        case "Guardia":
            return "G";
        case "Sistemas Informaticos":
            return "SI";
        case "Bases de datos":
            return "BD";
        case "Programación":
            return "PR";
        case "Lenguajes de marcas":
            return "LM";
        case "Entornos de desarrollo":
            return "ED";
        case "Acceso a datos":
            return "AD";
        case "Desarrollo de interfaces":
            return "DI";
        case "Programación multimedia y dispositivos móviles":
            return "PMDM";
        case "Programación de servicios y procesos":
            return "PSP";
        case "Sistemas de gestión empresarial":
            return "SGE";
        case "Empresa e Iniciativa Emprendedora":
            return "EIE";
        default:
        	return "N/A";
		}
	}
}
