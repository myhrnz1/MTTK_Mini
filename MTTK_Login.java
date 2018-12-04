public class MTTK_Login {

  private String tempUsername;
  private boolean usernameIsValid;

  public MTTK_Login() {
    tempUsername = "";
    usernameIsValid = false;
  }

  public boolean checkUsername(String username) {
    int index = MTTK_Users.indexOfUser(username);
    if (index < MTTK_Users.usersList.size()) {
      tempUsername = username;
      usernameIsValid = true;
    }
    return usernameIsValid;
  }

  public boolean checkPassword(String password) {
    if (usernameIsValid) {
      return password == passwordOfUser(tempUsername);
    }
    return false;
  }
}