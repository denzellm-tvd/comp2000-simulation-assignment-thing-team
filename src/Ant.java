public abstract class Ant {
    protected Cell position;
    protected boolean carryingFood;
    protected boolean scouting;
    protected MoveStrategy strategy;

    public Ant(Cell position, MoveStrategy strategy) {
        if (position == null) {
            throw new IllegalArgumentException("Ant position cannot be null.");
        }
        if (strategy == null) {
            throw new IllegalArgumentException("Move strategy cannot be null.");
        }
        this.position = position;
        this.carryingFood = false;
        this.scouting = false;
        this.strategy = strategy;
    }

    public void move(Cell target) {
        if (target != null) {
            position = target;
        }
    }

    public boolean isCarryingFood() {
        return carryingFood;
    }

    public boolean isReturningHome() {
        return carryingFood;
    }

    public boolean isScouting() {
        return scouting;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public Cell getPosition() {
        return position;
    }

    public void pickUpFood(FoodSource source) {
        if (source != null && !carryingFood) {
            carryingFood = true;
        }
    }

    public void dropFood(Nest nest) {
        if (nest != null && carryingFood) {
            carryingFood = false;
            nest.receiveFood();
        }
    }

    public Cell chooseNextCell(Map map) {
        return strategy.choose(this, map);
    }
}
