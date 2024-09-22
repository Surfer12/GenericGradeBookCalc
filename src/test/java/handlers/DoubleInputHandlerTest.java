package handlers;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

import validators.InputValidator;


public class DoubleInputHandlerTest {

   private DoubleInputHandler doubleInputHandler;
   private Scanner mockScanner;
   private InputValidator<Double> mockInputValidator;

   @BeforeEach
   public void setUp() {
      mockScanner = mock(Scanner.class);
      mockInputValidator = mock(InputValidator.class);
      doubleInputHandler = new DoubleInputHandler(mockScanner, mockInputValidator);
   }

   @Test
   public void testConstructor() {
      assertNotNull(doubleInputHandler);
   }

   // Additional tests can be added here to test the functionality of
   // DoubleInputHandler
}