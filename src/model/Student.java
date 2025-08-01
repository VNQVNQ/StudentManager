package model;

public class Student {
    private int id;
    private String fullName;
    private double gpa;

    public Student(int id, String fullName, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.gpa = gpa;
    }

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public double getGpa() { return gpa; }

    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    @Override
    public String toString() {
        return String.format("%-10d %-30s %.2f", id, fullName, gpa);
    }
}
