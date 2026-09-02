public class Nest extends MapObject {
    private int storedFood;

    public Nest(Cell position) {
        super(position);
        this.storedFood = 0;
    }

    @Override
    public void interact(Ant ant) {
        if (ant != null && ant.isCarryingFood()) {
            ant.dropFood(this);
        }
    }

    public void receiveFood() { storedFood++; }
    public int getStoredFood() { return storedFood; }
}
