package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import global.Constants;
import model.GlobalVariables;
import model.Horarios;
import model.Reuniones;
import model.view.TableRenderBilerak;
import model.view.TableRenderSchedule;
import model.view.TableUtils;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class VBilerakKontsultatu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	TableUtils tableUtils = new TableUtils();
	private JTable table;
	private TableRenderBilerak tableRender;
	private JButton btnAtzera;
	private JButton btnLogout;
	private JLabel lblLogo;
	
	public VBilerakKontsultatu(ArrayList<Horarios> horariosList, ArrayList<Reuniones> bilerakList) {
		setTitle("Bilerak - JEM Software");
		tableRender = new TableRenderBilerak(bilerakList);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		System.out.println(horariosList.size());
		

		DefaultTableModel model = new DefaultTableModel(new Object[]{"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"}, 5);

		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setEnabled(false);
		table.setBounds(10, 110, 800, 200);
		
		JTableHeader header = table.getTableHeader();
		header.setReorderingAllowed(false);
		
		table.setDefaultRenderer(Object.class, tableRender);
		

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 128, 745, 212);
		contentPane.add(scrollPane);
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableUtils.fillTable(table, horariosList);
		tableUtils.fillTableReuniones(table, bilerakList);
		
		btnAtzera = new JButton("⬅️ Atzera");
		btnAtzera.setHorizontalAlignment(SwingConstants.RIGHT);
		btnAtzera.setForeground(Color.WHITE);
		btnAtzera.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 17));
		btnAtzera.setBackground(Color.CYAN);
		btnAtzera.setBounds(24, 423, 150, 37);
		contentPane.add(btnAtzera);
		
		btnLogout = new JButton("❌ Logout");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
		btnLogout.setFocusPainted(false);
		btnLogout.setBackground(Color.RED);
		btnLogout.setBounds(605, 11, 150, 34);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("BILERAK");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 29));
		lblNewLabel.setBounds(0, 11, 765, 37);
		contentPane.add(lblNewLabel);
		
		lblLogo = new JLabel();
		lblLogo.setBounds(10, 11, 150, 44);
		ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/elorrieta.png"));
		Image logoImage = logoIcon.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(logoImage));
		contentPane.add(lblLogo);
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
