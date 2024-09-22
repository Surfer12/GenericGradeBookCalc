package dataModels;




public class IntegerGradeBookTest {

   private IntegerGradeBook gradeBook;
   private StudentRegistry<Student<Integer>, Integer> studentRegistry;
   private InputHandler<String> nameInputHandler;
   private InputHandler<Integer> countInputHandler;
   private InputHandler<Integer> assignmentCountInputHandler;
   private GradeEntrySystem<Student<Integer>, Integer> gradeEntrySystem;
   private GradeCalculator<Student<Integer>, Integer> gradeCalculator;
   private GradebookDisplay<Student<Integer>> gradebookDisplay;
   private ClassAverageCalculator<Student<Integer>> classAverageCalculator;
   private Supplier<Student<Integer>> studentFactory;
   private Set<String> uniqueNames;

   @BeforeEach
   public void setUp() {
      studentRegistry = mock(StudentRegistry.class);