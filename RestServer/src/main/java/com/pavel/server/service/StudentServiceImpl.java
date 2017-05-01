package com.pavel.server.service;

import com.pavel.server.data.base.DBWorker;
import com.pavel.common.enumiration.FormOfTraining;
import com.pavel.common.enumiration.GroupNumber;
import com.pavel.common.enumiration.StudentSex;
import com.pavel.common.model.Student;
import org.apache.log4j.Logger;
import com.pavel.server.sql.ConstForSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrey
 */

/**
 * Класс отвечаюшия за генерацию com.pavel.server.dataBase.sql запросов и отправку на бд
 */
public class StudentServiceImpl /*implements StudentService*/ {
    private DBWorker dbWorker;
    private String sqlForAdd;
    private String sqlForRemoveAll;
    private String sqlForRemoveById;
    private String sqlForGetAll;
    private String sqlForRename;
    public static StudentServiceImpl instance = null;
    private static Logger log = Logger.getLogger(StudentServiceImpl.class);

    /**
     * Создание экземпляра
     */
    private StudentServiceImpl() {
        dbWorker = DBWorker.getInstance();
    }

    /**
     * добавление студента
     *
     * @param firstName - имя студента
     * @param lastName  - фамилия студента
     * @param midleName - отчёство студента
     * @param sex       - пол студента
     * @param form      - форма обучения студента
     * @param group     - группа студента
     */
    public void addStudent(String firstName, String lastName, String midleName, String sex, String form, String group) {
        try {
            dbWorker.openConnection();
            PreparedStatement preparedStatement = dbWorker.getConnection().prepareStatement(ConstForSQL.INSERT_NEW_STUDENT);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, midleName);
            preparedStatement.setInt(4, StudentSex.valueOf(sex).getValue());
            preparedStatement.setInt(5, FormOfTraining.valueOf(form).getValue());
            preparedStatement.setInt(6, GroupNumber.valueOf(group).getValue());
            preparedStatement.execute();
            String sql = preparedStatement.toString();
            setSqlForAdd(sql.substring(sql.indexOf(": ") + 2));
            log.info("add student");
        } catch (SQLException e1) {
            log.error("Could not send request to the DB");
        } finally {
            dbWorker.closeConnection();
        }
    }

    public void addStudent(Student student) {
        try {
            dbWorker.openConnection();
            PreparedStatement preparedStatement = dbWorker.getConnection().prepareStatement(ConstForSQL.INSERT_NEW_STUDENT);
            preparedStatement.setString(1, (String) student.get(1));
            preparedStatement.setString(2, (String) student.get(2));
            preparedStatement.setString(3, (String) student.get(3));
            preparedStatement.setInt(4, StudentSex.valueOf((String) student.get(4)).getValue());
            System.out.println(FormOfTraining.valueOf((String) student.get(5)).getValue());
            preparedStatement.setInt(5, FormOfTraining.valueOf((String) student.get(5)).getValue());
            preparedStatement.setInt(6, GroupNumber.valueOf((String) student.get(6)).getValue());
            preparedStatement.execute();
            String sql = preparedStatement.toString();
            setSqlForAdd(sql.substring(sql.indexOf(": ") + 2));
            log.info("add student");
        } catch (SQLException e1) {
            log.error("Could not send request to the DB");
        } finally {
            dbWorker.closeConnection();
        }
    }

    /**
     * изменение студента
     *
     * @param id        студента для редактирования
     * @param firstName - имя студента
     * @param lastName  - фамилия студента
     * @param midleName - отчёство студента
     * @param sex       - пол студента
     * @param form      - форма обучения студента
     * @param group     - группа студента
     */
    public void renameStudent(int id, String firstName, String lastName, String midleName, String sex, String form, String group) {
        try {
            dbWorker.openConnection();
            PreparedStatement preparedStatement = dbWorker.getConnection().prepareStatement(ConstForSQL.RENAME_STUDENT);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, midleName);
            preparedStatement.setInt(4, StudentSex.valueOf(sex).getValue());
            preparedStatement.setInt(5, FormOfTraining.valueOf(form).getValue());
            preparedStatement.setInt(6, GroupNumber.valueOf(group).getValue());
            preparedStatement.setInt(7, id);
            preparedStatement.execute();
            String sql = preparedStatement.toString();
            setSqlForRename(sql.substring(sql.indexOf(": ") + 2));
            log.info("rename student. id of student for rename = " + id);
        } catch (SQLException e1) {
            log.error("Could not send request to the DB");
        } finally {
            dbWorker.closeConnection();
        }
    }

    public void renameStudent(Student student) {
        try {
            dbWorker.openConnection();
            PreparedStatement preparedStatement = dbWorker.getConnection().prepareStatement(ConstForSQL.RENAME_STUDENT);
            preparedStatement.setString(1, (String) student.get(1));
            preparedStatement.setString(2, (String) student.get(2));
            preparedStatement.setString(3, (String) student.get(3));
            preparedStatement.setInt(4, StudentSex.valueOf((String) student.get(4)).getValue());
            preparedStatement.setInt(5, FormOfTraining.valueOf((String) student.get(5)).getValue());
            preparedStatement.setInt(6, GroupNumber.valueOf((String) student.get(6)).getValue());
            preparedStatement.setInt(7, (Integer) student.get(0));
            preparedStatement.execute();
            String sql = preparedStatement.toString();
            setSqlForRename(sql.substring(sql.indexOf(": ") + 2));
            log.info("rename student. id of student for rename = " + student.get(0));
        } catch (SQLException e1) {
            log.error("Could not send request to the DB");
        } finally {
            dbWorker.closeConnection();
        }
    }

    /**
     * удаление студента по id
     *
     * @param id студента которого необходимо удалить
     */
    public void removeStudentById(int id) {
        try {
            dbWorker.openConnection();
            PreparedStatement preparedStatement = dbWorker.getConnection().prepareStatement(ConstForSQL.DELETE_FROM_STUDENT);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            String sql = preparedStatement.toString();
            setSqlForRemoveById(sql.substring(sql.indexOf(": ") + 2));
            log.info("remove student whose id = " + id);
        } catch (SQLException e1) {
            log.error("Could not send request to the DB");
        } finally {
            dbWorker.closeConnection();
        }
    }

    /**
     * удаление всех студентов
     */
    public void removeAllStudent() {
        try {
            dbWorker.openConnection();
            PreparedStatement preparedStatement = dbWorker.getConnection().prepareStatement(ConstForSQL.DELETE_ALL_FROM_STUDENT);
            preparedStatement.execute();
            String sql = preparedStatement.toString();
            setSqlForRemoveAll(sql.substring(sql.indexOf(": ") + 2));
            log.info("remove all student: ");
        } catch (SQLException e1) {
            log.error("Could not send request to the DB");
        } finally {
            dbWorker.closeConnection();
        }
    }

    /**
     * получение студента по id
     *
     * @param id - id студента для удаления
     * @return найденного студента
     */
    public Student getStudentById(int id) {
        //com.pavel.common.model.Student[] students = getAllStudent();
        List<Student> studentList = getAllStudent();
        for (Student student : studentList) {
            if (student.getId() == id) {
                log.info("get student whose id = " + id);
                return student;
            }
        }
        return null;
    }

    /**
     * получение всех студентов
     *
     * @return лист студентов
     */
    public List<Student> getAllStudent() {
        List<Student> studentList = new ArrayList<Student>();
        try {
            dbWorker.openConnection();
            Statement statement = dbWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(ConstForSQL.SELECT_ALL_FROM_STUDENT);
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setFirstName(resultSet.getString(2));
                student.setLastName(resultSet.getString(3));
                student.setMidleName(resultSet.getString(4));
                student.setSex(StudentSex.getById(resultSet.getInt(5)));
                student.setForm(FormOfTraining.getById(resultSet.getInt(6)));
                student.setGroup(GroupNumber.getById(resultSet.getInt(7)));
                studentList.add(student);
            }
            setSqlForGetAll(ConstForSQL.SELECT_ALL_FROM_STUDENT);
        } catch (SQLException e) {
            log.error("Could not send request to the DB");
        } finally {
            dbWorker.closeConnection();
        }
        Student[] students = new Student[studentList.size()];
        for (int i = 0; i < studentList.size(); i++) {
            students[i] = studentList.get(i);
        }
        return studentList;
    }

    public String getSqlForAdd() {
        return sqlForAdd;
    }

    private void setSqlForAdd(String sqlForAdd) {
        this.sqlForAdd = sqlForAdd;
    }

    public String getSqlForRemoveAll() {
        return sqlForRemoveAll;
    }

    private void setSqlForRemoveAll(String sqlForRemoveAll) {
        this.sqlForRemoveAll = sqlForRemoveAll;
    }

    public String getSqlForRemoveById() {
        return sqlForRemoveById;
    }

    private void setSqlForRemoveById(String sqlForRemoveById) {
        this.sqlForRemoveById = sqlForRemoveById;
    }

    public String getSqlForGetAll() {
        return sqlForGetAll;
    }

    private void setSqlForGetAll(String sqlForGetAll) {
        this.sqlForGetAll = sqlForGetAll;
    }

    public String getSqlForRename() {
        return sqlForRename;
    }

    private void setSqlForRename(String sqlForRename) {
        this.sqlForRename = sqlForRename;
    }

    public static StudentServiceImpl getInstance() {
        if (instance == null) {
            instance = new StudentServiceImpl();
        }
        return instance;
    }
}