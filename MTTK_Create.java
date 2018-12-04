public class MTTK_Create {
  private String tempUsername;
  private String tempPassword;

  private boolean usernameIsValid;
  private boolean passwordIsValid;

  public MTTK_Create() {
    tempUsername = "";
    tempPassword = "";
    usernameIsValid = false;
    passwordIsValid = false;
  }

  public boolean tryUsername(String username) {
    int index = MTTK_Users.indexOfUser(username);
    System.out.println("index: " + index);
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