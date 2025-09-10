/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gradetracker;

/**
 *
 * @author lab_services_student
 */
public class Student extends Person {
    private double mark;

    public Student(String id, String name, double mark) {
        super(id, name);
        this.mark = mark;
    }

    public double getMark() { return mark; }
    public void setMark(double mark) { this.mark = mark; }

    @Override
    public String info() {
        return super.info() + " : " + mark;
    }
}
