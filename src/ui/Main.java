/* This is the Main of Student Management System.
 */

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
		
		
		
		/* Admin: AD2023-000-BN (same ID and password)
		 * Faculty: FA2023-000-BN (same ID and password)
		 * 
		 * The comments and Trello will be updated by Saturday.
		 */

	}

}
