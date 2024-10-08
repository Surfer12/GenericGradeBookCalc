package validators;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * validators.NameValidator class that implements the
 * validators.InputValidator.Validator interface for String type.
 * This class provides methods to parse and validate name inputs.
 */
public class NameValidator implements InputValidator.Validator<String> {

    /**
     * Parses the input string by trimming any leading or trailing whitespace.
     *
     * @param input The input string to be parsed
     * @return The trimmed input string
     */
    @Override
    public String parse(String input) {
        return input.trim(); // Simple parsing, just trims the input
    }

    /**
     * Validates the parsed string to ensure it is not empty and contains only
     * letters and spaces.
     *
     * @param value The parsed string to be validated
     * @return true if the string is valid, false otherwise
     */
    @Override
    public boolean isValid(String value) {
        // Example validation: Ensure the name is not empty and contains only letters
        // and spaces
        return value != null && value.matches("[a-zA-Z\\s]+");
    }

    List<String> getUniqueNames(List<String> names) {
        return names.stream().distinct().collect(Collectors.toList());
    }

    public Set<String> getUniqueNamesForHashSet(List<String> names) {
        return new HashSet<>(names);
    }

}