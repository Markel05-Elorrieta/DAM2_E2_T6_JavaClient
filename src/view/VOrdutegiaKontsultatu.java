package view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import global.Constants;
import model.Horarios;
import model.view.TableRenderSchedule;
import model.view.TableUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;

public class VOrdutegiaKontsultatu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	TableUtils tableUtils = new TableUtils();

	private JButton btnAtzera;
	private JTable table;
	private TableRenderSchedule tableRender = new TableRenderSchedule();
	private JLabel lblLogo;
	private JLabel lblOrdutegia;
	private JButton btnLogout;
	
	public VOrdutegiaKontsultatu(ArrayList<Horarios> horariosList) {
		setTitle("Ordutegia - JEM Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
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
		scrollPane.setBounds(10, 110, 745, 264);
		contentPane.add(scrollPane);
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAtzera = new JButton("⬅️ Atzera");
		btnAtzera.setBackground(Color.CYAN);
		btnAtzera.setForeground(Color.WHITE);
		btnAtzera.setHorizontalAlignment(SwingConstants.RIGHT);
		btnAtzera.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 17));
		btnAtzera.setBounds(23, 423, 150, 37);
		contentPane.add(btnAtzera);
		
		tableUtils.fillTable(table, horariosList);
		
		lblLogo = new JLabel();
		lblLogo.setBounds(10, 11, 150, 44);
		ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/elorrieta.png"));
		Image logoImage = logoIcon.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(logoImage));
		contentPane.add(lblLogo);
		
		btnLogout = new JButton("❌ Logout");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
		btnLogout.setFocusPainted(false);
		btnLogout.setBackground(Color.RED);
		btnLogout.setBounds(592, 17, 150, 34);
		contentPane.add(btnLogout);
		
		lblOrdutegia = new JLabel("ORDUTEGIA");
		lblOrdutegia.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdutegia.setFont(new Font("Segoe UI Variable", Font.PLAIN, 29));
		lblOrdutegia.setBounds(0, 13, 765, 37);
		contentPane.add(lblOrdutegia);
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



/*
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import model.Horarios;
import model.view.TableRender;
import model.view.TableUtils;

public class VOrdutegiaKontsultatu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private TableUtils tableUtils = new TableUtils();

    private JButton btnAtzera;
    private JButton btnLogout;
    private JTable table;
    private TableRender tableRender = new TableRender();

    public VOrdutegiaKontsultatu(ArrayList<Horarios> horariosList) {
        // Set up the main frame
        setTitle("Horarios Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 500);
        setLocationRelativeTo(null); // Center the frame

        // Set a modern look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Main content panel
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        // Create header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());

        btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Arial", Font.PLAIN, 14));
        btnLogout.setForeground(Color.BLACK);
        btnLogout.setBackground(new Color(220, 53, 69)); // Bootstrap danger color
        btnLogout.setFocusPainted(false);
        headerPanel.add(btnLogout, BorderLayout.EAST);

        btnAtzera = new JButton("Back");
        btnAtzera.setFont(new Font("Arial", Font.PLAIN, 14));
        btnAtzera.setForeground(Color.BLACK);
        btnAtzera.setBackground(new Color(108, 117, 125)); // Bootstrap secondary color
        btnAtzera.setFocusPainted(false);
        headerPanel.add(btnAtzera, BorderLayout.WEST);

        contentPane.add(headerPanel, BorderLayout.NORTH);

        // Table setup
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"}, 5);
        table = new JTable(model);
        table.setEnabled(false);
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setGridColor(new Color(220, 220, 220));
        table.setBorder(new LineBorder(Color.GRAY, 1));

        // Customize table header
        JTableHeader header = table.getTableHeader();
        header.setReorderingAllowed(false);
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setBackground(new Color(248, 249, 250)); // Light gray
        header.setForeground(Color.BLACK);
        header.setBorder(new LineBorder(Color.GRAY, 1));

        table.setDefaultRenderer(Object.class, tableRender);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(650, 250));
        scrollPane.setBorder(new LineBorder(Color.GRAY, 1));
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Footer panel
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new BorderLayout());

        JButton btnHelp = new JButton("Help");
        btnHelp.setFont(new Font("Arial", Font.PLAIN, 14));
        btnHelp.setForeground(Color.BLACK);
        btnHelp.setBackground(new Color(40, 167, 69)); // Bootstrap success color
        btnHelp.setFocusPainted(false);
        footerPanel.add(btnHelp, BorderLayout.EAST);

        contentPane.add(footerPanel, BorderLayout.SOUTH);

        // Fill table with data
        tableUtils.fillTable(table, horariosList);
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

*/