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
import model.Ikastetxeak;
import model.Reuniones;
import java.awt.Component;
import javax.swing.Box;

public class VBileraXehetasunak extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtzera;
	private JButton btnLogout;
	private JLabel lblLogo;
	
	public VBileraXehetasunak(Reuniones r, Ikastetxeak i) {
		setTitle("Bilera xehetasuna - JEM Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAtzera = new JButton("⬅️ Atzera");
		btnAtzera.setHorizontalAlignment(SwingConstants.RIGHT);
		btnAtzera.setForeground(Color.WHITE);
		btnAtzera.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 17));
		btnAtzera.setBackground(Color.CYAN);
		btnAtzera.setBounds(20, 426, 140, 34);
		contentPane.add(btnAtzera);
		
		btnLogout = new JButton("❌ Logout");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
		btnLogout.setFocusPainted(false);
		btnLogout.setBackground(Color.RED);
		btnLogout.setBounds(605, 10, 150, 34);
		contentPane.add(btnLogout);
		
		lblLogo = new JLabel();
		lblLogo.setBounds(10, 10, 150, 44);
		ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/elorrieta.png"));
		Image logoImage = logoIcon.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(logoImage));
		contentPane.add(lblLogo);
		
		JLabel lblBileraXeh = new JLabel("BILERA XEHETASUNA");
		lblBileraXeh.setHorizontalAlignment(SwingConstants.CENTER);
		lblBileraXeh.setFont(new Font("Segoe UI Variable", Font.PLAIN, 29));
		lblBileraXeh.setBounds(0, 10, 765, 40);
		contentPane.add(lblBileraXeh);
		
		JLabel lblIzenburua = new JLabel("");
		lblIzenburua.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzenburua.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		lblIzenburua.setText(r.getTitulo());
		lblIzenburua.setBounds(10, 69, 745, 34);
		contentPane.add(lblIzenburua);
		
		JLabel lblEgoera = new JLabel("");
		lblEgoera.setHorizontalAlignment(SwingConstants.CENTER);
		lblEgoera.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
		lblEgoera.setText(r.getEstado());
		lblEgoera.setBounds(269, 123, 225, 34);
		contentPane.add(lblEgoera);
		
		JLabel lblAsuntoa = new JLabel("");
		lblAsuntoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsuntoa.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		lblAsuntoa.setText("Asuntoa: " + r.getAsunto());
		lblAsuntoa.setBounds(279, 285, 225, 34);
		contentPane.add(lblAsuntoa);
		
		JLabel lblData = new JLabel("");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		lblData.setText("Data: " + r.getFecha().toString());
		lblData.setBounds(269, 177, 225, 34);
		contentPane.add(lblData);
		
		JLabel lblAula = new JLabel("");
		lblAula.setHorizontalAlignment(SwingConstants.CENTER);
		lblAula.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		lblAula.setText("Aula: " + r.getAula());
		lblAula.setBounds(269, 231, 225, 34);
		contentPane.add(lblAula);
		
		JLabel lblIkastetxeaIzena = new JLabel("");
		lblIkastetxeaIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIkastetxeaIzena.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		lblIkastetxeaIzena.setText("Ikastetxea: " + i.getNOM());
		lblIkastetxeaIzena.setBounds(269, 342, 225, 34);
		contentPane.add(lblIkastetxeaIzena);
		
		JLabel lblIkastetxeaEmail = new JLabel("");
		lblIkastetxeaEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIkastetxeaEmail.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		lblIkastetxeaEmail.setText("E-mail: " + i.getEMAIL());
		lblIkastetxeaEmail.setBounds(269, 396, 225, 34);
		contentPane.add(lblIkastetxeaEmail);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(67, 319, 632, 12);
		contentPane.add(horizontalStrut);
	}
}


