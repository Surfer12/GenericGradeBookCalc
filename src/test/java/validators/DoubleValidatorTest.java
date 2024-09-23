package validators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class DoubleValidatorTest {

   private final DoubleValidator validator = new DoubleValidator();

   @Test
   public void testParseValidDouble() {
      assertEquals(123.45, validator.parse("123.45"));
   }

   @Test
   public void testParseInvalidDouble() {
      Exception exception = assertThrows(IllegalArgumentException.class, () -> {
         validator.parse("invalid");
      });
      assertEquals("Invalid double value: invalid", exception.getMessage());
   }

   @Test
   public void testIsValidWithNonNullValue() {
      assertTrue(validator.isValid(123.45));
   }

   @Test
   public void testIsValidWithNullValue() {
      assertFalse(validator.isValid(null));
   }
}