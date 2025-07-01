
import java.sql.SQLOutput;
import java.util.Scanner;
public class Actions {

    Scanner keyboard = new Scanner(System.in);


    private String taskName;
    private int taskCount;


    public void addTask() {
        char taskOption;
        int taskCount;

        do {

            System.out.print("\nSet task name:");
            this.taskName = keyboard.nextLine().toUpperCase();

            System.out.print("Set task description:");
            String description = keyboard.nextLine().toLowerCase();

            System.out.print("Set deadline:");
            String deadline = keyboard.nextLine();

            System.out.print("Set task Priority:");
            char cPriority = keyboard.nextLine().charAt(0);

            Tasks newTask = new Tasks(taskName, description, deadline, cPriority);


            DetailsStorage.completedTasks.add(newTask);
            taskCount = DetailsStorage.completedTasks.size();
            this.taskCount = taskCount;
            newTask.setTaskCount(this.taskCount);

            System.out.println("\n>>>Task successfully Added<<<\n");

            System.out.print("Do you want to add Another task?:");
            taskOption = keyboard.nextLine().charAt(0);

            if (taskOption == 'n' || taskOption == 'N') {
                System.out.println("\n>>>Added Tasks<<<\n");
                for (Tasks task : DetailsStorage.completedTasks) {
                    System.out.println(task.toString());
                }
                System.out.println("\n>>>Going Back to menu<<<\n");
            }


        } while (taskOption == 'Y' || taskOption == 'y');

    }

    public void editTask() {

        Tasks tasks;
        int editOption;
        String newTaskName;
        String newDescription;
        String newDeadline;
        char newPriority;
        char nameConfirm;
        boolean isTaskEdited;

        System.out.println("Tasks Available:" +this.taskCount+"\n");
        System.out.print("Provide task name:");
        taskName = keyboard.nextLine().toUpperCase();

        for(Tasks task : DetailsStorage.completedTasks){
            if (task.getTaskName().equals(taskName)) {
                isTaskEdited = true;
                System.out.println("\n========================================");
                System.out.println("\t\t\t\tEdit Menu");
                System.out.println("========================================\n");

                System.out.println("1.Task Name");
                System.out.println("2.Task Description");
                System.out.println("3.Task DeadLine");
                System.out.println("4.Task Priority");
                System.out.println("5.Exit");

                System.out.print("What would you like to edit?:");
                editOption = keyboard.nextInt();
                keyboard.nextLine();

                switch (editOption) {
                    case 1:
                        System.out.print("Enter new task name:");
                        newTaskName = keyboard.nextLine();
                        task.setTaskName(newTaskName);
                        System.out.println("\n>>>Name successfully updated<<<\n");
                        break;

                    case 2:
                        System.out.print("Enter new task description:");
                        newDescription = keyboard.nextLine();
                        task.setDescription(newDescription);
                        System.out.println("\n>>>Description successfully updated<<<\n");
                        break;

                    case 3:
                        System.out.print("Enter new task deadline:");
                        newDeadline = keyboard.nextLine();
                        task.setDeadline(newDeadline);
                        System.out.print("\n>>>Deadline successfully updated<<<\n");
                        break;

                    case 4:
                        System.out.print("Enter new task priority:");
                        newPriority = keyboard.nextLine().charAt(0);
                        task.setPriorityLevel(newPriority);
                        System.out.println("\n>>>Priority successfully updated<<<\n");
                        break;

                    case 5:
                        System.out.println(">>>Exiting....<<<:");
                        isTaskEdited = false;
                        break;
                    default:
                        System.out.print("Incorrect option,Enter again:");
                        editOption = keyboard.nextInt();
                }
            } else if(!task.getTaskName().equals(taskName)){
                isTaskEdited = false;
            }else{
                System.out.println("\n>>>No task found<<<\n");
            }

        }

    }

    public void taskStatus() {
        String taskSelect;
        int statusSet;
        char delete;

        boolean isStatusSelected = false;

        System.out.println(">>>Current Tasks<<\n");
        for (Tasks c : DetailsStorage.completedTasks){
            System.out.println( c.toString());
        }

        System.out.print("Choose Task by Name:");
        taskSelect = keyboard.nextLine();

        for (Tasks task : DetailsStorage.completedTasks) {
            if (task.getTaskName().equalsIgnoreCase(taskSelect)) {
                  isStatusSelected = true;

                System.out.println("\n========================================");
                System.out.println("\t\t\t\tStatus Menu");
                System.out.println("========================================\n");

                System.out.println("1.Done");
                System.out.println("2.Pending ");
                System.out.println("3.Skip");
                System.out.println("4.Exit");

                System.out.print("Select task status: ");
                statusSet = keyboard.nextInt();

                if (statusSet == 1) {
                    System.out.println("You have completed the task");
                    task.setTaskStatus("Done");
                    DetailsStorage.finishedTasks.add(task);
                } else if (statusSet == 2) {
                    System.out.println("Task still  in progress");
                    task.setTaskStatus("Pending");
                } else if (statusSet == 3) {
                    System.out.println("Task skipped");
                } else if (statusSet == 4) {
                    System.out.println(">>>Exiting....<<<");
                    isStatusSelected = false;
                    break;
                }

            } else if(!task.getTaskName().equalsIgnoreCase(taskSelect)) {
                isStatusSelected = false;
            }else{
                System.out.println("No Matching Task");
            }
        }
        keyboard.nextLine();
    }
    public void displayTaskDetails(){
        for(Tasks task : DetailsStorage.completedTasks) {
            System.out.println(">>>Tasks<<<\n");
            if (DetailsStorage.completedTasks.contains(task)) {
                System.out.println(task);
            }
        }if(DetailsStorage.completedTasks.isEmpty()){
            System.out.println("No tasks added yet");
        }

    }
}
