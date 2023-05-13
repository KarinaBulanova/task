package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testMatchesForSimpleTaskWhenTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("родителям");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMatchesForSimpleTaskWhenFasle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("бабушке");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMatchesForEpicWhenTrue() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);


        boolean actual = epic.matches("Яйца");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMatchesForEpicWhenFasle() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);


        boolean actual = epic.matches("бабушке");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMatchesForMeetingTopicWhenTrue() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        boolean actual = meeting.matches("Выкатка 3й версии приложения");

        Assertions.assertTrue(actual);


    }

    @Test
    public void testMatchesForMeetingTopicWhenFalse() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        boolean actual = meeting.matches("Во вторник после обеда");

        Assertions.assertFalse(actual);


    }

    @Test
    public void testMatchesForMeetingProjectWhenTrue() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        boolean actual = meeting.matches("Приложение НетоБанка");

        Assertions.assertTrue(actual);


    }

    @Test
    public void testMatchesForMeetingProjectWhenFalse() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        boolean actual = meeting.matches("Во вторник после обеда");

        Assertions.assertFalse(actual);


    }
}