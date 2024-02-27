import org.example.ScoreCollection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ScoreCollectionTest {

    private ScoreCollection scoreCollection;

    @BeforeEach
    void setUp() {
        scoreCollection = new ScoreCollection();
    }

    @Test
    void testAverageScore_EmptyCollection() {
        double average = scoreCollection.averageScore();

        assertEquals(0.0, average, "Expected average of 0 for an empty collection");

        System.out.println("Passed!!");
    }

    @Test
    void testAverageScore_SingleScore() {
        scoreCollection.addScore(5);

        double average = scoreCollection.averageScore();

        assertEquals(5.0, average, "Expected average of 5 for a single score");

        System.out.println("Passed!!");
    }

    @Test
    void testAverageScore_MultipleScores() {
        scoreCollection.addScore(7);
        scoreCollection.addScore(9);
        scoreCollection.addScore(11);

        double average = scoreCollection.averageScore();

        assertEquals(9.0, average, "Expected average of 20 for scores 10, 20, 30");

        System.out.println("Passed!!");
    }
}

