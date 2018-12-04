import java.util.Scanner;
import java.util.InputMismatchException;

public class MTTK_Main {
  private static Scanner scan = new Scanner(System.in);
  public static void main (String[] args) {
  
  int menuOption = 0;
  boolean loggedIn = false;

  printMenu();
  while(!(menuOption == 1 || menuOption == 2)) {
    System.out.print("Select your option: ");
    menuOption = scanInt();
  }
  
  if (menuOption == 1) {
    tryCreateUser();
  } else if (menuOption == 2) {
    tryLoginUser();
    System.out.println("Welcome MAKE SURE RIGHT NAME!");
    loggedIn = true;
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
  }
  
  scan.close();
  }

  private static void printLoggedInMenu() {
    System.out.println("1. Logout");
  }

  private static void tryCreateUser() {
    String tempUsername = "";
    String tempPassword = "";
    System.out.print("Choose a username: ");
    tempUsername = scan.next();
    System.out.print("Choose a password: ");
    tempPassword = scan.next();
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