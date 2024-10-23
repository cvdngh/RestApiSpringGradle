package be.abis.exercise.repository;

import be.abis.exercise.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryCourseRepository implements CourseRepository {

    private List<Course> courses = new ArrayList<>();

    public MemoryCourseRepository() {
        courses.add(new Course(1, "Hibernate", "Hibernate (long)", 7, 800));
        courses.add(new Course(2, "Gradle", "Gradle (long)", 4, 777));
        courses.add(new Course(3, "Business Intelligence", "Business Intelligence (long)", 6, 750));
        courses.add(new Course(4, "Java", "Java (long)", 8, 900));
        courses.add(new Course(5, "C++", "C++ (long)", 9, 780));
    }

    @Override
    public List<Course> findAllCourses() {
        return courses;
    }

    @Override
    public Course findCourseById(int id) {
        Course courseFound = null;
        for(Course c: courses) {
            if (c.getCourseId() == id) {
                courseFound = c;
            }
        }
        return courseFound;
    }

    @Override
    public Course findCourseByShortTitle(String shortTitle) {
        //Course courseFound = null;
        /*
        for(Course c: courses) {
            if (c.getShortTitle().equals(shortTitle)) {
                courseFound = c;
            }
        }*/

        Optional<Course> courseFound = courses.stream()
                .filter(c -> c.getShortTitle().equalsIgnoreCase(shortTitle))
                .findFirst();

        return courseFound.orElse(null);
    }

    @Override
    public List<Course> findCoursesByDuration(int duration) {
        List<Course> courseList = courses.stream()
                .filter(c -> c.getNumberOfDays() == duration)
                .collect(Collectors.toList());
        return courseList;
    }

    @Override
    public void addCourse(Course c) {
        try {
            if (this.findCourseByShortTitle(c.getShortTitle()) == null) {
                courses.add(c);
            } else
                System.out.println("Course " + c.getShortTitle() + "(" + c.getCourseId() + ") is already part of the course list.");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void updateCourse(Course c) {
        Course foundCourse = this.findCourseByShortTitle(c.getShortTitle());
        if (foundCourse != null) {
            try {
                courses.set(courses.indexOf(foundCourse), c);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void deleteCourse(int id) {
        Course c = this.findCourseById(id);
        if (c != null) {
            courses.remove(c);
        }
    }
}
