import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public final class Movement {
    private static final Random RANDOM = new Random();

    private Movement() {
    }

    public static Cell randomNeighbour(Ant ant, Map map) {
        List<Cell> neighbours = map.getNeighbours(ant.getPosition());
        if (neighbours.isEmpty()) {
            return ant.getPosition();
        }
        return neighbours.get(RANDOM.nextInt(neighbours.size()));
    }

    public static Cell followPheromone(Ant ant, Map map) {
        List<Cell> neighbours = map.getNeighbours(ant.getPosition());
        if (neighbours.isEmpty()) {
            return ant.getPosition();
        }

        double strongest = neighbours.stream()
                .mapToDouble(Cell::getPheromone)
                .max()
                .orElse(0.0);

        if (strongest == 0.0) {
            return neighbours.get(RANDOM.nextInt(neighbours.size()));
        }

        List<Cell> best = neighbours.stream()
                .filter(cell -> Math.abs(cell.getPheromone() - strongest) < 10)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        if (best.isEmpty()) {
            return neighbours.get(RANDOM.nextInt(neighbours.size()));
        }
        return best.get(RANDOM.nextInt(best.size()));
    }

    public static MoveStrategy closestTo(final Cell target) {
        return (Ant ant, Map map) -> map.getNeighbours(ant.getPosition()).stream()
                .min(Comparator.comparingInt((Cell cell) ->
                        Math.abs(cell.getX() - target.getX())
                                + Math.abs(cell.getY() - target.getY())))
                .orElse(ant.getPosition());
    }
}
