package conways.controller;

public class ReproductionRule implements IRule {

    @Override
    public boolean shouldSwitch(boolean isAlive, int livingNeighborCount) {
        return !isAlive && livingNeighborCount == 3;
    }
}
