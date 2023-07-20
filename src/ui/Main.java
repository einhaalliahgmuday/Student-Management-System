// This is the Main of Student Management System.

package ui;

import java.awt.EventQueue;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		//EventQueue is used to execute the application.
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new SMSLogin();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		
		
		/* Admin: AD2023-000-BN-0 (same ID and password)
		 * Faculty: FA2023-000-BN-0 (same ID and password)
		 * 
		 * Double-click on table to select
		 * (for adding and deleting a student record, selecting a faculty load to view class list or grading sheet)
		 * 
		 * The comments will be updated by Saturday for better understanding.
		 */

	}

}
