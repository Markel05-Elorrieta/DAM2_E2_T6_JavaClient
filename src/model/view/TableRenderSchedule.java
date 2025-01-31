package model.view;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableRenderSchedule extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		// Set the appropriate icon based on the cell value

		if (value != null) {
			System.out.println(value.toString());
			switch (value.toString()) {
				case "T":
				case "Tutoretza":
					c.setBackground(java.awt.Color.RED);
					c.setForeground(java.awt.Color.WHITE);
					break;
				case "G":
				case "Zaintza":
					c.setBackground(java.awt.Color.GREEN);
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "SI":
				case "Informatika-sistemak":
					c.setBackground(java.awt.Color.BLUE);
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "BD":
				case "Datu-baseak":
					c.setBackground(java.awt.Color.CYAN);
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "PR":
				case "Programazioa":
					c.setBackground(java.awt.Color.MAGENTA);
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "LM":
				case "Markatzeko lengoaiak":
					c.setBackground(java.awt.Color.YELLOW);
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "ED":
				case "Garapen-inguruneak":
					c.setBackground(java.awt.Color.GRAY);
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "AD":
				case "Datu-atzipena":
					c.setBackground(java.awt.Color.DARK_GRAY);
					c.setForeground(java.awt.Color.WHITE);
					break;
				case "DI":
				case "Interfazeen garapena":
					c.setBackground(java.awt.Color.LIGHT_GRAY);
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "PMDM":
				case "Multimedia-programazioa eta gailu mugikorrak":
					c.setBackground(java.awt.Color.ORANGE);
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "PSP":
				case "Zerbitzu eta prozesuen programazioa":
					c.setBackground(java.awt.Color.PINK);
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "SGE":
				case "Enpresa-kudeaketako sistemak":
					c.setBackground(new java.awt.Color(0, 255, 0));
					c.setForeground(java.awt.Color.BLACK);
					break;
				case "EIE":
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
