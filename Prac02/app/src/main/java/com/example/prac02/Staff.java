package com.example.prac02;

public class Staff {
    private String staffId;
    private String fullName;
    private String birthDate;
    private int salary;

    public Staff(String staffId, String fullName, String birthDate, int salary) {
        this.staffId = staffId;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public String getStaffId() { return staffId; }
    public String getFullName() { return fullName; }
    public String getBirthDate() { return birthDate; }
    public int getSalary() { return salary; }
}
