package conways.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class WorldTest {

    private static final int WORLD_WIDTH = 3;
    private static final int WORLD_HEIGHT = 4;

    private World world;

    @Before
    public void setUp() {
        world = new World(WORLD_WIDTH, WORLD_HEIGHT);
    }

    @Test
    public void isAlive_should_return_false_on_dead_cell() {
        final int x = 2;
        final int y = 1;

        world.setDead(x, y);

        boolean result = world.isAlive(x, y);

        assertFalse(result);
    }

    @Test
    public void isAlive_should_return_true_on_living_cell() {
        final int x = 2;
        final int y = 1;

        world.setAlive(x, y);

        boolean result = world.isAlive(x, y);

        assertTrue(result);
    }

    @Test(expected = RuntimeException.class)
    public void isAlive_should_throw_exception_on_out_of_bounds() {
        world.isAlive(-1, -1);
    }

    @Test
    public void setAlive_should_set_a_cell_to_true() {
        final int x = 2;
        final int y = 1;

        world.setAlive(x, y);

        boolean result = world.isAlive(x, y);

        assertTrue(result);
    }

    @Test
    public void setAlive_twice_should_set_a_cell_to_true() {
        final int x = 2;
        final int y = 1;

        world.setAlive(x, y);
        world.setAlive(x, y);

        boolean result = world.isAlive(x, y);

        assertTrue(result);
    }

    @Test(expected = RuntimeException.class)
    public void setAlive_should_throw_exception_on_out_of_bounds() {
        int x = world.getWidth();
        int y = 1;

        world.setAlive(x, y);
    }

    @Test
    public void setDead_should_set_a_cell_to_false() {
        final int x = 2;
        final int y = 1;

        world.setDead(x, y);

        boolean result = world.isAlive(x, y);

        assertFalse(result);
    }

    @Test
    public void setDead_twice_should_set_a_cell_to_false() {
        final int x = 2;
        final int y = 1;

        world.setDead(x, y);
        world.setDead(x, y);

        boolean result = world.isAlive(x, y);

        assertFalse(result);
    }

    @Test
    public void getWidth_should_return_width() {
        int result = world.getWidth();

        assertEquals(WORLD_WIDTH, result);
    }
}