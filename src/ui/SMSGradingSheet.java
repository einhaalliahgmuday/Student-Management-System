package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import models.FacultyLoad;
import models.Professor;
import models.StudentGrade;

public class SMSGradingSheet extends JFrame implements ActionListener{
	
	FacultyLoad facultyLoad;
	Professor professor;
	TableModel tableModel = TableModel.ALL;		// This is an enum used to determine if a table must display all the data, or filter according to the search input.
	StudentGrade studentGrade;	// This instance will contain the @StudentGrade to be updated.
	SMSDialog smsDialog = new SMSDialog(); 	// The class used to display message dialogs
	
	// Components for the main frame
	JLabel lblGradingSheet;
	JPanel pnlMain;
	
	// Components for the panel that contains the description of the faculty load
	JPanel pnlLoadDescription;
	JLabel lblSchoolYear, lblSchoolYearV, lblSemester, lblSemesterV, lblSubject, lblSubjectV, lblSection, 
			lblSectionV, lblSchedule, lblScheduleV;
	
	// Components for displaying and updating @StudentGrade
	JPanel pnlGradingSheet;
	JLabel lblStudentNo, lblStudentNoV, lblName, lblNameV, lblMidtermGrade, lblFinalsGrade, lblFinalRating, lblTotalAttendance, lblRemark;
	JTextField txtfldMidtermGrade, txtfldFinalsGrade, txtfldFinalRating, txtfldTotalAttendance;
	JComboBox cmbbxRemark;
	JButton bttnClear, bttnCompute, bttnSave;
	
	// Components for searching in the table
	JPanel pnlSearch;
	JLabel lblSearch;
	JTextField txtfldSearch;
	JButton bttnSearch, bttnRefresh;
	
	// Components for the table of grading sheet
	JPanel pnlTable;
	JTable tblGradingSheet;
	JScrollPane scrollPane;
	
	SMSGradingSheet(Professor professor, FacultyLoad facultyLoad) throws SQLException {
		this.professor = professor;		// The Professor
		this.facultyLoad = facultyLoad;		// The faculty load
		
		setTitle("Grading Sheet - Student Management System");
		setSize(1050, 650);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(187, 37, 61));
		
		lblGradingSheet = new JLabel("Grading Sheet");
		lblGradingSheet.setBounds(20, 7, 150, 40);
		lblGradingSheet.setFont(new Font("Tahoma", 1, 20));
		lblGradingSheet.setForeground(new Color(255, 255, 255));
		
		
		// The panel that contains the description of the faculty load.
		
		lblSchoolYear = new JLabel("School Year");
		lblSchoolYear.setBounds(5, 10, 138, 18);
		lblSchoolYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblSchoolYear.setFont(new Font("Tahoma", 1, 13));
		lblSchoolYear.setForeground(new Color(0, 0, 0));
		
		lblSchoolYearV = new JLabel(Integer.toString(facultyLoad.getYear()));
		lblSchoolYearV.setBounds(5, 30, 138, 22);
		lblSchoolYearV.setHorizontalAlignment(SwingConstants.CENTER);
		lblSchoolYearV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSchoolYearV.setForeground(new Color(0, 0, 0));
		
		lblSemester = new JLabel("Semester");
		lblSemester.setBounds(153, 10, 168, 18);
		lblSemester.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemester.setFont(new Font("Tahoma", 1, 13));
		lblSemester.setForeground(new Color(0, 0, 0));
		
		lblSemesterV = new JLabel(facultyLoad.getSemester());
		lblSemesterV.setBounds(153, 30, 168, 18);
		lblSemesterV.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemesterV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSemesterV.setForeground(new Color(0, 0, 0));
		
		lblSubject = new JLabel("Subject");
		lblSubject.setBounds(327, 10, 300, 18);
		lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject.setFont(new Font("Tahoma", 1, 13));
		lblSubject.setForeground(new Color(0, 0, 0));
		
