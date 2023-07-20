/* This class is used to validate a user inputs (ID and password) from SMSLogin.
 */

package models;

import java.sql.SQLException;

import data.SQLData;

public class User {
	
	private SQLData sql = new SQLData();
	
	public User() throws SQLException {
		
	}
	
	/*If the user type selected in SMS Login is "Professor", this method is called.
	 * If the ID and password exists correspondingly, it returns its object of @Professor.
	 */
	public Professor loginAsProfessor(String userID, String password) throws SQLException {
		Professor foundProfessor = null;
		
		for (var professor : sql.getProfessors()) {
			if ((professor.getFacultyNo().equals(userID)) && (professor.getPassword().equals(password))) {
				foundProfessor = professor;
			}
		}
		
		return foundProfessor;
	}
	
	/*If the user type selected in SMS Login is "Admin", this method is called.
	 * If the ID and password exists correspondingly, it returns its object of @Admin.
	 */
	public Admin loginAsAdmin(String userID, String password) throws SQLException {
		Admin foundAdmin = null;
		
		for (var admin : sql.getAdmins()) {
			if ((admin.getAdminNo().equals(userID)) && (admin.getPassword().equals(password))) {
				foundAdmin = admin;
			}
		}
		
		return foundAdmin;
	}

}
