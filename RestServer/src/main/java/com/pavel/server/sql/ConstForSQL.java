package com.pavel.server.sql;


/**
 * константы для SQL
 */
public final class ConstForSQL {
    public static final String INSERT_NEW_STUDENT = "INSERT INTO Student (nameOfSudent, surName, secondName, sex, formOfTrainingenum, groupNumber) VALUES(?,?,?,?,?,?)";

    public static final String RENAME_STUDENT = "UPDATE Student SET nameOfSudent = ?, surName = ?, secondName = ?, sex = ?, formOfTrainingenum = ?, groupNumber = ?  WHERE id = ?";

    public static final String SELECT_ALL_FROM_STUDENT = "SELECT * FROM Student";

    public static final String DELETE_FROM_STUDENT = "DELETE LOW_PRIORITY FROM Student WHERE id = ?";
    public static final String DELETE_ALL_FROM_STUDENT = "DELETE LOW_PRIORITY FROM Student";
    
}
