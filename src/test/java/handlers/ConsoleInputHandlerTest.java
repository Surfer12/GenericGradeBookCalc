package handlers;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import validators.InputValidator;


public class ConsoleInputHandlerTest {

   private Scanner scanner;
   private InputValidator<String> inputValidator;
   private ConsoleInputHandler<String> consoleInputHandler;

   @BeforeEach
   public void setUp() {
      scanner = mock(Scanner.class);
      inputValidator = mock(InputValidator.class);
      consoleInputHandler = new ConsoleInputHandler<>(scanner, inputValidator);
   }

   @Test
   public void testGetInput_ValidInput() {
      when(scanner.nextLine()).thenReturn("validInput");
      when(inputValidator.parse("validInput")).thenReturn("parsedInput");
      when(inputValidator.isValid("parsedInput")).thenReturn(true);

      String result = consoleInputHandler.getInput("Enter input: ");

      assertEquals("parsedInput", result);
      verify(scanner).nextLine();
      verify(inputValidator).parse("validInput");
      verify(inputValidator).isValid("parsedInput");
   }

   @Test
   public void testGetInput_InvalidInput() {
      when(scanner.nextLine()).thenReturn("invalidInput", "validInput");
      when(inputValidator.parse("invalidInput")).thenReturn("parsedInvalidInput");
      when(inputValidator.isValid("parsedInvalidInput")).thenReturn(false);
      when(inputValidator.parse("validInput")).thenReturn("parsedValidInput");
      when(inputValidator.isValid("parsedValidInput")).thenReturn(true);

      String result = consoleInputHandler.getInput("Enter input: ");

      assertEquals("parsedValidInput", result);
      verify(scanner, times(2)).nextLine();
      verify(inputValidator).parse("invalidInput");
      verify(inputValidator).isValid("parsedInvalidInput");
      verify(inputValidator).parse("validInput");
      verify(inputValidator).isValid("parsedValidInput");
   }

   @Test
   public void testGetMultipleInputs() {
      when(scanner.nextLine()).thenReturn("input1", "input2", "stop");
      when(inputValidator.parse("input1")).thenReturn("parsedInput1");
      when(inputValidator.isValid("parsedInput1")).thenReturn(true);
      when(inputValidator.parse("input2")).thenReturn("parsedInput2");
      when(inputValidator.isValid("parsedInput2")).thenReturn(true);

      List<String> result = consoleInputHandler.getMultipleInputs("Enter input: ", "stop");

      assertEquals(2, result.size());
      assertTrue(result.contains("parsedInput1"));
      assertTrue(result.contains("parsedInput2"));
      verify(scanner, times(3)).nextLine();
      verify(inputValidator).parse("input1");
      verify(inputValidator).isValid("parsedInput1");
      verify(inputValidator).parse("input2");
      verify(inputValidator).isValid("parsedInput2");
   }

   @Test
   public void testGetMultipleInputs_InvalidInput() {
      when(scanner.nextLine()).thenReturn("invalidInput", "input1", "stop");
      when(inputValidator.parse("invalidInput")).thenReturn("parsedInvalidInput");
      when(inputValidator.isValid("parsedInvalidInput")).thenReturn(false);
      when(inputValidator.parse("input1")).thenReturn("parsedInput1");
      when(inputValidator.isValid("parsedInput1")).thenReturn(true);

      List<String> result = consoleInputHandler.getMultipleInputs("Enter input: ", "stop");

      assertEquals(1, result.size());
      assertTrue(result.contains("parsedInput1"));
      verify(scanner, times(3)).nextLine();
      verify(inputValidator).parse("invalidInput");
      verify(inputValidator).isValid("parsedInvalidInput");
      verify(inputValidator).parse("input1");
      verify(inputValidator).isValid("parsedInput1");
   }
}