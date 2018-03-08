package edu.knoldus.ClassActions;

import java.util.List;
import java.util.Optional;

/**
 * classrooms with room id and students optional.
 */
public class ClassRooms {
    /**
     * roomiD is basically like a room number.
     */
    public int roomId;
    /**
     * optional list of students i.e. students may
     * or may not be present in a classroom.
     */
    public Optional<List<Students>> students;

    /**
     * @param roomId   is like a room number.
     * @param students optional list of students which
     */

    public ClassRooms(final int roomId
            , final Optional<List<Students>> students) {
        this.roomId = roomId;
        this.students = students;
    }

  /*
public Optional<List<Students>> getStudents() {
return students;
}

public int getRoomId() {
return roomId;
}
*/
}
