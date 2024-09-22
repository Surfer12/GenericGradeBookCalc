package dataModels;

public class DoubleGradeBookTest {

   private DoubleGradeBook doubleGradeBook;
   private StudentRegistry<Student<Double>, Double> studentRegistry;
   private InputHandler<String> nameInputHandler;
   private InputHandler<Integer> countInputHandler;
   private InputHandler<Integer> assignmentCountInputHandler;
   private GradeEntrySystem<Student<Double>, Double> gradeEntrySystem;
   private GradeCalculator<Student<Double>, Double> gradeCalculator;
   private GradebookDisplay<Student<Double>> gradebookDisplay;
   private ClassAverageCalculator<Student<Double>> classAverageCalculator;
   private Supplier<Student<Double>> studentFactory;
   private Set<String> uniqueNames;

   @BeforeEach
   public void setUp() {
      studentRegistry = mock(StudentRegistry.class);
      nameInputHandler = mock(InputHandler.class);
      countInputHandler = mock(InputHandler.class);
      assignmentCountInputHandler = mock(InputHandler.class);
      gradeEntrySystem = mock(GradeEntrySystem.class);
      gradeCalculator = mock(GradeCalculator.class);
      gradebookDisplay = mock(GradebookDisplay.class);
      classAverageCalculator = mock(ClassAverageCalculator.class);
      studentFactory = mock(Supplier.class);
      uniqueNames = new HashSet<>();

      doubleGradeBook = new DoubleGradeBook(studentRegistry, nameInputHandler, countInputHandler,
            assignmentCountInputHandler, gradeEntrySystem, gradeCalculator, gradebookDisplay,
            classAverageCalculator, studentFactory, uniqueNames);
   }

   @Test
   public void