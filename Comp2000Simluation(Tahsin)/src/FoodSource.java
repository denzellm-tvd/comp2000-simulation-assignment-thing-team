public class FoodSource {

    private int x;
    private int y;
    private int foodAmount;

    public FoodSource(int x, int y, int foodAmount) {
        this.x = x;
        this.y = y;
        this.foodAmount = foodAmount;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public boolean hasFood() {
        return foodAmount > 0;
    }

    public int collectFood(int amount) {

        int collected = Math.min(amount, foodAmount);

        foodAmount -= collected;

        return collected;
    }
}