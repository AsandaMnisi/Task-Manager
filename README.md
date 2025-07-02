# ✅ Java Task Manager 🗂️

A simple, interactive **task management system** built using Java!  
This CLI-based program allows you to create, view, edit, delete, and track the status of tasks — all from the terminal.

---

## ✨ Features

📌 **Add Tasks**  
- Enter task name, description, deadline (`YYYY/MM/DD`), and priority (High, Medium, Low).  
- Automatically stored and counted.

✏️ **Edit Tasks**  
- Update task name, description, deadline, or priority.  
- Easy-to-use menu interface.

🚦 **Change Task Status**  
- Mark tasks as `Done`, `Pending`, or `Skip`.  
- Completed tasks are saved in a separate list.

📋 **Display Tasks**  
- View all pending and completed tasks in a clean format.

🗑️ **Delete Tasks**  
- Delete a task by name with confirmation prompt.

✅ **Deadline Validation**  
- Deadlines must follow `YYYY/MM/DD` format for consistency.

---

## 🧑‍💻 Technologies Used

- Java ☕ (OOP principles)
- Scanner class for user input
- `ArrayList` for storing tasks
- Simple console interface (no GUI)

---

## 🚀 Getting Started

### 📁 File Structure

```
📂 src/
 ┣ 📄 Actions.java      // Main logic and user interaction
 ┣ 📄 Tasks.java        // Task object model
 ┣ 📄 DetailsStorage.java // Holds task lists (completed, finished)
 ┗ 📄 Main.java         // Entry point (calls Actions class)
```

---

### ▶️ Run the Program

1. **Compile:**
   ```bash
   javac Main.java
   ```

2. **Run:**
   ```bash
   java Main
   ```

3. **Follow the prompts** in the terminal to manage your tasks.

---

## 🛠 Sample Task Fields

| Field       | Example               |
|-------------|------------------------|
| Task Name   | `GROCERY SHOPPING`     |
| Description| `buy fresh vegetables` |
| Deadline    | `2025/07/10`           |
| Priority    | `HIGH` / `MEDIUM` / `LOW` |

---

## 📌 Notes

- Description must be at least **7 characters** long.
- Deadline format is strictly validated as `YYYY/MM/DD`.
- Priority is case-insensitive, but stored in uppercase.
- You can exit at any point by selecting the appropriate option.

---

## 🤝 Contributing

If you'd like to contribute enhancements or bug fixes, feel free to fork the repo and submit a pull request!

---

## 🧠 Future Improvements

- Add unique task IDs for easier reference
- Add file storage (save/load tasks)
- GUI version with JavaFX or Swing
- Sorting/filtering by deadline or priority

---

## 📝 Author

Created with 💻 by **Asanda Mnisi**

---
