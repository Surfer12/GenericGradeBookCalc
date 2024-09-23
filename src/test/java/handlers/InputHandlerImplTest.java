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

public class InputHandlerImplTest {

   private Scanner scanner;
   private InputValidator<String> inputValidator;
   private InputHandlerImpl<String> inputHandler;

   @BeforeEach
   public void setUp() {
      scanner = mock(Scanner.class);
      inputValidator = mock(InputValidator.class);
      inputHandler = new InputHandlerImpl<>(scanner, inputValidator);
   }

   @Test
   public void testGetInput_ValidInput() {
      when(scanner.nextLine()).thenReturn("validInput");
      when(inputValidator.parse("validInput")).thenReturn("validInput");
      when(inputValidator.isValid("validInput")).thenReturn(true);

      String result = inputHandler.getInput("Enter input: ");

      assertEquals("validInput", result);
      verify(scanner).nextLine();
      verify(inputValidator).parse("validInput");
      verify(inputValidator).isValid("validInput");
   }

   @Test
   public void testGetInput_InvalidInputThenValidInput() {
      when(scanner.nextLine()).thenReturn("invalidInput", "validInput");
      when(inputValidator.parse("invalidInput")).thenThrow(new IllegalArgumentException("Invalid input"));
      when(inputValidator.parse("validInput")).thenReturn("validInput");
      when(inputValidator.isValid("validInput")).thenReturn(true);

      String result = inputHandler.getInput("Enter input: ");

      assertEquals("validInput", result);
      verify(scanner, times(2)).nextLine();
      verify(inputValidator).parse("invalidInput");
      verify(inputValidator).parse("validInput");
      verify(inputValidator).isValid("validInput");
   }

   @Test
   public void testGetMultipleInputs_ValidInputs() {
      when(scanner.nextLine()).thenReturn("input1", "input2", "stop");
      when(inputValidator.parse("input1")).thenReturn("input1");
      when(inputValidator.parse("input2")).thenReturn("input2");
      when(inputValidator.isValid("input1")).thenReturn(true);
      when(inputValidator.isValid("input2")).thenReturn(true);

      List<String> result = inputHandler.getMultipleInputs("Enter input: ", "stop");

      assertEquals(2, result.size());
      assertTrue(result.contains("input1"));
      assertTrue(result.contains("input2"));
      verify(scanner, times(3)).nextLine();
      verify(inputValidator).parse("input1");
      verify(inputValidator).parse("input2");
      verify(inputValidator).isValid("input1");
      verify(inputValidator).isValid("input2");
   }

   @Test
   public void testGetMultipleInputs_InvalidInputThenStop() {
      when(scanner.nextLine()).thenReturn("invalidInput", "stop");
      when(inputValidator.parse("invalidInput")).thenThrow(new IllegalArgumentException("Invalid input"));

      List<String> result = inputHandler.getMultipleInputs("Enter input: ", "stop");

      assertTrue(result.isEmpty());
      verify(scanner, times(2)).nextLine();
      verify(inputValidator).parse("invalidInput");
   }
}