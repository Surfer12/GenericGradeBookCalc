package handlers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class InputHandlerTest {

    @Mock
    private InputHandler<Number> inputHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetInput() {
        // Arrange
        when(inputHandler.getInput("Enter a number: ")).thenReturn(42);

        // Act
        Number result = inputHandler.getInput("Enter a number: ");

        // Assert
        assertEquals(42, result);
        verify(inputHandler).getInput("Enter a number: ");
    }

    @Test
    void testGetMultipleInputs() {
        // Arrange
        List<Number> expectedInputs = Arrays.asList(1, 2, 3);
        when(inputHandler.getMultipleInputs("Enter numbers (type 'stop' to finish): ", "stop"))
                .thenReturn(expectedInputs);

        // Act
        List<Number> result = inputHandler.getMultipleInputs("Enter numbers (type 'stop' to finish): ", "stop");

        // Assert
        assertEquals(expectedInputs, result);
        verify(inputHandler).getMultipleInputs("Enter numbers (type 'stop' to finish): ", "stop");
    }
}