package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import global.Constants;

import javax.swing.JButton;

public class VMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton btnOrdutegiaKontsultatu;
	private JButton btnBesteOrdutegiaKontsultatu;
	private JButton btnBilerakKontsultatu;
	private JButton btnLogout;

	public VMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnOrdutegiaKontsultatu = new JButton("btnOrdutegiaKontsultatu");
		btnOrdutegiaKontsultatu.setBounds(55, 32, 181, 23);
		contentPane.add(btnOrdutegiaKontsultatu);
		
		btnBesteOrdutegiaKontsultatu = new JButton("btnBesteOrdutegiaKontsultatu");
		btnBesteOrdutegiaKontsultatu.setBounds(55, 68, 181, 23);
		contentPane.add(btnBesteOrdutegiaKontsultatu);
		
		btnBilerakKontsultatu = new JButton("btnBilerakKontsultatu");
		btnBilerakKontsultatu.setBounds(55, 110, 181, 23);
		contentPane.add(btnBilerakKontsultatu);
		
		btnLogout = new JButton("btnLogout");
		btnLogout.setBounds(179, 205, 89, 23);
		contentPane.add(btnLogout);
	}
	
	public JButton getBtnOrdutegiaKontsultatu() {
		return btnOrdutegiaKontsultatu;
	}
	
	public JButton getBtnBesteOrdutegiaKontsultatu() {
		return btnBesteOrdutegiaKontsultatu;
	}
	
	public JButton getBtnBilerakKontsultatu() {
		return btnBilerakKontsultatu;
	}
	
	public JButton getBtnLogout() {
		return btnLogout;
	}
}
