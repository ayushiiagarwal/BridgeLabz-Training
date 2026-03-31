import org.junit.jupiter.api.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrailUtilTest {

    private TrailUtil util;

    @BeforeEach
    void setUp() {
        util = new TrailUtil();
        util.addTrailRecord(new Trail("T1", "Trail1", "Himalayas", "Easy", 100));
        util.addTrailRecord(new Trail("T2", "Trail2", "Himalayas", "Hard", 200));
        util.addTrailRecord(new Trail("T3", "Trail3", "Sahyadri", "Easy", 100));
    }

    @Test
    void testGetTrailByIdFound() {
        assertNotNull(util.getTrailById("T1"));
    }

    @Test
    void testGetTrailByIdNotFound() {
        assertNull(util.getTrailById("INVALID"));
    }

    @Test
    void testMostHikedTrails() {
        Set<Trail> result = util.getMostHikedTrails();
        assertEquals(1, result.size());
    }

    @Test
    void testMostHikedEmptyList() {
        TrailUtil empty = new TrailUtil();
        assertTrue(empty.getMostHikedTrails().isEmpty());
    }

    @Test
    void testUpdateHikeCountValid() {
        assertTrue(util.updateHikeCount("T1", 50));
    }

    @Test
    void testUpdateHikeCountInvalidId() {
        assertFalse(util.updateHikeCount("X", 20));
    }

    @Test
    void testUpdateHikeCountNegative() {
        assertFalse(util.updateHikeCount("T1", -10));
    }

    @Test
    void testUpdateHikeCountZero() {
        assertFalse(util.updateHikeCount("T1", 0));
    }

    @Test
    void testFilterTrailsMatch() {
        List<Trail> list = util.filterTrails("Himalayas", "Easy");
        assertEquals(1, list.size());
    }

    @Test
    void testFilterTrailsNoMatch() {
        assertTrue(util.filterTrails("Alps", "Easy").isEmpty());
    }

    @Test
    void testGetTopTrailsByRegion() {
        Map<String, List<Trail>> map = util.getTopTrailsByRegion(1);
        assertEquals(1, map.get("Himalayas").size());
    }

    @Test
    void testDifficultyStats() {
        Map<String, String> stats = util.getDifficultyStats();
        assertTrue(stats.containsKey("Easy"));
        assertTrue(stats.containsKey("Hard"));
    }
}
