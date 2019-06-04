package conways;

import conways.model.World;
import conways.view.View;

public class Main {
    public Main() {
        World world = new World(1000, 1000);
        world.setAlive(5, 5);
        world.setAlive(6, 5);
        world.setAlive(7, 5);

        View view = new View();
        view.setWorld(world);
    }

    public static void main(String[] args) {

        new Main();
    }
}
