package com.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import com.model.lib.BasicMemberData;
import com.model.lib.MemberRepository;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for MemberRepository.
 */
class MemberRepositoryTest {

  private MemberRepository sut;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    // Initialize MemberRepository with a mocked TimeService
    sut = new MemberRepository();
  }

  // Test for email validation
  @Test
  void shouldValidateEmailCorrectly() {
    assertTrue(sut.validateEmail("test@example.com"), "Valid email should return true");
    assertFalse(sut.validateEmail("invalidemail"), "Invalid email should return false");
  }

  // Test for mobile number validation
  @Test
  void shouldValidateMobileCorrectly() {
    assertTrue(sut.validateMobile("1234567890"), "Valid mobile should return true");
    assertFalse(sut.validateMobile(null), "Invalid mobile should return false");
    assertFalse(sut.validateMobile(""), "Invalid mobile should return false");
  }

  // Test for name validation
  @Test
  void shouldValidateNameCorrectly() {
    assertTrue(sut.validateName("John Doe"), "Valid name should return true");
    assertFalse(sut.validateName("J"), "Name too short should return false");
  }

  // Test adding a Member
  @Test
  void shouldAddNewMemberSuccessfully() {
    BasicMemberData validMemberData = new BasicMemberData("Jane Doe", "jane@example.com", "9876543210", 20210101);
    Member result = sut.addNewMember(validMemberData);
    assertNotNull(result, "Adding a valid member should succeed");
    assertEquals("Jane Doe", result.getName(), "The name of the added member should match");
  }

  @Test
  void shouldFailToAddMemberWithExistingEmail() {
    BasicMemberData memberDataWithExistingEmail = new BasicMemberData("Existing Email", "existing@example.com", "9876543210",
        20210101);

    sut.addNewMember(memberDataWithExistingEmail);

    BasicMemberData newMemberDataWithSameEmail = new BasicMemberData("New Name", "existing@example.com", "1234567890",
        20220101);
    Member result = sut.addNewMember(newMemberDataWithSameEmail); // Attempt to add another with the same email
    assertNull(result, "Should fail to add a new member with an existing email");
  }

  // Test for deleting a member
  @Test
  void shouldDeleteMemberSuccessfully() {
    BasicMemberData memberData = new BasicMemberData("Delete Me", "delete@example.com", "1234567890", 2);
    Member memberToDelete = sut.addNewMember(memberData);
    
    boolean deleted = sut.deleteMember(memberToDelete);
    assertTrue(deleted, "Member should be deleted successfully");

    assertNull(sut.getMemberById("idToDelete"), "Deleted member should not be found");
  }

  @Test
  void shouldNotDeleteNonExistingMember() {
    Member nonExistingMember = new Member("nonExistingId", "I Don't Exist", "nonexistent@example.com", "0000000000",
        20220101);
    boolean deleted = sut.deleteMember(nonExistingMember);
    assertFalse(deleted, "Non-existing member should not be deleted");
  }

  // Test for updating a member
  @Test
  void shouldUpdateMemberSuccessfully() {
    Member existingMember = new Member("idToUpdate", "Original Name", "original@example.com", "1234567890", 20200101);
    BasicMemberData updatedData = new BasicMemberData("Updated Name", "updated@example.com", "0987654321", 20200101);

    Member updatedMember = sut.updateMember(updatedData, existingMember);
    assertNotNull(updatedMember, "Member should be updated successfully");
    assertEquals("Updated Name", updatedMember.getName(), "Member name should be updated");
  }

  @Test
  void shouldFailToUpdateWithInvalidEmail() {
    Member existingMember = new Member("idToUpdate", "Original Name", "original@example.com", "1234567890", 20200101);
    BasicMemberData invalidEmailData = new BasicMemberData("Original Name", "notAnEmail", "1234567890", 20200101);

    Member result = sut.updateMember(invalidEmailData, existingMember);
    assertNull(result, "Should fail to update member with invalid email");
  }
}
