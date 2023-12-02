package controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.MainView;

public class AppTest {

  @Test
    public void testCreateMainView() {
        App app = new App();
        MainView consoleUi = app.createMainView();
        assertTrue(consoleUi instanceof MainView);
    }
    
    @Test
    public void testRun() {
        // Mock the View interface
        MainView mockConsoleUi = Mockito.mock(MainView.class);

        // Create an instance of App with the mocked View
        App app = new App() {
          @Override
          protected MainView createMainView() {
            return mockConsoleUi;
          }
        };

        // Run the application
        // app.run();

        // Verify that displayGreeting was called once
        // verify(mockConsoleUi, times(1)).displayGreeting();
    }
}
