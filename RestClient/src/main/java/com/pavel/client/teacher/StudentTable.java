package com.pavel.client.teacher;




import com.pavel.client.enumeration.table.StudentColumnNames;
import com.pavel.common.model.Student;
import com.pavel.client.dataBase.DBStorage;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * класс описывающий модель таблицы для студентов
 */
public class StudentTable extends AbstractTableModel {
    private List<Student> studentList = DBStorage.getInstance().getStudentList();
    /**
     * количество колонок в таблице
     */
    public static final int column = 7;
    private JTable table;

    /**
     * содание экземпляра класса
     */
    public StudentTable() {
    }

    /**
     * заполнение заголовков в таблице
     */
    public static final String columnNames[] = {
            StudentColumnNames.ID.getName(),
            StudentColumnNames.NAME.getName(),
            StudentColumnNames.SURNAME.getName(),
            StudentColumnNames.SECONDNAME.getName(),
            StudentColumnNames.SEX.getName(),
            StudentColumnNames.FORM.getName(),
            StudentColumnNames.GROUP.getName()
    };

    /**
     * получить значение из таблицы
     *
     * @param rowIndex    - строка
     * @param columnIndex - столбец
     * @return студент
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = studentList.get(rowIndex);
        return student.get(columnIndex);
    }


    public String getColumnName(int column) {
        return columnNames[column];
    }

    public int getRowCount() {
        return studentList.size();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public int getColumnCount() {
        return column;
    }


    public Student getSelectedStudent() {
        Student result = null;
        if (table.getSelectedRow() < 0) {
            result = null;
        } else for (Student student : DBStorage.getInstance().getStudentList()) {
            if (student.getId() == (Integer) getValueAt(table.getSelectedRow(), 0)) {
                result = student;
            }
        }
        if (result == null) {
            JOptionPane.showMessageDialog(null, "вы не выбрали студента");
        }
        return result;
    }


    public void setTable(JTable table) {
        this.table = table;
    }
}
