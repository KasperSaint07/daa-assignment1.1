package metrics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MetricsTest {

    @Test
    void testMetricsCounting() {
        Metrics m = new Metrics();
        m.start();

        // Проверяем счётчики
        m.inComparisons();
        m.inComparisons();
        m.inOperations();

        // Check deppppppppth of the recursion
        m.enterRecursion();
        m.enterRecursion();
        m.exitRecursion();

        // stop time
        m.stop();

        // Asserts
        assertEquals(2, m.getComparisons());
        assertEquals(1, m.getOperations());
        assertEquals(2, m.getMaxDepth());
        assertTrue(m.getTimeMillis() >= 0);
    }
}
