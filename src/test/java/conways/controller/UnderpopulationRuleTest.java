package conways.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class UnderpopulationRuleTest {

    @InjectMocks
    public UnderpopulationRule rule;

    @Test
    public void shouldSwitch_should_return_true_on_alive_and_0_living() {
        boolean result = rule.shouldSwitch(true, 0);

        assertTrue(result);
    }

    @Test
    public void shouldSwitch_should_return_true_on_alive_and_1_living() {
        boolean result = rule.shouldSwitch(true, 1);

        assertTrue(result);
    }

    @Test
    public void shouldSwitch_should_return_false_on_alive_and_2_living() {
        boolean result = rule.shouldSwitch(true, 2);

        assertFalse(result);
    }

    @Test
    public void shouldSwitch_should_return_false_on_alive_and_3_living() {
        boolean result = rule.shouldSwitch(true, 3);

        assertFalse(result);
    }

    @Test
    public void shouldSwitch_should_return_false_on_dead_and_0_living() {
        boolean result = rule.shouldSwitch(false, 0);

        assertFalse(result);
    }

    @Test
    public void shouldSwitch_should_return_false_on_dead_and_1_living() {
        boolean result = rule.shouldSwitch(false, 1);

        assertFalse(result);
    }

    @Test
    public void shouldSwitch_should_return_false_on_dead_and_2_living() {
        boolean result = rule.shouldSwitch(false, 2);

        assertFalse(result);
    }

    @Test
    public void shouldSwitch_should_return_false_on_dead_and_3_living() {
        boolean result = rule.shouldSwitch(false, 3);

        assertFalse(result);
    }

}
