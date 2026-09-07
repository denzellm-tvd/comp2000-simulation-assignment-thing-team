import javax.swing.JFrame;
import javax.swing.Timer;

public class SimulationFrame extends JFrame {

    private World world;
    private SimulationPanel panel;

    public SimulationFrame(World world) {

        this.world = world;

        panel =
                new SimulationPanel(world);

        setTitle(
                "Ant Colony Foraging Simulation"
        );

        setSize(
                world.getWidth(),
                world.getHeight()
        );

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        add(panel);

        setLocationRelativeTo(null);

        Timer timer =
                new Timer(
                        40,
                        e -> {

                            world.update();

                            panel.repaint();
                        }
                );

        timer.start();
    }
}