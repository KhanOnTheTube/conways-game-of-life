package conways.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RuleChainTest {

    @Mock
    private IRule firstRule;

    @Mock
    private IRule secondRule;

    @Mock
    private IRule thirdRule;

    @Captor
    private ArgumentCaptor<Boolean> isAliveCaptor;

    @Captor
    private ArgumentCaptor<Integer> livingCountCaptor;

    private RuleChain ruleChain;

    @Before
    public void setUp() {
        ruleChain = new RuleChain(asList(firstRule, secondRule, thirdRule));
    }

    @After
    public void tearDown(){
        reset(firstRule, secondRule, thirdRule);
    }

    @Test
    public void shouldSwitch_should_return_false_on_all_rules_false() {

        when(firstRule.shouldSwitch(anyBoolean(), anyInt())).thenReturn(false);
        when(secondRule.shouldSwitch(anyBoolean(), anyInt())).thenReturn(false);
        when(thirdRule.shouldSwitch(anyBoolean(), anyInt())).thenReturn(false);

        boolean result = ruleChain.shouldSwitch(true, 8);

        assertFalse(result);
    }

    @Test
    public void shouldSwitch_should_call_each_rule_with_expected_isAlive() {
        boolean result = ruleChain.shouldSwitch(true, 8);

        verify(firstRule).shouldSwitch(eq(true), anyInt());
        verify(secondRule).shouldSwitch(eq(true), anyInt());
        verify(thirdRule).shouldSwitch(eq(true), anyInt());

        assertFalse(result);
    }

    @Test
    public void shouldSwitch_should_call_each_rule_with_expected_neighborCount() {
        boolean result = ruleChain.shouldSwitch(true, 3);

        verify(firstRule).shouldSwitch(anyBoolean(), eq(3));
        verify(secondRule).shouldSwitch(anyBoolean(), eq(3));
        verify(thirdRule).shouldSwitch(anyBoolean(), eq(3));

        assertFalse(result);
    }

    @Test
    public void shouldSwitch_should_not_call_rules_after_one_rule_returning_true() {
        when(firstRule.shouldSwitch(anyBoolean(), anyInt())).thenReturn(false);
        when(secondRule.shouldSwitch(anyBoolean(), anyInt())).thenReturn(true);
        when(thirdRule.shouldSwitch(anyBoolean(), anyInt())).thenReturn(false);

        boolean result = ruleChain.shouldSwitch(true, 8);

        verify(firstRule).shouldSwitch(eq(true), eq(8));
        verify(secondRule).shouldSwitch(eq(true), eq(8));
        verifyZeroInteractions(thirdRule);

        assertTrue(result);
    }

    @Test
    public void shouldSwitch_should_call_rules_with_expected_isAlive() {
        when(firstRule.shouldSwitch(isAliveCaptor.capture(), anyInt())).thenReturn(false);
        when(secondRule.shouldSwitch(isAliveCaptor.capture(), anyInt())).thenReturn(false);
        when(thirdRule.shouldSwitch(isAliveCaptor.capture(), anyInt())).thenReturn(false);

        ruleChain.shouldSwitch(true, 8);

        List<Boolean> allAliveValues = isAliveCaptor.getAllValues();
        assertEquals(3, allAliveValues.size());
        assertTrue(allAliveValues.get(0));
        assertTrue(allAliveValues.get(1));
        assertTrue(allAliveValues.get(2));
    }

    @Test
    public void shouldSwitch_should_call_rules_with_expected_neighborCount() {
        when(firstRule.shouldSwitch(anyBoolean(), livingCountCaptor.capture())).thenReturn(false);
        when(secondRule.shouldSwitch(anyBoolean(), livingCountCaptor.capture())).thenReturn(false);
        when(thirdRule.shouldSwitch(anyBoolean(), livingCountCaptor.capture())).thenReturn(true);

        ruleChain.shouldSwitch(true, 2);

        List<Integer> livingValues = livingCountCaptor.getAllValues();
        assertEquals(3, livingValues.size());
        assertEquals(2, (int)livingValues.get(0));
        assertEquals(2, (int)livingValues.get(1));
        assertEquals(2, (int)livingValues.get(2));
    }
}
