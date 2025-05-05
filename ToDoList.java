import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    static class Task {
        String description;
        boolean completed;

        Task(String description) {
            this.description = description;
            this.completed = false;
        }

        @Override
        public String toString() {
            return (completed ? "[X] " : "[ ] ") + description;
        }
    }

    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        do {
            showMenu();
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> addTask();
                case 2 -> listTasks();
                case 3 -> markAsCompleted();
                case 4 -> deleteTask();
                case 5 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }

        } while (option != 5);
    }

    private static void showMenu() {
        System.out.println("\n--- LISTA DE TAREAS ---");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Ver tareas");
        System.out.println("3. Marcar tarea como completada");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
    }

    private static void addTask() {
        System.out.print("Escribe la descripción de la tarea: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Tarea agregada.");
    }

    private static void listTasks() {
        System.out.println("\n--- TUS TAREAS ---");
        if (tasks.isEmpty()) {
            System.out.println("No hay tareas aún.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void markAsCompleted() {
        listTasks();
        System.out.print("Ingresa el número de la tarea completada: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).completed = true;
            System.out.println("Tarea marcada como completada.");
        } else {
            System.out.println("Número inválido.");
        }
    }

    private static void deleteTask() {
        listTasks();
        System.out.print("Ingresa el número de la tarea a eliminar: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Tarea eliminada.");
        } else {
            System.out.println("Número inválido.");
        }
    }
}