package ui;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import java.awt.*;

public class Admin extends JFrame {
	
	JLabel lblSMS;
	JTabbedPane tabbedPane;
	JPanel pnlStudent, pnlProfessor, pnlFacultyLoad, pnlGrades;
	
	JPanel studentPnl1, studentPnl2;
	JLabel lblStudentNo, lblFirstName, lblMiddleName, lblLastName, lblSex, lblBirthday, lblSectionCode, 
			lblEmail, lblContactNo, lblAddress;
	JTextField txtfldStudentNo, txtfldFirstName, txtfldMiddleName, txtfldLastName, txtfldBirthMonth, 
				txtfldBirthDay, txtfldBirthYear, txtfldEmail, txtfldContactNo, txtfldAddress;
	JRadioButton rdbttnMale, rdbttnFemale;
	ButtonGroup bttngrpSex;
	JComboBox cmbbxSectionCode;
	JButton bttnAdd;
	
	JLabel lblSearch;
	JComboBox cmbbxSearch;
	JTextField txtfldSearch;
	JButton bttnSearch, bttnClear, bttnDelete;
	JTable studentTbl;
	JScrollPane scrollPane;
	
	//border of buttons
	
	
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
		
		
//		lblStudentNo = new JLabel("Student No:");
//		lblStudentNo.setBounds(17, 50, 100, 22);
//		lblStudentNo.setFont(new Font("Tahoma", 1, 12));
//		lblStudentNo.setForeground(new Color(0, 0, 0));
//		
//		txtfldStudentNo = new JTextField();
//		txtfldStudentNo.setBounds(130, 50, 201, 22);
//		txtfldStudentNo.setBorder(new LineBorder(new Color(0, 0, 0)));
//		txtfldStudentNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		
//		lblFirstName = new JLabel("First Name:");
//		lblFirstName.setBounds(17, 82, 100, 22);
//		lblFirstName.setFont(new Font("Tahoma", 1, 12));
//		lblFirstName.setForeground(new Color(0, 0, 0));
//		
//		txtfldFirstName = new JTextField();
//		txtfldFirstName.setBounds(130, 82, 201, 22);
//		txtfldFirstName.setBorder(new LineBorder(new Color(0, 0, 0)));
//		txtfldFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		
//		lblMiddleName = new JLabel("Middle Name:");
//		lblMiddleName.setBounds(17, 114, 100, 22);
//		lblMiddleName.setFont(new Font("Tahoma", 1, 12));
//		lblMiddleName.setForeground(new Color(0, 0, 0));
//		
//		txtfldMiddleName = new JTextField();
//		txtfldMiddleName.setBounds(130, 114, 201, 22);
//		txtfldMiddleName.setBorder(new LineBorder(new Color(0, 0, 0)));
//		txtfldMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		
//		lblLastName = new JLabel("Last Name:");
//		lblLastName.setBounds(17, 146, 100, 22);
//		lblLastName.setFont(new Font("Tahoma", 1, 12));
//		lblLastName.setForeground(new Color(0, 0, 0));
//		
//		txtfldLastName = new JTextField();
//		txtfldLastName.setBounds(130, 146, 201, 22);
//		txtfldLastName.setBorder(new LineBorder(new Color(0, 0, 0)));
//		txtfldLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		
//		lblSex = new JLabel("Sex: ");
//		lblSex.setBounds(17, 178, 100, 22);
//		lblSex.setFont(new Font("Tahoma", 1, 12));
//		lblSex.setForeground(new Color(0, 0, 0));
//		
//		rdbttnMale = new JRadioButton("Male");
//		rdbttnMale.setBounds(130, 178, 100, 22);
//		rdbttnMale.setBackground(null);
//		rdbttnMale.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		rdbttnMale.setForeground(new Color(0, 0, 0));
//		
//		rdbttnFemale = new JRadioButton("Female");
//		rdbttnFemale.setBounds(240, 178, 100, 22);
//		rdbttnFemale.setBackground(null);
//		rdbttnFemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		rdbttnFemale.setForeground(new Color(0, 0, 0));
//		
//		bttngrpSex = new ButtonGroup();
//		bttngrpSex.add(rdbttnMale);
//		bttngrpSex.add(rdbttnFemale);
//		
//		lblBirthday = new JLabel("Birthday (mm/dd/yyy):              /           /");
//		lblBirthday.setBounds(17, 210, 300, 22);
//		lblBirthday.setBackground(null);
//		lblBirthday.setFont(new Font("Tahoma", 1, 12));
//		lblBirthday.setForeground(new Color(0, 0, 0));
//		
//		txtfldBirthMonth = new JTextField();
//		txtfldBirthMonth.setBounds(181, 210, 30, 22);
//		txtfldBirthMonth.setBorder(new LineBorder(new Color(0, 0, 0)));
//		txtfldBirthMonth.setHorizontalAlignment(JTextField.CENTER);
//		txtfldBirthMonth.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		
//		txtfldBirthDay = new JTextField();
//		txtfldBirthDay.setBounds(231, 210, 30, 22);
//		txtfldBirthDay.setBorder(new LineBorder(new Color(0, 0, 0)));
//		txtfldBirthDay.setHorizontalAlignment(JTextField.CENTER);
//		txtfldBirthDay.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		
//		txtfldBirthYear = new JTextField();
//		txtfldBirthYear.setBounds(281, 210, 50, 22);
//		txtfldBirthYear.setBorder(new LineBorder(new Color(0, 0, 0)));
//		txtfldBirthYear.setHorizontalAlignment(JTextField.CENTER);
//		txtfldBirthYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		
//		lblSectionCode = new JLabel("Section Code:");
//		lblSectionCode.setBounds(17, 242, 100, 22);
//		lblSectionCode.setFont(new Font("Tahoma", 1, 12));
//		lblSectionCode.setForeground(new Color(0, 0, 0));
//		
//		String[] sectionCodes = {"BSIT 2-1", "DICT 2-1"};
//		cmbbxSectionCode = new JComboBox(sectionCodes);
//		cmbbxSectionCode.setBounds(130, 242, 100, 22);
//		cmbbxSectionCode.setAlignmentX(CENTER_ALIGNMENT);
//		cmbbxSectionCode.setForeground(new Color(0, 0, 0));
//		
//		lblEmail = new JLabel("Email:");
//		lblEmail.setBounds(17, 274, 100, 22);
//		lblEmail.setFont(new Font("Tahoma", 1, 12));
//		lblEmail.setForeground(new Color(0, 0, 0));
//		
//		txtfldEmail = new JTextField();
//		txtfldEmail.setBounds(130, 274, 201, 22);
//		txtfldEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
//		txtfldEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		
//		lblContactNo = new JLabel("Contact No:");
//		lblContactNo.setBounds(17, 304, 100, 22);
//		lblContactNo.setFont(new Font("Tahoma", 1, 12));
//		lblContactNo.setForeground(new Color(0, 0, 0));
//		
//		txtfldContactNo = new JTextField();
//		txtfldContactNo.setBounds(130, 304, 201, 22);
//		txtfldContactNo.setBorder(new LineBorder(new Color(0, 0, 0)));
//		txtfldContactNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		
//		lblAddress = new JLabel("Address:");
//		lblAddress.setBounds(17, 336, 100, 22);
//		lblAddress.setFont(new Font("Tahoma", 1, 12));
//		lblAddress.setForeground(new Color(0, 0, 0));
//		
//		txtfldAddress = new JTextField();
//		txtfldAddress.setBounds(130, 336, 201, 22);
//		txtfldAddress.setBorder(new LineBorder(new Color(0, 0, 0)));
//		txtfldAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		
//		bttnAdd = new JButton("Add Student");
//		bttnAdd.setBounds(100, 385, 130, 22);
//		bttnAdd.setFont(new Font("Tahoma", 1, 12));
//		bttnAdd.setForeground(new Color(0, 0, 0));
//
//		studentPnl1 = new JPanel();
//		studentPnl1.setBounds(6, 4, 350, 480);
//		studentPnl1.setLayout(null);
//		studentPnl1.setBackground(new Color(245, 225, 187));
//		studentPnl1.add(lblStudentNo);
//		studentPnl1.add(txtfldStudentNo);
//		studentPnl1.add(lblFirstName);
//		studentPnl1.add(txtfldFirstName);
//		studentPnl1.add(lblMiddleName);
//		studentPnl1.add(txtfldMiddleName);
//		studentPnl1.add(lblLastName);
//		studentPnl1.add(txtfldLastName);
//		studentPnl1.add(lblSex);
//		studentPnl1.add(rdbttnMale);
//		studentPnl1.add(rdbttnFemale);
//		studentPnl1.add(lblBirthday);
//		studentPnl1.add(txtfldBirthMonth);
//		studentPnl1.add(txtfldBirthDay);
//		studentPnl1.add(txtfldBirthYear);
//		studentPnl1.add(lblSectionCode);
//		studentPnl1.add(cmbbxSectionCode);
//		studentPnl1.add(lblEmail);
//		studentPnl1.add(txtfldEmail);
//		studentPnl1.add(lblContactNo);
//		studentPnl1.add(txtfldContactNo);
//		studentPnl1.add(lblAddress);
//		studentPnl1.add(txtfldAddress);
//		studentPnl1.add(bttnAdd);
//		
//		
//		lblSearch = new JLabel("Search");
//		lblSearch.setBounds(17, 17, 60, 22);
//		lblSearch.setFont(new Font("Tahoma", 1, 12));
//		lblSearch.setForeground(new Color(0, 0, 0));
//		
//		String[] search = {"Student No", "Section"};
//		cmbbxSearch = new JComboBox(search);
//		cmbbxSearch.setBounds(65, 17, 90, 22);
//		cmbbxSearch.setForeground(Color.BLACK);
//		
//		txtfldSearch = new JTextField();
//		txtfldSearch.setBounds(160, 17, 190, 22);
//		txtfldSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
//		txtfldSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		
//		bttnSearch = new JButton("Search");
//		bttnSearch.setBounds(355, 17, 80, 22);
//		bttnSearch.setFont(new Font("Tahoma", 1, 12));
//		bttnSearch.setForeground(new Color(0, 0, 0));
//		
//		bttnClear = new JButton("Clear");
//		bttnClear.setBounds(440, 17, 80, 22);
//		bttnClear.setFont(new Font("Tahoma", 1, 12));
//		bttnClear.setForeground(new Color(0, 0, 0));
//		
//		bttnDelete = new JButton("Delete");
//		bttnDelete.setBounds(525, 17, 80, 22);
//		bttnDelete.setFont(new Font("Tahoma", 1, 12));
//		bttnDelete.setForeground(new Color(0, 0, 0));
//		
//		
//		String column[] = {"Student No", "First Name", "Middle Name", "Last Name", "Sex", "Birthday", 
//				"Section Code", "Email", "Contact No", "Address"};
//		String data[][] = {{"2021-00214-BN-0", "Einha Alliah", "Genciana", "Muday", "Female", "02-19-2003", 
//			"BSIT 2-1", "einhaalliahgmuday@gmail.com", "09065765145", "Ganado, Binan, Laguna"}, 
//				{"2021-00214-BN-0", "Einha Alliah", "Genciana", "Muday", "Female", "02-19-2003", 
//				"BSIT 2-1", "einhaalliahgmuday@gmail.com", "09065765145", "Ganado, Binan, Laguna"}}; 
//		
//		studentTbl = new JTable(data, column);			//edit header
////		studentTbl.setPreferredScrollableViewportSize(new Dimension(1000, 100));
////		studentTbl.setPreferredSize(null);
//		studentTbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
////		studentTbl.doLayout();
//		studentTbl.setRowHeight(22);
//		studentTbl.setGridColor(Color.BLACK);
//		studentTbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		studentTbl.setForeground(new Color(0, 0, 0));
//		studentTbl.setFillsViewportHeight(true);
//		studentTbl.setBorder(new LineBorder(Color.BLACK));
////		studentTbl.setAutoCreateRowSorter(true);
//		
//		JTableHeader studentTblHeader = studentTbl.getTableHeader();
//		studentTblHeader.setBackground(new Color(245, 245, 245));
//		studentTblHeader.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		studentTblHeader.setForeground(Color.BLACK);
//		
//		for (int i = 0; i < studentTbl.getColumnCount(); i++) {
//			studentTbl.getColumnModel().getColumn(i).setPreferredWidth(180);
////			studentTbl.getColumnModel().getColumn(i).setMinWidth(100);
////			studentTbl.getColumnModel().getColumn(i).setMaxWidth(200);
//		}
//		
//		scrollPane = new JScrollPane(studentTbl);
//		scrollPane.setBounds(17, 49, 588, 414);
//		scrollPane.setBorder(new LineBorder(Color.BLACK));
//		    
//		
//		studentPnl2 = new JPanel();
//		studentPnl2.setBounds(363, 4, 622, 480);
//		studentPnl2.setLayout(null);
//		studentPnl2.setBackground(new Color(245, 225, 187));
//		studentPnl2.add(lblSearch);
//		studentPnl2.add(cmbbxSearch);
//		studentPnl2.add(txtfldSearch);
//		studentPnl2.add(bttnSearch);
//		studentPnl2.add(bttnClear);
//		studentPnl2.add(bttnDelete);
//		studentPnl2.add(scrollPane, BorderLayout.CENTER);	//border layout?
//		
//		
//		pnlStudent = new JPanel();
//		pnlStudent.setLayout(null);
//		pnlStudent.setBackground(new Color(187, 37, 61));
//		pnlStudent.add(studentPnl1);
//		pnlStudent.add(studentPnl2);
		
		
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
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 12));
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.addTab("Student", StudentTab());
		tabbedPane.addTab("Professor", pnlProfessor);
		tabbedPane.addTab("Faculty Load", pnlFacultyLoad);
		tabbedPane.addTab("Grades", pnlGrades);
		
		add(lblSMS);
		add(tabbedPane);
		setVisible(true);
	}
	
	public JPanel StudentTab() {
		
		lblStudentNo = new JLabel("Student No:");
		lblStudentNo.setBounds(17, 50, 100, 22);
		lblStudentNo.setFont(new Font("Tahoma", 1, 12));
		lblStudentNo.setForeground(new Color(0, 0, 0));
		
		txtfldStudentNo = new JTextField();
		txtfldStudentNo.setBounds(130, 50, 201, 22);
		txtfldStudentNo.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldStudentNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(17, 82, 100, 22);
		lblFirstName.setFont(new Font("Tahoma", 1, 12));
		lblFirstName.setForeground(new Color(0, 0, 0));
		
		txtfldFirstName = new JTextField();
		txtfldFirstName.setBounds(130, 82, 201, 22);
		txtfldFirstName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblMiddleName = new JLabel("Middle Name:");
		lblMiddleName.setBounds(17, 114, 100, 22);
		lblMiddleName.setFont(new Font("Tahoma", 1, 12));
		lblMiddleName.setForeground(new Color(0, 0, 0));
		
		txtfldMiddleName = new JTextField();
		txtfldMiddleName.setBounds(130, 114, 201, 22);
		txtfldMiddleName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(17, 146, 100, 22);
		lblLastName.setFont(new Font("Tahoma", 1, 12));
		lblLastName.setForeground(new Color(0, 0, 0));
		
		txtfldLastName = new JTextField();
		txtfldLastName.setBounds(130, 146, 201, 22);
		txtfldLastName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblSex = new JLabel("Sex: ");
		lblSex.setBounds(17, 178, 100, 22);
		lblSex.setFont(new Font("Tahoma", 1, 12));
		lblSex.setForeground(new Color(0, 0, 0));
		
		rdbttnMale = new JRadioButton("Male");
		rdbttnMale.setBounds(130, 178, 100, 22);
		rdbttnMale.setBackground(null);
		rdbttnMale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbttnMale.setForeground(new Color(0, 0, 0));
		
		rdbttnFemale = new JRadioButton("Female");
		rdbttnFemale.setBounds(240, 178, 100, 22);
		rdbttnFemale.setBackground(null);
		rdbttnFemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbttnFemale.setForeground(new Color(0, 0, 0));
		
		bttngrpSex = new ButtonGroup();
		bttngrpSex.add(rdbttnMale);
		bttngrpSex.add(rdbttnFemale);
		
		lblBirthday = new JLabel("Birthday (mm/dd/yyy):              /           /");
		lblBirthday.setBounds(17, 210, 300, 22);
		lblBirthday.setBackground(null);
		lblBirthday.setFont(new Font("Tahoma", 1, 12));
		lblBirthday.setForeground(new Color(0, 0, 0));
		
		txtfldBirthMonth = new JTextField();
		txtfldBirthMonth.setBounds(181, 210, 30, 22);
		txtfldBirthMonth.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldBirthMonth.setHorizontalAlignment(JTextField.CENTER);
		txtfldBirthMonth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtfldBirthDay = new JTextField();
		txtfldBirthDay.setBounds(231, 210, 30, 22);
		txtfldBirthDay.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldBirthDay.setHorizontalAlignment(JTextField.CENTER);
		txtfldBirthDay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtfldBirthYear = new JTextField();
		txtfldBirthYear.setBounds(281, 210, 50, 22);
		txtfldBirthYear.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldBirthYear.setHorizontalAlignment(JTextField.CENTER);
		txtfldBirthYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblSectionCode = new JLabel("Section Code:");
		lblSectionCode.setBounds(17, 242, 100, 22);
		lblSectionCode.setFont(new Font("Tahoma", 1, 12));
		lblSectionCode.setForeground(new Color(0, 0, 0));
		
		String[] sectionCodes = {"BSIT 2-1", "DICT 2-1"};
		cmbbxSectionCode = new JComboBox(sectionCodes);
		cmbbxSectionCode.setBounds(130, 242, 100, 22);
		cmbbxSectionCode.setAlignmentX(CENTER_ALIGNMENT);
		cmbbxSectionCode.setForeground(new Color(0, 0, 0));
		cmbbxSectionCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(17, 274, 100, 22);
		lblEmail.setFont(new Font("Tahoma", 1, 12));
		lblEmail.setForeground(new Color(0, 0, 0));
		
		txtfldEmail = new JTextField();
		txtfldEmail.setBounds(130, 274, 201, 22);
		txtfldEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblContactNo = new JLabel("Contact No:");
		lblContactNo.setBounds(17, 304, 100, 22);
		lblContactNo.setFont(new Font("Tahoma", 1, 12));
		lblContactNo.setForeground(new Color(0, 0, 0));
		
		txtfldContactNo = new JTextField();
		txtfldContactNo.setBounds(130, 304, 201, 22);
		txtfldContactNo.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldContactNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblAddress = new JLabel("Address:");
		lblAddress.setBounds(17, 336, 100, 22);
		lblAddress.setFont(new Font("Tahoma", 1, 12));
		lblAddress.setForeground(new Color(0, 0, 0));
		
		txtfldAddress = new JTextField();
		txtfldAddress.setBounds(130, 336, 201, 22);
		txtfldAddress.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtfldAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		bttnAdd = new JButton("Add Student");
		bttnAdd.setBounds(100, 385, 130, 22);
		bttnAdd.setFont(new Font("Tahoma", 1, 12));
		bttnAdd.setForeground(new Color(0, 0, 0));

		studentPnl1 = new JPanel();
		studentPnl1.setBounds(6, 4, 350, 480);
		studentPnl1.setLayout(null);
		studentPnl1.setBackground(new Color(245, 225, 187));
		studentPnl1.add(lblStudentNo);
		studentPnl1.add(txtfldStudentNo);
		studentPnl1.add(lblFirstName);
		studentPnl1.add(txtfldFirstName);
		studentPnl1.add(lblMiddleName);
		studentPnl1.add(txtfldMiddleName);
		studentPnl1.add(lblLastName);
		studentPnl1.add(txtfldLastName);
		studentPnl1.add(lblSex);
		studentPnl1.add(rdbttnMale);
		studentPnl1.add(rdbttnFemale);
		studentPnl1.add(lblBirthday);
		studentPnl1.add(txtfldBirthMonth);
		studentPnl1.add(txtfldBirthDay);
		studentPnl1.add(txtfldBirthYear);
		studentPnl1.add(lblSectionCode);
		studentPnl1.add(cmbbxSectionCode);
		studentPnl1.add(lblEmail);
		studentPnl1.add(txtfldEmail);
		studentPnl1.add(lblContactNo);
		studentPnl1.add(txtfldContactNo);
		studentPnl1.add(lblAddress);
		studentPnl1.add(txtfldAddress);
		studentPnl1.add(bttnAdd);
		
		
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
		
		
		String column[] = {"Student No", "First Name", "Middle Name", "Last Name", "Sex", "Birthday", 
				"Section Code", "Email", "Contact No", "Address"};
		String data[][] = {{"2021-00214-BN-0", "Einha Alliah", "Genciana", "Muday", "Female", "02-19-2003", 
			"BSIT 2-1", "einhaalliahgmuday@gmail.com", "09065765145", "Ganado, Binan, Laguna"}, 
				{"2021-00212-BN-0", "Michi", "Takahata", "Legaspino", "Female", "01-07-2002", 
				"BSIT 2-1", "michitakahata15@gmail.com", "09270870751", "Sto. Tomas, Binan, Laguna"}}; 
		
		studentTbl = new JTable(data, column);			//edit header
//		studentTbl.setPreferredScrollableViewportSize(new Dimension(1000, 100));
//		studentTbl.setPreferredSize(null);
		studentTbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		studentTbl.doLayout();
		studentTbl.setRowHeight(22);
		studentTbl.setGridColor(Color.BLACK);
		studentTbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		studentTbl.setForeground(new Color(0, 0, 0));
		studentTbl.setFillsViewportHeight(true);
		studentTbl.setBorder(new LineBorder(Color.BLACK));
//		studentTbl.setAutoCreateRowSorter(true);
		
		JTableHeader studentTblHeader = studentTbl.getTableHeader();
		studentTblHeader.setBackground(new Color(245, 245, 245));
		studentTblHeader.setFont(new Font("Tahoma", Font.PLAIN, 12));
		studentTblHeader.setForeground(Color.BLACK);
		
		for (int i = 0; i < studentTbl.getColumnCount(); i++) {
			studentTbl.getColumnModel().getColumn(i).setPreferredWidth(180);
//			studentTbl.getColumnModel().getColumn(i).setMinWidth(100);
//			studentTbl.getColumnModel().getColumn(i).setMaxWidth(200);
		}
		
		scrollPane = new JScrollPane(studentTbl);
		scrollPane.setBounds(17, 49, 588, 414);
		scrollPane.setBorder(new LineBorder(Color.BLACK));
		    
		
		studentPnl2 = new JPanel();
		studentPnl2.setBounds(363, 4, 622, 480);
		studentPnl2.setLayout(null);
		studentPnl2.setBackground(new Color(245, 225, 187));
		studentPnl2.add(lblSearch);
		studentPnl2.add(cmbbxSearch);
		studentPnl2.add(txtfldSearch);
		studentPnl2.add(bttnSearch);
		studentPnl2.add(bttnClear);
		studentPnl2.add(bttnDelete);
		studentPnl2.add(scrollPane, BorderLayout.CENTER);	//border layout?
		
		
		pnlStudent = new JPanel();
		pnlStudent.setLayout(null);
		pnlStudent.setBackground(new Color(187, 37, 61));
		pnlStudent.add(studentPnl1);
		pnlStudent.add(studentPnl2);
		
		
		return pnlStudent;
		
	}

}
