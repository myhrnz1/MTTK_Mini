public class MTTK_Create {
  public String tempUsername;
  public String tempPassword;

  public boolean usernameIsValid;
  public boolean passwordIsValid;

  public MTTK_Create() {
    tempUsername = "";
    tempPassword = "";
    usernameIsValid = false;
    passwordIsValid = false;
  }

  public boolean tryUsername(String username) {
    int index = MTTK_Users.indexOfUser(username);
    if (index >= MTTK_Users.usersList.size()) {
      tempUsername = username;
      usernameIsValid = true;
    }
    return usernameIsValid;
  }

  public boolean tryPassword(String password) {
    // here we can use requirements on chosen password
    tempPassword = password;
    passwordIsValid = true;
    return passwordIsValid;
  }

  public boolean tryCreate() {
    boolean creationComplete = false;
    if (usernameIsValid && passwordIsValid) {
      MTTK_Users.addMTTK_User(tempUsername,tempPassword);
      creationComplete = true;
    }
    return creationComplete;
  }
}
