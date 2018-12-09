public class MTTK_Login {

  public String tempUsername;
  public boolean usernameIsValid;

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
      return password.equals(MTTK_Users.passwordOfUser(tempUsername));
    }
    return false;
  }
}
