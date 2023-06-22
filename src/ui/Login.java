package ui;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

	private JRadioButton rdbtnProfessor, rdbtnAdmin;
	private ButtonGroup btngrpUser;
	private JLabel lblSMS, lblUserID, lblPassword;
	private JTextField txtfldUserID;
	private JPasswordField txtfldPassword;
	private JButton btnLogin;	//btnForgotPassword
	
	
	Login() {
		
		setTitle("Student Management System - Login");
		setSize(1000, 600);
		// getContentPane().setForeground(Color.red);;
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		lblSMS = new JLabel("Student Management System");
		lblSMS.setBounds(195, 100, 600, 55);
		lblSMS.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		rdbtnProfessor = new JRadioButton("Professor");
		rdbtnProfessor.setBounds(360, 170, 100, 25);
		rdbtnProfessor.setFont(new Font("Arial", Font.PLAIN, 15));
		
		rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setBounds(550, 170, 100, 25);
		rdbtnAdmin.setFont(new Font("Arial", Font.PLAIN, 15));
		
		btngrpUser = new ButtonGroup();
		btngrpUser.add(rdbtnProfessor);
		btngrpUser.add(rdbtnAdmin);
		
		lblUserID = new JLabel("User ID: ");
		lblUserID.setBounds(350, 220, 100, 30);
		lblUserID.setFont(new Font("Arial", Font.BOLD, 15));
		
		txtfldUserID = new JTextField();
		txtfldUserID.setBounds(450, 220, 200, 30);
		txtfldUserID.setFont(new Font("Arial", Font.PLAIN, 15));
		
		lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(333, 270, 100, 30);
		lblPassword.setFont(new Font("Arial", Font.BOLD, 15));
		
		txtfldPassword = new JPasswordField();
		txtfldPassword.setBounds(450, 270, 200, 30);
		txtfldPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		
		btnLogin = new JButton("Log In");
		btnLogin.setBounds(415, 335, 150, 30);
		btnLogin.setFont(new Font("Arial", Font.BOLD, 15));
		
		
		add(lblSMS);
		add(rdbtnProfessor);
		add(rdbtnAdmin);
		add(lblUserID);
		add(txtfldUserID);
		add(lblPassword);
		add(txtfldPassword);
		add(btnLogin);
		
	}
}
