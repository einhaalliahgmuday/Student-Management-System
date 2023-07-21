//This class is the UI to login into an SMS account.

package ui;

import javax.swing.*;

import models.Admin;
import models.Professor;
import models.User;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class SMSLogin extends JFrame implements ActionListener {
	
	User user = new User();		//@User is instantiated to validate user inputs of ID and password.
	SMSDialog smsDialogs = new SMSDialog();		//@SMSDialog is instantiated to display dialogs if login errors occur.
	
	//Components used
	private JPanel panel1, panel2;
	private JLabel lblSMS1, lblSMS2, lblLogin, lblUserID, lblPassword;
	private JSeparator sprtrUserID, sprtrPassword;
	private JRadioButton rdbttnProfessor, rdbttnAdmin;
	private ButtonGroup bttngrpUser;
	private JTextField txtfldUserID;
	private JPasswordField txtfldPassword;
	private JButton bttnLogin;
	
	SMSLogin() throws SQLException {	
		
		setTitle("Student Management System - Login");
		setSize(1050, 650);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Panel 1
		lblSMS1 = new JLabel("Student Management");
		lblSMS1.setBounds(45, 200, 450, 55);
		lblSMS1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblSMS1.setForeground(new Color(255, 255, 255));
		
		lblSMS2 = new JLabel("System");
		lblSMS2.setBounds(190, 275, 200, 55);
		lblSMS2.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblSMS2.setForeground(new Color(255, 255, 255));
		
		panel1 = new JPanel();
		panel1.setBounds(0, 0, 525, 650);
		panel1.setLayout(null);
		panel1.setBackground(new Color(187, 37, 61));
		panel1.add(lblSMS1);
		panel1.add(lblSMS2);
		
		
		//Panel 2
		lblLogin = new JLabel("Login");
		lblLogin.setBounds(198, 100, 150, 55);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblLogin.setForeground(new Color(0, 0, 0));
		
		rdbttnProfessor = new JRadioButton("Professor");
		rdbttnProfessor.setBounds(130, 190, 100, 25);
		rdbttnProfessor.setBackground(null);
		rdbttnProfessor.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
		rdbttnAdmin = new JRadioButton("Admin");
		rdbttnAdmin.setBounds(311, 190, 100, 25);
		rdbttnAdmin.setBackground(null);
		rdbttnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		bttngrpUser = new ButtonGroup();
		bttngrpUser.add(rdbttnProfessor);
		bttngrpUser.add(rdbttnAdmin);
		rdbttnProfessor.doClick();
		
		lblUserID = new JLabel("ID");
		lblUserID.setBounds(50, 230, 200, 30);
		lblUserID.setFont(new Font("Tahoma", 1, 20));
		
		txtfldUserID = new JTextField();
		txtfldUserID.setBorder(null);
		txtfldUserID.setBounds(50, 265, 425, 40);
		txtfldUserID.setBackground(null);
		txtfldUserID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		sprtrUserID = new JSeparator();
		sprtrUserID.setOrientation(SwingConstants.HORIZONTAL);
		sprtrUserID.setBounds(50, 310, 410, 1);
		sprtrUserID.setForeground(new Color(0, 0, 0));
		
		lblPassword = new JLabel("Password ");
		lblPassword.setBounds(50, 330, 200, 30);
		lblPassword.setFont(new Font("Tahoma", 1, 20));
		
		txtfldPassword = new JPasswordField();
		txtfldPassword.setBorder(null);
		txtfldPassword.setBounds(50, 365, 425, 40);
		txtfldPassword.setBackground(null);
		txtfldPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		sprtrPassword = new JSeparator();
		sprtrPassword.setOrientation(SwingConstants.HORIZONTAL);
		sprtrPassword.setBounds(50, 410, 410, 1);
		sprtrPassword.setForeground(new Color(0, 0, 0));
		
		bttnLogin = new JButton("Login");
		bttnLogin.setBounds(155, 460, 200, 40);
		bttnLogin.setFont(new Font("Tahoma", 1, 15));
		bttnLogin.setBorder(null);
		bttnLogin.setBackground(new Color(187, 37, 61));
		bttnLogin.setForeground(new Color(0, 0, 0));
		bttnLogin.addActionListener(this);
		
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
		panel2.add(rdbttnProfessor);
		panel2.add(rdbttnAdmin);
		panel2.add(bttnLogin);
		
		
		add(panel1);
		add(panel2);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//The user inputs are placed in new Strings, which will be used by the conditional statements. 
		String userID = txtfldUserID.getText();
		String password = new String(txtfldPassword.getPassword());
		
		/* If the selected user type is "Professor", the "loginAsProfessor()" method of @User class is called, which
		 * returns an instance of @Professor. If the account is not found, the instance would be null and will not proceed to
		 * @SMSProfessor.
		 */
		if (rdbttnProfessor.isSelected()) {
			try {
				Professor professor = user.loginAsProfessor(userID, password);
				if (professor != null) {
					dispose();
					new SMSFaculty(professor);
				}
				else {
					//This is the dialog that displays when login fails.
					smsDialogs.showMessageDialog(this, "Login Failed!", "You entered an invalid ID or password.");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		/* If the selected user type is "Admin", the "loginAsAdmin()" method of @User class is called, which returns
		 * an instance of @Admin. If the account is not found, the instance would be null and will not proceed to
		 * @SMSAdmin.
		 */
		else if (rdbttnAdmin.isSelected()) {
			try {
				Admin admin = user.loginAsAdmin(userID, password);
				if (admin != null) {
					dispose();
					new SMSAdmin(admin);
				}
				else {
					//This is the dialog that displays when login fails.
					smsDialogs.showMessageDialog(this, "Login Failed!", "You entered an invalid ID or password.");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
}
