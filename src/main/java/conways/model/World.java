package conways.model;

public class World {

    private static final String OUT_OF_BOUNDS_MESSAGE = "The index [%d][%d] is out of bounds [%d][%d]";

    private boolean[][] cells;

    public World(int width, int height) {
        cells = new boolean[width][height];
    }

    public boolean isAlive(int x, int y) {
        outOfBoundsCheck(x, y);

        return cells[x][y];
    }

    public void setAlive(int x, int y) {
        outOfBoundsCheck(x, y);

        cells[x][y] = true;
    }

    public void setDead(int x, int y) {
        outOfBoundsCheck(x, y);

        cells[x][y] = false;
    }

    public int getWidth() {
        return this.cells.length;
    }

    public int getHeight() {
        return this.cells[0].length;
    }

    private void outOfBoundsCheck(int x, int y) throws RuntimeException {
        if (x < 0 || x > getWidth() - 1 || y < 0 || y > getHeight() - 1) {
            String message = String.format(OUT_OF_BOUNDS_MESSAGE, x, y, cells.length - 1, cells[0].length - 1);

            throw new RuntimeException(message);
        }
    }
}
