package main;

import dataModels.Student;
import dataModels.StudentRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRegistryImpl<S extends Student<G>, G extends Number> extends StudentRegistry<S, G> {
    private final List<S> students = new ArrayList<>();

    public StudentRegistryImpl() {
        super();
    }

    @Override
    public List<S> getStudents() {
      return new ArrayList<>(students);
   }

   @Override
   public void addStudent(S student) {
      students.add(student);
   }

   @Override
   public Optional<S> removeStudent(String name) {
      Optional<S> studentToRemove = getStudent(name);
      studentToRemove.ifPresent(students::remove);
      return studentToRemove;
   }

   @Override
   public Optional<S> getStudent(String name) {
      return students.stream()
            .filter(s -> s.getName().equals(name))
            .findFirst();
   }

   @Override
   public int countStudents() {
      return students.size();
   }

   @Override
   public Optional<S> updateGrade(String name, int assignmentNumber, G grade) {
      return getStudent(name).map(student -> {
         student.addGrade(grade);
         System.out.println("Grade updated for student: " + name);
         return student;
      });
   }
}