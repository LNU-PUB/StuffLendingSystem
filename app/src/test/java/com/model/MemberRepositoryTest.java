package com.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for MemberRepository.
 */
class MemberRepositoryTest {

  private MemberRepository sut;

  @Mock
  private TimeService mockTimeService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    // Initialize MemberRepository with a mocked TimeService
    sut = new MemberRepository(mockTimeService);
  }

  // Test for email validation
  @Test
  void shouldValidateEmailCorrectly() {
    assertTrue(sut.validateEmail("test@example.com"), "Valid email should return true");
    assertFalse(sut.validateEmail("invalidemail"), "Invalid email should return false");
    // Additional specific cases can be added
  }

  // Test for mobile number validation
  @Test
  void shouldValidateMobileCorrectly() {
    assertTrue(sut.validateMobile("1234567890"), "Valid mobile should return true");
    assertFalse(sut.validateMobile(null), "Invalid mobile should return false");
    assertFalse(sut.validateMobile(""), "Invalid mobile should return false");
    // Additional specific cases can be added
  }

  // Test for name validation
  @Test
  void shouldValidateNameCorrectly() {
    assertTrue(sut.validateName("John Doe"), "Valid name should return true");
    assertFalse(sut.validateName("J"), "Name too short should return false");
    // Additional specific cases can be added
  }
}
