package src;

public class Cell {
    private final int x;
    private final int y;
    private double pheromone;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.pheromone = 0.0;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public double getPheromone() { return pheromone; }

    public void addPheromone(double amount) {
        if (amount > 0) pheromone += amount;
    }

    public void evaporate(double rate) {
        if (rate < 0 || rate > 1) {
            throw new IllegalArgumentException("Evaporation rate must be between 0 and 1.");
        }
        pheromone *= (1.0 - rate);
        if (pheromone < 0.0001) pheromone = 0.0;
    }
}

