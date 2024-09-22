package Displays;

import dataModels.Student;

import java.util.List;

/**
 * An interface for displaying a list of students in a gradebook.
 *
 * @param <S> the type of student to display, which extends the
 *            dataModels.Student class
 */
public interface GradebookDisplay<S extends Student<?>> {

    /**
     * Displays a list of students.
     *
     * @param students the list of students to display
     */
    void display(List<S> students);
}
