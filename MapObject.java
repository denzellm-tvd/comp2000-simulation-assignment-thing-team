public abstract class MapObject {

    protected Cell position;

    public MapObject(Cell position) {
        this.position = position;
    }

    public Cell getPosition() {
        return position;
    }

    public abstract void interact(Ant ant);
}