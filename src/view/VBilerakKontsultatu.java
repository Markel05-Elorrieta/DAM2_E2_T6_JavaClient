package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import model.Horarios;
import model.Reuniones;
import model.view.TableRenderBilerak;
import model.view.TableRenderSchedule;
import model.view.TableUtils;

public class VBilerakKontsultatu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	TableUtils tableUtils = new TableUtils();

	private JButton btnAtzera;
	private JButton btnLogout;
	private JButton btnNewBilera;
	private JTable table;
	private TableRenderBilerak tableRender;
	
	public VBilerakKontsultatu(ArrayList<Horarios> horariosList, ArrayList<Reuniones> bilerakList) {
		tableRender = new TableRenderBilerak(bilerakList);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		DefaultTableModel model = new DefaultTableModel(new Object[]{"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"}, 5);

		table = new JTable(model);
		table.setBorder(null);
		table.setEnabled(false);
		table.setBorder(BorderFactory.createEmptyBorder());
		table.setBounds(10, 110, 626, 104);
		
		
		
		JTableHeader header = table.getTableHeader();
		header.setReorderingAllowed(false);
		header.setBackground(new Color(200, 200, 200)); // Light gray background
		
        // Add a big border behind the header
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Large border
        headerPanel.add(header);
		
		table.setDefaultRenderer(Object.class, tableRender);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 110, 626, 256);
		contentPane.add(scrollPane);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAtzera = new JButton("btnAtzera");
		btnAtzera.setBounds(10, 45, 89, 23);
		contentPane.add(btnAtzera);
		
		btnLogout = new JButton("btnLogout");
		btnLogout.setBounds(10, 11, 89, 23);
		contentPane.add(btnLogout);
		
		tableUtils.fillTable(table, horariosList);
		tableUtils.fillTableReuniones(table, bilerakList);
		tableUtils.adjustRowHeights(table);
		
		btnNewBilera = new JButton("btnNewBilera");
		btnNewBilera.setBounds(270, 377, 110, 23);
		contentPane.add(btnNewBilera);
		
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}
	
	public JButton getBtnAtzera() {
		return btnAtzera;
	}
	
	public JButton getBtnNewBilera() {
		return btnNewBilera;
	}
	
	public JTable getTable() {
		return table;
	}
}
