public class Forager extends Ant {
    public Forager(Cell position) {
        super(position, Movement::followPheromone);
    }
}
