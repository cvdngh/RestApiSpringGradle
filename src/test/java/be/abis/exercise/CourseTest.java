package be.abis.exercise;

import be.abis.exercise.model.Course;

public class CourseTest {

    public static void main(String[] args) {
        Course course = new Course(15, "REST API", "REST API (long name)", 5, 500);
        System.out.println("The " + course.getShortTitle() + " course takes " + course.getNumberOfDays() + " days and costs " + course.getPricePerDay() + " per day.");
        System.out.println(course);
    }
}
