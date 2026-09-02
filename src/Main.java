import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            World world = new World(50, 35);
            Map map = world.getMap();

            world.addFoodSource(new FoodSource(map.getCell(42, 8), 250));
            world.addFoodSource(new FoodSource(map.getCell(43, 27), 250));

            Nest nest = world.getColony().getNest();
            for (int i = 0; i < 8; i++) {
                world.getColony().addAnt(new Scout(nest.getPosition()));
            }
            for (int i = 0; i < 42; i++) {
                world.getColony().addAnt(new Forager(nest.getPosition()));
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
