package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import models.FacultyLoad;

public class SMSClassList extends JFrame implements ActionListener {
	
	FacultyLoad facultyLoad;
	TableModel tableModel = TableModel.ALL;	// This is an enum used to determine if a table must display all the data, or filter according to the search input.
	SMSDialog smsDialog = new SMSDialog();	// The class used to display message dialogs
	
	// Components for the main frame
	JLabel lblClassList;
	JPanel pnlMain, pnlLoadDescription, pnlTable;
	
	// Components for the panel that contains the description of the faculty load
	JLabel lblSchoolYear, lblSchoolYearV, lblSemester, lblSemesterV, lblSection, lblSectionV, 
			lblSubject, lblSubjectV, lblSchedule, lblScheduleV;
	
	// Components for the panel that contains the table of class list
	JLabel lblSearch;
	JTextField txtfldSearch;
	JButton bttnSearch, bttnRefresh;
	JTable tblClassList;
	JScrollPane scrollPane;
	
	SMSClassList(FacultyLoad facultyLoad) throws SQLException {
		
		this.facultyLoad = facultyLoad;		//The faculty load
		
		setTitle("Class List - Student Management System");
		setSize(1050, 650);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(187, 37, 61));
		
		lblClassList = new JLabel("Class List");
		lblClassList.setBounds(20, 7, 150, 40);
		lblClassList.setFont(new Font("Tahoma", 1, 20));
		lblClassList.setForeground(new Color(255, 255, 255));
		
		
		// The panel that contains the descriptions of the faculty load.
		
		lblSchoolYear = new JLabel("School Year");
		lblSchoolYear.setBounds(0, 10, 168, 18);
		lblSchoolYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblSchoolYear.setFont(new Font("Tahoma", 1, 13));
		lblSchoolYear.setForeground(new Color(0, 0, 0));
		
		lblSchoolYearV = new JLabel(Integer.toString(facultyLoad.getYear()));
		lblSchoolYearV.setBounds(0, 30, 168, 22);
		lblSchoolYearV.setHorizontalAlignment(SwingConstants.CENTER);
		lblSchoolYearV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSchoolYearV.setForeground(new Color(0, 0, 0));
		
		lblSemester = new JLabel("Semester");
		lblSemester.setBounds(158, 10, 168, 18);
		lblSemester.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemester.setFont(new Font("Tahoma", 1, 13));
		lblSemester.setForeground(new Color(0, 0, 0));
		
		lblSemesterV = new JLabel(facultyLoad.getSemester());
		lblSemesterV.setBounds(158, 30, 168, 18);
		lblSemesterV.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemesterV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSemesterV.setForeground(new Color(0, 0, 0));
		
		lblSection = new JLabel("Section");
		lblSection.setBounds(327, 10, 168, 18);
		lblSection.setHorizontalAlignment(SwingConstants.CENTER);
		lblSection.setFont(new Font("Tahoma", 1, 13));
		lblSection.setForeground(new Color(0, 0, 0));
		
		lblSectionV = new JLabel(facultyLoad.getSectionCode());
		lblSectionV.setBounds(327, 30, 168, 18);
		lblSectionV.setHorizontalAlignment(SwingConstants.CENTER);
		lblSectionV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSectionV.setForeground(new Color(0, 0, 0));
		
		lblSubject = new JLabel("Subject");
		lblSubject.setBounds(495, 10, 300, 18);
		lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject.setFont(new Font("Tahoma", 1, 13));
		lblSubject.setForeground(new Color(0, 0, 0));
		
		lblSubjectV = new JLabel(facultyLoad.getSubjectCode() + " | " + facultyLoad.getSubjectDescription());
		lblSubjectV.setBounds(495, 30, 300, 18);
		lblSubjectV.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubjectV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSubjectV.setForeground(new Color(0, 0, 0));
		
		lblSchedule = new JLabel("Schedule");
		lblSchedule.setBounds(775, 10, 198, 18);
		lblSchedule.setHorizontalAlignment(SwingConstants.CENTER);
		lblSchedule.setFont(new Font("Tahoma", 1, 13));
		lblSchedule.setForeground(new Color(0, 0, 0));
		
		lblScheduleV = new JLabel(facultyLoad.getSchedule());
		lblScheduleV.setBounds(775, 30, 198, 18);
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
		
		
		// The panel that contains the table of class list.
		
		lblSearch = new JLabel("Search Student No:");
		lblSearch.setBounds(10, 10, 120, 22);
		lblSearch.setFont(new Font("Tahoma", 1, 12));
		lblSearch.setForeground(new Color(0, 0, 0));
		
		txtfldSearch = new JTextField();
		txtfldSearch.setBounds(140, 10, 462, 22);
		txtfldSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldSearch.setForeground(new Color(0, 0, 0));
		
