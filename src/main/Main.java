package main;

import io.micronaut.context.ApplicationContext;
import dataModels.StudentRegistry;
import dataModels.IntegerGradeBook;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = ApplicationContext.run();
        IntegerGradeBook integerGradeBook = context.getBean(IntegerGradeBook.class);

        // Run the GradeBook
        integerGradeBook.run();
    }
}