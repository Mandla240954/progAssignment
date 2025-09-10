package com.mycompany.gradetracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeTrackerApp {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1": // add new student
                    addStudentInteractive(students, sc);
                    break;
                case "2": // view report
                    viewReport(students);
                    break;
                case "3": // exit
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
        }

        sc.close();
    }

    private static void printMenu() {
        System.out.println("=== Student Grade Tracker ===");
        System.out.println("1. Add new student");
        System.out.println("2. View grade report");
        System.out.println("3. Exit");
    }

    private static void addStudentInteractive(List<Student> students, Scanner sc) {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine().trim();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine().trim();

        double mark = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter Student Mark: ");
            String markStr = sc.nextLine().trim();
            try {
                mark = Double.parseDouble(markStr);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid mark. Please enter a number.");
            }
        }

        Student s = new Student(id, name, mark);
        students.add(s);
        System.out.println("Student added successfully.");
    }

    private static void viewReport(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students recorded yet.");
            return;
        }
        System.out.println("=== Student Report ===");
        double total = 0;
        for (Student s : students) {
            System.out.println(s.info());
            total += s.getMark();
        }
        double avg = total / students.size();
        System.out.println("Average mark: " + avg);
    }
}
