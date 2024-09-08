package dataModels;

import Displays.GradebookDisplay;
import dataManipulators.ClassAverageCalculator;
import dataManipulators.GradeCalculator;
import handlers.GradeEntrySystem;
import handlers.InputHandler;

import java.util.function.Supplier;

public class IntegerGradeBook extends AbstractGradeBook<Student<Integer>, Integer> {
    public IntegerGradeBook(StudentRegistry<Student<Integer>, Integer> studentRegistry,
                            InputHandler<String> nameInputHandler,
                            InputHandler<Integer> countInputHandler,
                            InputHandler<Integer> assignmentCountInputHandler,
                            GradeEntrySystem<Student<Integer>, Integer> gradeEntrySystem,
                            GradeCalculator< Student<Integer> > gradeCalculator,
                            GradebookDisplay< Student<Integer> > gradebookDisplay,
                            ClassAverageCalculator< Student<Integer> > classAverageCalculator,
                            Supplier< Student<Integer> > studentFactory) {
        super(studentRegistry, nameInputHandler, countInputHandler,
                assignmentCountInputHandler, gradeEntrySystem,
                gradeCalculator, gradebookDisplay, classAverageCalculator, studentFactory);
    }
}