package br.grupointegrado.bowlingGame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dougl
 */
public class BowlingGameTest {

    private Game g;

    @Before
    public void setup() {
        g = new Game();
    }

    public void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            g.roll(pins);
        }
    }

    @Test
    public void testGutterGame() {
        rollMany(20, 0);
        assertEquals(0, g.score());
    }

    @Test
    public void testAllOnes() {
        rollMany(20, 1);
        assertEquals(20, g.score());
    }

    @Test
    public void testOneSpare() {
        doSpare();
        g.roll(3);
        rollMany(17, 0);
        assertEquals(16, g.score());
    }

    @Test
    public void testOneStrike() {
        doStrike();
        g.roll(3);
        g.roll(4);
        rollMany(16, 0);
        assertEquals(24, g.score());
    }

    @Test
    public void testPerfectGame() {
        rollMany(12, 10);
        assertEquals(300, g.score());
    }

    private void doStrike() {
        g.roll(10);
    }

    private void doSpare() {
        g.roll(5);
        g.roll(5);
    }
}
