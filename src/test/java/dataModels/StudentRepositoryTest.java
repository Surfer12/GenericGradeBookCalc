package dataModels;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



            class StudentRepositoryTest {

               private StudentRepository<Student<Integer>, Integer> studentRepository;
               private Student<Integer> student;

               @BeforeEach
               void setUp() {
                  studentRepository = Mockito.mock(StudentRepository.class);
                  student = Mockito.mock(Student.class);
               }

               @Test
               void testFindById() {
                  Long id = 1L;
                  when(studentRepository.findById(id)).thenReturn(student);

                  Student<Integer> result = studentRepository.findById(id);

                  assertEquals(student, result);
                  verify(studentRepository, times(1)).findById(id);
               }

               @Test
               void testFindAll() {
                  List<Student<Integer>> students = Arrays.asList(student);
                  when(studentRepository.findAll()).thenReturn(students);

                  List<Student<Integer>> result = studentRepository.findAll();

                  assertEquals(students, result);
                  verify(studentRepository, times(1)).findAll();
               }

               @Test
               void testSave() {
                  when(studentRepository.save(student)).thenReturn(student);

                  Student<Integer> result = studentRepository.save(student);

                  assertEquals(student, result);
                  verify(studentRepository, times(1)).save(student);
               }

               @Test
               void testDeleteById() {
                  Long id = 1L;
                  doNothing().when(studentRepository).deleteById(id);

                  studentRepository.deleteById(id);

                  verify(studentRepository, times(1)).deleteById(id);
               }
            }


