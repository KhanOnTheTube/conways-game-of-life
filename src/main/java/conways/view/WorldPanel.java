package conways.view;

import conways.model.World;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class WorldPanel extends JPanel {

    private static final Color ALIVE_COLOR = Color.BLACK;
    private static final Color GRID_COLOR = Color.BLACK;

    private static final float SCALE_FACTOR = 25;

    private World world;

    @Override
    public void paintComponent(Graphics g) {
        if (world == null){
            return;
        }

        g.setColor(ALIVE_COLOR);

        for (int y = 0; y < world.getHeight(); y++) {
            for (int x = 0; x < world.getWidth(); x++) {
                drawCell(g, x, y);
            }
        }
    }

    public void setWorld(World world) {
        this.world = world;
    }

    private void drawCell(Graphics g, int x, int y) {
        int xUiPosition = (int) (x * SCALE_FACTOR);
        int yUiPosition = (int) (y * SCALE_FACTOR);
        int uiScaleFactor = (int) SCALE_FACTOR;

        g.setColor(GRID_COLOR);
        g.drawRect(xUiPosition, yUiPosition, uiScaleFactor, uiScaleFactor);

        if (world.isAlive(x, y)) {
            g.setColor(ALIVE_COLOR);
            g.fillRect(xUiPosition, yUiPosition, uiScaleFactor, uiScaleFactor);
        }
    }

}
