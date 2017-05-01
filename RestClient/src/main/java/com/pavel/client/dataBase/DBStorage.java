package com.pavel.client.dataBase;



import com.pavel.common.model.Student;
import com.pavel.client.service.StudentService;

import java.util.ArrayList;
import java.util.List;

/**
 * модель описывающая локальную бд
 */
public class DBStorage {
    private static DBStorage instance = null;
    private List<Student> studentList = new ArrayList();

    /**
     * создание экземпляра класса
     */
    public DBStorage() {

    }

    public static DBStorage getInstance() {
        if (instance == null) {
            instance = new DBStorage();
        }
        return instance;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    /**
     * обновление списка студентов
     */
    public void updateStudentList() {
        studentList = StudentService.getInstance().getAllStudents();
    }
}
