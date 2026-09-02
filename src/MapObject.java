public abstract class MapObject {
    protected final Cell position;

    public MapObject(Cell position) {
        if (position == null) throw new IllegalArgumentException("Position cannot be null.");
        this.position = position;
    }

    public Cell getPosition() { return position; }
    public abstract void interact(Ant ant);
}
