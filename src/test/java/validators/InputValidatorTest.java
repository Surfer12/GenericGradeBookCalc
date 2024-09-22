package validators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;



public class InputValidatorTest {

   @Test
   public void testIsValid() {
      InputValidator.Validator<String> stringValidator = new InputValidator.Validator<>() {
         @Override
         public String parse(String input) {
            return input;
         }

         @Override
         public boolean isValid(String value) {
            return value != null && !value.isEmpty();
         }
      };

      InputValidator<String> inputValidator = new InputValidator<>(stringValidator, "String");

      assertTrue(inputValidator.isValid("test"));
      assertFalse(inputValidator.isValid(""));
      assertFalse(inputValidator.isValid(null));
   }

   @Test
   public void testParse() {
      InputValidator.Validator<Integer> integerValidator = new InputValidator.Validator<>() {
         @Override
         public Integer parse(String input) {
            return Integer.parseInt(input);
         }

         @Override
         public boolean isValid(Integer value) {
            return value != null && value >= 0;
         }
      };

      InputValidator<Integer> inputValidator = new InputValidator<>(integerValidator, "Integer");

      assertEquals(123, inputValidator.parse("123"));
      assertThrows(NumberFormatException.class, () -> inputValidator.parse("abc"));
   }

   @Test
   public void testGetTypeName() {
      InputValidator.Validator<Double> doubleValidator = new InputValidator.Validator<>() {
         @Override
         public Double parse(String input) {
            return Double.parseDouble(input);
         }

         @Override
         public boolean isValid(Double value) {
            return value != null && value >= 0.0;
         }
      };

      InputValidator<Double> inputValidator = new InputValidator<>(doubleValidator, "Double");

      assertEquals("Double", inputValidator.getTypeName());
   }
}