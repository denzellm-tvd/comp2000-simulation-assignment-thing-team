import java.util.List;
import java.util.Random;

public class Scout extends Ant {
    private final Random random = new Random();

    public Scout(Cell position) {
        super(position);
    }

    @Override
    public Cell chooseNextCell(Map map) {
        List<Cell> neighbours = map.getNeighbours(position);
        if (neighbours.isEmpty()) {
            return position;
        }
        return neighbours.get(random.nextInt(neighbours.size()));
    }
}
