package ui;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class Admin extends JFrame {
	
	JLabel lblSMS;
	JTabbedPane tabbedPane;
	JPanel pnlStudent, pnlProfessor, pnlFacultyLoad, pnlGrades;
	JPanel studentPnl1, studentPnl2;
	JLabel lblStudentNo, lblName, lblSex, lblBirthday, lblSectionCode, lblEmail, lblContactNo, lblAddress;
	JTextField txtfldStudentNo, txtfldName, txtfldBirthday, txtfldSectionCode, txtfldEmail, 
				txtfldContactNo, txtfldAddress;
	JRadioButton rdbttnMale, rdbttnFemale;
	ButtonGroup bttngrpSex;
	JButton bttnAdd;
	
	
	Admin() {
		
		setTitle("Student Management System - Admin");
		setSize(1050, 650);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(187, 37, 61));
		
		lblSMS = new JLabel("Student Management System");
		lblSMS.setBounds(303, 15, 445, 40);
		lblSMS.setFont(new Font("Tahoma", 1, 30));
		lblSMS.setForeground(new Color(255, 255, 255));
		
		
		lblStudentNo = new JLabel("Student No:");
		lblStudentNo.setBounds(17, 10, 100, 22);
		lblStudentNo.setFont(new Font("Tahoma", 1, 12));
		
		txtfldStudentNo = new JTextField();
		txtfldStudentNo.setBounds(130, 10, 201, 22);
		txtfldStudentNo.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldStudentNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblName = new JLabel("Name:");
		lblName.setBounds(17, 42, 100, 22);
		lblName.setFont(new Font("Tahoma", 1, 12));
		
		txtfldName = new JTextField();
		txtfldName.setBounds(130, 42, 201, 22);
		txtfldName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblSex = new JLabel("Sex: ");
		lblSex.setBounds(17, 74, 100, 22);
		lblSex.setFont(new Font("Tahoma", 1, 12));
		
		rdbttnMale = new JRadioButton("Male");
		rdbttnMale.setBounds(130, 74, 100, 22);
		rdbttnMale.setBackground(null);
		rdbttnMale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		rdbttnFemale = new JRadioButton("Female");
		rdbttnFemale.setBounds(240, 74, 100, 22);
		rdbttnFemale.setBackground(null);
		rdbttnFemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		bttngrpSex = new ButtonGroup();
		bttngrpSex.add(rdbttnMale);
		bttngrpSex.add(rdbttnFemale);

		
		studentPnl1 = new JPanel();
		studentPnl1.setBounds(6, 4, 350, 480);
		studentPnl1.setLayout(null);
		studentPnl1.setBackground(new Color(245, 225, 187));
		studentPnl1.add(lblStudentNo);
		studentPnl1.add(txtfldStudentNo);
		studentPnl1.add(lblName);
		studentPnl1.add(txtfldName);
		studentPnl1.add(lblSex);
		studentPnl1.add(rdbttnMale);
		studentPnl1.add(rdbttnFemale);
		
		studentPnl2 = new JPanel();
		studentPnl2.setBounds(363, 4, 622, 480);
		studentPnl2.setLayout(null);
		studentPnl2.setBackground(new Color(245, 225, 187));
		
		pnlStudent = new JPanel();
		pnlStudent.setLayout(null);
		pnlStudent.setBackground(new Color(187, 37, 61));
		pnlStudent.add(studentPnl1);
		pnlStudent.add(studentPnl2);
		
		
		pnlProfessor = new JPanel();
		pnlProfessor.setLayout(null);
		pnlProfessor.setBackground(new Color(187, 37, 61));
		
		
		pnlFacultyLoad = new JPanel();
		pnlFacultyLoad.setLayout(null);
		pnlFacultyLoad.setBackground(new Color(187, 37, 61));
		
		
		pnlGrades = new JPanel();
		pnlGrades.setLayout(null);
		pnlGrades.setBackground(new Color(187, 37, 61));
		
		
		tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(20, 70, 995, 520);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.addTab("Student", pnlStudent);
		tabbedPane.addTab("Professor", pnlProfessor);
		tabbedPane.addTab("Faculty Load", pnlFacultyLoad);
		tabbedPane.addTab("Grades", pnlGrades);
		
		add(lblSMS);
		add(tabbedPane);
		setVisible(true);
	}

}
