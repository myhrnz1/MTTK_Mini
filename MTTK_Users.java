import java.util.ArrayList;

public class MTTK_Users {
  public static ArrayList<MTTK_Users> usersList = new ArrayList<MTTK_Users>();

  String username = "";
  String password = "";

  private MTTK_Users(String inputUsername, String inputPassword) {
    username = inputUsername;
    password = inputPassword;
  }

  public static void addMTTK_User(String inputUsername, String inputPassword) {
    MTTK_Users newUser = new MTTK_Users(inputUsername, inputPassword);
    usersList.add(newUser);
  }

  public static int indexOfUser(String username) {
    int index;
    for (index = 0; index < usersList.size(); index++) {
      if (usersList.get(index).username.equals(username)) {
        break;
      }
    }
  return index;
  }

  public static String passwordOfUser(String username) {
    int index = indexOfUser(username);
    String password = "-1";
    if (index < usersList.size()) {
      password = usersList.get(index).password;
    }
    return password;
  }
}