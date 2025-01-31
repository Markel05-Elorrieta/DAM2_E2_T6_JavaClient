package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import global.Constants;
import model.Users;

import javax.swing.JTextField;

public class VBilerakSortu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtzera;
	private JButton btnSortu;
	private JTextField txtTitle;
	private JTextField txtGaia;
	private JTextField txtData;
	private JTextField txtTime;
	
	private JComboBox comboBox;


	public VBilerakSortu(ArrayList<Users> userList) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		btnAtzera = new JButton("Atzera");
		btnAtzera.setForeground(Color.WHITE);
		btnAtzera.setBackground(Color.BLACK);
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnAtzera.setFocusPainted(false);
		btnAtzera.setBounds(10, 11, 115, 36);
		contentPane.add(btnAtzera);
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSortu = new JButton("Gorde");
		btnSortu.setForeground(Color.WHITE);
		btnSortu.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnSortu.setFocusPainted(false);
		btnSortu.setBackground(Color.BLACK);
		btnSortu.setBounds(181, 421, 115, 36);
		contentPane.add(btnSortu);
		
		JLabel lblTitle = new JLabel("BILERA");
		lblTitle.setBounds(99, 58, 105, 36);
		contentPane.add(lblTitle);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(61, 105, 180, 36);
		txtTitle.setToolTipText("Izenburua");
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
		txtGaia = new JTextField();
		txtGaia.setToolTipText("Gaia");
		txtGaia.setColumns(10);
		txtGaia.setBounds(61, 163, 180, 36);
		contentPane.add(txtGaia);
		
		txtData = new JTextField();
		txtData.setToolTipText("yyyy/mm/dd");
		txtData.setColumns(10);
		txtData.setBounds(61, 210, 180, 36);
		contentPane.add(txtData);
		
		txtTime = new JTextField();
		txtTime.setToolTipText("HH:mm");
		txtTime.setColumns(10);
		txtTime.setBounds(61, 257, 180, 36);
		contentPane.add(txtTime);
		
		comboBox = new JComboBox();
		initializeComboBox(userList);
		comboBox.setBounds(61, 304, 130, 22);
		contentPane.add(comboBox);
	}
	
	public JButton getBtnSortu() {
		return btnSortu;
	}
	
	public JButton getBtnAtzera() {
		return btnAtzera;
	}
	
	private void initializeComboBox(ArrayList<Users> userList) {
		for (int i = 0; i < userList.size(); i++) {
			comboBox.addItem(userList.get(i).getNombre() + " " + userList.get(i).getApellidos());
		}
		comboBox.setSelectedIndex(-1);

	}
}
