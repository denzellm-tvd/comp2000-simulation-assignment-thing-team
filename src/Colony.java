import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Colony {
    private final List<Ant> ants;
    private final List<Ant> scouts;
    private final List<Ant> foragers;
    private final Nest nest;

    public Colony(Nest nest) {
        if (nest == null) {
            throw new IllegalArgumentException("Colony requires a nest.");
        }
        this.nest = nest;
        this.ants = new ArrayList<>();
        this.scouts = new ArrayList<>();
        this.foragers = new ArrayList<>();
    }

    public void addAnt(Ant ant, String antType) {
        if (ant != null) {
            ants.add(ant);
            if (antType == "Scout") {
                scouts.add(ant);
            } else if (antType == "Forager") { foragers.add(ant); }
        }
    }

    public List<Ant> getAnts() {
        return Collections.unmodifiableList(ants);
    }

    public List<Ant> getScouts() {
        return Collections.unmodifiableList(scouts);
    }

    public List<Ant> getForagers() {
        return Collections.unmodifiableList(foragers);
    }

    public Nest getNest() {
        return nest;
    }

    public void update(World world) {
        Map map = world.getMap();

        for (Ant ant : ants) {
            Cell nextCell;

            if (ant.isReturningHome()) {
                nextCell = chooseStepTowards(ant.getPosition(), nest.getPosition(), map);
            } else {
                nextCell = ant.chooseNextCell(map);
            }

            ant.move(nextCell);

            if (ant.isCarryingFood()) {
                ant.getPosition().addPheromone(10.0);
            }

            if (ant.isScouting()) {
                ant.getPosition().addPheromone(1.0);
            }

            for (FoodSource source : world.getFoodSources()) {
                if (source.getPosition() == ant.getPosition()) {
                    source.interact(ant);
                    break;
                }
                for (Cell cell : map.getNeighbours(source.getPosition())) {
                    if (source.isAvailable()) {
                        source.getPosition().addPheromone(0.012);
                        cell.addPheromone(0.01);
                    } else break;
                }
            }

            if (nest.getPosition() == ant.getPosition()) {
                nest.interact(ant);
            }
        }
    }

    private Cell chooseStepTowards(Cell from, Cell target, Map map) {
        Cell best = from;
        int bestDistance = distance(from, target);

        for (Cell cell : map.getNeighbours(from)) {
            int currentDistance = distance(cell, target);
            if (currentDistance < bestDistance) {
                best = cell;
                bestDistance = currentDistance;
            }
        }

        return best;
    }

    private int distance(Cell a, Cell b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }
}
