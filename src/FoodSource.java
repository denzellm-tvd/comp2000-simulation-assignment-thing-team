public class FoodSource extends MapObject {
    private int initialAmount;
    private int amount;

    public FoodSource(Cell position, int amount) {
        this(position, amount, amount);
    }

    public FoodSource(Cell position, int amount, int initialAmount) {
        super(position);
        if (amount < 0 || initialAmount <= 0) {
            throw new IllegalArgumentException("Food amount cannot be negative.");
        }
        this.amount = amount;
        this.initialAmount = initialAmount;
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
    public int getInitialAmount() { return initialAmount; }
    public double getPercent() {
        if (initialAmount <= 0) return 0.0;
        double p = (double) amount / initialAmount;
        if (p < 0) return 0.0;
        if (p > 1) return 1.0;
        return p;
    }
}