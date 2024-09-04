public class NameValidator implements InputValidator.Validator<String> {
    @Override
    public String parse(String input) {
        return input.trim();
    }

    @Override
    public boolean isValid(String value) {
        return !value.isEmpty() && !value.matches(".*[!@#$%^&*(),.?\":{}|<>0-9].*");
    }

    @Override
    public boolean isValid(Integer value) {
        return value > 0;
    }
}

