package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import global.Constants;
import java.awt.Toolkit;

public class VMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton btnOrdutegiaKontsultatu;
	private JButton btnBesteOrdutegiaKontsultatu;
	private JButton btnBilerakKontsultatu;
	private JButton btnLogout;
	private JLabel lblNewLabel;
	private JLabel lblLogo;

	public VMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VMenu.class.getResource("/images/elorrieta.png")));
		setTitle("Menua - JEM Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLogo = new JLabel();
		lblLogo.setBounds(10, 11, 150, 44);
		ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/elorrieta.png"));
		Image logoImage = logoIcon.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(logoImage));
		contentPane.add(lblLogo);
		
		btnOrdutegiaKontsultatu = new JButton("Ordutegia kontsultatu");
		btnOrdutegiaKontsultatu.setForeground(Color.WHITE);
		btnOrdutegiaKontsultatu.setBackground(Color.BLACK);
		btnOrdutegiaKontsultatu.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnOrdutegiaKontsultatu.setFocusPainted(false);
		btnOrdutegiaKontsultatu.setBounds(203, 95, 362, 81);
		contentPane.add(btnOrdutegiaKontsultatu);
		
		btnBesteOrdutegiaKontsultatu = new JButton("Beste ordutegia kontsultatu");
		btnBesteOrdutegiaKontsultatu.setForeground(Color.WHITE);
		btnBesteOrdutegiaKontsultatu.setBackground(Color.BLACK);
		btnBesteOrdutegiaKontsultatu.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnBesteOrdutegiaKontsultatu.setFocusPainted(false);
		btnBesteOrdutegiaKontsultatu.setBounds(203, 215, 362, 81);
		contentPane.add(btnBesteOrdutegiaKontsultatu);
		
		btnBilerakKontsultatu = new JButton("Bilerak kontsultatu");
		btnBilerakKontsultatu.setForeground(Color.WHITE);
		btnBilerakKontsultatu.setBackground(Color.BLACK);
		btnBilerakKontsultatu.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnBilerakKontsultatu.setFocusPainted(false);;
		btnBilerakKontsultatu.setBounds(203, 338, 362, 81);
		contentPane.add(btnBilerakKontsultatu);
		
		btnLogout = new JButton("⬅️ Logout");
		btnLogout.setBackground(Color.RED);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFocusPainted(false);
		btnLogout.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
		btnLogout.setBounds(592, 17, 150, 34);
		contentPane.add(btnLogout);
		
		lblNewLabel = new JLabel("MENUA");
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 29));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 13, 765, 37);
		contentPane.add(lblNewLabel);
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
