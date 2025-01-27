package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import model.Horarios;
import model.Reuniones;
import model.view.TableRenderSchedule;
import model.view.TableUtils;

public class VBilerakKontsultatu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	TableUtils tableUtils = new TableUtils();

	private JButton btnAtzera;
	private JButton btnLogout;
	private JTable table;
	private TableRenderSchedule tableRender = new TableRenderSchedule();
	
	public VBilerakKontsultatu(ArrayList<Horarios> horariosList, ArrayList<Reuniones> bilerakList) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		System.out.println(horariosList.size());
		

		DefaultTableModel model = new DefaultTableModel(new Object[]{"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"}, 5);

		table = new JTable(model);
		table.setEnabled(false);
		table.setBounds(10, 110, 626, 104);
		
		
		
		JTableHeader header = table.getTableHeader();
		header.setReorderingAllowed(false);
		
		table.setDefaultRenderer(Object.class, tableRender);
		

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 110, 626, 104);
		contentPane.add(scrollPane);
		

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
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}
	
	public JButton getBtnAtzera() {
		return btnAtzera;
	}
	
	public JTable getTable() {
		return table;
	}

}
