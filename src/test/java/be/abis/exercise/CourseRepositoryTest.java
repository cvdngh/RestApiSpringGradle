package be.abis.exercise;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.MemoryCourseRepository;

import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryTest {

    public static void main(String[] args) {
        CourseRepository cr = new MemoryCourseRepository();

        List<Course> courseList = new ArrayList<>();
        Course specificCourse = null;

        courseList = cr.findAllCourses();

        courseList.stream()
                .forEach(c -> System.out.println("findAllCourses: " + c.getShortTitle() + " - " + c.getLongTitle() + " - " + c.getCourseId()));

        /*
        for (Course c: courseList) {
            System.out.println("findAllCourses: " + c.getShortTitle() + " - " + c.getLongTitle());
        }*/

        specificCourse = cr.findCourseById(5);

        if (specificCourse != null) {
            System.out.println("findCourseById(5): " + specificCourse.getShortTitle());
        }

        specificCourse = cr.findCourseByShortTitle("Gradle");

        if (specificCourse != null) {
            System.out.println("findCourseByShortTitle(Gradle): " + specificCourse.getShortTitle());
        }

        Course courseToAdd = new Course(6, "JavaScript", "JavaScript (long)", 6, 444);

        cr.addCourse(courseToAdd);

        System.out.println("*****");
        System.out.println("List of courses (after adding one):");

        courseList = cr.findCoursesByDuration(6);

        courseList.stream()
                .forEach(c -> System.out.println("findCoursesByDuration: " + c.getShortTitle() + " - " + c.getLongTitle() + " - " + c.getNumberOfDays()));

        System.out.println("*****");
        System.out.println("List of courses (after testing findCoursesByDuration):");

        courseList = cr.findAllCourses();

        for (Course c: courseList) {
            System.out.println("findAllCourses: " + c.getShortTitle() + " - " + c.getLongTitle());
        }

        Course courseToUpdate = new Course(3, "Business Intelligence", "Business Intelligence (even longer)", 7, 540);

        System.out.println("*****");
        System.out.println("List of courses (after updating one (3)):");

        cr.updateCourse(courseToUpdate);

        courseList = cr.findAllCourses();

        for (Course c: courseList) {
            System.out.println("findAllCourses: " + c.getShortTitle() + " - " + c.getLongTitle());
        }

        cr.deleteCourse(4);

        System.out.println("*****");
        System.out.println("List of courses (after removing one (4)):");

        courseList = cr.findAllCourses();

        for (Course c: courseList) {
            System.out.println("findAllCourses: " + c.getShortTitle() + " - " + c.getLongTitle());
        }

    }

}
