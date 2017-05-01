package com.pavel.client.view.box;


import com.pavel.client.controller.StudentController;
import com.pavel.client.enumeration.view.ConstForView;
import com.pavel.common.model.Student;
import com.pavel.client.dataBase.DBStorage;
import com.pavel.client.service.StudentService;
import com.pavel.client.teacher.StudentTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CRUDBarStudents extends Box {
    private StudentController studentController;
    private StudentTable studentTable;

    public CRUDBarStudents(StudentTable studentTable) {
        super(0);
        this.studentTable = studentTable;
        studentController = new StudentController(studentTable);

    }

    public void addStudent() {
        JButton newEntry = new JButton(ConstForView.ADD);
        newEntry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                studentController.newAddDialog();
            }
        });

        add(newEntry);

    }

    public void removeStudent() {
        JButton removeEntry = new JButton(ConstForView.REMOVE);
        removeEntry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student student = studentTable.getSelectedStudent();
                if (student != null) {
                    removeStudentById(student);
                }

            }

            private void removeStudentById(Student student) {
                StudentService.getInstance().deleteStudent((Integer) student.get(0));
                DBStorage.getInstance().updateStudentList();
                studentTable.setStudentList(DBStorage.getInstance().getStudentList());
                studentTable.fireTableDataChanged();
            }
        });
        add(removeEntry);
    }

    public void renameStudent() {
        final JButton renameEntry = new JButton(ConstForView.RENAME);
        renameEntry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student student = studentTable.getSelectedStudent();
                if (student != null) {
                    studentController.newRenameDialog(student);
                }
            }


        });
        add(renameEntry);
    }

    public void updateStudent() {
        JButton update = new JButton("Обновить");
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DBStorage.getInstance().updateStudentList();
                studentTable.setStudentList(DBStorage.getInstance().getStudentList());
                studentTable.fireTableDataChanged();
            }
        });
        add(update);
    }
}
