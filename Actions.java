import java.util.Scanner;

public class Actions {
    Scanner keyboard = new Scanner(System.in);

    private String taskName;
    private int taskCount;

    /**
     * Validates the deadline format.
     * Must follow the format: YYYY/MM/DD (10 characters long, with slashes at positions 4 and 7)
     * @param deadline the deadline string entered by the user
     * @return true if valid, false otherwise
     */
    public static boolean isValidDeadline(String deadline) {
        if (deadline.length() != 10) {
            return false;
        }
        if (deadline.charAt(4) != '/' || deadline.charAt(7) != '/') {
            return false;
        }
        for (int i = 0; i < deadline.length(); i++) {
            if (i == 4 || i == 7) continue;
            if (!Character.isDigit(deadline.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds a new task with input from the user.
     * Includes validation for description length, deadline format, and priority input.
     */
    public void addTask() {
        char taskOption;

        do {
            // Collect task name
            System.out.print("\nSet task name: ");
            this.taskName = keyboard.nextLine().toUpperCase();

            // Collect task description
            System.out.print("Set task description: ");
            String description = keyboard.nextLine().toLowerCase();
            while (description.length() < 7) {
                System.out.print("Description too short. Enter again: ");
                description = keyboard.nextLine().toLowerCase();
            }

            // Collect task deadline
            System.out.print("Set deadline (YYYY/MM/DD): ");
            String deadline = keyboard.nextLine();
            while (!isValidDeadline(deadline)) {
                System.out.print("Deadline format is incorrect. Enter again: ");
                deadline = keyboard.nextLine();
            }

            // Collect task priority
            System.out.print("Set task Priority (High, Medium, Low): ");
            String priority = keyboard.nextLine().toUpperCase();
            while (!priority.equals("HIGH") && !priority.equals("MEDIUM") && !priority.equals("LOW")) {
                System.out.print("Priority must be High, Medium, or Low. Enter again: ");
                priority = keyboard.nextLine().toUpperCase();
            }

            // Create and add new task
            Tasks newTask = new Tasks(taskName, description, deadline, priority);
            DetailsStorage.completedTasks.add(newTask);
            taskCount = DetailsStorage.completedTasks.size();
            this.taskCount = taskCount;
            newTask.setTaskCount(this.taskCount);

            System.out.println("\n>>>Task successfully Added<<<\n");

            // Ask to add another task
            System.out.print("Do you want to add another task? (Y/N): ");
            taskOption = keyboard.nextLine().charAt(0);

            if (taskOption == 'n' || taskOption == 'N') {
                System.out.println("\n>>>Going back to menu<<<\n");
            }

        } while (taskOption == 'Y' || taskOption == 'y');
    }

    /**
     * Allows the user to edit an existing task by task name.
     * Offers a menu to choose what to edit (name, description, deadline, or priority).
     */
    public void editTask() {
        int editOption;
        String newTaskName, newDescription, newDeadline, newPriority;
        boolean isTaskEdited = false;

        if (DetailsStorage.completedTasks.isEmpty()) {
            System.out.println("\n>>>No task found<<<\n");
        } else {
            System.out.println(">>>Tasks Available: " + this.taskCount + "\n");
            System.out.print("Provide task name: ");
            taskName = keyboard.nextLine().toUpperCase();

            for (Tasks task : DetailsStorage.completedTasks) {
                if (task.getTaskName().equals(taskName)) {
                    isTaskEdited = true;

                    // Display edit menu
                    System.out.println("\n========================================");
                    System.out.println("\t\t\t\tEdit Menu");
                    System.out.println("========================================\n");

                    System.out.println("1. Task Name");
                    System.out.println("2. Task Description");
                    System.out.println("3. Task Deadline");
                    System.out.println("4. Task Priority");
                    System.out.println("5. Exit");

                    System.out.print("What would you like to edit?: ");
                    editOption = keyboard.nextInt();
                    keyboard.nextLine(); // consume leftover newline

                    switch (editOption) {
                        case 1:
                            System.out.print("Enter new task name: ");
                            newTaskName = keyboard.nextLine();
                            task.setTaskName(newTaskName);
                            System.out.println("\n>>>Name successfully updated<<<\n");
                            break;
                        case 2:
                            System.out.print("Enter new task description: ");
                            newDescription = keyboard.nextLine();
                            task.setDescription(newDescription);
                            System.out.println("\n>>>Description successfully updated<<<\n");
                            break;
                        case 3:
                            System.out.print("Enter new task deadline: ");
                            newDeadline = keyboard.nextLine();
                            task.setDeadline(newDeadline);
                            System.out.println("\n>>>Deadline successfully updated<<<\n");
                            break;
                        case 4:
                            System.out.print("Enter new task priority: ");
                            newPriority = keyboard.nextLine().toUpperCase();
                            task.setPriorityLevel(newPriority);
                            System.out.println("\n>>>Priority successfully updated<<<\n");
                            break;
                        case 5:
                            System.out.println("\n>>>Exiting......\n");
                            isTaskEdited = false;
                            break;
                        default:
                            System.out.print("Incorrect option. Enter again: ");
                            editOption = keyboard.nextInt();
                    }
                }
            }

            if (!isTaskEdited) {
                System.out.println("\n>>>No matching task found<<<\n");
            }
        }
    }

    /**
     * Allows the user to change the status of a task (Done, Pending, Skip, Exit).
     */
    public void taskStatus() {
        String taskSelect;
        int statusSet;
        boolean isStatusSelected = false;

        System.out.println(">>>Current Tasks<<<\n");
        for (Tasks c : DetailsStorage.completedTasks) {
            System.out.println(c.toString());
        }

        System.out.print("Choose task by name: ");
        taskSelect = keyboard.nextLine();

        for (Tasks task : DetailsStorage.completedTasks) {
            if (task.getTaskName().equalsIgnoreCase(taskSelect)) {
                isStatusSelected = true;

                // Show status menu
                System.out.println("\n========================================");
                System.out.println("\t\t\t\tStatus Menu");
                System.out.println("========================================\n");

                System.out.println("1. Done");
                System.out.println("2. Pending");
                System.out.println("3. Skip");
                System.out.println("4. Exit");

                System.out.print("Select task status: ");
                statusSet = keyboard.nextInt();

                if (statusSet == 1) {
                    System.out.println("\n>>>Congrats, you have completed the task<<<\n");
                    task.setTaskStatus("Done");
                    DetailsStorage.finishedTasks.add(task);
                } else if (statusSet == 2) {
                    System.out.println("\n>>>Task still in progress<<<\n");
                    task.setTaskStatus("Pending");
                } else if (statusSet == 3) {
                    System.out.println("\n>>>Task skipped<<<\n");
                } else if (statusSet == 4) {
                    System.out.println("\n>>>Exiting....<<<\n");
                    isStatusSelected = false;
                    break;
                }
            }
        }
        keyboard.nextLine(); // clear buffer
        if (!isStatusSelected) {
            System.out.println("\n>>>No matching task<<<\n");
        }
    }

    /**
     * Displays all current and completed tasks.
     */
    public void displayTaskDetails() {
        if (DetailsStorage.completedTasks.isEmpty()) {
            System.out.println("\n>>>No tasks added yet<<<\n");
        } else {
            System.out.println("\n>>>Tasks<<<\n");
            for (Tasks task : DetailsStorage.completedTasks) {
                System.out.println(task);
            }
        }

        if (DetailsStorage.finishedTasks.isEmpty()) {
            System.out.println("<<<<<NO COMPLETED TASKS>>>>>>>");
        } else {
            System.out.println("<<<<<<<<COMPLETED TASKS>>>>>>>>");
            for (Tasks task : DetailsStorage.finishedTasks) {
                System.out.println(task);
            }
        }
    }

    /**
     * Deletes a task by name if confirmed by the user.
     */
    public void deleteTasks() {
        boolean isTaskAvailable = false;

        if (DetailsStorage.completedTasks.isEmpty()) {
            System.out.println("\n>>>No tasks found<<<\n");
        } else {
            System.out.print("Enter the name of the task to be deleted: ");
            String taskName = keyboard.nextLine();

            for (Tasks task : DetailsStorage.completedTasks) {
                if (task.getTaskName().equalsIgnoreCase(taskName)) {
                    isTaskAvailable = true;
                    System.out.println(task.toString());
                    System.out.print("Confirm Delete (Y/N): ");
                    char delete = keyboard.nextLine().charAt(0);

                    if (delete == 'Y' || delete == 'y') {
                        DetailsStorage.completedTasks.remove(task);
                        this.taskCount -= 1;
                        System.out.println("\n>>>Task has been deleted<<<\n");
                    } else {
                        System.out.println("\n>>>Task not deleted<<<\n");
                    }
                    break;
                }
            }

            if (!isTaskAvailable) {
                System.out.println("\n>>>No task found with that name<<<\n");
            }
        }
    }
}
