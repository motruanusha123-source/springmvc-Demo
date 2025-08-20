package com.upload;


public class Employee {
    private int id;
    private String name;
    private String resumeName;
    private String resumePath;

    public Employee(int id, String name, String resumeName, String resumePath) {
        this.id = id;
        this.name = name;
        this.resumeName = resumeName;
        this.resumePath = resumePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResumeName() {
        return resumeName;
    }

    public void setResumeName(String resumeName) {
        this.resumeName = resumeName;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resumeName='" + resumeName + '\'' +
                ", resumePath='" + resumePath + '\'' +
                '}';
    }
}