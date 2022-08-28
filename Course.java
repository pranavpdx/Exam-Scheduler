//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This file contains the Course class which defines fields and methods for each Course
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
/**
 * This file contains the Course class which defines fields and methods for each Course
 * 
 * @author pranav sharma
 * @author pujan patel
 *
 */
public class Course {
  // defines private fields for the Course class
  private String name;
  private int numStudents;

  /**
   * Constructor for the Course object which assigns name and the number of students
   * 
   * @param name        name of the course
   * @param numStudents number of students
   * @throws IllegalArgumentException with descriptive message of number of students is under 0
   */
  public Course(String name, int numStudents) throws IllegalArgumentException {
    if (numStudents < 0) {
      throw new IllegalArgumentException("Number of students is a negative value.");
    }
    this.name = name;
    this.numStudents = numStudents;
  }

  /**
   * gets the name of the Course
   * 
   * @return the name of the course (name)
   */
  public String getName() {
    return name;
  }

  /**
   * gets the number of students in the course
   * 
   * @return the number of students in the course (numStudents)
   */
  public int getNumStudents() {
    return numStudents;
  }
  // ^^ tester methods called testCourse() in ExamScheulerTester();
}