		bttnSearch = new JButton("Search");
		bttnSearch.setBounds(612, 10, 172, 22);
		bttnSearch.setFont(new Font("Tahoma", 1, 12));
		bttnSearch.setForeground(new Color(0, 0, 0));
		bttnSearch.addActionListener(this);
		
		bttnRefresh = new JButton("Refresh");
		bttnRefresh.setBounds(794, 10, 172, 22);
		bttnRefresh.setFont(new Font("Tahoma", 1, 12));
		bttnRefresh.setForeground(new Color(0, 0, 0));
		bttnRefresh.addActionListener(this);
		
		
		// This is the table.
		tblClassList = new JTable();
		tblClassList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblClassList.setRowHeight(22);
		tblClassList.setGridColor(new Color(0, 0, 0));
		tblClassList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblClassList.setForeground(new Color(0, 0, 0));
		tblClassList.setFillsViewportHeight(true);
		tblClassList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		displayClassListTable();
		
		scrollPane = new JScrollPane(tblClassList);
		scrollPane.setBounds(10, 42, 955, 394);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		pnlTable = new JPanel();
		pnlTable.setBounds(10, 82, 975, 446);
		pnlTable.setLayout(null);
		pnlTable.setBackground(new Color(245, 225, 187));
		pnlTable.add(scrollPane);
		pnlTable.add(lblSearch);
		pnlTable.add(txtfldSearch);
		pnlTable.add(bttnSearch);
		pnlTable.add(bttnRefresh);
		
		
		pnlMain = new JPanel();
		pnlMain.setBounds(20, 53, 994, 538);
		pnlMain.setLayout(null);
		pnlMain.setBackground(null);
		pnlMain.setBorder(new LineBorder(new Color(255, 255, 255)));
		pnlMain.add(pnlLoadDescription);
		pnlMain.add(pnlTable);
		
		add(pnlMain);
		add(lblClassList);
		setVisible(true);
	}
	
	
	//This method displays the class list in the table by setting the table model.
	public void displayClassListTable() throws SQLException {
		
		DefaultTableModel tblmdlClassList = new DefaultTableModel() {		//This is the table model.
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		//This sets the column names.
		String[] columnNames = {"Student No", "Last Name", "First Name", "Middle Name", "Sex", 
				"Birthday", "Section Code", "Email", "Contact No", "Address"};
		for (String columnName : columnNames) {
			tblmdlClassList.addColumn(columnName);
		}
		
		//This sets the rows' data. 
		Object[] rowData = new Object[columnNames.length];
		switch(tableModel) {
			case ALL:		//If @TableModel is set to ALL, all data in the student records will be displayed. 
				for (var student : facultyLoad.getClassList()) {
					rowData[0] = student.getStudentNo();
					rowData[1] = student.getLastName();
					rowData[2] = student.getFirstName();
					rowData[3] = student.getMiddleName();
					rowData[4] = student.getSex();
					rowData[5] = student.getBirthday();
					rowData[6] = student.getSectionCode();
					rowData[7] = student.getEmail();
					rowData[8] = student.getContactNo();
					rowData[9] = student.getAddress();
						
					tblmdlClassList.addRow(rowData);
				}
				
				break;
				
			case SEARCH:	//If @TableModel is set to SEARCH, it will display the @Student found.
				for (var student : facultyLoad.getClassList()) {
					if (student.getStudentNo().equals(txtfldSearch.getText())) {
						rowData[0] = student.getStudentNo();
						rowData[1] = student.getLastName();
						rowData[2] = student.getFirstName();
						rowData[3] = student.getMiddleName();
						rowData[4] = student.getSex();
						rowData[5] = student.getBirthday();
						rowData[6] = student.getSectionCode();
						rowData[7] = student.getEmail();
						rowData[8] = student.getContactNo();
						rowData[9] = student.getAddress();
							
						tblmdlClassList.addRow(rowData);
					}
				}
				
				break;		
		}
		
		//If no results found, the table will not refresh.
		if (tblmdlClassList.getRowCount() == 0) {
			smsDialog.showMessageDialog(this, "No Results Found");
		}
		else {
			tblClassList.setModel(tblmdlClassList);
			
			//This sets the table design, such as the columns' width and header color.
			JTableHeader tblhdrClassList = tblClassList.getTableHeader();
			tblhdrClassList.setBackground(new Color(245, 245, 245));
			tblhdrClassList.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tblhdrClassList.setForeground(new Color(0, 0, 0));
			
			for (int i = 0; i < tblClassList.getColumnCount(); i++) {
				tblClassList.getColumnModel().getColumn(i).setPreferredWidth(180);
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
					displayClassListTable();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		else if (e.getSource() == bttnRefresh) {	//This action refreshes the table.
			/* The value of the instance "tableModel" is changed back into @TableModel.ALL, and the method "displayClassListTable()"
			 * is called again to refresh the table. The textfield for Search is also cleared.
			 */
			try {
				tableModel = TableModel.ALL;
				displayClassListTable();
				
				txtfldSearch.setText("");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
}
