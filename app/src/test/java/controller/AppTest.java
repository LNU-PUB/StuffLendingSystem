package controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.ConsoleUi;

public class AppTest {

  @Test
    public void testCreateConsoleUi() {
        App app = new App();
        ConsoleUi consoleUi = app.createConsoleUi();
        assertTrue(consoleUi instanceof ConsoleUi);
    }
    
    @Test
    public void testRun() {
        // Mock the View interface
        ConsoleUi mockConsoleUi = Mockito.mock(ConsoleUi.class);

        // Create an instance of App with the mocked View
        App app = new App() {
          @Override
          protected ConsoleUi createConsoleUi() {
            return mockConsoleUi;
          }
        };

        // Run the application
        app.run();

        // Verify that displayGreeting was called once
        verify(mockConsoleUi, times(1)).displayGreeting();
    }
}
