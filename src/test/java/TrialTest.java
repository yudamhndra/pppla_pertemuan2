import org.example.Trial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrialTest {

    @Test
    void testTrialMethod(){
        Trial trial = new Trial();
        Assertions.assertEquals("Test", trial.trialMethod());
        System.out.println("test 1 passed");
    }

    @Test
    void testTrialMethod2(){
        System.out.println("test 2 passed");
    }

    @Test
    void testTrialMethod3(){
        System.out.println("test 3 passed");
    }

    @Test
    void testTrialMethodNull(){
        Trial trial = new Trial();
        Assertions.assertNull(trial.trialMethodNull(), "your result isnotnull");
        System.out.println("Test Null passed");
    }

    @Test
    void testTrialMethodNotNull(){
        Trial trial = new Trial();
        Assertions.assertNotNull(trial.trialMethodNotNull());
    }

}
