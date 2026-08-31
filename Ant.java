public class Ant {

    private Cell position;
    private boolean hasFood;

    public Ant(Cell position) {
        this.position = position;
        this.hasFood = false;
    }

    // Overloading 1
    public void move(Map map) {
        // choose next cell
    }

    // Overloading 2
    public void move(Cell target) {
        position = target;
    }

    public boolean hasFood() {
        return hasFood;
    }

    public void pickUpFood(Food food) {
        hasFood = true;
    }

    public void dropFood(Nest nest) {
        hasFood = false;
        nest.receiveFood();
    }
}