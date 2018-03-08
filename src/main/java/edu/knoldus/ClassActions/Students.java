package edu.knoldus.ClassActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Students {
    private String name;
    private int rollNumber;
    private Optional<List<String>> subjects;

    public Students(String name, int rollNumber
            , Optional<List<String>> subjects) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjects = subjects;
    }

    public static void main(String[] args) {
        ArrayList<String> studentsWithoutSubjects = new ArrayList<String> ();
        Students s1 = new Students("deepankar", 4,
                Optional.of(Arrays.asList("maths", "eng", "science")));
        Students s2 = new Students("ankit", 2,
                Optional.of(Arrays.asList("maths", "eng", "science")));
        Students s3 = new Students ("amit", 1,
                Optional.of(Arrays.asList("maths", "eng", "science")));
        Students s4 = new Students("nitin", 10,
                Optional.of(Arrays.asList("maths", "eng", "science")));
        Students s5 = new Students("deepak", 3,
                Optional.of(Arrays.asList("maths", "eng", "science")));
        Students s6 = new Students("harish", 15,
                Optional.empty());
        Students s7 = new Students("rohit", 20,
                Optional.empty());

        ClassRooms room1 = new ClassRooms(1,
                Optional.of(Arrays.asList(s1, s2, s3, s6, s7)));
        ClassRooms room2 = new ClassRooms(2,
                Optional.of(Arrays.asList(s6, s7)));
        ClassRooms room3 = new ClassRooms(3,
                Optional.empty());

        studentsWithoutSubjects = getStudentsWithNoSubject(room1);
        System.out.println(studentsWithoutSubjects);
        String hello = helloStudents(room3);
        System.out.println(hello);
    }

    /**
     * @param room1 object of class room
     * @return list of student names who don;t have any subjects
     */
    public static ArrayList<String> getStudentsWithNoSubject(ClassRooms room1) {
        ArrayList<String> classStudents = new ArrayList<>();
        room1.students.orElseGet(ArrayList::new).stream().filter(
                students -> !(students.subjects.isPresent())).forEach((Students student) -> {
            classStudents.add(student.name);
        });
        return classStudents;
    }

  /*public static ArrayList<String> getSubjectsFromRoom(List<ClassRooms> objects, int roomNumber) {
    ArrayList<String> getSubjects = new ArrayList<> ();
    objects.stream ().filter (rooms -> rooms.roomId == roomNumber)
        .map (room -> room.students.orElseGet (ArrayList::new))
        .map (student -> student.stream ().forEach (x -> {
          if (x.subjects.isPresent ()){
            x.subjects.orElseGet (ArrayList::new).stream ().forEach (y -> getSubjects.add (y));
          }
        }));
    return getSubjects;
  }*/

    /**
     * @param room object of classroom
     * @return hello students if students are presnt in class else returns null
     */
    public static String helloStudents(ClassRooms room) {
        if (room.students.isPresent()) {
            return "hello students";
        } else {
            return "null";
        }
    }
}
