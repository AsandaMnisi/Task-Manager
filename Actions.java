import java.util.Scanner;

public class Actions {
    Scanner keyboard = new Scanner(System.in);

    private String taskName;
    private int taskCount;
   public static boolean isValidDeadline(String priority){
       if(priority.length() != 10){
           return false;
       }if(priority.charAt(4) !='/' || priority.charAt(7) !='/' ){
           return false;
       }
       for (int i = 0; i < priority.length();i++){
           if(i == 4 || i == 7){
               continue;
           }
           if(!Character.isDigit(priority.charAt(i))){
               return false;
           }
       }
       return true;
   }
    public void addTask() {
        char taskOption;
        int taskCount;

        do {
            System.out.print("\nSet task name:");
            this.taskName = keyboard.nextLine().toUpperCase();

            System.out.print("Set task description:");
            String description = keyboard.nextLine().toLowerCase();

            if(description.length() < 7){
                System.out.print("low characters for description:");
                description = keyboard.nextLine().toLowerCase();
            }

            System.out.print("Set deadline:");
            String deadline = keyboard.nextLine();

            if(!isValidDeadline(deadline)){
                System.out.print("Deadline format is incorrect:");
                deadline = keyboard.nextLine();
            }

            System.out.print("Set task Priority:");
            String priority = keyboard.nextLine().toUpperCase();


            while(!priority.equalsIgnoreCase("High") && !priority.equalsIgnoreCase("Medium") && !priority.equalsIgnoreCase("Low")  ){
                System.out.print("Priority can only be (Hard,Medium or Low):");
                priority = keyboard.nextLine().toUpperCase();
            }


            Tasks newTask = new Tasks(taskName, description, deadline, priority);

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
        String newPriority;
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
                        newPriority = keyboard.nextLine().toUpperCase();
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
                    System.out.println("\n>>>Congrats,You have completed the task<<<\n");
                    task.setTaskStatus("Done");
                    DetailsStorage.finishedTasks.add(task);
                } else if (statusSet == 2) {
                    System.out.println("\n>>>Task still  in progress<<<\n");
                    task.setTaskStatus("Pending");
                } else if (statusSet == 3) {
                    System.out.println("\n>>>Task skipped<<<\n");
                } else if (statusSet == 4) {
                    System.out.println("\n>>>Exiting....<<<\n");
                    isStatusSelected = false;
                    break;
                }

            } else if(!task.getTaskName().equalsIgnoreCase(taskSelect)) {
                isStatusSelected = false;
            }else{
                System.out.println("\n>>>No Matching Task<<<\n");
            }
        }
        keyboard.nextLine();
    }
    public void displayTaskDetails(){
        for(Tasks task : DetailsStorage.completedTasks) {
            System.out.println("\n>>>Tasks<<<\n");
            if (DetailsStorage.completedTasks.contains(task)) {
                System.out.println(task);
            }
        }if(DetailsStorage.completedTasks.isEmpty()){
            System.out.println("\n>>>No tasks added yet<<<\n");
        }

    }
}
