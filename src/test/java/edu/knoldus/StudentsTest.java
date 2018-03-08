package edu.knoldus;

import edu.knoldus.ClassActions.ClassRooms;
import edu.knoldus.ClassActions.Students;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class StudentsTest {

  private static ClassRooms room1;
  @Before
  public void setUp() {
    Students s1 = new Students("deepankar", 4, Optional.of (Arrays.asList ("maths", "eng", "science")));
    Students s6 = new Students ("harish", 15, Optional.empty ());
    Students s7 = new Students ("rohit", 20, Optional.empty ());
    room1 = new ClassRooms (1, Optional.of (Arrays.asList (s1, s6, s7)));
    }

    @Test
    public void testGetStudentsWithNoSubject(){
      ArrayList<String> actualResult = Students.getStudentsWithNoSubject (room1);
      ArrayList<String> expectedResult = new ArrayList<String>
          (Arrays.asList("harish", "rohit"));
      assertEquals("first method", expectedResult, actualResult);
    }

    @Test
    public void testHelloStudents() {
    String actualResult = Students.helloStudents (room1);
    String expectedResult = "hello students";
    assertEquals ("third method", expectedResult, actualResult);
    }


  @After
  public void tearDown() {
  }
}
