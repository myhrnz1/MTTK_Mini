import java.util.Scanner;
import java.util.InputMismatchException;

public class MTTK_Main {
  static String currentUser = "";

  private static Scanner scan = new Scanner(System.in);
  public static void main (String[] args) {
  
  int menuOption = 0;
  boolean loggedIn = false;
  

  boolean loopAgain = true;
  while(loopAgain) {
      menuOption = 0;
      currentUser = "";
      printMenu();
      while(!(menuOption == 1 || menuOption == 2 || menuOption == 3)) {
      System.out.print("Select your option: ");
      menuOption = scanInt();
    }
    if (menuOption == 1) {
      tryCreateUser();
    } else if (menuOption == 2) {
      loggedIn = tryLoginUser();
    } else if (menuOption == 3) {
      loopAgain = false;
    } else {
      System.out.println("Fundamental error!");
    }
    if (loggedIn) {
      menuOption = 0;
      System.out.println("Welcome " + currentUser + "!");
      printLoggedInMenu();
      while(menuOption != 1) {
        System.out.print("Select your option: ");
        menuOption = scanInt();
      }
      System.out.println("Bye " + currentUser + "!");
      loggedIn = false;
    }
  }
  scan.close();
  }

  private static void printLoggedInMenu() {
    System.out.println("1. Logout");
  }

  private static void tryCreateUser() {
    boolean success = false;
    MTTK_Create create = new MTTK_Create();
    while(!success) {
      boolean validInput = false;
      System.out.print("Choose a username: ");
      while(!validInput) {
        validInput = create.tryUsername(scan.next());
        if(!validInput) {
          System.out.print("Choose another username: ");
        }
      }
      validInput = false;
      while(!validInput) {
        System.out.print("Choose a password: ");
        validInput = create.tryPassword(scan.next());
        if(!validInput) {
          System.out.print("Choose another password: ");
        }
      }
      success = create.tryCreate();
    }
  }

  private static boolean tryLoginUser() {
    MTTK_Login login = new MTTK_Login();
    System.out.print("Username: ");
    String tempUsername = scan.next();
    login.checkUsername(tempUsername);
    System.out.print("Password: ");
    boolean success = login.checkPassword(scan.next());
    if (success) {
      currentUser = tempUsername;
    }
    return success;
  }

  private static void printMenu() {
    System.out.println("1. Create user");
    System.out.println("2. Login existing user");
    System.out.println("3. Exit");
  }

  private static int scanInt() {
    int inputInt;
    while(true){
      try {
        inputInt = scan.nextInt();
        break;
      }
      catch (InputMismatchException e) {
        System.out.print("Select your option: ");
        scan.next();
      }
    }
    return inputInt;
  }
}