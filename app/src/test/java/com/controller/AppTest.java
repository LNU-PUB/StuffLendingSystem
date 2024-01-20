package com.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.controller.model.Language;
import com.controller.model.MainActions;
import com.model.Member;
import com.model.StuffLendingSystem;
import com.view.MainView;
import com.view.model.View;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class AppTest {

  private App app;

  @Mock
  private StuffLendingSystem stuffLendingSystem;
  @Mock
  private MainView view;
  @Mock
  private StuffControl stuffControl;

  // @BeforeEach
  // void setUp() {
  // app = new App();
  // }

  @BeforeEach
  void seUp() {
    MockitoAnnotations.openMocks(this);
    app = spy(new App());

    // Mock the methods to return your mocked objects
    doReturn(stuffLendingSystem).when(app).createStuffSystem();
    doReturn(view).when(app).createMainView(any(Language.class), anyString());
    doReturn(stuffControl).when(app).createStuffControl(any(), any(), any());
  }

  @Test
  void testSetLanguageValid() {
    Language lang = app.setLanguage(new String[] { "SWE" });
    assertEquals(Language.SWE, lang);
  }

  @Test
  void testSetLanguageInvalid() {
    Language lang = app.setLanguage(new String[] { "invalid" });
    assertEquals(Language.ENG, lang);
  }

  @Test
  void testCreateMainView() {
    View view = app.createMainView(Language.ENG, "MainView");
    assertNotNull(view);
    assertTrue(view instanceof MainView);
  }

  @Test
  void testCreateStuffSystem() {
    StuffLendingSystem system = app.createStuffSystem();
    assertNotNull(system);
    assertTrue(system instanceof StuffLendingSystem);
  }

  @Test
  void testRunMethod() {
    // Mock view.getInput() to return QUIT to exit the loop in StuffControl.run()
    when(view.getInput()).thenReturn(MainActions.QUIT);

    app.run(Language.ENG);

    // Verify that the required methods are called
    verify(app).createStuffSystem();
    verify(app).createMainView(Language.ENG, "MainView");
    verify(view, atLeastOnce()).displayMenu();
    verify(view, atLeastOnce()).getInput();
  }
}
