package conways.controller;

import java.util.LinkedList;
import java.util.List;

public class RuleChain implements IRule {

    private List<IRule> rules = new LinkedList<>();

    public RuleChain(List<IRule> rules) {
        this.rules.addAll(rules);
    }

    @Override
    public boolean shouldSwitch(boolean isAlive, int livingNeighborCount) {
        return rules.stream()
                .anyMatch(r -> r.shouldSwitch(isAlive, livingNeighborCount));
    }
}
