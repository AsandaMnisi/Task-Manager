public class Tasks {

    private String taskName;
    private String description;
    private String deadline;
    private String taskDetails;
    private String priorityLevel ;
    private int taskCount;
    private String taskStatus = "Not yet set";

    public Tasks(String taskName,String description,String deadline,String priorityLevel){
        this.taskName = taskName;
        this.description = description;
        this.deadline = deadline;
        this.priorityLevel = priorityLevel;
    }
    public String getDescription(){
        return this.description;
    }
    public int getTaskCount(){
        return this.taskCount;
    }
   public  String getTaskStatus(){
        return this.taskStatus;
   }
    public void setTaskName(String taskName){
        this.taskName = taskName;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setDeadline(String deadline){
        this.deadline = deadline;
    }
    public void setPriorityLevel(String priorityLevel){
        this.priorityLevel = priorityLevel;
    }
    public void  setTaskCount(int taskCount){
        this.taskCount = taskCount;
    }
    public void setTaskStatus(String taskStatus){
        this.taskStatus = taskStatus;
    }

    public String getTaskName(){
        return this.taskName;
    }
    @Override
    public String toString(){
        return "Task:"+this.taskCount+"\n"+
                "Task Name:"+taskName+"\nTask Description:" + description+"\nTask Deadline:"
                + deadline+"\nTask Priority:" + priorityLevel+"\nTask Status:"+taskStatus+"\n";

    }
}
