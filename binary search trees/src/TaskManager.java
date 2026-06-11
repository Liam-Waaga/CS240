// TaskManager.java
// This class will manage a collection of tasks using a BST<Task>.
// It should provide methods to add, delete, search, and print tasks by priority.
public class TaskManager {
    // TO IMPLEMENT: Add methods to manage tasks using BST<Task>
    private BST<Task> tasks;

    public TaskManager() {
        tasks = new BST<Task>();
    }

    public void addTask(Task t) {

        BST.TreeNode<Task> curr = tasks.root;
        BST.TreeNode<Task> prev = tasks.root;

        if (curr == null) {
            tasks.root = new BST.TreeNode<Task>(t);
            return;
        }

        while (true) {
            if (curr == null) {
                if (t.compareTo(prev.element) > 0) {
                    prev.right = new BST.TreeNode<Task>(t);
                } else {
                    prev.left = new BST.TreeNode<Task>(t);
                }
                break;
            }
            prev = curr;
            if (curr.element.compareTo(t) > 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    public void printTasks() {
        tasks.inorder();
    }

    public Task search(int priority) {
        BST.TreeNode<Task> curr = tasks.root;
        while (true) {
            if (curr == null) {
                return null;
            }

            if (curr.element.getPriority() > priority) {
                curr = curr.left;
            } else if (curr.element.getPriority() < priority) {
                curr = curr.right;
            } else {
                return curr.element;
            }
        }
    }

    public void deleteTask(int priority) {
        tasks.delete(new Task(priority, null));
    }

    public void deleteHighestPriority() {
        BST.TreeNode<Task> curr = tasks.root;
        if (curr == null) return;
        while (curr.right != null) {
            curr = curr.right;
        }
        tasks.delete(curr.element);
    }
    
    public void printHighestPriority() {
        BST.TreeNode<Task> curr = tasks.root;
        if (curr == null) return;
        while (curr.right != null) {
            curr = curr.right;
        }
        System.out.println(curr.element);
    }

    public static void main(String[] args) {
        // TO IMPLEMENT: Create a TaskManager object
        // Use the TaskManager to insert tasks, search, delete, and print in priority order
        // This serves as your main test harness

        TaskManager manager = new TaskManager();
        manager.addTask(new Task(3, "take out trash"));
        manager.addTask(new Task(2, "clean yard"));
        manager.addTask(new Task(10, "repair car"));
        manager.addTask(new Task(12, "pay bills"));
        manager.addTask(new Task(2, "mow yard"));

        manager.printTasks();
    }
}
