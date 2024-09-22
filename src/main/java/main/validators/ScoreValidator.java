package src.main.java.main.validators;

/**
 * The validators.ScoreValidator class implements the validators.InputValidator.Validator interface for Integer values.
 * It validates if a given score is within a specified range.
 */
public class ScoreValidator implements InputValidator.Validator<Integer> {
    // Minimum valid score
    private static final int MIN_SCORE = 0;

    // Maximum valid score
    private static final int MAX_SCORE = 100;

    /**
     * Parses the input string to an Integer.
     *
     * @param input the input string to be parsed
     * @return the parsed Integer value
     * @throws NumberFormatException if the input string is not a valid integer
     */
    @Override
    public Integer parse(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }

    /**
     * Checks if the given Integer value is within the valid score range.
     *
     * @param value the Integer value to be validated
     * @return true if the value is within the range [MIN_SCORE, MAX_SCORE], false otherwise
     */
    @Override
    public boolean isValid(Integer value) {
        return value >= MIN_SCORE && value <= MAX_SCORE;
    }
}