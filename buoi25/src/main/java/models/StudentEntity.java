package models;

public class StudentEntity {
    private int id;
    private String fullName, className, address;
    private float score;

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getClassName() {
        return className;
    }

    public String getAddress() {
        return address;
    }

    public float getScore() {
        return score;
    }

    public StudentEntity(int id, String fullName, String className, String address, float score) {
        this.id = id;
        this.fullName = fullName;
        this.className = className;
        this.address = address;
        this.score = score;
    }

    public StudentEntity(String fullName, String className, String address, float score) {
        this.fullName = fullName;
        this.className = className;
        this.address = address;
        this.score = score;
    }
}
