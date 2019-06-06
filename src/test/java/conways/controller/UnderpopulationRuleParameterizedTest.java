package conways.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UnderpopulationRuleParameterizedTest {

    private UnderpopulationRule rule = new UnderpopulationRule();

    private boolean isAlive;
    private int livingNeighborCount;
    private boolean expectedResult;

    public UnderpopulationRuleParameterizedTest(boolean isAlive, int livingNeighborCount, boolean expectedResult) {
        this.isAlive = isAlive;
        this.livingNeighborCount = livingNeighborCount;
        this.expectedResult = expectedResult;
    }

    @Parameters
    public static List<Object[]> parameters() {
        return Arrays.asList(new Object[][] {
                {true, 0, true},
                {true, 1, true},
                {true, 2, false},
                {true, 3, false},
                {false, 0, false},
                {false, 1, false},
                {false, 2, false},
                {false, 3, false}
        });
    }

    @Test
    public void should_return_expected_result() {
        boolean result = rule.shouldSwitch(isAlive, livingNeighborCount);

        assertEquals(expectedResult, result);
    }
}