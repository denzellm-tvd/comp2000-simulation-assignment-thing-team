import java.util.ArrayList;
import java.util.List;

public class Map {
    private final int width;
    private final int height;
    private final Cell[][] cells;

    public Map(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Map dimensions must be positive.");
        }
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(x, y);
            }
        }
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public Cell getCell(int x, int y) {
        if (!inBounds(x, y)) {
            throw new IndexOutOfBoundsException("Cell is outside the map: (" + x + ", " + y + ")");
        }
        return cells[x][y];
    }

    public List<Cell> getNeighbours(Cell cell) {
        List<Cell> neighbours = new ArrayList<>();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;
                int nx = cell.getX() + dx;
                int ny = cell.getY() + dy;
                if (inBounds(nx, ny)) neighbours.add(cells[nx][ny]);
            }
        }
        return neighbours;
    }

    public boolean inBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public void evaporatePheromones(double rate) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y].evaporate(rate);
            }
        }
    }
}
