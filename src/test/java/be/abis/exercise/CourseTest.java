package be.abis.exercise;

import be.abis.exercise.model.Course;
import be.abis.exercise.utility.MyUtility;

public class CourseTest {

    public static void main(String[] args) {
        Course course = new Course(15, "REST API", "REST API (long name)", 5, 500);
        System.out.println("The " + course.getShortTitle() + " course takes " + course.getNumberOfDays() + " days and costs " + course.getPricePerDay() + " per day.");
        System.out.println(course);
        course = new Course(39, "Kotlin", "Kotlin (long name)", 10, 870);
        MyUtility.printCourse(course);
    }
}
