/*
 * AI-assisted cleanup of template
 */
package com.mycompany.gradetracker;   // ✅ adjust to your actual package name

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for the Student class.
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentManagerTest {

    private StudentManager manager;

    @BeforeEach
    public void setUp() {
        manager = new StudentManager();
        manager.addStudent("ST001", "Alice", 75.0);
        manager.addStudent("ST002", "Bob", 60.0);
    }

    @Test
    public void testAddAndFindStudent() {
        Student s = manager.findById("ST001");
        assertNotNull(s);
        assertEquals("Alice", s.getName());
        assertEquals(75.0, s.getMark());
    }

    @Test
    public void testFindStudentNotFound() {
        Student s = manager.findById("ST999");
        assertNull(s);
    }

    @Test
    public void testUpdateStudentMark() {
        boolean updated = manager.updateStudentMark("ST002", 70.5);
        assertTrue(updated);
        Student s = manager.findById("ST002");
        assertEquals(70.5, s.getMark());
    }

    @Test
    public void testUpdateStudentMarkNotFound() {
        boolean updated = manager.updateStudentMark("NOID", 80.0);
        assertFalse(updated);
    }

    @Test
    public void testDeleteStudent() {
        boolean deleted = manager.deleteStudent("ST001");
        assertTrue(deleted);
        assertNull(manager.findById("ST001"));
        assertEquals(1, manager.count());
    }

    @Test
    public void testDeleteStudentNotFound() {
        boolean deleted = manager.deleteStudent("NOID");
        assertFalse(deleted);
        assertEquals(2, manager.count());
    }

    @Test
    public void testAverageMark() {
        double avg = manager.averageMark();
        // (75 + 60)/2 = 67.5
        assertEquals(67.5, avg);
    }

    @Test
    public void testAverageMarkEmptyList() {
        StudentManager m2 = new StudentManager();
        assertEquals(0.0, m2.averageMark());
    }

    @Test
    public void testStudentInfoContainsIdNameMark() {
        Student s = new Student("S100", "Chris", 99.0);
        String info = s.info();
        assertTrue(info.contains("S100"));
        assertTrue(info.contains("Chris"));
        assertTrue(info.contains("99.0"));
    }
}