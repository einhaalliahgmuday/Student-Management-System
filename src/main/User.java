package main;

import java.sql.SQLException;

import data.SQLData;

public class User {
	
	private SQLData sql = new SQLData();
	
	public User() throws SQLException {
		
	}
	
	public Professor loginAsProfessor(String userID, String password) throws SQLException {
		Professor foundProfessor = null;
		
		for (var professor : sql.getProfessors()) {
			if ((professor.getFacultyNo().equals(userID)) && (professor.getPassword().equals(password))) {
				foundProfessor = professor;
			}
		}
		
		return foundProfessor;
	}
	
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