		lblSubjectV = new JLabel(facultyLoad.getSubjectCode() + " | " + facultyLoad.getSubjectDescription());
		lblSubjectV.setBounds(327, 30, 300, 18);
		lblSubjectV.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubjectV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSubjectV.setForeground(new Color(0, 0, 0));
		
		lblSection = new JLabel("Section");
		lblSection.setBounds(627, 10, 168, 18);
		lblSection.setHorizontalAlignment(SwingConstants.CENTER);
		lblSection.setFont(new Font("Tahoma", 1, 13));
		lblSection.setForeground(new Color(0, 0, 0));
		
		lblSectionV = new JLabel(facultyLoad.getSectionCode());
		lblSectionV.setBounds(627, 30, 168, 18);
		lblSectionV.setHorizontalAlignment(SwingConstants.CENTER);
		lblSectionV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSectionV.setForeground(new Color(0, 0, 0));
		
		lblSchedule = new JLabel("Schedule");
		lblSchedule.setBounds(765, 10, 208, 18);
		lblSchedule.setHorizontalAlignment(SwingConstants.CENTER);
		lblSchedule.setFont(new Font("Tahoma", 1, 13));
		lblSchedule.setForeground(new Color(0, 0, 0));
		
		lblScheduleV = new JLabel(facultyLoad.getSchedule());
		lblScheduleV.setBounds(765, 30, 208, 18);
		lblScheduleV.setHorizontalAlignment(SwingConstants.CENTER);
		lblScheduleV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblScheduleV.setForeground(new Color(0, 0, 0));
		
		pnlLoadDescription = new JPanel();
		pnlLoadDescription.setBounds(10, 10, 975, 62);
		pnlLoadDescription.setLayout(null);
		pnlLoadDescription.setBackground(new Color(245, 225, 187));
		pnlLoadDescription.add(lblSchoolYear);
		pnlLoadDescription.add(lblSchoolYearV);
		pnlLoadDescription.add(lblSemester);
		pnlLoadDescription.add(lblSemesterV);
		pnlLoadDescription.add(lblSubject);
		pnlLoadDescription.add(lblSubjectV);
		pnlLoadDescription.add(lblSection);
		pnlLoadDescription.add(lblSectionV);
		pnlLoadDescription.add(lblSchedule);
		pnlLoadDescription.add(lblScheduleV);
		
		
		// The panel for displaying and updating @StudentGrade
		
		lblStudentNo = new JLabel("Student No:");
		lblStudentNo.setBounds(20, 15, 120, 22);
		lblStudentNo.setFont(new Font("Tahoma", 1, 12));
		lblStudentNo.setForeground(new Color(0, 0, 0));
		
		lblStudentNoV = new JLabel();
		lblStudentNoV.setBounds(150, 15, 200, 22);
		lblStudentNoV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStudentNoV.setForeground(new Color(0, 0, 0));
		
		lblName = new JLabel("Name:");
		lblName.setBounds(20, 47, 120, 22);
		lblName.setFont(new Font("Tahoma", 1, 12));
		lblName.setForeground(new Color(0, 0, 0));
		
		lblNameV = new JLabel();
		lblNameV.setBounds(150, 47, 400, 22);
		lblNameV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNameV.setForeground(new Color(0, 0, 0));
		
		lblMidtermGrade = new JLabel("Midterm Grade:");
		lblMidtermGrade.setBounds(20, 79, 150, 22);
		lblMidtermGrade.setFont(new Font("Tahoma", 1, 12));
		lblMidtermGrade.setForeground(new Color(0, 0, 0));
		
		txtfldMidtermGrade = new JTextField();
		txtfldMidtermGrade.setBounds(150, 79, 50, 22);
		txtfldMidtermGrade.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldMidtermGrade.setHorizontalAlignment(JTextField.CENTER);
		txtfldMidtermGrade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldMidtermGrade.setForeground(new Color(0, 0, 0));
		
