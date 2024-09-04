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
