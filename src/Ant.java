public abstract class Ant {
    protected Cell position;
    protected boolean carryingFood;
    protected boolean scouting;

    public Ant(Cell position) {
        if (position == null) {
            throw new IllegalArgumentException("Ant position cannot be null.");
        }
        this.position = position;
        this.carryingFood = false;
        this.scouting = false;
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

    public abstract Cell chooseNextCell(Map map);
}
