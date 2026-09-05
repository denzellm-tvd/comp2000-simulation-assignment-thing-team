import java.util.Random;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            World world = new World(50, 35);
            Map map = world.getMap();
            Random random = new Random();
            int randomX = random.nextInt(50);
            int randomY = random.nextInt(35);

            //world.addFoodSource(new FoodSource(map.getCell(randomX, randomY), 1));
            //world.addFoodSource(new FoodSource(map.getCell(randomX, randomY), 1));
            for (int i = 0; i < 3; i++) {
                world.addFoodSource(new FoodSource(map.getCell(randomX, randomY), 250, 250));
                randomX = random.nextInt(50);
                randomY = random.nextInt(35);
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
