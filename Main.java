import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean isTrue = true;
        int menuOption;
        String userName;
        String userSurname;

        System.out.println("\n============================================");
        System.out.println("\t\t\t\tTask Manager");
        System.out.println("============================================");

        System.out.print("\nPlease provide your name: ");
        userName = keyboard.next();

        System.out.print("Please provide your surname: ");
        userSurname = keyboard.next();

        System.out.println("\nWelcome " + userName + " " + userSurname + "\n>>>What would you like to do?<<< \n");

        Actions actions = new Actions();

        while (isTrue) {
            System.out.println("1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Task status");
            System.out.println("3. Exit");

            System.out.print(">>> Choose Option: ");
            menuOption = keyboard.nextInt();
            keyboard.nextLine(); // consume newline

            switch (menuOption) {
                case 1:
                    actions.addTask();
                    break;
                case 2:
                    actions.editTask();
                    break;
                case 3:
                    actions.taskStatus();break;
                case 4:
                    System.out.println("Exiting...");
                    isTrue = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
