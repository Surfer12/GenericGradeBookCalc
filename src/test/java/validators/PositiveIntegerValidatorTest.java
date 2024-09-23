package validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PositiveIntegerValidatorTest {

    private final PositiveIntegerValidator validator = new PositiveIntegerValidator();

    @Test
    public void testParseValidInteger() {
        assertEquals(5, validator.parse("5"));
    }

    @Test
    public void testParseUnknown() {
        assertEquals(10, validator.parse("unknown"));
    }

    @Test
    public void testParseInvalidInteger() {
        assertThrows(NumberFormatException.class, () -> validator.parse("invalid"));
    }

    @Test
    public void testIsValidPositiveInteger() {
        assertTrue(validator.isValid(5));
    }

    @Test
    public void testIsValidZero() {
        assertFalse(validator.isValid(0));
    }

    @Test
    public void testIsValidNegativeInteger() {
        assertFalse(validator.isValid(-5));
    }

    @Test
    public void testIsValidNull() {
        assertFalse(validator.isValid(null));
    }
}