public class NameValidator implements InputValidator.Validator<String> {

    @Override
    public String parse(String input) {
        return input.trim(); // Simple parsing, just trims the input
    }

    @Override
    public boolean isValid(String value) {
        // Example validation: Ensure the name is not empty and contains only letters and spaces
        return value != null && value.matches("[a-zA-Z\\s]+");
    }
}
