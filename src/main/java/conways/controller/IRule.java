package conways.controller;

public interface IRule {
    boolean shouldSwitch(boolean isAlive, int livingNeighborCount);
}
