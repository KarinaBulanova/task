package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        TodosManager todosManager = new TodosManager();

        todosManager.add(simpleTask);
        todosManager.add(epic);
        todosManager.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todosManager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenFewTasksFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        TodosManager todosManager = new TodosManager();

        todosManager.add(simpleTask);
        todosManager.add(epic);
        todosManager.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todosManager.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenZeroTasksFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        TodosManager todosManager = new TodosManager();

        todosManager.add(simpleTask);
        todosManager.add(epic);
        todosManager.add(meeting);

        Task[] expected = {};
        Task[] actual = todosManager.search("колбаса");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenOneTasksFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        TodosManager todosManager = new TodosManager();

        todosManager.add(simpleTask);
        todosManager.add(epic);
        todosManager.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todosManager.search("Приложение");
        Assertions.assertArrayEquals(expected, actual);
    }
}
