package dataModels; // Ensure this is correct

import handlers.InputHandler; // Updated import
import handlers.GradeEntrySystem; // Updated import
import handlers.GradebookDisplay; // Updated import
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class IntegerGradeBookTest {

   private InputHandler<String> nameInputHandler; // Ensure this class exists
   private InputHandler<Integer> countInputHandler; // Ensure this class exists
   private InputHandler<Integer> assignmentCountInputHandler; // Ensure this class exists
   private GradeEntrySystem<Student<Integer>, Integer> gradeEntrySystem; // Ensure this class exists
   private GradebookDisplay<Student<Integer>> gradebookDisplay; // Ensure this class exists

   @BeforeEach
   public void setUp() {
      nameInputHandler = mock(InputHandler.class); // Ensure this class exists
      countInputHandler = mock(InputHandler.class); // Ensure this class exists
      assignmentCountInputHandler = mock(InputHandler.class); // Ensure this class exists
      gradeEntrySystem = mock(GradeEntrySystem.class); // Ensure this class exists
      gradebookDisplay = mock(GradebookDisplay.class); // Ensure this class exists
   }

}
