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

import main.FacultyLoad;
import main.Professor;
import main.StudentGrade;

public class SMSGradingSheet extends JFrame implements ActionListener{
	
	FacultyLoad facultyLoad;
	Professor professor;
	TableModel tableModel = TableModel.ALL;
	StudentGrade studentGrade;
	SMSDialog smsDialog = new SMSDialog(); 
	
	JLabel lblGradingSheet;
	JPanel pnlMain;
	
	JPanel pnlLoadDescription;
	JLabel lblSchoolYear, lblSchoolYearV, lblSemester, lblSemesterV, lblSubject, lblSubjectV, lblSection, 
			lblSectionV, lblSchedule, lblScheduleV;
	
	JPanel pnlGradingSheet;
	JLabel lblStudentNo, lblStudentNoV, lblName, lblNameV, lblMidtermGrade, lblFinalsGrade, lblFinalRating, lblTotalAttendance, lblRemark;
	JTextField txtfldMidtermGrade, txtfldFinalsGrade, txtfldFinalRating, txtfldTotalAttendance;
	JComboBox cmbbxRemark;
	JButton bttnClear, bttnCompute, bttnSave;
	
	JPanel pnlSearch;
	JLabel lblSearch;
	JTextField txtfldSearch;
	JButton bttnSearch, bttnRefresh;
	
	JPanel pnlTable;
	JTable tblGradingSheet;
	JScrollPane scrollPane;
	
	SMSGradingSheet(Professor professor, FacultyLoad facultyLoad) throws SQLException {
		this.professor = professor;
		this.facultyLoad = facultyLoad;
		
		lblGradingSheet = new JLabel("Grading Sheet");
		lblGradingSheet.setBounds(20, 7, 150, 40);
		lblGradingSheet.setFont(new Font("Tahoma", 1, 20));
		lblGradingSheet.setForeground(new Color(255, 255, 255));
		
		setTitle("Grading Sheet - Student Management System");
		setSize(1050, 650);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(187, 37, 61));
		
		
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
		
		
		lblSearch = new JLabel("Search Student: ");
		lblSearch.setBounds(10, 10, 120, 22);
		lblSearch.setFont(new Font("Tahoma", 1, 12));
		lblSearch.setForeground(new Color(0, 0, 0));
		
		txtfldSearch = new JTextField();
		txtfldSearch.setBounds(125, 10, 188, 22);
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
		
		
		tblGradingSheet = new JTable();
		tblGradingSheet.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblGradingSheet.setRowHeight(22);
		tblGradingSheet.setGridColor(new Color(0, 0, 0));
		tblGradingSheet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblGradingSheet.setForeground(new Color(0, 0, 0));
		tblGradingSheet.setFillsViewportHeight(true);
		tblGradingSheet.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		displayGradingSheetTable();
		
		tblGradingSheet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int rowIndex = tblGradingSheet.getSelectedRow();	
					try {
						studentGrade = facultyLoad.getStudentGradeByStudentNo(tblGradingSheet.getValueAt(rowIndex, 0).toString());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					lblStudentNoV.setText(studentGrade.getStudentNo());
					lblNameV.setText(studentGrade.getStudentName());
					txtfldMidtermGrade.setText(Double.toString(studentGrade.getMidtermGrade()));
					txtfldFinalsGrade.setText(Double.toString(studentGrade.getFinalsGrade()));
					txtfldFinalRating.setText(Double.toString(studentGrade.getFinalRating()));
					txtfldTotalAttendance.setText(Integer.toString(studentGrade.getTotalAttendance()));
					cmbbxRemark.setSelectedItem(studentGrade.getRemark().toString());
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
	
	public void displayGradingSheetTable() throws SQLException {
		
		DefaultTableModel tblmdlGradingSheet = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		String[] columnNames = {"Student No", "Name", "Midterm Grade", "Finals Grade", "Final Rating", 
				"Total Attendance", "Remark"};
		for (String columnName : columnNames) {
			tblmdlGradingSheet.addColumn(columnName);
		}
		
		Object[] rowData = new Object[columnNames.length];
		switch(tableModel) {
			case ALL:
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
			case SEARCH:
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
		
		if (tblmdlGradingSheet.getRowCount() == 0) {
			smsDialog.showMessageDialog(this, "No Results Found!");
		}
		else {
			tblGradingSheet.setModel(tblmdlGradingSheet);
			
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
		if (e.getSource() == bttnSearch) {
			if (txtfldSearch.getText().trim().isEmpty() == false) {
				tableModel = TableModel.SEARCH;
				try {
					displayGradingSheetTable();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		else if (e.getSource() == bttnRefresh) {
			tableModel = TableModel.ALL;
			txtfldSearch.setText("");
			try {
				displayGradingSheetTable();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == bttnSave) {
			if (studentGrade != null) {
				double midtermGrade = Double.parseDouble(txtfldMidtermGrade.getText());
				double finalsGrade = Double.parseDouble(txtfldFinalsGrade.getText());
				String remark = cmbbxRemark.getSelectedItem().toString();
				if (cmbbxRemark.getSelectedItem().toString().equals("------")) {
					remark = "";
				}
				
				if ((midtermGrade > 5 && midtermGrade < 1) || (finalsGrade > 5 && finalsGrade < 1)) {
					smsDialog.showMessageDialog(this, "Invalid Input", "Please enter valid grade inputs.");
				}
				else {
					studentGrade.setMidtermGrade(midtermGrade);
					studentGrade.setFinalsGrade(finalsGrade);
					studentGrade.setTotalAttendace(Integer.parseInt(txtfldTotalAttendance.getText()));
					studentGrade.setRemark(remark);
					
					try {
						professor.updateStudentGrade(studentGrade);
						facultyLoad.updateGradeSheet();
						smsDialog.showMessageDialog(this, "Student Grades Saved");
						
						txtfldFinalRating.setText(Double.toString(studentGrade.getFinalRating()));
						
						displayGradingSheetTable();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						smsDialog.showMessageDialog(this, "Grades Not Saved", "Please make sure you entered valid", "inputs.");
					}
				}
			}
		}
		else if (e.getSource() == bttnCompute) {
			double midtermGrade = Double.parseDouble(txtfldMidtermGrade.getText());
			double finalsGrade = Double.parseDouble(txtfldFinalsGrade.getText());
			double finalRating = (midtermGrade+finalsGrade)/2;
			txtfldFinalRating.setText(Double.toString(finalRating));
		}
		else if (e.getSource() == bttnClear) {
			lblStudentNoV.setText("");
			lblNameV.setText("");
			txtfldMidtermGrade.setText("");
			txtfldFinalsGrade.setText("");
			txtfldFinalRating.setText("");
			txtfldTotalAttendance.setText("");
			cmbbxRemark.setSelectedIndex(0);
		}
		
	}
	


}
