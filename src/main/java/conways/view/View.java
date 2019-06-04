package conways.view;

import conways.model.World;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class View {

    private static final String TITLE = "Conway's game of life";

    private JFrame frame;

    private WorldPanel worldPanel;

    public View(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle(TITLE);
        frame.setSize(1024, 768);

        worldPanel = new WorldPanel();
        frame.getContentPane().add(worldPanel);

        frame.setVisible(true);
    }

    public void setWorld(World world){
        worldPanel.setWorld(world);
    }
}
