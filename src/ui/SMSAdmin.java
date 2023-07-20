package ui;

import main.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SMSAdmin extends JFrame implements ActionListener, SMSUser {
	
	Admin admin;
	StudentRecords studentRecords;
	TableModel tableModel = TableModel.ALL;
	Student student;
	SMSDialog smsDialog = new SMSDialog();
	
	JLabel lblSMS;
	JTabbedPane tabbedPane;
	JPanel pnlStudent;
	JButton bttnLogout;
	
	JPanel studentPnlAddStudent;
	JLabel lblStudentNo, lblFirstName, lblMiddleName, lblLastName, lblSex, lblBirthday, lblSectionCode, 
			lblEmail, lblContactNo, lblAddress;
	JTextField txtfldStudentNo, txtfldFirstName, txtfldMiddleName, txtfldLastName, txtfldBirthYear, 
				txtfldBirthMonth, txtfldBirthDay, txtfldEmail, txtfldContactNo, txtfldAddress;
	JRadioButton rdbttnMale, rdbttnFemale;
	ButtonGroup bttngrpSex;
	JComboBox cmbbxSectionCode;
	JButton bttnAdd, bttnUpdate, bttnClear;
	
	JPanel studentPnlTable;
	JLabel lblSearch;
	JComboBox cmbbxSearch;
	JTextField txtfldSearch;
	JButton bttnSearch, bttnRefresh, bttnDelete;
	JTable tblStudentRecords;
	JScrollPane scrollPane;
	
	SMSAdmin(Admin admin) throws SQLException {
		this.admin = admin;
		studentRecords = new StudentRecords();
		
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
		
		tabbedPane = new JTabbedPane();
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
	
	public JPanel getStudentTab() throws SQLException {
		
		lblStudentNo = new JLabel("Student No:");
		lblStudentNo.setBounds(17, 42, 100, 22);
		lblStudentNo.setFont(new Font("Tahoma", 1, 12));
		lblStudentNo.setForeground(new Color(0, 0, 0));
		
		txtfldStudentNo = new JTextField();
		txtfldStudentNo.setBounds(130, 42, 201, 22);
		txtfldStudentNo.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldStudentNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldStudentNo.setForeground(new Color(0, 0, 0));
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(17, 76, 100, 22);
		lblFirstName.setFont(new Font("Tahoma", 1, 12));
		lblFirstName.setForeground(new Color(0, 0, 0));
		
		txtfldFirstName = new JTextField();
		txtfldFirstName.setBounds(130, 76, 201, 22);
		txtfldFirstName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldFirstName.setForeground(new Color(0, 0, 0));
		
		lblMiddleName = new JLabel("Middle Name:");
		lblMiddleName.setBounds(17, 108, 100, 22);
		lblMiddleName.setFont(new Font("Tahoma", 1, 12));
		lblMiddleName.setForeground(new Color(0, 0, 0));
		
		txtfldMiddleName = new JTextField();
		txtfldMiddleName.setBounds(130, 108, 201, 22);
		txtfldMiddleName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldMiddleName.setForeground(new Color(0, 0, 0));
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(17, 140, 100, 22);
		lblLastName.setFont(new Font("Tahoma", 1, 12));
		lblLastName.setForeground(new Color(0, 0, 0));
		
		txtfldLastName = new JTextField();
		txtfldLastName.setBounds(130, 140, 201, 22);
		txtfldLastName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldLastName.setForeground(new Color(0, 0, 0));
		
		lblSex = new JLabel("Sex: ");
		lblSex.setBounds(17, 172, 100, 22);
		lblSex.setFont(new Font("Tahoma", 1, 12));
		lblSex.setForeground(new Color(0, 0, 0));
		
		rdbttnMale = new JRadioButton("Male");
		rdbttnMale.setBounds(130, 172, 100, 22);
		rdbttnMale.setBackground(null);
		rdbttnMale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbttnMale.setForeground(new Color(0, 0, 0));
		
		rdbttnFemale = new JRadioButton("Female");
		rdbttnFemale.setBounds(240, 172, 100, 22);
		rdbttnFemale.setBackground(null);
		rdbttnFemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbttnFemale.setForeground(new Color(0, 0, 0));
		
		bttngrpSex = new ButtonGroup();
		bttngrpSex.add(rdbttnMale);
		bttngrpSex.add(rdbttnFemale);
		
		lblBirthday = new JLabel("Birthday (yyyy/mm/dd):                  /           /");
		lblBirthday.setBounds(17, 204, 300, 22);
		lblBirthday.setBackground(null);
		lblBirthday.setFont(new Font("Tahoma", 1, 12));
		lblBirthday.setForeground(new Color(0, 0, 0));
		
		txtfldBirthYear = new JTextField();
		txtfldBirthYear.setBounds(181, 204, 50, 22);
		txtfldBirthYear.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldBirthYear.setHorizontalAlignment(JTextField.CENTER);
		txtfldBirthYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldBirthYear.setForeground(new Color(0, 0, 0));
		
		txtfldBirthMonth = new JTextField();
		txtfldBirthMonth.setBounds(251, 204, 30, 22);
		txtfldBirthMonth.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldBirthMonth.setHorizontalAlignment(JTextField.CENTER);
		txtfldBirthMonth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldBirthMonth.setForeground(new Color(0, 0, 0));
		
		txtfldBirthDay = new JTextField();
		txtfldBirthDay.setBounds(301, 204, 30, 22);
		txtfldBirthDay.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldBirthDay.setHorizontalAlignment(JTextField.CENTER);
		txtfldBirthDay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldBirthDay.setForeground(new Color(0, 0, 0));
		
		lblSectionCode = new JLabel("Section Code:");
		lblSectionCode.setBounds(17, 236, 100, 22);
		lblSectionCode.setFont(new Font("Tahoma", 1, 12));
		lblSectionCode.setForeground(new Color(0, 0, 0));
		
		String[] sectionCodes = {"----SELECT----", "BSIT 2-1", "DICT 2-1"};
		cmbbxSectionCode = new JComboBox(sectionCodes);
		cmbbxSectionCode.setBounds(130, 236, 100, 22);
		cmbbxSectionCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbbxSectionCode.setForeground(new Color(0, 0, 0));
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(17, 268, 100, 22);
		lblEmail.setFont(new Font("Tahoma", 1, 12));
		lblEmail.setForeground(new Color(0, 0, 0));
		
		txtfldEmail = new JTextField();
		txtfldEmail.setBounds(130, 268, 201, 22);
		txtfldEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldEmail.setForeground(new Color(0, 0, 0));
		
		lblContactNo = new JLabel("Contact No:");
		lblContactNo.setBounds(17, 298, 100, 22);
		lblContactNo.setFont(new Font("Tahoma", 1, 12));
		lblContactNo.setForeground(new Color(0, 0, 0));
		
		txtfldContactNo = new JTextField();
		txtfldContactNo.setBounds(130, 298, 201, 22);
		txtfldContactNo.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldContactNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldContactNo.setForeground(new Color(0, 0, 0));
		
		lblAddress = new JLabel("Address:");
		lblAddress.setBounds(17, 330, 100, 22);
		lblAddress.setFont(new Font("Tahoma", 1, 12));
		lblAddress.setForeground(new Color(0, 0, 0));
		
		txtfldAddress = new JTextField();
		txtfldAddress.setBounds(130, 330, 201, 22);
		txtfldAddress.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtfldAddress.setForeground(new Color(0, 0, 0));
		
		bttnAdd = new JButton("Add Student");
		bttnAdd.setBounds(110, 381, 130, 22);
		bttnAdd.setFont(new Font("Tahoma", 1, 12));
		bttnAdd.setForeground(new Color(0, 0, 0));
		bttnAdd.addActionListener(this);
		
//		bttnUpdate = new JButton("Update");
//		bttnUpdate.setBounds(110, 413, 130, 22);
//		bttnUpdate.setFont(new Font("Tahoma", 1, 12));
//		bttnUpdate.setForeground(new Color(0, 0, 0));
//		bttnUpdate.addActionListener(this);
		
		bttnClear = new JButton("Clear");
		bttnClear.setBounds(110, 413, 130, 22);
		bttnClear.setFont(new Font("Tahoma", 1, 12));
		bttnClear.setForeground(new Color(0, 0, 0));
		bttnClear.addActionListener(this);

		studentPnlAddStudent = new JPanel();
		studentPnlAddStudent.setBounds(6, 4, 350, 480);
		studentPnlAddStudent.setLayout(null);
		studentPnlAddStudent.setBackground(new Color(245, 225, 187));
		studentPnlAddStudent.add(lblStudentNo);
		studentPnlAddStudent.add(txtfldStudentNo);
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
//		studentPnlAddStudent.add(bttnUpdate);
		studentPnlAddStudent.add(bttnClear);
		
		
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
		
		tblStudentRecords = new JTable();
		tblStudentRecords.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblStudentRecords.setRowHeight(22);
		tblStudentRecords.setGridColor(new Color(0, 0, 0));
		tblStudentRecords.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblStudentRecords.setForeground(new Color(0, 0, 0));
		tblStudentRecords.setFillsViewportHeight(true);
		tblStudentRecords.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		displayStudentRecordsTable();
		
		tblStudentRecords.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int rowIndex = tblStudentRecords.getSelectedRow();	
					try {
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
	
	public void displayStudentRecordsTable() throws SQLException {
		
		DefaultTableModel tblmdlStudentRecords = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		String[] columnNames = {"Student No", "First Name", "Middle Name", "Last Name", "Sex", 
				"Birthday", "Section Code", "Email", "Contact No", "Address"};
		for (String columnName : columnNames) {
			tblmdlStudentRecords.addColumn(columnName);
		}
		
		Object[] rowData = new Object[columnNames.length];
		switch(tableModel) {
			case ALL:
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
		
		if (tblmdlStudentRecords.getRowCount() == 0) {
			smsDialog.showMessageDialog(this, "No Results Found!");
		}
		else {
			tblStudentRecords.setModel(tblmdlStudentRecords);
			
			JTableHeader tblhdrStudentRecords = tblStudentRecords.getTableHeader();
			tblhdrStudentRecords.setBackground(new Color(245, 245, 245));
			tblhdrStudentRecords.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tblhdrStudentRecords.setForeground(new Color(0, 0, 0));
			
			for (int i = 0; i < tblStudentRecords.getColumnCount(); i++) {
				tblStudentRecords.getColumnModel().getColumn(i).setPreferredWidth(180);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == bttnLogout) {			
			confirmLogout();
		} 
		else if (e.getSource() == bttnAdd) {	//This action adds a student to the student record.
			student = null;
			
			String birthday = txtfldBirthYear.getText()+"-"+txtfldBirthMonth.getText()+"-"+txtfldBirthDay.getText();
			String sex = "";	
			if (rdbttnMale.isSelected()) {
				sex = "Male";
			}
			else if (rdbttnFemale.isSelected()) {
				sex = "Female";
			}
			
			if (txtfldStudentNo.getText().trim().isEmpty() || txtfldFirstName.getText().trim().isEmpty() || 
					txtfldLastName.getText().trim().isEmpty() || sex.trim().isEmpty() || txtfldBirthYear.getText().trim().isEmpty() || 
					txtfldBirthMonth.getText().trim().isEmpty() || txtfldBirthDay.getText().trim().isEmpty() ||
					cmbbxSectionCode.getSelectedItem().toString().equals("----SELECT----")) {
				
				smsDialog.showMessageDialog(this, "No Student Added", "Please fill-in the necessary information.");
			}
			else if (txtfldStudentNo.getText().length() < 15) {
				smsDialog.showMessageDialog(this, "Invalid Student Number", "Please enter a valid student number.");
			}
			else {
				try {
					student = new Student(txtfldStudentNo.getText(), txtfldFirstName.getText(), txtfldMiddleName.getText(), 
							txtfldLastName.getText(), sex, Date.valueOf(birthday), cmbbxSectionCode.getSelectedItem().toString(), 
							txtfldEmail.getText(), txtfldContactNo.getText(), txtfldAddress.getText());
					
					admin.createStudentRecord(student);
					smsDialog.showMessageDialog(this, "Student Record Created");
					studentRecords.update();
					
					txtfldStudentNo.setText(""); 
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
					
					tableModel = TableModel.ALL;
					displayStudentRecordsTable();
				} catch (SQLIntegrityConstraintViolationException e1) {
					smsDialog.showMessageDialog(this, "Duplicate Student Number", "The student number you entered already", "exists.");
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					smsDialog.showMessageDialog(this, "Student Not Created", "Please make sure you entered valid", "information.");
				}
				
				student = null;
			}
		}
		else if (e.getSource() == bttnClear) {
			txtfldStudentNo.setText(""); 
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
		else if (e.getSource() == bttnSearch) {
			if (txtfldSearch.getText().trim().isEmpty() == false) {
				tableModel = TableModel.SEARCH;
				try {
					displayStudentRecordsTable();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			student = null;
		}
		else if (e.getSource() == bttnRefresh) {
			tableModel = TableModel.ALL;
			txtfldSearch.setText("");
			try {
				displayStudentRecordsTable();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			student = null;
		}
		else if (e.getSource() == bttnDelete) {
			if (student != null) {
				try {
					admin.deleteStudentRecord(student);
					smsDialog.showMessageDialog(this, "Student Record Deleted");
					studentRecords.update();
					displayStudentRecordsTable();
					
					student = null;
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				student = null;
			}
		
		}
	}

}
