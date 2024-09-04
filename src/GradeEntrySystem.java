public interface GradeEntrySystem<S extends Student<?>, G> {
    void enterGradesForStudent(S student);
}
