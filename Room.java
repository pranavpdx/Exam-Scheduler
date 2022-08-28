//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This file contains the Room class which defines fields and methods for each Room
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
 * This file contains the Room class which defines fields and methods for each Room
 * 
 * @author pranav sharma
 * @author pujan patel
 *
 */
public class Room {
  // defines private fields of the Room class
  private String location;
  private int capacity;

  /**
   * Constructor of the Room class which assigns the location name and capacity of the room
   * 
   * @param location the location of the room
   * @param capacity the capacity of the room
   * @throws IllegalArgumentException with descriptive message if capacity is less than 0
   */
  public Room(String location, int capacity) throws IllegalArgumentException {
    if (capacity < 0) {
      throw new IllegalArgumentException("Capacity is a negative value.");
    }
    this.location = location;
    this.capacity = capacity;
  }

  /**
   * gets the location of the Room
   * 
   * @return the location of the Room
   */
  public String getLocation() {
    return location;
  }

  /**
   * gets the capacity of the room
   * 
   * @return the capacity of the room
   */
  public int getCapacity() {
    return capacity;
  }

  /**
   * Reduces the capacity of the room by a specific amount, returns a new room with changed capacity
   * 
   * @param amount The amount the capacity is decreased by
   * @return A new room with the changed capacity and same location
   * @throws IllegalArgumentException
   */
  public Room reduceCapacity(int amount) throws IllegalArgumentException {
    if (capacity < amount) {
      throw new IllegalArgumentException("Amount is larger than capacity.");
    }

    return new Room(location, capacity - amount);
  }
  // tester method called testRoom() in ExamScheulerTester();
}
