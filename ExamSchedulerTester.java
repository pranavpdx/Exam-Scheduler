import java.util.ArrayList;

public class ExamSchedulerTester {
  public static void main(String args[]) {
    System.out.println("Run all Tests: " + runAllTests());
  }

  public static boolean runAllTests() {
    if (testFindSchedule()) {
      return true;
    }
    return false;
  }

  public static boolean testCourse() {
    return true;
  }

  public static boolean testRoom() {
    return true;
  }

  public static boolean testScheduleAccessors() {

    return true;
  }

  public static boolean testAssignCourse() {
    Room[] rooms =
        new Room[] {new Room("Room1", 75), new Room("Room2", 100), new Room("Room3", 15)};
    Course[] courses =
        new Course[] {new Course("CS200", 20), new Course("CS300", 110), new Course("CS400", 80 )};
    Schedule schedule = new Schedule(rooms, courses);

    try {
      // Test here etc.
      schedule = schedule.assignCourse(1, 6);
      System.out.println(schedule.toString());
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }

    return true;
  }

  public static boolean testFindAllSchedules() {
    return true;
  }

  public static boolean testFindSchedule() {
    Room[] rooms =
        new Room[] {new Room("Room1", 75), new Room("Room2", 100), new Room("Room3", 15)};
    Course[] courses =
        new Course[] {new Course("CS200", 20), new Course("CS300", 110), new Course("CS400", 80)};
    ArrayList<Schedule> schedule;
    Schedule s1 = new Schedule(rooms, courses);
    
    try {
      s1 = ExamScheduler.findScheduleHelper(s1, 0);
      System.out.println(s1);
      /*for(Schedule s: schedule) {
        System.out.println(s.toString());
      }*/
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }

    return true;
  }

}

