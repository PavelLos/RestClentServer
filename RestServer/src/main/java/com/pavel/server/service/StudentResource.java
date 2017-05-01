package com.pavel.server.service;

import com.pavel.common.model.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;
import java.util.List;


@Path("students")
public class StudentResource {
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Student> getAllStudents() {
        List<Student> students = StudentServiceImpl.getInstance().getAllStudent();
        if (students == null) {
            throw new RuntimeException("Can't load all messages");
        }
        return students;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Student getStudentById(@PathParam("id") int id) {
        Student student = StudentServiceImpl.getInstance().getStudentById(id);
        if (student == null) {
            throw new RuntimeException("can't find mesage with id = " + id);
        }
        return student;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void addStudent(JAXBElement<Student> student) {
        StudentServiceImpl.getInstance().addStudent(student.getValue());
    }

    @DELETE
    @Path("{id}")
    public void deleteStudent(@PathParam("id") int id) {
        StudentServiceImpl.getInstance().removeStudentById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void updateStudent(JAXBElement<Student> student) {
        StudentServiceImpl.getInstance().renameStudent(student.getValue());
    }
}
