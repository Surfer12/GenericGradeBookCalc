public class InputValidator<T> {
    private final Validator<T> validator;
    private final String typeName;

    public InputValidator(Validator<T> validator, String typeName) {
        this.validator = validator;
        this.typeName = typeName;
    }

    public boolean isValid(String input) {
        try {
            T value = validator.parse(input);
            return validator.isValid(value);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid " + typeName + ".");
            return false;
        }
    }

    public T parse(String input) throws Exception {
        return validator.parse(input);
    }

    public interface Validator<T> {
        T parse(String input) throws Exception;
        boolean isValid(T value);
    }
}
