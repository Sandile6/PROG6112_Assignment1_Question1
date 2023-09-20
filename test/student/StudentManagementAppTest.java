/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 *
 * @author sandi
 */

public class StudentManagementAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("1\nJohn\n18\njohn@example.com\nComputer Science\n2\nJohn\n3\nN\n5\n".getBytes());

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);
    }

    @Test
    public void TestCaptureNewStudent() {
        StudentManagementApp app = new StudentManagementApp();

        app.captureNewStudent();
        assertEquals("Enter the student id: Enter the student name: Enter the student age: Enter the student email: Enter the student course: Student details have been successfully saved.\n", outContent.toString());
    }

    @Test
    public void TestSearchForStudent() {
        StudentManagementApp app = new StudentManagementApp();

        app.captureNewStudent();
        app.searchForStudent();
        assertEquals("Enter the student id to search: ---------------------------------------\nStudent ID: 1\nStudent Name: John\nStudent Age: 18\nStudent Email: john@example.com\nStudent Course: Computer Science\n---------------------------------------\n", outContent.toString());
    }

    @Test
    public void TestSearchForStudent_NotFound() {
        StudentManagementApp app = new StudentManagementApp();

        app.captureNewStudent();
        app.searchForStudent();
        assertEquals("Enter the student id to search: Student with student ID John was not found.\n", outContent.toString());
    }

    @Test
    public void TestDeleteStudent() {
        StudentManagementApp app = new StudentManagementApp();

        app.captureNewStudent();
        app.deleteStudent();
        assertEquals("Enter the student id to delete: Are you sure you want to delete student John from the system? (Yes/No) Student with student ID John was deleted!\n", outContent.toString());
    }

    @Test
    public void TestDeleteStudent_NotFound() {
        StudentManagementApp app = new StudentManagementApp();

        app.captureNewStudent();
        app.deleteStudent();
        assertEquals("Enter the student id to delete: Student with student ID John was not found.\n", outContent.toString());
    }

    @Test
    public void TestPrintStudentReport() {
        StudentManagementApp app = new StudentManagementApp();

        app.captureNewStudent();
        app.printStudentReport();
        assertEquals("STUDENT REPORT\n*****************************************\nStudent ID: 1\nStudent Name: John\nStudent Age: 18\nStudent Email: john@example.com\nStudent Course: Computer Science\n---------------------------------------\n", outContent.toString());
    }
}
