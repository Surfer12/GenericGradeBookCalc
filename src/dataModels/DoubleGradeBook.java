package dataModels;

import Displays.GradebookDisplay;
import dataManipulators.ClassAverageCalculator;
import dataManipulators.GradeCalculator;
import handlers.GradeEntrySystem;
import handlers.InputHandler;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class DoubleGradeBook extends AbstractGradeBook<Student<Double>, Double> {
    public DoubleGradeBook(StudentRegistry<Student<Double>> studentRegistry,
                           InputHandler<String> nameInputHandler,
                           InputHandler<Integer> countInputHandler,
                           InputHandler<Integer> assignmentCountInputHandler,
                           GradeEntrySystem<Student<Double>, Double> gradeEntrySystem,
                           GradeCalculator< Student<Double> > gradeCalculator,
                           GradebookDisplay< Student<Double> > gradebookDisplay,
                           ClassAverageCalculator< Student<Double> > classAverageCalculator,
                           Supplier< Student<Double> > studentFactory) {
        super(studentRegistry, nameInputHandler, countInputHandler,
                assignmentCountInputHandler, gradeEntrySystem,
                gradeCalculator, gradebookDisplay, classAverageCalculator, studentFactory);
    }
}