		lblFinalsGrade = new JLabel("Finals Grade:");
		lblFinalsGrade.setBounds(20, 111, 150, 22);
		lblFinalsGrade.setFont(new Font("Tahoma", 1, 12));
		lblFinalsGrade.setForeground(new Color(0, 0, 0));
		
		txtfldFinalsGrade = new JTextField();
		txtfldFinalsGrade.setBounds(150, 111, 50, 22);
		txtfldFinalsGrade.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldFinalsGrade.setHorizontalAlignment(JTextField.CENTER);
		txtfldFinalsGrade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldFinalsGrade.setForeground(new Color(0, 0, 0));
		
		lblFinalRating = new JLabel("Final Rating:");
		lblFinalRating.setBounds(20, 143, 150, 22);
		lblFinalRating.setFont(new Font("Tahoma", 1, 12));
		lblFinalRating.setForeground(new Color(0, 0, 0));
		
		txtfldFinalRating = new JTextField();
		txtfldFinalRating.setEditable(false);
		txtfldFinalRating.setBounds(150, 143, 50, 22);
		txtfldFinalRating.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldFinalRating.setHorizontalAlignment(JTextField.CENTER);
		txtfldFinalRating.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldFinalRating.setForeground(new Color(0, 0, 0));
		
		lblTotalAttendance = new JLabel("Total Attendance:");
		lblTotalAttendance.setBounds(20, 175, 150, 22);
		lblTotalAttendance.setFont(new Font("Tahoma", 1, 12));
		lblTotalAttendance.setForeground(new Color(0, 0, 0));
		
		txtfldTotalAttendance = new JTextField();
		txtfldTotalAttendance.setBounds(150, 175, 50, 22);
		txtfldTotalAttendance.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldTotalAttendance.setHorizontalAlignment(JTextField.CENTER);
		txtfldTotalAttendance.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldTotalAttendance.setForeground(new Color(0, 0, 0));
		
		lblRemark = new JLabel("Remark:");
		lblRemark.setBounds(20, 207, 150, 22);
		lblRemark.setFont(new Font("Tahoma", 1, 12));
		lblRemark.setForeground(new Color(0, 0, 0));
		
		String[] remarks = {"------", "P", "INC", "F"};
		cmbbxRemark = new JComboBox(remarks);
		cmbbxRemark.setBounds(150, 207, 50, 22);
		cmbbxRemark.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbbxRemark.setForeground(new Color(0, 0, 0));
		
		bttnSave = new JButton("Save");
		bttnSave.setBounds(92, 248, 140, 22);
		bttnSave.setFont(new Font("Tahoma", 1, 12));
		bttnSave.setForeground(new Color(0, 0, 0));
		bttnSave.addActionListener(this);
		
		bttnCompute = new JButton("Compute");
		bttnCompute.setBounds(92, 280, 140, 22);
		bttnCompute.setFont(new Font("Tahoma", 1, 12));
		bttnCompute.setForeground(new Color(0, 0, 0));
		bttnCompute.addActionListener(this);
		
		bttnClear = new JButton("Clear");
		bttnClear.setBounds(92, 312, 140, 22);
		bttnClear.setFont(new Font("Tahoma", 1, 12));
		bttnClear.setForeground(new Color(0, 0, 0));
		bttnClear.addActionListener(this);
		
		pnlGradingSheet = new JPanel();
		pnlGradingSheet.setBounds(10, 168, 323, 360);
		pnlGradingSheet.setLayout(null);
		pnlGradingSheet.setBackground(new Color(245, 225, 187));
		pnlGradingSheet.add(lblStudentNo);
		pnlGradingSheet.add(lblStudentNoV);
		pnlGradingSheet.add(lblName);
		pnlGradingSheet.add(lblNameV);
		pnlGradingSheet.add(lblMidtermGrade);
		pnlGradingSheet.add(txtfldMidtermGrade);
		pnlGradingSheet.add(lblFinalsGrade);
		pnlGradingSheet.add(txtfldFinalsGrade);
		pnlGradingSheet.add(lblFinalRating);
		pnlGradingSheet.add(txtfldFinalRating);
		pnlGradingSheet.add(lblTotalAttendance);
		pnlGradingSheet.add(txtfldTotalAttendance);
		pnlGradingSheet.add(lblRemark);
		pnlGradingSheet.add(cmbbxRemark);
		pnlGradingSheet.add(bttnSave);
		pnlGradingSheet.add(bttnCompute);
		pnlGradingSheet.add(bttnClear);
		
		
		// The panel for searching in the table
		
