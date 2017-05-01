package com.pavel.client.controller.frame;


import com.pavel.common.enumiration.FormOfTraining;
import com.pavel.common.enumiration.GroupNumber;
import com.pavel.common.enumiration.StudentSex;
import com.pavel.common.model.Student;
import com.pavel.client.dataBase.DBStorage;
import com.pavel.client.service.StudentService;
import com.pavel.client.teacher.StudentTable;

/**
 * класс, обрабатывающий события с фрейма редактирования
 */
public class EditStudentJFrameController {
    private StudentTable studentTable;

    public EditStudentJFrameController(StudentTable studentTable) {
        this.studentTable = studentTable;
    }

    /**
     *
     * @param id студента для редактирования
     * @param name - имя
     * @param surName - фамилия
     * @param secondName - отчество
     * @param sex - пол
     * @param formOfTrainingenum - форма обучения
     * @param groupNumber - номер группы
     */
    public void renameStudent(int id, String name, String surName, String secondName, int sex, int formOfTrainingenum, int groupNumber  ) {
        Student student = new Student(name, surName, secondName, StudentSex.getById(sex), GroupNumber.getById(groupNumber), FormOfTraining.getById(formOfTrainingenum));
        student.setId(id);
        StudentService.getInstance().updateStudent(student);
        DBStorage.getInstance().updateStudentList();
        studentTable.setStudentList(DBStorage.getInstance().getStudentList());
        studentTable.fireTableDataChanged();

    }

    public void setStudentTable(StudentTable studentTable) {
        this.studentTable = studentTable;
    }

}
