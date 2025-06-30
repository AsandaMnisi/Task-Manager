public class Tasks {

    private String taskName;
    private String description;
    private String deadline;
    private String taskDetails;
    private char cPriorityLevel;
    private int taskCount;

    public Tasks(String taskName,String description,String deadline,char cPriorityLevel){
        this.taskName = taskName;
        this.description = description;
        this.deadline = deadline;
        this.cPriorityLevel = cPriorityLevel;
    }
    public String getDescription(){
        return this.description;
    }
    public String getTaskDetails(){
        return taskName + " " + description + " " + deadline + " " + cPriorityLevel + " ";
    }
    public int getTaskCount(){
        return this.taskCount;
    }
    public void setTaskDetails(String details){
        this.taskDetails =  taskName + " " + description + " " + deadline + " " + cPriorityLevel + " ";
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
    public void setPriorityLevel(char cPriorityLevel){
        this.cPriorityLevel = cPriorityLevel;
    }
    public void  setTaskCount(int taskCount){
        this.taskCount = taskCount;
    }
    public String getTaskName(){
        return this.taskName;
    }
    @Override
    public String toString(){
        return "Task:"+this.taskCount+"\n"+
                "Task Name:"+taskName+"\nTask Description:" + description+"\nTask Deadline:" + deadline+"\nTask Priority:" + cPriorityLevel+"\n";

    }
}
