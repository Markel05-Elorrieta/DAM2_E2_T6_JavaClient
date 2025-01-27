package view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpinnerListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import model.Horarios;
import model.Users;
import model.view.TableRenderSchedule;
import model.view.TableUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;

public class VBesteOrdutegiaKontsultatu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	TableUtils tableUtils = new TableUtils();

	private JButton btnAtzera;
	private JButton btnLogout;
	private JTable table;
	private JComboBox comboBox;
	private TableRenderSchedule tableRender = new TableRenderSchedule();
	
	public VBesteOrdutegiaKontsultatu(ArrayList<Users> irakasleak) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
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
		
		tableUtils.clearTable(table);
		
		comboBox = new JComboBox();
		initializeComboBox(irakasleak);
		comboBox.setBounds(403, 45, 130, 22);
		contentPane.add(comboBox);
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
	
	public JComboBox getComboBox() {
        return comboBox;
    }

	private void initializeComboBox(ArrayList<Users> irakasleak) {
		for (int i = 0; i < irakasleak.size(); i++) {
			comboBox.addItem(irakasleak.get(i).getNombre() + " " + irakasleak.get(i).getApellidos());
		}
		comboBox.setSelectedIndex(-1);
		
	}
}
