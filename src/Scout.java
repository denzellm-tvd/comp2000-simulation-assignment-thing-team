public class Scout extends Ant {
    public Scout(Cell position) {
        super(position, Movement::randomNeighbour);
        this.scouting = true;
    }
}
