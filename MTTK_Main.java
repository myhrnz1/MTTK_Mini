import java.util.Scanner;
import java.util.InputMismatchException;

public class MTTK_Main {
  private static Scanner scan = new Scanner(System.in);
  public static void main (String[] args) {
  
  int menuOption = 0;
  boolean loggedIn = false;

  printMenu();
  boolean loopAgain = true;
  while(loopAgain) {
      menuOption = 0;
      while(!(menuOption == 1 || menuOption == 2 || menuOption == 3)) {
      System.out.print("Select your option: ");
      menuOption = scanInt();
    }
    if (menuOption == 1) {
      tryCreateUser();
    } else if (menuOption == 2) {
      tryLoginUser();
      System.out.println("Welcome MAKE SURE RIGHT NAME!");
      loggedIn = true;
    } else if (menuOption == 3) {
      loopAgain = false;
    } else {
      System.out.println("Fundamental error!");
    }
    if (loggedIn) {
      menuOption = 0;
      printLoggedInMenu();
      while(menuOption != 1) {
        System.out.print("Select your option: ");
        menuOption = scanInt();
      }
      System.out.println("Bye MAKE SURE RIGHT NAME!");
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

  private static void tryLoginUser() {
    String tempUsername = "";
    String tempPassword = "";
    System.out.print("Username: ");
    tempUsername = scan.next();
    System.out.print("Password: ");
    tempPassword = scan.next();
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