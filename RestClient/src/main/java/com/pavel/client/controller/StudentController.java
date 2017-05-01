package com.pavel.client.controller;



/**
 * @author Andrey
 */

import com.pavel.common.model.Student;
import com.pavel.client.teacher.StudentTable;
import com.pavel.client.view.frame.Dialog.teacher.AddStudentJFrame;
import com.pavel.client.view.frame.Dialog.teacher.EditStudentJFrame;

/**
 * класс, отвечающий за обработку событий в главном фрейме
 */
public class StudentController {
    private AddStudentJFrame addStudentJFrame;
    private EditStudentJFrame editStudentJFrame;
    private StudentTable studentTable;

    public StudentController(StudentTable studentTable) {
        this.studentTable = studentTable;
    }

    /**
     * открытие фрейма для добавления студента
     */
    public void newAddDialog() {
        if(addStudentJFrame == null) {
            addStudentJFrame = new AddStudentJFrame(studentTable);
        }
        addStudentJFrame.setVisible(true);
    }

    /**
     * открытие фрейма для изменения студента
     */
    public void newRenameDialog(Student student) {
        if(editStudentJFrame == null) {
            editStudentJFrame = new EditStudentJFrame(studentTable, student);
        }
        editStudentJFrame.setJTextField(student);
        editStudentJFrame.setVisible(true);
    }
}
