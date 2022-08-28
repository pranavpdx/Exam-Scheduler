//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This file contains the ExamScheduler class which static methods used to create schedules
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
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This file contains the ExamScheduler class which static methods used to create schedules
 * 
 * @author pranav sharma
 * @author pujan patel
 *
 */
public class ExamScheduler {

  /**
   * 
   * @param rooms
   * @param courses
   * @return
   * @throws IllegalStateException
   */
  public static Schedule findSchedule(Room[] rooms, Course[] courses) throws IllegalStateException {
    try {
      Schedule s = new Schedule(rooms, courses);
      return findScheduleHelper(s, 0);
    } catch (Exception e) {
      throw new IllegalStateException(e.getMessage());
    }

  }

  /**
   * 
   * @param schedule
   * @param index
   * @return
   * @throws IllegalStateException
   */
  public static Schedule findScheduleHelper(Schedule schedule, int index)
      throws IllegalStateException {
    if (index == schedule.getNumCourses()) {
      if (!schedule.isComplete()) {
        throw new IllegalStateException("No valid schedule");
      }
    }

    else if (schedule.isAssigned(index)) {
      schedule = findScheduleHelper(schedule, index + 1);
    }

    else if (!schedule.isAssigned(index)) {
      for (int i = 0; i < schedule.getNumRooms(); i++) {
        try {
          Schedule testSchedule = schedule.assignCourse(index, i);
          return findScheduleHelper(testSchedule, index + 1);
        } catch (IllegalStateException e) {

        } catch (Exception e) {
          if (i == schedule.getNumRooms() - 1)
            throw new IllegalStateException("No valid schedule");
        }
      }
    }
    return schedule;
  }

  /**
   * 
   * @param rooms
   * @param courses
   * @return
   */
  public static ArrayList<Schedule> findAllSchedules(Room[] rooms, Course[] courses) {
    try {
      Schedule s = new Schedule(rooms, courses);
      return findAllSchedulesHelper(s, 0);
    } catch (Exception e) {
      return new ArrayList<Schedule>();
    }
  }

  /**
   * 
   * @param schedule
   * @param index
   * @return
   */
  public static ArrayList<Schedule> findAllSchedulesHelper(Schedule schedule, int index) {
    ArrayList<Schedule> array = new ArrayList<>();

    if (schedule.getNumCourses() == index) {
      if (schedule.isComplete()) {
        array.add(schedule);
        return array;
      }
    }
    if (schedule.isAssigned(index)) {
      array = findAllSchedulesHelper(schedule, index + 1);
      return array;
    } else {
      for (int i = 0; i < schedule.getNumRooms(); ++i) {
        try {
          Schedule newSchedule = schedule.assignCourse(index, i);
          array.addAll((findAllSchedulesHelper(newSchedule, index + 1)));
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e) {
        }
      }
    }
    return array;
  }

}
