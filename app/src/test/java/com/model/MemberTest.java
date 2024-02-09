package com.model;

import com.model.Member;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class MemberTest {

  @Test
  public void testMemberCreation() {
    Member member = new Member("1", "John Doe", "john.doe@example.com", "1234567890", 100);
    assertNotNull(member, "Member should be successfully instantiated");
  }

  @Test
  public void testGetters() {
    String id = "1";
    String name = "John Doe";
    String email = "john.doe@example.com";
    String mobile = "1234567890";
    int creationDay = 100;

    Member member = new Member(id, name, email, mobile, creationDay);

    assertEquals(id, member.getId(), "ID should match");
    assertEquals(name, member.getName(), "Name should match");
    assertEquals(email, member.getEmail(), "Email should match");
    assertEquals(mobile, member.getMobile(), "Mobile should match");
    assertEquals(creationDay, member.getMemberCreationDay(), "Member creation day should match");
  }

  @Test
  public void testImmutability() {
    Field[] fields = Member.class.getDeclaredFields();
    for (Field field : fields) {
      int modifiers = field.getModifiers();
      assertTrue(Modifier.isFinal(modifiers), "Field " + field.getName() + " should be final");
    }
  }

  @Test
  public void testEquality() {
    Member member1 = new Member("1", "John Doe", "john.doe@example.com", "1234567890", 100);
    Member member2 = new Member("1", "John Doe", "john.doe@example.com", "1234567890", 100);
    assertEquals(member1, member2, "Two members with the same field values should be equal");
  }

  @Test
  public void testHashCode() {
    Member member1 = new Member("1", "John Doe", "john.doe@example.com", "1234567890", 100);
    Member member2 = new Member("1", "John Doe", "john.doe@example.com", "1234567890", 100);
    assertEquals(member1.hashCode(), member2.hashCode(), "Hash codes should be equal for equal objects");
  }

  @Test
  public void testSerialization() throws IOException, ClassNotFoundException {
    Member originalMember = new Member("1", "John Doe", "john.doe@example.com", "1234567890", 100);

    // Serialize
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream out = new ObjectOutputStream(bos);
    out.writeObject(originalMember);
    out.flush();
    byte[] serializedData = bos.toByteArray();

    // Deserialize
    ByteArrayInputStream bis = new ByteArrayInputStream(serializedData);
    ObjectInputStream in = new ObjectInputStream(bis);
    Member deserializedMember = (Member) in.readObject();

    assertEquals(originalMember, deserializedMember, "Deserialized member should be equal to the original");
  }
}
