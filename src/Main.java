import java.util.Random;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            World world = new World(50, 35);
            Map map = world.getMap();
            Random random = new Random();
            int width = map.getWidth();
            int height = map.getHeight();
            for (int i = 0; i < 3; i++) {
                int randomX = random.nextInt(width);
                int randomY = random.nextInt(height);
                world.addFoodSource(new FoodSource(map.getCell(randomX, randomY), 250, 250));
            }

            Nest nest = world.getColony().getNest();
            for (int i = 0; i < 8; i++) {
                world.getColony().addAnt(new Scout(nest.getPosition()), "Scout");
            }
            for (int i = 0; i < 42; i++) {
                world.getColony().addAnt(new Forager(nest.getPosition()), "Forager");
            }

            JFrame frame = new JFrame("Ant Colony Foraging Simulation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new SimulationPanel(world));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}