package validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ScoreValidatorTest {

    private final ScoreValidator validator = new ScoreValidator();

    @Test
    public void testParseValidInteger() {
        assertEquals(50, validator.parse("50"));
    }

    @Test
    public void testParseInvalidInteger() {
        assertThrows(NumberFormatException.class, () -> {
            validator.parse("invalid");
        });
    }

    @Test
    public void testIsValidWithinRange() {
        assertTrue(validator.isValid(50));
    }

    @Test
    public void testIsValidAtMinBoundary() {
        assertTrue(validator.isValid(0));
    }

    @Test
    public void testIsValidAtMaxBoundary() {
        assertTrue(validator.isValid(100));
    }

    @Test
    public void testIsValidBelowMinBoundary() {
        assertFalse(validator.isValid(-1));
    }

    @Test
    public void testIsValidAboveMaxBoundary() {
        assertFalse(validator.isValid(101));
    }
}