import java.util.List;
import java.util.Random;

public class Forager extends Ant {
    private final Random random = new Random();

    public Forager(Cell position) {
        super(position);
    }

    @Override
    public Cell chooseNextCell(Map map) {
        List<Cell> neighbours = map.getNeighbours(position);
        if (neighbours.isEmpty()) {
            return position;
        }

        double strongest = neighbours.stream()
                .mapToDouble(Cell::getPheromone)
                .max()
                .orElse(0.0);

        if (strongest == 0.0 || random.nextDouble() < 0.20) {
            return neighbours.get(random.nextInt(neighbours.size()));
        }

        List<Cell> bestCells = neighbours.stream()
                .filter(cell -> Math.abs(cell.getPheromone() - strongest) < 0.000001)
                .toList();

        return bestCells.get(random.nextInt(bestCells.size()));
    }
}
