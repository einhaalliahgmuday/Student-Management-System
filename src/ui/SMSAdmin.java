//This is the UI for Admin.

package ui;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import models.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SMSAdmin extends JFrame implements ActionListener, SMSUser {

	Admin admin;
	StudentRecords studentRecords;
	TableModel tableModel = TableModel.ALL;		// This is an enum used to determine if a table must display all the data, or filter according to the search input.
	Student student;	// This instance will contain the student record to be created or deleted.
	SMSDialog smsDialog = new SMSDialog();	// The class used to display message dialogs
	
	// Components for the main frame
	JLabel lblSMS;
	JTabbedPane tabbedPane;
	JPanel pnlStudent;
	JButton bttnLogout;
	
	// Components for the panel where student record is created
	JPanel studentPnlAddStudent;
	JLabel lblFirstName, lblMiddleName, lblLastName, lblSex, lblBirthday, lblSectionCode, 
			lblEmail, lblContactNo, lblAddress;
	JTextField txtfldFirstName, txtfldMiddleName, txtfldLastName, txtfldBirthYear, 
				txtfldBirthMonth, txtfldBirthDay, txtfldEmail, txtfldContactNo, txtfldAddress;
	JRadioButton rdbttnMale, rdbttnFemale;
	ButtonGroup bttngrpSex;
	JComboBox cmbbxSectionCode;
	JButton bttnAdd, bttnUpdate, bttnClear;
	
	// Components for the panel that contains the table of student records
	JPanel studentPnlTable;
	JLabel lblSearch;
	JComboBox cmbbxSearch;
	JTextField txtfldSearch;
	JButton bttnSearch, bttnRefresh, bttnDelete;
	JTable tblStudentRecords;
	JScrollPane scrollPane;
	
	SMSAdmin(Admin admin) throws SQLException {
		this.admin = admin;		// The Admin
		studentRecords = new StudentRecords();		//The student records
		
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
		
		tabbedPane = new JTabbedPane();		// This is the tabbed pane.
		tabbedPane.setBounds(20, 60, 995, 520);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 14));
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.addTab("Student", getStudentTab());
		
		bttnLogout = new JButton("Logout");
		bttnLogout.setBounds(915, 47, 100, 25);
		bttnLogout.setBorderPainted(false);
		bttnLogout.setBackground(null);
		bttnLogout.setFont(new Font("Tahoma", 1, 14));
		bttnLogout.setForeground(new Color(255, 255, 255));
		bttnLogout.addActionListener(this);
		
		add(lblSMS);
		add(tabbedPane);
		add(bttnLogout);
		setVisible(true);
	}
	
	
	/* This method returns the tab that contains the panels for adding and displaying student records. It is added in
	 * the JTabbedPane. @SMSAdmin has only one tab for now, but it is scalable. If we want to add new functionalities
	 * in the future, such as creating @Professor accounts, creating @FacultyLoad, and printing grades, we can
	 * just add new tabs.
	 */
	public JPanel getStudentTab() throws SQLException {
		
		//The panel for creating a student record
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(17, 56, 100, 22);
		lblFirstName.setFont(new Font("Tahoma", 1, 12));
		lblFirstName.setForeground(new Color(0, 0, 0));
		
		txtfldFirstName = new JTextField();
		txtfldFirstName.setBounds(130, 56, 201, 22);
		txtfldFirstName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldFirstName.setForeground(new Color(0, 0, 0));
		
		lblMiddleName = new JLabel("Middle Name:");
		lblMiddleName.setBounds(17, 88, 100, 22);
		lblMiddleName.setFont(new Font("Tahoma", 1, 12));
		lblMiddleName.setForeground(new Color(0, 0, 0));
		
		txtfldMiddleName = new JTextField();
		txtfldMiddleName.setBounds(130, 88, 201, 22);
		txtfldMiddleName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldMiddleName.setForeground(new Color(0, 0, 0));
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(17, 120, 100, 22);
		lblLastName.setFont(new Font("Tahoma", 1, 12));
		lblLastName.setForeground(new Color(0, 0, 0));
		
		txtfldLastName = new JTextField();
		txtfldLastName.setBounds(130, 120, 201, 22);
		txtfldLastName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldLastName.setForeground(new Color(0, 0, 0));
		
		lblSex = new JLabel("Sex: ");
		lblSex.setBounds(17, 152, 100, 22);
		lblSex.setFont(new Font("Tahoma", 1, 12));
		lblSex.setForeground(new Color(0, 0, 0));
		
		rdbttnMale = new JRadioButton("Male");
		rdbttnMale.setBounds(130, 152, 100, 22);
		rdbttnMale.setBackground(null);
		rdbttnMale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbttnMale.setForeground(new Color(0, 0, 0));
		
		rdbttnFemale = new JRadioButton("Female");
		rdbttnFemale.setBounds(240, 152, 100, 22);
		rdbttnFemale.setBackground(null);
		rdbttnFemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbttnFemale.setForeground(new Color(0, 0, 0));
		
		bttngrpSex = new ButtonGroup();
		bttngrpSex.add(rdbttnMale);
		bttngrpSex.add(rdbttnFemale);
		
		lblBirthday = new JLabel("Birthday (yyyy/mm/dd):                  /           /");
		lblBirthday.setBounds(17, 184, 300, 22);
		lblBirthday.setBackground(null);
		lblBirthday.setFont(new Font("Tahoma", 1, 12));
		lblBirthday.setForeground(new Color(0, 0, 0));
		
		txtfldBirthYear = new JTextField();
		txtfldBirthYear.setBounds(181, 184, 50, 22);
		txtfldBirthYear.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldBirthYear.setHorizontalAlignment(JTextField.CENTER);
		txtfldBirthYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldBirthYear.setForeground(new Color(0, 0, 0));
		
		txtfldBirthMonth = new JTextField();
		txtfldBirthMonth.setBounds(251, 184, 30, 22);
		txtfldBirthMonth.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldBirthMonth.setHorizontalAlignment(JTextField.CENTER);
		txtfldBirthMonth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldBirthMonth.setForeground(new Color(0, 0, 0));
		
		txtfldBirthDay = new JTextField();
		txtfldBirthDay.setBounds(301, 184, 30, 22);
		txtfldBirthDay.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldBirthDay.setHorizontalAlignment(JTextField.CENTER);
		txtfldBirthDay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldBirthDay.setForeground(new Color(0, 0, 0));
		
		lblSectionCode = new JLabel("Section Code:");
		lblSectionCode.setBounds(17, 216, 100, 22);
		lblSectionCode.setFont(new Font("Tahoma", 1, 12));
		lblSectionCode.setForeground(new Color(0, 0, 0));
		
		String[] sectionCodes = {"----SELECT----", "BSIT 2-1", "DICT 2-1"};
		cmbbxSectionCode = new JComboBox(sectionCodes);
		cmbbxSectionCode.setBounds(130, 216, 100, 22);
		cmbbxSectionCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbbxSectionCode.setForeground(new Color(0, 0, 0));
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(17, 248, 100, 22);
		lblEmail.setFont(new Font("Tahoma", 1, 12));
		lblEmail.setForeground(new Color(0, 0, 0));
		
		txtfldEmail = new JTextField();
		txtfldEmail.setBounds(130, 248, 201, 22);
		txtfldEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldEmail.setForeground(new Color(0, 0, 0));
		
		lblContactNo = new JLabel("Contact No:");
		lblContactNo.setBounds(17, 278, 100, 22);
		lblContactNo.setFont(new Font("Tahoma", 1, 12));
		lblContactNo.setForeground(new Color(0, 0, 0));
		
		txtfldContactNo = new JTextField();
		txtfldContactNo.setBounds(130, 278, 201, 22);
		txtfldContactNo.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldContactNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldContactNo.setForeground(new Color(0, 0, 0));
		
		lblAddress = new JLabel("Address:");
		lblAddress.setBounds(17, 310, 100, 22);
		lblAddress.setFont(new Font("Tahoma", 1, 12));
		lblAddress.setForeground(new Color(0, 0, 0));
		
		txtfldAddress = new JTextField();
		txtfldAddress.setBounds(130, 310, 201, 22);
		txtfldAddress.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldAddress.setForeground(new Color(0, 0, 0));
		
		bttnAdd = new JButton("Add Student");
		bttnAdd.setBounds(110, 381, 130, 22);
		bttnAdd.setFont(new Font("Tahoma", 1, 12));
		bttnAdd.setForeground(new Color(0, 0, 0));
		bttnAdd.addActionListener(this);
		
		bttnClear = new JButton("Clear");
		bttnClear.setBounds(110, 413, 130, 22);
		bttnClear.setFont(new Font("Tahoma", 1, 12));
		bttnClear.setForeground(new Color(0, 0, 0));
		bttnClear.addActionListener(this);

		studentPnlAddStudent = new JPanel();
		studentPnlAddStudent.setBounds(6, 4, 350, 480);
		studentPnlAddStudent.setLayout(null);
		studentPnlAddStudent.setBackground(new Color(245, 225, 187));
		studentPnlAddStudent.add(lblFirstName);
		studentPnlAddStudent.add(txtfldFirstName);
		studentPnlAddStudent.add(lblMiddleName);
		studentPnlAddStudent.add(txtfldMiddleName);
		studentPnlAddStudent.add(lblLastName);
		studentPnlAddStudent.add(txtfldLastName);
		studentPnlAddStudent.add(lblSex);
		studentPnlAddStudent.add(rdbttnMale);
		studentPnlAddStudent.add(rdbttnFemale);
		studentPnlAddStudent.add(lblBirthday);
		studentPnlAddStudent.add(txtfldBirthMonth);
		studentPnlAddStudent.add(txtfldBirthDay);
		studentPnlAddStudent.add(txtfldBirthYear);
		studentPnlAddStudent.add(lblSectionCode);
		studentPnlAddStudent.add(cmbbxSectionCode);
		studentPnlAddStudent.add(lblEmail);
		studentPnlAddStudent.add(txtfldEmail);
		studentPnlAddStudent.add(lblContactNo);
		studentPnlAddStudent.add(txtfldContactNo);
		studentPnlAddStudent.add(lblAddress);
		studentPnlAddStudent.add(txtfldAddress);
		studentPnlAddStudent.add(bttnAdd);
		studentPnlAddStudent.add(bttnClear);
		
		
		//The panel for the table of student records
		
		lblSearch = new JLabel("Search");
		lblSearch.setBounds(17, 17, 60, 22);
		lblSearch.setFont(new Font("Tahoma", 1, 12));
		lblSearch.setForeground(new Color(0, 0, 0));
		
		String[] search = {"Student No", "Section"};
		cmbbxSearch = new JComboBox(search);
		cmbbxSearch.setBounds(65, 17, 90, 22);
		cmbbxSearch.setForeground(new Color(0, 0, 0));
		cmbbxSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtfldSearch = new JTextField();
		txtfldSearch.setBounds(160, 17, 190, 22);
		txtfldSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldSearch.setForeground(new Color(0, 0, 0));
		
		bttnSearch = new JButton("Search");
		bttnSearch.setBounds(357, 17, 75, 22);
		bttnSearch.setFont(new Font("Tahoma", 1, 12));
		bttnSearch.setForeground(new Color(0, 0, 0));
		bttnSearch.addActionListener(this);
		
		bttnDelete = new JButton("Delete");
		bttnDelete.setBounds(439, 17, 75, 22);
		bttnDelete.setFont(new Font("Tahoma", 1, 12));
		bttnDelete.setForeground(new Color(0, 0, 0));
		bttnDelete.addActionListener(this);
		
		bttnRefresh = new JButton("Refresh");
		bttnRefresh.setBounds(520, 17, 85, 22);
		bttnRefresh.setFont(new Font("Tahoma", 1, 12));
		bttnRefresh.setForeground(new Color(0, 0, 0));
		bttnRefresh.addActionListener(this);
		
		//This is the table.
		tblStudentRecords = new JTable();
		tblStudentRecords.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblStudentRecords.setRowHeight(22);
		tblStudentRecords.setGridColor(new Color(0, 0, 0));
		tblStudentRecords.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblStudentRecords.setForeground(new Color(0, 0, 0));
		tblStudentRecords.setFillsViewportHeight(true);
		tblStudentRecords.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		displayStudentRecordsTable();
		
		/* This is the mouse listener of the table. If a row is double-clicked, that student record is inserted
		 * in the instance "student".
		 */
		tblStudentRecords.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int rowIndex = tblStudentRecords.getSelectedRow();
					try {
						/* The value of "Student No" column is retrieve using "getValueAt()" method of JTable.
						 * The method "getStudentRecordByStudentNo" of @StudentRecords is then called to get the @Student.
						 */
						student = studentRecords.getStudentRecordByStudentNo(tblStudentRecords.getValueAt(rowIndex, 0).toString());
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
			
		});
		
		scrollPane = new JScrollPane(tblStudentRecords);
		scrollPane.setBounds(17, 49, 588, 414);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		studentPnlTable = new JPanel();
		studentPnlTable.setBounds(363, 4, 622, 480);
		studentPnlTable.setLayout(null);
		studentPnlTable.setBackground(new Color(245, 225, 187));
		studentPnlTable.add(lblSearch);
		studentPnlTable.add(cmbbxSearch);
		studentPnlTable.add(txtfldSearch);
		studentPnlTable.add(bttnSearch);
		studentPnlTable.add(bttnRefresh);
		studentPnlTable.add(bttnDelete);
		studentPnlTable.add(scrollPane);
		
		
		pnlStudent = new JPanel();
		pnlStudent.setLayout(null);
		pnlStudent.setBackground(new Color(187, 37, 61));
		pnlStudent.add(studentPnlAddStudent);
		pnlStudent.add(studentPnlTable);
		
		
		return pnlStudent;
	}
	
	//This method displays the student records in the table by setting the table model.
	public void displayStudentRecordsTable() throws SQLException {
		
		DefaultTableModel tblmdlStudentRecords = new DefaultTableModel() {		//This is the table model.
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		//This sets the column names.
		String[] columnNames = {"Student No", "First Name", "Middle Name", "Last Name", "Sex", 
				"Birthday", "Section Code", "Email", "Contact No", "Address"};
		for (String columnName : columnNames) {
			tblmdlStudentRecords.addColumn(columnName);
		}
		
		//This sets the rows' data. 
		Object[] rowData = new Object[columnNames.length];
		switch(tableModel) {
			case ALL:	//If @TableModel is set to ALL, all data in the student records will be displayed. 
				for (var student : studentRecords.get()) {
					rowData[0] = student.getStudentNo();
					rowData[1] = student.getFirstName();
					rowData[2] = student.getMiddleName();
					rowData[3] = student.getLastName();
					rowData[4] = student.getSex();
					rowData[5] = student.getBirthday();
					rowData[6] = student.getSectionCode();
					rowData[7] = student.getEmail();
					rowData[8] = student.getContactNo();
					rowData[9] = student.getAddress();
					
					tblmdlStudentRecords.addRow(rowData);
				}
				
				break;
				
			/* If @TableModel is set to SEARCH, it will only display the student/s found based on the
			 * search input. The admin may search for a section or a student.
			 */
			case SEARCH:
				for (var student : studentRecords.get()) {
					if (cmbbxSearch.getSelectedItem().toString().equals("Student No")) {
						if (student.getStudentNo().equals(txtfldSearch.getText())) {
							rowData[0] = student.getStudentNo();
							rowData[1] = student.getFirstName();
							rowData[2] = student.getMiddleName();
							rowData[3] = student.getLastName();
							rowData[4] = student.getSex();
							rowData[5] = student.getBirthday();
							rowData[6] = student.getSectionCode();
							rowData[7] = student.getEmail();
							rowData[8] = student.getContactNo();
							rowData[9] = student.getAddress();
							
							tblmdlStudentRecords.addRow(rowData);
						}	
					}
					if (cmbbxSearch.getSelectedItem().toString().equals("Section")) {
						if (student.getSectionCode().equals(txtfldSearch.getText())) {
							rowData[0] = student.getStudentNo();
							rowData[1] = student.getFirstName();
							rowData[2] = student.getMiddleName();
							rowData[3] = student.getLastName();
							rowData[4] = student.getSex();
							rowData[5] = student.getBirthday();
							rowData[6] = student.getSectionCode();
							rowData[7] = student.getEmail();
							rowData[8] = student.getContactNo();
							rowData[9] = student.getAddress();
							
							tblmdlStudentRecords.addRow(rowData);
						}	
					}
				}
				
				break;		
		}
		
		//If no results found, the table will not refresh.
		if (tblmdlStudentRecords.getRowCount() == 0) {
			smsDialog.showMessageDialog(this, "No Results Found");
		}
		else {
			tblStudentRecords.setModel(tblmdlStudentRecords);
			
			//This sets the table design, such as the columns' width and header color.
			JTableHeader tblhdrStudentRecords = tblStudentRecords.getTableHeader();
			tblhdrStudentRecords.setBackground(new Color(245, 245, 245));
			tblhdrStudentRecords.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tblhdrStudentRecords.setForeground(new Color(0, 0, 0));
			
			for (int i = 0; i < tblStudentRecords.getColumnCount(); i++) {
				tblStudentRecords.getColumnModel().getColumn(i).setPreferredWidth(180);
			}
		}
	}
	
	
	/* This is the implementation of the abstract method "confirmLogout()" from @SMSUser interface.
	 * It is a JDialog. If the user click the button 'Yes', the account will log out, that is, @SMSAdmin will dispose
	 * and return to @SMSLogin. 
	 */
	public void confirmLogout() {
		
		JDialog dlgLogout = new JDialog(this, "Confirm Logout");
		dlgLogout.setSize(300, 125);
		dlgLogout.setLayout(null);
		dlgLogout.setResizable(false);
		dlgLogout.setLocationRelativeTo(null);
		dlgLogout.getContentPane().setBackground(new Color(187, 37, 61));
		
		JLabel lblConfirm = new JLabel("Are you sure you want to log out?");
		lblConfirm.setBounds(20, 10, 300, 25);
		lblConfirm.setFont(new Font("Tahoma", 1, 14));
		lblConfirm.setForeground(new Color(255, 255, 255));
		
		JButton bttnNo = new JButton("No");
		bttnNo.setBounds(50, 45, 70, 22);
		bttnNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bttnNo.setForeground(new Color(0, 0, 0));
		bttnNo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dlgLogout.dispose();
			}
		});
		
		JButton bttnYes = new JButton("Yes");
		bttnYes.setBounds(165, 45, 70, 22);
		bttnYes.setFont(new Font("Tahoma", 1, 12));
		bttnYes.setForeground(new Color(0, 0, 0));
		bttnYes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					new SMSLogin();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		dlgLogout.add(lblConfirm);
		dlgLogout.add(bttnYes);
		dlgLogout.add(bttnNo);
		dlgLogout.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bttnLogout) {		//This action is for logging out of @SMSAdmin account. 
			// The method "confirmLogout()" is called, which is an abstract method of @SMSUser interface implemented by @SMSAdmin.
			confirmLogout();
		} 
		else if (e.getSource() == bttnAdd) {	//This action creates the student record.
			student = null;
			
			/*The inputs for birthday and sex are placed into new Strings, as textfields for birthYear, birthMonth,
			 * and birthDay is separated and button group has no method that returns the title of the selected item.
			 */
			String birthday = txtfldBirthYear.getText()+"-"+txtfldBirthMonth.getText()+"-"+txtfldBirthDay.getText();
			String sex = "";	
			if (rdbttnMale.isSelected()) {
				sex = "Male";
			}
			else if (rdbttnFemale.isSelected()) {
				sex = "Female";
			}
			
			//These are the conditions for adding a student.
			if (txtfldFirstName.getText().trim().isEmpty() || txtfldLastName.getText().trim().isEmpty() || sex.trim().isEmpty() || 
					txtfldBirthYear.getText().trim().isEmpty() || txtfldBirthMonth.getText().trim().isEmpty() || txtfldBirthDay.getText().trim().isEmpty() ||
					cmbbxSectionCode.getSelectedItem().toString().equals("----SELECT----")) {		
				
				/*
				 *  If textfields are null, or some of the necessary information were not provided, a dialog will
				 *  appear which informs the Admin that no student is added.
				 */
				
				smsDialog.showMessageDialog(this, "No Student Added", "Please fill-in the necessary information.");
			}
			else {
				
				//If all conditions are met, it will try to add the student, while catching the possible Exceptions.
				
				try {
					/*The inputs are used to instantiate a @Student, which will be thrown as parameter in "createStudentRecord()"
					 * method of the admin.
					 */
					student = new Student(studentRecords.generateStudentNo(), txtfldFirstName.getText(), txtfldMiddleName.getText(), 
							txtfldLastName.getText(), sex, Date.valueOf(birthday), cmbbxSectionCode.getSelectedItem().toString(), 
							txtfldEmail.getText(), txtfldContactNo.getText(), txtfldAddress.getText());
					
					admin.createStudentRecord(student);		//This is the code that creates the student record.
					smsDialog.showMessageDialog(this, "Student Record Created", ("Student No: "+student.getStudentNo()));	//If the student is successfully created, a dialog will inform the admin.
					
					// The textfields are cleared.
					txtfldFirstName.setText(""); 
					txtfldMiddleName.setText(""); 
					txtfldLastName.setText("");
					bttngrpSex.clearSelection();
					txtfldBirthYear.setText("");
					txtfldBirthMonth.setText("");
					txtfldBirthDay.setText("");
					cmbbxSectionCode.setSelectedIndex(0);
					txtfldEmail.setText(""); 
					txtfldContactNo.setText(""); 
					txtfldAddress.setText("");
					
					//The table model is set to "ALL", and the table is refreshed.
					tableModel = TableModel.ALL;
					displayStudentRecordsTable();
				} catch (SQLException e1) {
					//This catches all other SQL Exceptions, and displays a dialog.
					smsDialog.showMessageDialog(this, "Student Not Created", "Please make sure you entered valid", "information.");
					e1.printStackTrace();
				} catch (Exception e1) {
					//This catches all other Exceptions, and displays a dialog.
					smsDialog.showMessageDialog(this, "Student Not Created", "Please make sure you entered valid", "information.");
				}
				
				student = null;
			}
		}
		else if (e.getSource() == bttnClear) {		//This action clears the inputs in creating a student record.
			txtfldFirstName.setText(""); 
			txtfldMiddleName.setText(""); 
			txtfldLastName.setText("");
			bttngrpSex.clearSelection();
			txtfldBirthYear.setText("");
			txtfldBirthMonth.setText("");
			txtfldBirthDay.setText("");
			cmbbxSectionCode.setSelectedIndex(0);
			txtfldEmail.setText(""); 
			txtfldContactNo.setText(""); 
			txtfldAddress.setText(""); 
			
			student = null;
		}
		else if (e.getSource() == bttnSearch) {		//This is the action for Search.
			//It checks first if the textfield for Search is not empty, otherwise it will not proceed.
			if (txtfldSearch.getText().trim().isEmpty() == false) {
				/* To display the search results in the table, the value of the instance "tableModel" is changed into
				 * @TableModel.SEARCH. The method "displayStudentRecordsTable()" is then called again to refresh the table.
				 */
				tableModel = TableModel.SEARCH;
				try {
					displayStudentRecordsTable();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			student = null;
		}
		else if (e.getSource() == bttnRefresh) {		//This action refreshes the table.
			/* The value of the instance "tableModel" is changed back into @TableModel.ALL, and the method "displayStudentRecordsTable()"
			 * is called again to refresh the table. The textfield for Search is also cleared.
			 */
			tableModel = TableModel.ALL;
			txtfldSearch.setText("");
			try {
				displayStudentRecordsTable();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			student = null;
		}
		else if (e.getSource() == bttnDelete) {			//This action deletes a student record.
			//It checks first if the instance "student" is not null, that is, the @Admin selected a student record in the table.
			if (student != null) {
				try {
					/* If the instance "student" is not null, the method "deleteStudentRecord()" of @Admin is called 
					 * to delete the student record. A dialog displays if the student record is successfully deleted.
					 * Then, the table is refreshed by calling the "displayStudentRecordsTable()" method.
					 */
					admin.deleteStudentRecord(student);
					smsDialog.showMessageDialog(this, "Student Record Deleted");
					tableModel = TableModel.ALL;
					displayStudentRecordsTable();
					
					student = null;
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				student = null;
			}
		}
		
		/* Other Notes:
		 * The instance "student" is set to null everytime an action is performed. This is because the instance is shared by actions
		 * add student and delete student. It is to ensure that the actions will not be confused of which @Student 
		 * is being referred.
		 */
	}

}
