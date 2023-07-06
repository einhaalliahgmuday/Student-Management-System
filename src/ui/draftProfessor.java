package ui;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import java.awt.*;

public class Professor extends JFrame {
	
	JLabel lblSMS, lblFacultyLoad;
	
	
	
	
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
		lblSMS.setBounds(303, 15, 445, 40);
		lblSMS.setFont(new Font("Tahoma", 1, 30));
		lblSMS.setForeground(new Color(255, 255, 255));
		
		panelBackground = new JPanel();
		panelBackground.setBounds(17, 65, 1001, 528);
		panelBackground.setLayout(null);
		panelBackground.setBackground(new Color(255, 255, 255));
		
		panel = new JPanel();
		panel.setBounds(20, 68, 995, 522);
		panel.setLayout(null);
		panel.setBackground(new Color(245, 225, 187));
		
		lblFacultyLoad = new JLabel("Faculty Load");
		lblFacultyLoad.setBounds(20, 15, 150, 24);
		lblFacultyLoad.setFont(new Font("Tahoma", 1, 16));
		lblFacultyLoad.setForeground(new Color(0, 0, 0));
		
		panel.add(lblFacultyLoad);
		
		
		

			
			
	
			
			
			String column[] = {"#", "Subject Code", "Subject Description", "Section Code", "Schedule", " ", " "};
			String data[][] = {{"1", "COMP20083", "Object Oriented Programming", "BSIT 2-1", "Sat 2:00PM-8:00PM", "", ""}}; 
			
			studentTbl = new JTable(data, column);
//			studentTbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
			
//			for (int i = 0; i < studentTbl.getColumnCount(); i++) {
//				studentTbl.getColumnModel().getColumn(i).setPreferredWidth(180);
//			}
			
			scrollPane = new JScrollPane(studentTbl);
			scrollPane.setBounds(17, 49, 960, 414);
			scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			
			
			panel.add(scrollPane);
			    
			
			
			
		add(lblSMS);
		add(panel);
		add(panelBackground);
		setVisible(true);
	}

}
