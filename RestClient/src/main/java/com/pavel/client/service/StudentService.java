package com.pavel.client.service;

import com.sun.jersey.api.client.GenericType;
import com.pavel.common.model.Student;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by pasha on 29.04.2017.
 */
public class StudentService {
    private ClientConnection clientConnection;
    private static StudentService instance = new StudentService();
    private StudentService() {
        clientConnection = ClientConnection.getInstance();
    }

    public List<Student> getAllStudents(){
        GenericType<List<Student>> genericType = new GenericType<List<Student>>() {};
        List<Student> students = clientConnection.getService().path("students")
                .accept(MediaType.APPLICATION_XML).get(genericType);
        return students;
    }

    public Student getStudentById(int id){
        Student student = clientConnection.getService().path("students")
                .path(String.valueOf(id)).accept(MediaType.APPLICATION_XML)
                .get(Student.class);
        return student;
    }

    public void updateStudent(Student student){
        ClientConnection.getInstance().getService().path("students").post(student);
    }

    public void addStudent(Student student){
        clientConnection.getService().path("students")
                .accept(MediaType.APPLICATION_XHTML_XML).put(student);
    }

    public void deleteStudent(int id){
        clientConnection.getService().path("students").path(String.valueOf(id)).delete();
    }

    public static StudentService getInstance() {
        return instance;
    }
}
