/* This is the UI for Professor. It contains the faculty loads, and has buttons to open its @SMSClassList and 
 * @SMSGradingSheet.
 */

package ui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import models.FacultyLoad;
import models.Professor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class SMSFaculty extends JFrame implements ActionListener, SMSUser {
	
	Professor professor;
	FacultyLoad selectedFacultyLoad;	//This is an instance for the selected faculty load.
	
	/* The @SMSGradingSheet and @SMSClassList that the @Professor will open are added into an ArrayList. This is for 
	 * the purpose of disposing all the frames opened when @Professor logged out of @SMSFaculty.
	 */
	ArrayList<SMSGradingSheet> gradingSheets = new ArrayList<SMSGradingSheet>();
	ArrayList<SMSClassList> classLists = new ArrayList<SMSClassList>();
	
	// Components used
	JLabel lblSMS, lblFacultyLoad;
	JButton bttnClassList, bttnGradingSheet, bttnLogout;
	JPanel panel;
	JTable tblFacultyLoad;
	JScrollPane scrollPane;
	
	SMSFaculty(Professor professor) throws SQLException {
		
		this.professor = professor;		//The Professor
		
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
		bttnLogout.addActionListener(this);
		
		panel = new JPanel();
		panel.setBounds(20, 85, 995, 500);
		panel.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel.setLayout(null);
		panel.setBackground(new Color(245, 225, 187));
		
		lblFacultyLoad = new JLabel("Faculty Load");
		lblFacultyLoad.setBounds(20, 19, 150, 30);
		lblFacultyLoad.setFont(new Font("Tahoma", 1, 20));
		lblFacultyLoad.setForeground(new Color(0, 0, 0));
		
		bttnClassList = new JButton("Class List");
		bttnClassList.setBounds(667, 20, 150, 24);
		bttnClassList.setFont(new Font("Tahoma", 1, 13));
		bttnClassList.setForeground(new Color(0, 0, 0));
		bttnClassList.addActionListener(this);
		
		bttnGradingSheet = new JButton("Grading Sheet");
		bttnGradingSheet.setBounds(827, 20, 150, 24);
		bttnGradingSheet.setFont(new Font("Tahoma", 1, 13));
		bttnGradingSheet.setForeground(new Color(0, 0, 0));
		bttnGradingSheet.addActionListener(this);
		
		
		// This is the table for the faculty loads.
		tblFacultyLoad = new JTable();
		tblFacultyLoad.setRowHeight(30);
		tblFacultyLoad.setGridColor(new Color(0, 0, 0));
		tblFacultyLoad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblFacultyLoad.setForeground(new Color(0, 0, 0));
		tblFacultyLoad.setFillsViewportHeight(true);
		tblFacultyLoad.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		tblFacultyLoad.setModel(getFacultyLoadTableModel());
		
		JTableHeader tblhdrFacultyLoad = tblFacultyLoad.getTableHeader();
		tblhdrFacultyLoad.setBackground(new Color(245, 245, 245));
		tblhdrFacultyLoad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblhdrFacultyLoad.setForeground(new Color(0, 0, 0));
		
		for (int i = 0; i < tblFacultyLoad.getColumnCount(); i++) {
			tblFacultyLoad.getColumnModel().getColumn(i).setPreferredWidth(250);
		}
		
		/* This is the mouse listener for the table. When a row is double-clicked, its index is used to get
		 * that faculty load using "get()" method of ArrayList, then the value is inserted in the instance "selectedFacultyLoad".
		 */
		tblFacultyLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int rowIndex = tblFacultyLoad.getSelectedRow();
					selectedFacultyLoad = professor.getFacultyLoads().get(rowIndex);
				}
			}
			
		});
		
		scrollPane = new JScrollPane(tblFacultyLoad);
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
	
	//This method returns the table model for the faculty loads.
	public DefaultTableModel getFacultyLoadTableModel() throws SQLException {
		
		DefaultTableModel tblmdlFacultyLoad = new DefaultTableModel() {		// This is the table model.
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		// This sets the column names.
		String[] columnNames = {"#", "Subject Code", "Subject Description", "Section Code", "Schedule"};
		for (String columnName : columnNames) {
			tblmdlFacultyLoad.addColumn(columnName);
		}
		
		// This sets the rows' data. It calls the "getFacultyLoads()" method of @Professor, adds the data in the row.
		Object[] rowData = new Object[columnNames.length];
		int no = 1;		// This variable is added to the table as a numbering.
		for (var load : professor.getFacultyLoads()) {	
			rowData[0] = no;
			rowData[1] = load.getSubjectCode();
			rowData[2] = load.getSubjectDescription();
			rowData[3] = load.getSectionCode();
			rowData[4] = load.getSchedule();
			
			tblmdlFacultyLoad.addRow(rowData);
			
			no++;	// The variable "no" increments here.
		}
		
		return tblmdlFacultyLoad;
	}
	
	/* This is the implementation of the abstract method "confirmLogout()" from @SMSUser interface.
	 * It is a JDialog. If the user click the button 'Yes', the account will log out, that is, @SMSAdmin will dispose
	 * (including all the @SMSGradingSheet and @SMSClassList opened), and returns to @SMSLogin. 
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
					for (var classList : classLists) {
						classList.dispose();
					}
					for (var gradingSheet : gradingSheets) {
						gradingSheet.dispose();
					}
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

		if (e.getSource() == bttnLogout) {		//This action is for logging out of @SMSFaculty account. 
			/* The method "confirmLogout()" is called, which is an abstract method of @SMSUser interface 
			 * implemented by @SMSAdmin. It disposes @SMSAdmin, including all the @SMSGradingSheet and @SMSClassList 
			 * opened.
			 */
			confirmLogout();
		} 
		else if (e.getSource() == bttnClassList) {
			try {
				if (selectedFacultyLoad != null) {	
					/* The "selectedFacultyLoad" is checked first it is null or not to avoid NullPointerException.
					 * If it is not null, a new @SMSClassList is opened and added to the ArrayList of @ClassList.
					 */
					classLists.add(new SMSClassList(selectedFacultyLoad));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} 
		else if (e.getSource() == bttnGradingSheet) {
			try {
				if (selectedFacultyLoad != null) {
					/* The "selectedFacultyLoad" is checked first it is null or not to avoid NullPointerException.
					 * If it is not null, a new @SMSGradingSheet is opened and added to the ArrayList of @GradingSheet.
					 */
					gradingSheets.add(new SMSGradingSheet(professor, selectedFacultyLoad));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} 
		
	}

}
