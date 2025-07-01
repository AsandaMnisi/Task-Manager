
# 📋 Task Management Console App 💻✅

Welcome to the **Task Management App** – a simple Java project that allows users to create, view, and manage tasks directly from the command line! 🧠💪

---

## 📁 Project Structure

| File Name             | Description 📃 |
|-----------------------|----------------|
| `Main.java`           | 🎬 Entry point that displays the menu and receives user input. |
| `Actions.java`        | ✍️ Provides logic for creating, editing, and updating tasks. |
| `Tasks.java`          | 📦 Represents an individual task with details like name, deadline, description, priority, and status. |
| `DetailsStorage.java` | 🗂️ Stores and manages the list of tasks using an `ArrayList<Tasks>`. |

---

## ⚙️ Features

✨ This application supports:

- ➕ **Adding Tasks**  
- ✏️ **Editing Task Details**  
- 🔍 **Viewing All Tasks**  
- ✅ **Marking Tasks as Complete**  
- 🧮 **Tracking Number of Tasks**  

---

## ▶️ How to Run the App

1. 📦 Ensure **Java is installed** (`java -version`)
2. 🛠️ Compile the project:
   ```bash
   javac Main.java Actions.java Tasks.java DetailsStorage.java
   ```
3. 🚀 Run the program:
   ```bash
   java Main
   ```

---

## 📦 Tasks.java Overview

The `Tasks` class is a blueprint for creating and managing task objects.

### 🧱 Fields:
- `taskName`: Name of the task 📝  
- `description`: Description of the task 📄  
- `deadline`: Due date of the task ⏳  
- `cPriorityLevel`: Task priority (e.g., H, M, L) ⚠️  
- `taskStatus`: Current status (default: `"Not yet set"`) ⏱️  
- `taskCount`: An identifier or tracker for task number 🔢  

### 🛠️ Methods:
- Getters and setters for all fields.
- A `toString()` method to neatly print task details.

---

## 🎯 Sample Output

```
Task: 1
Task Name: Buy groceries
Task Description: Buy milk, eggs, and bread
Task Deadline: 2025-07-05
Task Priority: H
Task Status: Not yet set
```

---

## 🏗️ Future Improvements

- Add GUI using JavaFX or Swing 🎨
- File/database persistence 🗃️
- Task reminders ⏰
- Sorting and filtering by priority or date 📅

---

## 👨‍💻 Created By

- 💻 Java
- ☕ Love for learning
- ❤️ By Asanda Mnisi

---
# Task-Manager
