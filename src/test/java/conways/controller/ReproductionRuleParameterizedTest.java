package conways.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ReproductionRuleParameterizedTest {

    private ReproductionRule rule = new ReproductionRule();

    private boolean isAlive;
    private int livingNeighborCount;
    private boolean expectedResult;

    public ReproductionRuleParameterizedTest(boolean isAlive, int livingNeighborCount, boolean expectedResult) {
        this.isAlive = isAlive;
        this.livingNeighborCount = livingNeighborCount;
        this.expectedResult = expectedResult;
    }

    @Parameters
    public static List<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {false, 0, false},
                {false, 1, false},
                {false, 2, false},
                {false, 3, true},
                {false, 4, false},
                {false, 5, false},
                {true, 0, false},
                {true, 1, false},
                {true, 2, false},
                {true, 3, false},
                {true, 4, false},
                {true, 5, false}
        });
    }

    @Test
    public void shouldSwitch_should_return_expected_result() {
        boolean result = rule.shouldSwitch(isAlive, livingNeighborCount);

        assertEquals(expectedResult, result);
    }
}
