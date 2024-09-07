package validators;

public class DoubleValidator implements InputValidator.Validator<Double> {

    @Override
    public Double parse(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid double value: " + input);
        }
    }

    @Override
    public boolean isValid(Double value) {
        return value != null;
    }
}