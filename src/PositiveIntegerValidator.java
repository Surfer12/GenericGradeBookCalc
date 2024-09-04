public class PositiveIntegerValidator implements InputValidator.Validator<Integer> {

    @Override
    public Integer parse(String input) throws NumberFormatException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid input. Please enter a valid integer.");
        }
    }

    @Override
    public boolean isValid(Integer value) {
        return value != null && value > 0;
    }
}
