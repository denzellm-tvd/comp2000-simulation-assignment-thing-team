public class Map {

    private int width;
    private int height;
    private Cell[][] cells;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;

        cells = new Cell[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(x, y);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public boolean inBounds(int x, int y) {
        return x >= 0 && x < width &&
                y >= 0 && y < height;
    }
}
