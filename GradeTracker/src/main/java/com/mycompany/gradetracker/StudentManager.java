/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gradetracker;

/**
 *
 * @author lab_services_student
 */
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(String id, String name, double mark) {
        students.add(new Student(id, name, mark));
    }

    public Student findById(String id) {
        return students.stream()
                .filter(s -> s.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    public boolean updateStudentMark(String id, double newMark) {
        Student s = findById(id);
        if (s == null) return false;
        s.setMark(newMark);
        return true;
    }

    public boolean deleteStudent(String id) {
        Student s = findById(id);
        if (s == null) return false;
        students.remove(s);
        return true;
    }

    public double averageMark() {
        if (students.isEmpty()) return 0.0;
        double total = 0;
        for (Student s : students) {
            total += s.getMark();
        }
        return total / students.size();
    }

    public int count() {
        return students.size();
    }
}