public interface GradeEntrySystem<S extends Student<G>, G> {
    G enterGradeForAssignment(S student, int assignmentNumber);
}