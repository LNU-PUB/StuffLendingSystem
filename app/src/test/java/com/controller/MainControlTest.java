package com.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.controller.model.MainActions;
import com.model.StuffLendingSystem;
import com.view.model.View;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MainControlTest {
  MainControl sut;
  
  //  @Mock
  //   private StuffLendingSystem stuffSystem;
  //   @Mock
  //   private View view;

  //   @BeforeEach
  //   void setUp() {
  //       MockitoAnnotations.openMocks(this);
  //       sut = new MainControl(stuffSystem, view, null);
  //   }

  //   @Test
  //   void advanceTimeShouldIncrementTimeInStuffSystem() {
  //       // Arrange: set up view to return ADVANCETIME when getInput() is called
  //       when(view.getInput()).thenReturn(MainActions.ADVANCETIME);

  //       // Act: call run() method which should trigger advanceTime()
  //       sut.run();

  //       // Assert: verify that StuffLendingSystem.advanceTime() was called
  //       verify(stuffSystem).advanceTime();
  //   }
}
