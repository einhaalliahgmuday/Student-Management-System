package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DraftLogin extends JFrame {

	private JPanel panel1, panel2;
	private JSeparator sprtrUserID, sprtrPassword;
	private JRadioButton rdbtnProfessor, rdbtnAdmin;
	private ButtonGroup btngrpUser;
	private JLabel lblSMS1, lblSMS2, lblLogin, lblUserID, lblPassword;
	private JTextField txtfldUserID;
	private JPasswordField txtfldPassword;
	private JButton btnLogin;	//btnForgotPassword
	
	
	DraftLogin() {
		
		setTitle("Student Management System - Login");
		setSize(1050, 650);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lblSMS1 = new JLabel("Student Management");
		lblSMS1.setBounds(40, 200, 450, 55);
		lblSMS1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblSMS1.setForeground(new Color(255, 255, 255));
		
		lblSMS2 = new JLabel("System");
		lblSMS2.setBounds(170, 275, 200, 55);
		lblSMS2.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblSMS2.setForeground(new Color(255, 255, 255));
		
		panel1 = new JPanel();
		panel1.setBounds(0, 0, 525, 650);
		panel1.setLayout(null);
		panel1.setBackground(new Color(187, 37, 61));
		panel1.add(lblSMS1);
		panel1.add(lblSMS2);
		
		
		rdbtnProfessor = new JRadioButton("Professor");
		rdbtnProfessor.setBounds(360, 170, 100, 25);
		rdbtnProfessor.setFont(new Font("Arial", Font.PLAIN, 15));
		
		rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setBounds(550, 170, 100, 25);
		rdbtnAdmin.setFont(new Font("Arial", Font.PLAIN, 15));
		
		btngrpUser = new ButtonGroup();
		btngrpUser.add(rdbtnProfessor);
		btngrpUser.add(rdbtnAdmin);
		
		
		lblLogin = new JLabel("Login");
		lblLogin.setBounds(190, 100, 150, 55);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblLogin.setForeground(new Color(0, 0, 0));
		
		lblUserID = new JLabel("User ID");
		lblUserID.setBounds(50, 210, 200, 30);
		lblUserID.setFont(new Font("Tahoma", 1, 20));
		
		txtfldUserID = new JTextField();
		txtfldUserID.setBorder(null);
		txtfldUserID.setBounds(50, 245, 425, 40);
		txtfldUserID.setBackground(null);
		txtfldUserID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		sprtrUserID = new JSeparator();
		sprtrUserID.setOrientation(SwingConstants.HORIZONTAL);
		sprtrUserID.setBounds(50, 290, 410, 1);
		sprtrUserID.setForeground(new Color(0, 0, 0));
		
		lblPassword = new JLabel("Password ");
		lblPassword.setBounds(50, 310, 200, 30);
		lblPassword.setFont(new Font("Tahoma", 1, 20));
		
		txtfldPassword = new JPasswordField();
		txtfldPassword.setBorder(null);
		txtfldPassword.setBounds(50, 345, 425, 40);
		txtfldPassword.setBackground(null);
		txtfldPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		sprtrPassword = new JSeparator();
		sprtrPassword.setOrientation(SwingConstants.HORIZONTAL);
		sprtrPassword.setBounds(50, 390, 410, 1);
		sprtrPassword.setForeground(new Color(0, 0, 0));
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(163, 440, 200, 40);
		btnLogin.setFont(new Font("Tahoma", 1, 15));
		btnLogin.setBorder(null);
		btnLogin.setBackground(new Color(187, 37, 61));
		btnLogin.setForeground(new Color(0, 0, 0));
		
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(525, 0, 525, 650);
		panel2.setBackground(new Color(245, 225, 187));
		panel2.add(lblLogin);
		panel2.add(lblUserID);
		panel2.add(txtfldUserID);
		panel2.add(sprtrUserID);
		panel2.add(lblPassword);
		panel2.add(txtfldPassword);
		panel2.add(sprtrPassword);
		panel2.add(btnLogin);
		
		
		add(panel1);
		add(panel2);
		setVisible(true);
		
	}
}
