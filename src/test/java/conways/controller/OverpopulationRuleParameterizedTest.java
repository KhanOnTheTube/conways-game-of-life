package conways.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class OverpopulationRuleParameterizedTest {

    private OverpopulationRule rule = new OverpopulationRule();

    private boolean isAlive;
    private int livingNeighborCount;
    private boolean expectedResult;

    public OverpopulationRuleParameterizedTest(boolean isAlive, int livingNeighborCount, boolean expectedResult) {
        this.isAlive = isAlive;
        this.livingNeighborCount = livingNeighborCount;
        this.expectedResult = expectedResult;
    }

    @Parameters
    public static List<Object[]> parameters() {
        return Arrays.asList(new Object[][] {
                {true, 0, false},
                {true, 1, false},
                {true, 2, false},
                {true, 3, false},
                {true, 4, true},
                {true, 5, true},
                {false, 0, false},
                {false, 1, false},
                {false, 2, false},
                {false, 3, false},
                {false, 4, false},
                {false, 5, false},
        });
    }

    @Test
    public void shouldSwitch_should_return_expected_result() {
        boolean result = rule.shouldSwitch(isAlive, livingNeighborCount);

        assertEquals(expectedResult, result);
    }
}