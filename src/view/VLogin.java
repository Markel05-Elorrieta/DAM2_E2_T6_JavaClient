package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import global.Constants;

public class VLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JButton btnLogin;
	private Image backgroundImage;

	public VLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		backgroundImage = new ImageIcon(getClass().getResource("/images/fondo-clase.jpg")).getImage();

        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPasahitza = new JLabel("Pasahitza");
		lblPasahitza.setBackground(Color.BLACK);
		lblPasahitza.setForeground(Color.WHITE);
		lblPasahitza.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPasahitza.setBounds(234, 252, 94, 25);
		contentPane.add(lblPasahitza);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBackground(Color.BLACK);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(234, 163, 69, 25);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setBounds(234, 199, 323, 31);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setForeground(Color.BLACK);
		txtPassword.setBackground(Color.WHITE);
		txtPassword.setBounds(234, 288, 323, 31);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(329, 405, 127, 40);
		btnLogin.setBackground(Color.BLUE);
		btnLogin.setFocusPainted(false);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Arial", Font.BOLD, 17));
		contentPane.add(btnLogin);
		
		JLabel lblLogo = new JLabel();
		lblLogo.setOpaque(true);
		lblLogo.setBackground(Color.WHITE);
		lblLogo.setBounds(198, 21, 392, 109);
		ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/elorrieta.png"));
		Image logoImage = logoIcon.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(logoImage));
		contentPane.add(lblLogo);

	}
	
	public void showInfoMessage (String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JTextField getTxtPassword() {
		return txtPassword;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}
}
