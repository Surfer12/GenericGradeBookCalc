package handlers;

import dataModels.Student;

public interface GradeProcessor<S extends Student<G>, G extends Number> {
    G calculateGrade(G score);
}