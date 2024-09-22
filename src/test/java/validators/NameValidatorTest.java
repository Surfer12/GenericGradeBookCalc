import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

package validators;

public class NameValidatorTest {

   private final NameValidator nameValidator = new NameValidator();

   @Test
   public void testParse() {
      assertEquals("John Doe", nameValidator.parse("  John Doe  "));
      assertEquals("Jane", nameValidator.parse("Jane"));
      assertEquals("", nameValidator.parse("   "));
   }

   @Test
   public void testIsValid() {
      assertTrue(nameValidator.isValid("John Doe"));
      assertTrue(nameValidator.isValid("Jane"));
      assertFalse(nameValidator.isValid("John123"));
      assertFalse(nameValidator.isValid("John_Doe"));
      assertFalse(nameValidator.isValid(""));
      assertFalse(nameValidator.isValid(null));
   }

   @Test
   public void testGetUniqueNames() {
      List<String> names = Arrays.asList("John", "Jane", "John", "Doe", "Jane");
      List<String> uniqueNames = nameValidator.getUniqueNames(names);
      assertEquals(3, uniqueNames.size());
      assertTrue(uniqueNames.contains("John"));
      assertTrue(uniqueNames.contains("Jane"));
      assertTrue(uniqueNames.contains("Doe"));
   }

   @Test
   public void testGetUniqueNamesForHashSet() {
      List<String> names = Arrays.asList("John", "Jane", "John", "Doe", "Jane");
      Set<String> uniqueNamesSet = nameValidator.getUniqueNamesForHashSet(names);
      assertEquals(3, uniqueNamesSet.size());
      assertTrue(uniqueNamesSet.contains("John"));
      assertTrue(uniqueNamesSet.contains("Jane"));
      assertTrue(uniqueNamesSet.contains("Doe"));
   }
}