		lblSearch = new JLabel("Search Student No: ");
		lblSearch.setBounds(10, 10, 135, 22);
		lblSearch.setFont(new Font("Tahoma", 1, 12));
		lblSearch.setForeground(new Color(0, 0, 0));
		
		txtfldSearch = new JTextField();
		txtfldSearch.setBounds(140, 10, 173, 22);
		txtfldSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldSearch.setForeground(new Color(0, 0, 0));
		
		bttnSearch = new JButton("Search");
		bttnSearch.setBounds(10, 42, 148, 22);
		bttnSearch.setFont(new Font("Tahoma", 1, 12));
		bttnSearch.setForeground(new Color(0, 0, 0));
		bttnSearch.addActionListener(this);
		
		bttnRefresh = new JButton("Refresh");
		bttnRefresh.setBounds(168, 42, 147, 22);
		bttnRefresh.setFont(new Font("Tahoma", 1, 12));
		bttnRefresh.setForeground(new Color(0, 0, 0));
		bttnRefresh.addActionListener(this);
		
		pnlSearch = new JPanel();
		pnlSearch.setBounds(10, 82, 323, 76);
		pnlSearch.setLayout(null);
		pnlSearch.setBackground(new Color(245, 225, 187));
		pnlSearch.add(lblSearch);
		pnlSearch.add(txtfldSearch);
		pnlSearch.add(bttnSearch);
		pnlSearch.add(bttnRefresh);
		
		
		// The panel for the table
		
		tblGradingSheet = new JTable();
		tblGradingSheet.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblGradingSheet.setRowHeight(22);
		tblGradingSheet.setGridColor(new Color(0, 0, 0));
		tblGradingSheet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblGradingSheet.setForeground(new Color(0, 0, 0));
		tblGradingSheet.setFillsViewportHeight(true);
		tblGradingSheet.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		displayGradingSheetTable();
		
