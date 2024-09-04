public class InputValidator<T> {
    private final Validator<T> validator;
    private final String typeName;

    public InputValidator(Validator<T> validator, String typeName) {
        this.validator = validator;
        this.typeName = typeName;
    }

    public boolean isValid(T value) {
        return validator.isValid(value);
    }

    public T parse(String input) throws Exception {
        return validator.parse(input);
    }

    public String getTypeName() {
        return typeName;
    }

    public interface Validator<T> {
        T parse(String input);

        boolean isValid(T value);
    }
}
