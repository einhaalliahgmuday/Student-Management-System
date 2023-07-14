package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.JTableHeader;

public class GradingSheet extends JFrame {
	    
	    private JLabel lblSMS;
	    private JPanel pnlStudent, pnlProfessor, pnlFacultyLoad;
		
	    private JPanel studentPnl1, studentPnl2;
	    private JLabel lblStudentNo, lblName, lblMidtermGrade, lblFinalGrade
	            ,lblAttendanceGrade, lblFinalRating, lblRemarks;
	    private JTextField txtfldStudentNo, txtfldName, txtfldMidterGrade, txtfldFinalGrade
	            ,txtfldAttendanceGrade, txtfldFinalRating;
	    private JButton bttnSave;
	    
	    private JLabel lblSchoolYear, lblSemester, lblSubject, lblSection, lblSchedule;
	    private JLabel lblYear, lblSem, lblSub1, lblSub2, lblSect, lblSched1, lblSched2;
		
	    private JLabel lblSearch;
	    private JComboBox cmbbxSearch;
	    private JTextField txtfldSearch;
	    private JButton bttnSearch, bttnClear, bttnDelete;
	    private JTable studentTbl;
	    private JScrollPane scrollPane;
	    
	    public GradingSheet(){
	        
	        //FRAME PROPERTIES
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
	        
	        //PANEL 1
	        lblStudentNo = new JLabel("Student No:");
		lblStudentNo.setBounds(17, 50, 100, 22);
		lblStudentNo.setFont(new Font("Tahoma", 1, 12));
		lblStudentNo.setForeground(new Color(0, 0, 0));
			
		txtfldStudentNo = new JTextField();
		txtfldStudentNo.setBounds(130, 50, 201, 22);
		txtfldStudentNo.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldStudentNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldStudentNo.setEditable(false);
	        
		lblName = new JLabel("First Name:");
		lblName.setBounds(17, 82, 100, 22);
		lblName.setFont(new Font("Tahoma", 1, 12));
		lblName.setForeground(new Color(0, 0, 0));
			
		txtfldName = new JTextField();
		txtfldName.setBounds(130, 82, 201, 22);
		txtfldName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldName.setEditable(false);
	        
	        lblMidtermGrade = new JLabel("Midterm Grade:");
	        lblMidtermGrade.setBounds(17, 114, 100, 22);
	        lblMidtermGrade.setFont(new Font("Tahoma", 1, 12));
		lblMidtermGrade.setForeground(new Color(0, 0, 0));
	        
	        txtfldMidterGrade = new JTextField();
	        txtfldMidterGrade.setBounds(130, 114, 201, 22);
		txtfldMidterGrade.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldMidterGrade.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        
	        lblFinalGrade = new JLabel("Final Grade:");
	        lblFinalGrade.setBounds(17, 146, 100, 22);
	        lblFinalGrade.setFont(new Font("Tahoma", 1, 12));
		lblFinalGrade.setForeground(new Color(0, 0, 0));
	        
	        txtfldFinalGrade = new JTextField();
	        txtfldFinalGrade.setBounds(130, 146, 201, 22);
		txtfldFinalGrade.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldFinalGrade.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        
	        lblAttendanceGrade = new JLabel("Final Grade:");
	        lblAttendanceGrade.setBounds(17, 178, 100, 22);
	        lblAttendanceGrade.setFont(new Font("Tahoma", 1, 12));
		lblAttendanceGrade.setForeground(new Color(0, 0, 0));
	        
	        txtfldAttendanceGrade = new JTextField();
	        txtfldAttendanceGrade.setBounds(130, 178, 201, 22);
		txtfldAttendanceGrade.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldAttendanceGrade.setFont(new Font("Tahoma", Font.PLAIN, 12));

	        lblFinalRating = new JLabel("Final Rating:");
	        lblFinalRating.setBounds(17, 210, 100, 22);
	        lblFinalRating.setFont(new Font("Tahoma", 1, 12));
		lblFinalRating.setForeground(new Color(0, 0, 0));
	        
	        txtfldFinalRating = new JTextField();
	        txtfldFinalRating.setBounds(130, 210, 201, 22);
		txtfldFinalRating.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldFinalRating.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        
		bttnSave = new JButton("Save");
		bttnSave.setBounds(130, 280, 130, 22);
		bttnSave.setFont(new Font("Tahoma", 1, 12));
		bttnSave.setForeground(new Color(0, 0, 0));
	        
	        pnlStudent = new JPanel();
	        pnlStudent.setBounds(5,200,390,400);
		pnlStudent.setLayout(null);
		pnlStudent.setBackground(new Color(245, 225, 187));
	        pnlStudent.add(lblStudentNo);
		pnlStudent.add(txtfldStudentNo);
		pnlStudent.add(lblName);
		pnlStudent.add(txtfldName);
	        pnlStudent.add(lblMidtermGrade);
	        pnlStudent.add(txtfldMidterGrade);
	        pnlStudent.add(lblFinalGrade);
	        pnlStudent.add(txtfldFinalGrade);
	        pnlStudent.add(lblAttendanceGrade);
	        pnlStudent.add(txtfldAttendanceGrade);
	        pnlStudent.add(lblFinalRating);
	        pnlStudent.add(txtfldFinalRating);
	        pnlStudent.add(bttnSave);
	        
	        
	        //PANEL 2 
	        lblSearch = new JLabel("Search");
		lblSearch.setBounds(17, 17, 60, 22);
		lblSearch.setFont(new Font("Tahoma", 1, 12));
		lblSearch.setForeground(new Color(0, 0, 0));
			
		String[] search = {"Student No", "Section"};
		cmbbxSearch = new JComboBox(search);
		cmbbxSearch.setBounds(65, 17, 90, 22);
		cmbbxSearch.setForeground(Color.BLACK);
		cmbbxSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
		txtfldSearch = new JTextField();
		txtfldSearch.setBounds(160, 17, 190, 22);
		txtfldSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
	        //PANEL 2 - BUTTONS
		bttnSearch = new JButton("Search");
		bttnSearch.setBounds(355, 17, 80, 22);
		bttnSearch.setFont(new Font("Tahoma", 1, 12));
		bttnSearch.setForeground(new Color(0, 0, 0));
			
		bttnClear = new JButton("Clear");
		bttnClear.setBounds(440, 17, 80, 22);
		bttnClear.setFont(new Font("Tahoma", 1, 12));
		bttnClear.setForeground(new Color(0, 0, 0));
			
		bttnDelete = new JButton("Delete");
		bttnDelete.setBounds(525, 17, 80, 22);
		bttnDelete.setFont(new Font("Tahoma", 1, 12));
		bttnDelete.setForeground(new Color(0, 0, 0));
			
	        
	        //DATA FOR TABLE
	        String column[] = 
	        {"Student No", "Name","Attendance","Midterm","Finals","Final Rating"};
		String data[][] = 
	        {{"2021-00214-BN-0", "Einha Alliah Muday","1","2","3","4"}, 
		{"2021-00212-BN-0", "Michi Legaspino","1","2","3","4"}}; 
		
	        //TABLE PROPERTIES  
		studentTbl = new JTable(data, column);//edit header
		studentTbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		studentTbl.setRowHeight(22);
		studentTbl.setGridColor(Color.BLACK);
		studentTbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		studentTbl.setForeground(new Color(0, 0, 0));
		studentTbl.setFillsViewportHeight(true);
		studentTbl.setBorder(new LineBorder(Color.BLACK));
	        
		JTableHeader studentTblHeader = studentTbl.getTableHeader();
		studentTblHeader.setBackground(new Color(245, 245, 245));
		studentTblHeader.setFont(new Font("Tahoma", Font.PLAIN, 12));
		studentTblHeader.setForeground(Color.BLACK);
			
		for (int i = 0; i < studentTbl.getColumnCount(); i++) {
			studentTbl.getColumnModel().getColumn(i).setPreferredWidth(180);
		}
			
		scrollPane = new JScrollPane(studentTbl);
		scrollPane.setBounds(20, 55, 590, 300);
		scrollPane.setBorder(new LineBorder(Color.BLACK));
	        
	        pnlProfessor = new JPanel();
	        pnlProfessor.setBounds(400,200,630,400);
		pnlProfessor.setLayout(null);
		pnlProfessor.setBackground(new Color(245, 225, 187));
	        pnlProfessor.add(scrollPane);
	        pnlProfessor.add(lblSearch);
	        pnlProfessor.add(cmbbxSearch);
	        pnlProfessor.add(txtfldSearch);
	        pnlProfessor.add(bttnSearch);
	        pnlProfessor.add(bttnClear);
	        pnlProfessor.add(bttnDelete);
	        
	        
	        //PANEL 3
	        lblSchoolYear = new JLabel("School Year");
	        lblSchoolYear.setBounds(50, 25, 120, 22);
		lblSchoolYear.setFont(new Font("Tahoma", 1, 17));
		lblSchoolYear.setForeground(new Color(0, 0, 0));
	        
	        lblYear = new JLabel("2023");
	        lblYear.setBounds(80, 50, 100, 22);
		lblYear.setFont(new Font("Tahoma", 4, 15));
		lblYear.setForeground(new Color(0, 0, 0));
	        
	        lblSemester = new JLabel("Semester");
	        lblSemester.setBounds(250, 25, 100, 22);
		lblSemester.setFont(new Font("Tahoma", 1, 17));
		lblSemester.setForeground(new Color(0, 0, 0));
	        
	        lblSem = new JLabel("First");
	        lblSem.setBounds(270, 50, 100, 22);
		lblSem.setFont(new Font("Tahoma", 4, 15));
		lblSem.setForeground(new Color(0, 0, 0));
	        
	        lblSubject = new JLabel("Subject");  
	        lblSubject.setBounds(460, 25, 100, 22);
		lblSubject.setFont(new Font("Tahoma", 1, 17));
		lblSubject.setForeground(new Color(0, 0, 0));
	        
	        lblSub1 = new JLabel("COMP 40013");
	        lblSub1.setBounds(448, 45, 100, 22);
		lblSub1.setFont(new Font("Tahoma", 4, 15));
		lblSub1.setForeground(new Color(0, 0, 0));
	        
	        lblSub2 = new JLabel("Object Oriented Programming");
	        lblSub2.setBounds(390, 60, 200, 22);
		lblSub2.setFont(new Font("Tahoma", 4, 15));
		lblSub2.setForeground(new Color(0, 0, 0));
	        
	        lblSection = new JLabel("Section"); 
	        lblSection.setBounds(660, 25, 100, 22);
		lblSection.setFont(new Font("Tahoma", 1, 17));
		lblSection.setForeground(new Color(0, 0, 0));
	        
	        lblSect = new JLabel("BSIT 2-1");
	        lblSect.setBounds(660, 50, 100, 22);
		lblSect.setFont(new Font("Tahoma", 4, 15));
		lblSect.setForeground(new Color(0, 0, 0));
	        
	        lblSchedule = new JLabel("Schedule");
	        lblSchedule.setBounds(860, 25, 100, 22);
		lblSchedule.setFont(new Font("Tahoma", 1, 17));
		lblSchedule.setForeground(new Color(0, 0, 0));
	        
	        lblSched1 = new JLabel("SAT/SAT 8:0AM-12:00PM/");
	        lblSched1.setBounds(820, 50, 200, 22);
		lblSched1.setFont(new Font("Tahoma", 4, 15));
		lblSched1.setForeground(new Color(0, 0, 0));
	        
	        lblSched2 = new JLabel("2:00AM-7:00PM");
	        lblSched2.setBounds(820, 65, 200, 22);
		lblSched2.setFont(new Font("Tahoma", 4, 15));
		lblSched2.setForeground(new Color(0, 0, 0));
	                
	        pnlFacultyLoad = new JPanel();
	        pnlFacultyLoad.setBounds(5,80,1025,115);
		pnlFacultyLoad.setLayout(null);
		pnlFacultyLoad.setBackground(new Color(245, 225, 187));
	        pnlFacultyLoad.add(lblSchoolYear);
	        pnlFacultyLoad.add(lblYear);
	        pnlFacultyLoad.add(lblSemester);
	        pnlFacultyLoad.add(lblSem);
	        pnlFacultyLoad.add(lblSubject);
	        pnlFacultyLoad.add(lblSub1);
	        pnlFacultyLoad.add(lblSub2);
	        pnlFacultyLoad.add(lblSection);
	        pnlFacultyLoad.add(lblSect);
	        pnlFacultyLoad.add(lblSchedule);
	        pnlFacultyLoad.add(lblSched1);
	        pnlFacultyLoad.add(lblSched2);
	        
	        add(lblSMS);
	        add(pnlStudent);
	        add(pnlProfessor);
	        add(pnlFacultyLoad);
	        
	        setVisible(true);
	    }


}
