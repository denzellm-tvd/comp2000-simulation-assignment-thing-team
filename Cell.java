public class Cell {

    private int x;
    private int y;
    private double pheromone;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.pheromone = 0.0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getPheromone() {
        return pheromone;
    }

    public void addPheromone(double amount) {
        pheromone += amount;
    }

    public void evaporate(double rate) {
        pheromone *= (1.0 - rate);
    }
}
