public class NameValidator implements InputValidator.Validator<String> {
    @Override
    public String parse(String input) {
        return input.trim();
    }

    @Override
    public boolean isValid(String value) {
        return !value.isEmpty() && !value.matches(".*[!@#$%^&*(),.?\":{}|<>0-9].*");
    }
}

public class ScoreValidator implements InputValidator.Validator<Integer> {
    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 100;

    @Override
    public Integer parse(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }

    @Override
    public boolean isValid(Integer value) {
        return value >= MIN_SCORE && value <= MAX_SCORE;
    }
}

public class PositiveIntegerValidator implements InputValidator.Validator<Integer> {
    @Override
    public Integer parse(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }

    @Override
    public boolean isValid(Integer value) {
        return value > 0;
    }
}
