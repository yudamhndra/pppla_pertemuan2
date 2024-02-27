import org.example.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    void testIsDoingMBKM_SemesterKurangDariEnam() {
        Student student = new Student("John", 5, true);
        boolean result = student.isDoingMBKM();
        assertFalse(result, "Expected false since semester is less than 6");
        System.out.println("Test 1 passed");
    }

    @Test
    void testIsDoingMBKM_SemesterEnamIsActive() {
        Student student = new Student("Jane", 6, true);
        boolean result = student.isDoingMBKM();
        assertTrue(result, "Expected true since semester is 6 or more and student is active");
        System.out.println("Test 2 passed");
    }

    @Test
    void testIsDoingMBKM_SemesterEnamIsNotActive() {
        Student student = new Student("Alex", 6, false);
        boolean result = student.isDoingMBKM();
        assertFalse(result, "Expected false since student is not active");
        System.out.println("Test 3 passed");
    }

    @Test
    void testIsDoingMBKM_SemesterLebihDariEnamIsActive() {
        Student student = new Student("Emma", 7, true);
        boolean result = student.isDoingMBKM();
        assertTrue(result, "Expected true since semester is 6 or more and student is active");
        System.out.println("Test 4 passed");
    }
}
