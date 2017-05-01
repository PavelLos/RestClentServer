package com.pavel.client.view.frame;



import com.pavel.client.enumeration.view.ConstForView;
import com.pavel.client.dataBase.DBStorage;
import com.pavel.client.teacher.StudentTable;
import com.pavel.client.view.box.CRUDBarStudents;
import com.pavel.client.view.panel.TableComponent;

import javax.swing.*;
import java.awt.*;

public class StudentsFrame extends JFrame {

    public StudentsFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setTitle(ConstForView.STUDENT);
        setSize(screenWidth / 2 + 10, screenHeight / 2 + 20);
        setLocation(screenWidth / 4, screenHeight / 4);

        StudentTable studentTable = new StudentTable();
        TableComponent tableComponent = new TableComponent(studentTable);

        CRUDBarStudents crudBarStudents = new CRUDBarStudents(studentTable);
        crudBarStudents.addStudent();
        crudBarStudents.removeStudent();
        crudBarStudents.renameStudent();
        crudBarStudents.updateStudent();

        add(crudBarStudents,"South");
        tableComponent.setVisible(true);
        add(tableComponent);
        DBStorage.getInstance().updateStudentList();
        studentTable.setStudentList(DBStorage.getInstance().getStudentList());
        studentTable.fireTableDataChanged();
        setResizable(false);
    }
}
