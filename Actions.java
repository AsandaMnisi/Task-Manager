
import java.util.Scanner;
import java.util.ArrayList;
public class Actions {

    Scanner keyboard = new Scanner(System.in);



   private String taskName;
   private String description;
   private String deadline;
   private char cPriority;
   private int taskCount;


    public void addTask(){
        char taskOption;
        int taskCount = 0;

        do{

            System.out.print("\nSet task name:");
            this.taskName = keyboard.nextLine().toUpperCase();

            System.out.print("Set task description:");
            this.description = keyboard.nextLine().toLowerCase();

            System.out.print("Set deadline:");
            this.deadline = keyboard.nextLine();

            System.out.print("Set task Priority:");
            this.cPriority = keyboard.nextLine().charAt(0);

            Tasks newTask = new Tasks(taskName,description,deadline,cPriority);


                DetailsStorage.completedTasks.add(newTask);
                taskCount = DetailsStorage.completedTasks.size();
                this.taskCount = taskCount;
                newTask.setTaskCount(this.taskCount);


           for(int i = 0;i < DetailsStorage.completedTasks.size();i++){
               System.out.println(DetailsStorage.completedTasks.get(i));
           }
            System.out.print("Do you want to add Another task?:");
            taskOption = keyboard.nextLine().charAt(0);

            if (taskOption == 'n' || taskOption =='N') {
                System.out.println(">>>Going Back<<");
            }


        }while(taskOption == 'Y' || taskOption == 'y');

    }
    public void editTask(){
        Tasks newTask = new Tasks(taskName,description,deadline,cPriority);

        int editOption;
        String newTaskName ="";
        String newDescription = "";
        String newDeadline = "";
        String newTaskDetails;
        char newPriority = ' ';
        char nameConfirm;
        boolean isTaskEdited = true;

        System.out.println("Task Count is:"+this.taskCount);
        System.out.print("Provide task name:");
        taskName = keyboard.nextLine().toUpperCase();


        while(isTaskEdited){
                if (newTask.getTaskName().equals(taskName)) {
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

                    switch(editOption){
                        case 1: System.out.print("Enter new task name:");
                                newTaskName = keyboard.nextLine();
                                this.taskName = newTaskName;
                                newTask.setTaskName(this.taskName);
                                System.out.println("Name successfully updated");break;

                        case 2: System.out.print("Enter new task description:");
                                newDescription = keyboard.nextLine();
                                this.description = newDescription;
                                newTask.setDescription(this.description);
                                System.out.println("Description successfully updated");break;

                        case 3: System.out.print("Enter new task deadline:");
                                newDeadline = keyboard.nextLine();
                                this.deadline = newDeadline;
                                newTask.setDeadline(this.deadline);
                                System.out.print("Deadline successfully updated");break;

                        case 4: System.out.print("Enter new task priority:");
                                newPriority = keyboard.nextLine().charAt(0);
                                this.cPriority = newPriority;
                                newTask.setPriorityLevel(this.cPriority);
                                System.out.println("Priority successfully updated");break;

                        case 5: System.out.println(">>>Exiting....<<<:");

                            isTaskEdited = false;
                        default:
                            System.out.print("Incorrect option,Enter again:");
                            editOption = keyboard.nextInt();
                            keyboard.next();
                            break;
                    }
                }else{
                    System.out.println("No task found");
                    isTaskEdited  = false;
                }

        }

    }
    public void taskStatus(){
        Tasks newTask = new Tasks(taskName,description,deadline,cPriority);

        boolean isStatusSelected = true;

        while(isStatusSelected){

            System.out.println(">>>Current Tasks<<\n");

            for(int i = 0;i < DetailsStorage.completedTasks.size();i++){
                System.out.println(DetailsStorage.completedTasks.get(i));
            }

            System.out.println("\n Select Task:");
            

            isStatusSelected = false;

        }
    }

}
