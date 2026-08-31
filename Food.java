public class Food extends MapObject {

    private int amount;

    public Food(Cell position, int amount) {
        super(position);
        this.amount = amount;
    }

    @Override
    public void interact(Ant ant) {
        if (amount > 0 && !ant.hasFood()) {
            ant.pickUpFood(this);
            amount--;
        }
    }

    public boolean isAvailable() {
        return amount > 0;
    }

    public int getAmount() {
        return amount;
    }
}
