public class PositiveIntegerValidator implements InputValidator.Validator<Integer> {
   @Override
   public Integer parse(String input) throws NumberFormatException {
      return Integer.parseInt(input);
   }
}