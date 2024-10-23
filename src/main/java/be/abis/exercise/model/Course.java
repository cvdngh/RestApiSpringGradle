package be.abis.exercise.model;

public class Course {

    private int courseId;

    private String shortTitle;

    private String longTitle;

    private int numberOfDays;

    private int pricePerDay;

    public Course() {}

    public Course(int courseId, String shortTitle, String longTitle, int numberOfDays, int pricePerDay) {
        this.courseId = courseId;
        this.shortTitle = shortTitle;
        this.longTitle = longTitle;
        this.numberOfDays = numberOfDays;
        this.pricePerDay = pricePerDay;
    }


    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getLongTitle() {
        return longTitle;
    }

    public void setLongTitle(String longTitle) {
        this.longTitle = longTitle;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        String string = "The " + this.shortTitle + " course takes " + this.numberOfDays + " days and costs " + this.pricePerDay + " per day.";
        return string;
    }
}
