package ui;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import java.awt.*;

public class Professor extends JFrame {
	
	JLabel lblSMS, lblFacultyLoad;
	JButton bttnClassList, bttnGradingSheet, bttnLogout;
	JPanel panelBackground, panel;
	JTable studentTbl;
	JScrollPane scrollPane;
	
	Professor() {
		
		setTitle("Student Management System - Professor");
		setSize(1050, 650);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(187, 37, 61));
		
		lblSMS = new JLabel("Student Management System");
		lblSMS.setBounds(303, 20, 445, 40);
		lblSMS.setFont(new Font("Tahoma", 1, 30));
		lblSMS.setForeground(new Color(255, 255, 255));
		
		bttnLogout = new JButton("Logout");
		bttnLogout.setBounds(915, 52, 100, 25);
		bttnLogout.setBorderPainted(false);
		bttnLogout.setBackground(null);
		bttnLogout.setFont(new Font("Tahoma", 1, 14));
		bttnLogout.setForeground(new Color(255, 255, 255));
		
		panel = new JPanel();
		panel.setBounds(20, 85, 995, 500);
		panel.setLayout(null);
		panel.setBackground(new Color(245, 225, 187));
		
		lblFacultyLoad = new JLabel("Faculty Load");
		lblFacultyLoad.setBounds(20, 19, 150, 30);
		lblFacultyLoad.setFont(new Font("Tahoma", 1, 20));
		lblFacultyLoad.setForeground(new Color(0, 0, 0));
		
		bttnClassList = new JButton("Class List");
		bttnClassList.setBounds(657, 20, 150, 25);
		bttnClassList.setFont(new Font("Tahoma", 1, 14));
		bttnClassList.setForeground(new Color(0, 0, 0));
		
		bttnGradingSheet = new JButton("Grading Sheet");
		bttnGradingSheet.setBounds(827, 20, 150, 25);
		bttnGradingSheet.setFont(new Font("Tahoma", 1, 14));
		bttnGradingSheet.setForeground(new Color(0, 0, 0));
		
		
		String column[] = {"#", "Subject Code", "Subject Description", "Section Code", "Schedule"};
		String data[][] = {{"1", "COMP20083", "Object Oriented Programming", "BSIT 2-1", "Sat 2:00PM-8:00PM"}}; 
		
		studentTbl = new JTable(data, column);
		studentTbl.setRowHeight(30);
		studentTbl.setGridColor(new Color(0, 0, 0));
		studentTbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		studentTbl.setForeground(new Color(0, 0, 0));
		studentTbl.setFillsViewportHeight(true);
		studentTbl.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JTableHeader studentTblHeader = studentTbl.getTableHeader();
		studentTblHeader.setBackground(new Color(245, 245, 245));
		studentTblHeader.setFont(new Font("Tahoma", Font.PLAIN, 12));
		studentTblHeader.setForeground(new Color(0, 0, 0));
		
		scrollPane = new JScrollPane(studentTbl);
		scrollPane.setBounds(17, 61, 960, 414);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		panel.add(lblFacultyLoad);
		panel.add(bttnClassList);
		panel.add(bttnGradingSheet);
		panel.add(scrollPane);
			    	
			
		add(lblSMS);
		add(panel);
		add(bttnLogout);
		setVisible(true);
	}

}
