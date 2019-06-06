package conways.controller;

public class UnderpopulationRule implements IRule {
    @Override
    public boolean shouldSwitch(boolean isAlive, int livingNeighborCount) {
        return isAlive && livingNeighborCount < 2;
    }
}