		/* This is the mouse listener of the table. If a row is double-clicked, that student is inserted
		 * in the instance "studentGrade", and is diplayed in the panel.
		 */
		tblGradingSheet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int rowIndex = tblGradingSheet.getSelectedRow();	
					try {
						/* The value of "Student No" column is retrieve using "getValueAt()" method of JTable.
						 * The method "getStudentGradeByStudentNo" of @FacultyLoad is then called to get the @StudentGrade.
						 */
						studentGrade = facultyLoad.getStudentGradeByStudentNo(tblGradingSheet.getValueAt(rowIndex, 0).toString());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					// The information of @StudentGrade is diplayed, and the @Professor can update the grades.
					lblStudentNoV.setText(studentGrade.getStudentNo());
					lblNameV.setText(studentGrade.getStudentName());
					txtfldMidtermGrade.setText(Double.toString(studentGrade.getMidtermGrade()));
					txtfldFinalsGrade.setText(Double.toString(studentGrade.getFinalsGrade()));
					txtfldFinalRating.setText(Double.toString(studentGrade.getFinalRating()));
					txtfldTotalAttendance.setText(Integer.toString(studentGrade.getTotalAttendance()));
					if (studentGrade.getRemark() != null) {
						cmbbxRemark.setSelectedItem(studentGrade.getRemark());
					}
				}
			}
			
		});
		
		scrollPane = new JScrollPane(tblGradingSheet);
		scrollPane.setBounds(10, 10, 622, 426);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		pnlTable = new JPanel();
		pnlTable.setBounds(343, 82, 642, 446);
		pnlTable.setLayout(null);
		pnlTable.setBackground(new Color(245, 225, 187));
		pnlTable.add(scrollPane);
		
		
		pnlMain = new JPanel();
		pnlMain.setBounds(20, 53, 994, 538);
		pnlMain.setLayout(null);
		pnlMain.setBackground(null);
		pnlMain.setBorder(new LineBorder(new Color(255, 255, 255)));
		pnlMain.add(pnlLoadDescription);
		pnlMain.add(pnlSearch);
		pnlMain.add(pnlTable);
		pnlMain.add(pnlGradingSheet);
		
		add(pnlMain);
		add(lblGradingSheet);
		setVisible(true);
	}
	
	//This method displays the grading sheet in the table by setting the table model.
	public void displayGradingSheetTable() throws SQLException {
		
		DefaultTableModel tblmdlGradingSheet = new DefaultTableModel() {	//This is the table model.
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		//This sets the column names.
		String[] columnNames = {"Student No", "Name", "Midterm Grade", "Finals Grade", "Final Rating", 
				"Total Attendance", "Remark"};
		for (String columnName : columnNames) {
			tblmdlGradingSheet.addColumn(columnName);
		}
		
		//This sets the rows' data.
		Object[] rowData = new Object[columnNames.length];
		switch(tableModel) {
			case ALL:		//If @TableModel is set to ALL, all @StudentGrade of the grading sheet will be displayed. 
				for (var gradeSheet : facultyLoad.getGradingSheet()) {
					rowData[0] = gradeSheet.getStudentNo();
					rowData[1] = gradeSheet.getStudentName();
					rowData[2] = gradeSheet.getMidtermGrade();
					rowData[3] = gradeSheet.getFinalsGrade();
					rowData[4] = gradeSheet.getFinalRating();
					rowData[5] = gradeSheet.getTotalAttendance();
					rowData[6] = gradeSheet.getRemark();
						
					tblmdlGradingSheet.addRow(rowData);
				}
				
				break;
			case SEARCH:	//If @TableModel is set to SEARCH, it will display the @StudentGrade found.
				for (var gradeSheet : facultyLoad.getGradingSheet()) {
					if (gradeSheet.getStudentNo().equals(txtfldSearch.getText())) {
						rowData[0] = gradeSheet.getStudentNo();
						rowData[1] = gradeSheet.getStudentName();
						rowData[2] = gradeSheet.getMidtermGrade();
						rowData[3] = gradeSheet.getFinalsGrade();
						rowData[4] = gradeSheet.getFinalRating();
						rowData[5] = gradeSheet.getTotalAttendance();
						rowData[6] = gradeSheet.getRemark();
							
						tblmdlGradingSheet.addRow(rowData);
					}
				}
				
				break;		
		}
		
		//If no results found, the table will not refresh.
		if (tblmdlGradingSheet.getRowCount() == 0) {
			smsDialog.showMessageDialog(this, "No Results Found");
		}
		else {
			tblGradingSheet.setModel(tblmdlGradingSheet);
			
			//This sets the table design, such as the columns' width and header color.
			JTableHeader tblhdrClassList = tblGradingSheet.getTableHeader();
			tblhdrClassList.setBackground(new Color(245, 245, 245));
			tblhdrClassList.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tblhdrClassList.setForeground(new Color(0, 0, 0));
			
			for (int i = 0; i < tblGradingSheet.getColumnCount(); i++) {
				tblGradingSheet.getColumnModel().getColumn(i).setPreferredWidth(180);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bttnSearch) {	//This is the action for Search.
			//It checks first if the textfield for Search is not empty, otherwise it will not proceed.
			if (txtfldSearch.getText().trim().isEmpty() == false) {
				/* To display the search results in the table, the value of the instance "tableModel" is changed into
				 * @TableModel.SEARCH. The method "displayClassListTable()" is then called again to refresh the table.
				 */
				tableModel = TableModel.SEARCH;
				try {
					displayGradingSheetTable();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		else if (e.getSource() == bttnRefresh) {	//This action refreshes the table.
			/* The value of the instance "tableModel" is changed back into @TableModel.ALL, and the method "displayGradingSheetTable()"
			 * is called again to refresh the table. The textfield for Search is also cleared.
			 */
			tableModel = TableModel.ALL;
			txtfldSearch.setText("");
			try {
				displayGradingSheetTable();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == bttnSave) {	// This action is for saving the updated @StudentGrade.
			// It checks first if the instance "studentGrade" is not null, that is, the @Professor selected a student in the table.
			if (studentGrade != null) {
				// If the instance "studentGrade" is not null, it will proceed.
				
				/*The inputs for midterm grade and finals grade are placed into new Double, which will be used by the conditional
				 * statements. The input for remark is also placed into a new String, so that if the selection is the default ("-----"), 
				 * the updated remark is empty.
				 */
				double midtermGrade = Double.parseDouble(txtfldMidtermGrade.getText());
				double finalsGrade = Double.parseDouble(txtfldFinalsGrade.getText());
				String remark = cmbbxRemark.getSelectedItem().toString();
				if (cmbbxRemark.getSelectedItem().toString().equals("------")) {
					remark = "";
				}
				
				if (midtermGrade > 5 || midtermGrade < 0 || finalsGrade > 5 || finalsGrade < 0) {
					/* If the inputs for midterm grade or finals grade is less than 1 or greater than 5, a dialog will display
					 * which inform the professor of invalid input.
					 */
					smsDialog.showMessageDialog(this, "Invalid Input", "Please enter valid grade inputs.");
				}
				else {
					/* If all conditions are met, the instance "studentGrade" is updated using its setters. Then the method "updateStudentGrade()"
					 * of @Professor is called, throwing the instance as parameter.
					 */
					studentGrade.setMidtermGrade(midtermGrade);
					studentGrade.setFinalsGrade(finalsGrade);
					studentGrade.setTotalAttendace(Integer.parseInt(txtfldTotalAttendance.getText()));
					studentGrade.setRemark(remark);
					
					try {
						professor.updateStudentGrade(studentGrade);		//This is the code that updates the @StudentGrade.
						smsDialog.showMessageDialog(this, "Student Grade Saved");	//If the @StudentGrade is successfully updated, a dialog will inform the professor.
						
						txtfldFinalRating.setText(Double.toString(studentGrade.getFinalRating()));
						
						displayGradingSheetTable();		//The table is then refreshed.
						
						// The panel is not cleared in case the @Professor has forgot to change something, or mistakes the inputted grades.
					} catch (SQLException e1) {
						// This catches all SQL Exceptions.
						e1.printStackTrace();	
					} catch (Exception e1) {
						// This catches all other Exceptions, and displays a dialog.
						smsDialog.showMessageDialog(this, "Grades Not Saved", "Please make sure you entered valid", "inputs.");
					}
				}
			}
		}
		else if (e.getSource() == bttnCompute) {	//This action computes the average of the midterm grade and finals grade inputs.
			if (studentGrade != null) {
				double midtermGrade = Double.parseDouble(txtfldMidtermGrade.getText());
				double finalsGrade = Double.parseDouble(txtfldFinalsGrade.getText());
				double finalRating = (midtermGrade+finalsGrade)/2;
				txtfldFinalRating.setText(Double.toString(finalRating));
			}
		}
		else if (e.getSource() == bttnClear) {		// This action clears the panel for displaying and updating a @StudentGrade.
			lblStudentNoV.setText("");
			lblNameV.setText("");
			txtfldMidtermGrade.setText("");
			txtfldFinalsGrade.setText("");
			txtfldFinalRating.setText("");
			txtfldTotalAttendance.setText("");
			cmbbxRemark.setSelectedIndex(0);
			
			studentGrade = null;
		}
		
	}
	


}
