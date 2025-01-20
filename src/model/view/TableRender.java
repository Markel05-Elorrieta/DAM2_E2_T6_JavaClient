package model.view;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableRender extends DefaultTableCellRenderer {

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
					break;
				case "Guardia":
				case "Zaintza":
					c.setBackground(java.awt.Color.GREEN);
					break;
				case "Sistemas Informaticos":
				case "Informatika-sistemak":
					c.setBackground(java.awt.Color.BLUE);
					break;
				case "Bases de datos":
				case "Datu-baseak":
					c.setBackground(java.awt.Color.CYAN);
					break;
				case "Programación":
				case "Programazioa":
					c.setBackground(java.awt.Color.MAGENTA);
					break;
				case "Lenguajes de marcas":
				case "Markatzeko lengoaiak":
					c.setBackground(java.awt.Color.YELLOW);
					break;
				case "Entornos de desarrollo":
				case "Garapen-inguruneak":
					c.setBackground(java.awt.Color.GRAY);
					break;
				case "Acceso a datos":
				case "Datu-atzipena":
					c.setBackground(java.awt.Color.DARK_GRAY);
					break;
				case "Desarrollo de interfaces":
				case "Interfazeen garapena":
					c.setBackground(java.awt.Color.LIGHT_GRAY);
					break;
				case "Programación multimedia y dispositivos móviles":
				case "Multimedia-programazioa eta gailu mugikorrak":
					c.setBackground(java.awt.Color.ORANGE);
					break;
				case "Programación de servicios y procesos":
				case "Zerbitzu eta prozesuen programazioa":
					c.setBackground(java.awt.Color.PINK);
					break;
				case "Sistemas de gestión empresarial":
				case "Enpresa-kudeaketako sistemak":
					c.setBackground(new java.awt.Color(0, 255, 0));
					break;
				case "Empresa e Iniciativa Emprendedora":
				case "Enpresa eta ekimen sortzailea":
					c.setBackground(new java.awt.Color(0, 255, 255));
					break;
				case "":
				case " ":
				case "null":
					c.setBackground(java.awt.Color.WHITE);
					break;
				default:
	                c.setBackground(java.awt.Color.WHITE);
	                break;
					
			}
		}

		return c;
	}

}
