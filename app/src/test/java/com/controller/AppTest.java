package com.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.controller.model.Language;
import com.controller.model.controllers.MainControl;
import com.model.lib.MemberRepository;
import com.view.model.MainView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class AppTest {

  private App app;

  @Mock
  private MemberRepository stuffLendingSystem;
  @Mock
  private MainView view;
  @Mock
  private MainControl stuffControl;

  @BeforeEach
  void seUp() {
    MockitoAnnotations.openMocks(this);
    app = spy(new App());
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
}
