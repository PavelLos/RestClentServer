
import com.pavel.common.enumiration.FormOfTraining;
import com.pavel.common.enumiration.GroupNumber;
import com.pavel.common.enumiration.StudentSex;
import com.pavel.server.data.base.DBWorker;
import com.pavel.server.service.StudentServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import static org.junit.Assert.assertEquals;


/**
 * @author Andrey
 */
public class StudentServiceImplTest {
    private DBWorker dbWorker;
    private StudentServiceImpl studentService;

    private final String sqlForAdd = "INSERT INTO Student (nameOfSudent, surName, secondName, sex, formOfTrainingenum, groupNumber) VALUES(\'test\',\'test\',\'test\',1,1,1)";
    private final String sqlForRemoveAll = "DELETE LOW_PRIORITY FROM Student";
    private final String sqlForRemoveById = "DELETE LOW_PRIORITY FROM Student WHERE id = 1";
    private final String sqlForGetAll = "SELECT * FROM Student";
    private final String sqlForRename = "UPDATE Student SET nameOfSudent = \'test1\', surName = \'test1\', secondName = \'test1\', sex = 1, formOfTrainingenum = 1, groupNumber = 1  WHERE id = 1";

    @Before
    public void init() {
        dbWorker = DBWorker.getInstance();
        studentService = StudentServiceImpl.getInstance();
    }

    @After
    public void destroy() {
        dbWorker = null;
        studentService = null;
    }

    @Test
    public void getAllStudentTest() {
        studentService.getAllStudent();
        assertEquals(sqlForGetAll, studentService.getSqlForGetAll());
    }

    @Test
    public void renameStudentByIdTest()  {
        studentService.renameStudent(1, "test1", "test1", "test1", StudentSex.getById(1), FormOfTraining.getById(1), GroupNumber.getById(1));
        assertEquals(sqlForRename, studentService.getSqlForRename());
    }

    @Test
    public void removeStudentByIdTest() {
        studentService.removeStudentById(1);
        assertEquals(sqlForRemoveById, studentService.getSqlForRemoveById());
    }

    @Test
    public void removeAllStudentTest()  {
        studentService.removeAllStudent();
        assertEquals(sqlForRemoveAll, studentService.getSqlForRemoveAll());
    }

    @Test
    public void addStudent()  {
        studentService.addStudent("test", "test", "test", StudentSex.getById(1), FormOfTraining.getById(1), GroupNumber.getById(1));
        assertEquals(sqlForAdd, studentService.getSqlForAdd());
    }


    public static void main(String[] args) {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(StudentServiceImplTest.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }
}

