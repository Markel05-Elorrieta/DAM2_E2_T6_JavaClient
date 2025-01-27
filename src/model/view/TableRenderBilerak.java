package model.view;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import model.Horarios;
import model.Reuniones;

public class TableRenderBilerak extends DefaultTableCellRenderer {
		private ArrayList<Horarios> scheduleList;
		private ArrayList<Reuniones> bilerakList;
	
		public TableRenderBilerak(ArrayList<Horarios> scheduleList, ArrayList<Reuniones> bilerakList) {
			this.scheduleList = scheduleList;
			this.bilerakList = bilerakList;
		}
		

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		// Set the appropriate icon based on the cell value

		if (value != null) {
			System.out.println(value.toString());
			
			switch (value.toString()) {
				case "Tutoria":
				case "Tutoretza":
					c.setBackground(java.awt.Color.RED);
					c.setForeground(java.awt.Color.WHITE);
					break;
				case "Guardia":
				case "Zaintza":
					c.setBackground(java.awt.Color.GREEN);
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "Sistemas Informaticos":
				case "Informatika-sistemak":
					c.setBackground(java.awt.Color.BLUE);
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "Bases de datos":
				case "Datu-baseak":
					c.setBackground(java.awt.Color.CYAN);
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "Programación":
				case "Programazioa":
					c.setBackground(java.awt.Color.MAGENTA);
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "Lenguajes de marcas":
				case "Markatzeko lengoaiak":
					c.setBackground(java.awt.Color.YELLOW);
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "Entornos de desarrollo":
				case "Garapen-inguruneak":
					c.setBackground(java.awt.Color.GRAY);
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "Acceso a datos":
				case "Datu-atzipena":
					c.setBackground(java.awt.Color.DARK_GRAY);
					c.setForeground(java.awt.Color.WHITE);
					break;
				case "Desarrollo de interfaces":
				case "Interfazeen garapena":
					c.setBackground(java.awt.Color.LIGHT_GRAY);
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "Programación multimedia y dispositivos móviles":
				case "Multimedia-programazioa eta gailu mugikorrak":
					c.setBackground(java.awt.Color.ORANGE);
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "Programación de servicios y procesos":
				case "Zerbitzu eta prozesuen programazioa":
					c.setBackground(java.awt.Color.PINK);
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "Sistemas de gestión empresarial":
				case "Enpresa-kudeaketako sistemak":
					c.setBackground(new java.awt.Color(0, 255, 0));
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "Empresa e Iniciativa Emprendedora":
				case "Enpresa eta ekimen sortzailea":
					c.setBackground(new java.awt.Color(0, 255, 255));
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "":
				case " ":
				case "null":
					c.setBackground(java.awt.Color.WHITE);
					c.setForeground(java.awt.Color.BLACK);
					break;
				default:
	                c.setBackground(java.awt.Color.WHITE);
	                c.setForeground(java.awt.Color.BLACK);
	                break;
					
			}
		}

		return c;
	}

}
