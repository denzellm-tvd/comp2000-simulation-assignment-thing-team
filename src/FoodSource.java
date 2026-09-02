public class FoodSource extends MapObject {
    private int amount;

    public FoodSource(Cell position, int amount) {
        super(position);
        if (amount < 0) throw new IllegalArgumentException("Food amount cannot be negative.");
        this.amount = amount;
    }

    @Override
    public void interact(Ant ant) {
        if (ant != null && !ant.isCarryingFood() && takeFood()) {
            ant.pickUpFood(this);
        }
    }

    public boolean isAvailable() { return amount > 0; }

    public boolean takeFood() {
        if (!isAvailable()) return false;
        amount--;
        return true;
    }

    public int getAmount() { return amount; }
}
