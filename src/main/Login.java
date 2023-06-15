package main;

public class Login {
	
	public boolean ValidateAccount(Professor prof, String userID, String password) {
		boolean doesAccountExists = false;
		
		if (userID.equals(prof.getFacultyNo())&& password.equals(prof.getPassword())) {
			doesAccountExists = true;
		}
		
		return doesAccountExists;
	}
	
	public boolean ValidateAccount(Admin admin, String userID, String password) {
		boolean doesAccountExists = false;
		
		if (userID.equals(admin.getAdminNo())&& password.equals(admin.getPassword())) {
			doesAccountExists = true;
		}
		
		return doesAccountExists;
	}
	
	public void ChangePassword(Professor prof, String oldPassword, String newPassword, String confirmNewPassword) {
		if (oldPassword.equals(prof.getPassword()) && newPassword.equals(confirmNewPassword)) {
			prof.setPassword(newPassword);
		}
	}
	
	public void ChangePassword(Admin admin, String oldPassword, String newPassword, String confirmNewPassword) {
		if (oldPassword.equals(admin.getPassword()) && newPassword.equals(confirmNewPassword)) {
			admin.setPassword(newPassword);
		}
	}

}
