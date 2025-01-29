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

import global.Constants;
import model.Horarios;
import model.Users;
import model.view.TableRenderSchedule;
import model.view.TableUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;

public class VBesteOrdutegiaKontsultatu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	TableUtils tableUtils = new TableUtils();
	private JTable table;
	private JComboBox comboBox;
	private TableRenderSchedule tableRender = new TableRenderSchedule();
	private JLabel lblBesteIrakOrdutegia;
	private JButton btnLogout;
	private JLabel lblLogo;
	private JButton btnAtzera;
	private JLabel lblAukeratuIrakasle;

	public VBesteOrdutegiaKontsultatu(ArrayList<Users> irakasleak) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		DefaultTableModel model = new DefaultTableModel(
				new Object[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes" }, 5);

		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setEnabled(false);
		table.setBounds(10, 110, 626, 104);

		JTableHeader header = table.getTableHeader();
		header.setReorderingAllowed(false);

		table.setDefaultRenderer(Object.class, tableRender);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 123, 745, 219);
		contentPane.add(scrollPane);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tableUtils.clearTable(table);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		initializeComboBox(irakasleak);
		comboBox.setBounds(569, 428, 166, 24);
		contentPane.add(comboBox);

		btnLogout = new JButton("❌ Logout");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
		btnLogout.setFocusPainted(false);
		btnLogout.setBackground(Color.RED);
		btnLogout.setBounds(605, 11, 150, 34);
		contentPane.add(btnLogout);

		lblLogo = new JLabel();
		lblLogo.setBounds(10, 11, 150, 44);
		ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/elorrieta.png"));
		Image logoImage = logoIcon.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(),
				Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(logoImage));
		contentPane.add(lblLogo);

		lblBesteIrakOrdutegia = new JLabel("BESTE IRAKASLEEN ORDUTEGIA");
		lblBesteIrakOrdutegia.setHorizontalAlignment(SwingConstants.CENTER);
		lblBesteIrakOrdutegia.setFont(new Font("Segoe UI Variable", Font.PLAIN, 27));
		lblBesteIrakOrdutegia.setBounds(0, 11, 765, 37);
		contentPane.add(lblBesteIrakOrdutegia);

		btnAtzera = new JButton("⬅️ Atzera");
		btnAtzera.setHorizontalAlignment(SwingConstants.RIGHT);
		btnAtzera.setForeground(Color.WHITE);
		btnAtzera.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 17));
		btnAtzera.setBackground(Color.CYAN);
		btnAtzera.setBounds(21, 423, 150, 37);
		contentPane.add(btnAtzera);

		lblAukeratuIrakasle = new JLabel("Aukeratu irakasle bat:");
		lblAukeratuIrakasle.setBounds(569, 403, 166, 14);
		contentPane.add(lblAukeratuIrakasle);
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
