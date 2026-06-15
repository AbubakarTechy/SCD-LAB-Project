import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    Main app = new Main();

    @Test
    public void testGradeA() {
        assertEquals("A", app.calculateGrade(90));
    }

    @Test
    public void testGradeB() {
        assertEquals("B", app.calculateGrade(75));
    }

    @Test
    public void testGradeC() {
        assertEquals("C", app.calculateGrade(65));
    }

    @Test
    public void testGradeD() {
        assertEquals("D", app.calculateGrade(55));
    }

    @Test
    public void testGradeF() {
        assertEquals("F", app.calculateGrade(40));
    }

    @Test
    public void testBoundary() {
        assertEquals("A", app.calculateGrade(100));
        assertEquals("F", app.calculateGrade(0));
    }
}