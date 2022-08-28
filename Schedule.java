//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This file contains the Schedule class which defines fields and methods for each Schedule,
// which assigns courses to rooms for exams to be taken at
// Course: CS 300 Spring 2022
//
// Author: Pujan Patel, Pranav Sharma
// Email: phpatel4@wisc.edu, pnsharma@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: None used
// Online Sources: None used
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Arrays;

/**
 * This file contains the Schedule class which defines fields and methods for each Schedule, which
 * assigns courses to rooms for exams to be taken at
 * 
 * @author pranav sharma
 * @author pujan patel
 *
 */
public class Schedule {

  // defines private fields to be used by the schedule object
  private Room[] rooms;
  private Course[] courses;
  private int[] assignments;

  /**
   * Constructor for the Schedule object, assigns rooms and courses array while initializing the
   * assignments array and setting its contents
   * 
   * @param rooms   The Room array the objects rooms array is assigned to
   * @param courses The Course array the objects courses array is assigned to
   */
  public Schedule(Room[] rooms, Course[] courses) {
    this.rooms = rooms;
    this.courses = courses;
    this.assignments = new int[courses.length];
    for (int i = 0; i < assignments.length; i++) {
      assignments[i] = -1;
    }
  }

  /**
   * Second private constructor that directly sets rooms, assigments, and courses array
   * 
   * @param rooms       The Room array the objects rooms array is assigned to
   * @param courses     The Course array the objects courses array is assigned to
   * @param assignments The Int array the objects assignments array is assigned to
   */
  private Schedule(Room[] rooms, Course[] courses, int[] assignments) {
    this.rooms = rooms;
    this.courses = courses;
    this.assignments = assignments;
  }

  /**
   * Returns the number of rooms in the schedule(length of rooms array)
   * 
   * @return the number of rooms
   */
  public int getNumRooms() {
    return rooms.length;
  }

  /**
   * Gets the room at a specified index in the rooms array
   * 
   * @param index index of the room in the rooms array
   * 
   * @return The room located at the index in rooms
   * @throws IndexOutOfBoundsException with descriptive message is index is out of bounds
   */
  public Room getRoom(int index) {
    try {
      return rooms[index];
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("The index is invalid");
    }
  }

  /**
   * gets the number of courses in the schedule (length of the courses array)
   * 
   * @return the number of courses in the schedule
   */
  public int getNumCourses() {
    return courses.length;
  }

  /**
   * Gets the course at a specified index in the courses array
   * 
   * @param index index of the course in the courses array
   * 
   * @return The course located at the index in courses
   * @throws IndexOutOfBoundsException with descriptive message is index is out of bounds
   */
  public Course getCourse(int index) {
    try {
      return courses[index];
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("The index is invalid");
    }
  }

  /**
   * Returns if assignments of an index has been assigned or not
   * 
   * @param index index of the assignments array to check if has been assigned or not
   * @return true if assignments[index] has been assigned, false otherwise
   */
  public boolean isAssigned(int index) {
    if (assignments[index] != -1) {
      return true;
    }
    return false;
  }

  /**
   * Gets the Room in rooms a course at the given index is assigned to
   * 
   * @param index The index in courses that the room is being retrieved for
   * @return the Room a course at the given index is assigned to
   * @throws IllegalArgumentException  with a descriptive message if the course is not assigned to a
   *                                   Room
   * @throws IndexOutOfBoundsException with a descriptive message if the index is out of bounds
   */
  public Room getAssignment(int index) throws IllegalArgumentException, IndexOutOfBoundsException {
    try {
      if (assignments[index] == -1) {
        throw new IllegalArgumentException("course has not been assigned a room");
      }
      return rooms[assignments[index]];
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("The index is invalid");
    }
  }

  /**
   * Checks if the current schedule is fully complete with every course being assigned to a Room
   * 
   * @return true if the schedule is complete (every course being assigned to a Room), false
   *         otherwise
   */
  public boolean isComplete() {
    for (int i = 0; i < assignments.length; i++) {
      if (!isAssigned(i)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Assigns the course at courseIndex in courses to the room at roomIndex in rooms
   * 
   * @param courseIndex the index in courses which the course that is being assigned exists
   * @param roomIndex   the index in rooms which the room that is being assigned to exists
   * @return A new schedule copy with the updated assignments
   * @throws IllegalArgumentException  with descriptive message if the course has not been assigned
   *                                   to a room
   * @throws IndexOutOfBoundsException with descriptive message if one of the indices is out of
   *                                   bounds
   */
  public Schedule assignCourse(int courseIndex, int roomIndex)
      throws IllegalArgumentException, IndexOutOfBoundsException {
    try {
      Room[] r = Arrays.copyOf(rooms, getNumRooms());
      int[] a = Arrays.copyOf(assignments, getNumCourses());
      r[roomIndex] = getRoom(roomIndex).reduceCapacity(getCourse(courseIndex).getNumStudents());
      a[courseIndex] = roomIndex;
      return new Schedule(r, courses, a);
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("given course index or room index is invalid");
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("course has not been assigned a room");
    }
  }

  @Override
  /**
   * Returns the string representation of the object
   * 
   * @return the string representation of the object
   */
  public String toString() {
    String output = "{";
    for (int i = 0; i < getNumCourses(); i++) {
      String location = "";
      if (assignments[i] == -1) {
        location = "Unassigned";
      } else {
        location = rooms[assignments[i]].getLocation();
      }
      output += courses[i].getName() + ": " + location + ", ";
    }
    output = output.substring(0, output.length() - 2);
    output = output.trim() + "}";
    return output;
  }
}
