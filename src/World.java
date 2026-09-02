import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class World {
    private final Map map;
    private final Colony colony;
    private final List<FoodSource> foodSources;

    public World(int width, int height) {
        this.map = new Map(width, height);
        this.colony = new Colony(new Nest(map.getCell(2, height / 2)));
        this.foodSources = new ArrayList<>();
    }

    public void addFoodSource(FoodSource source) {
        if (source != null) foodSources.add(source);
    }

    public void update() {
        colony.update(this);
        map.evaporatePheromones(0.015);
    }

    public Map getMap() { return map; }
    public Colony getColony() { return colony; }
    public List<FoodSource> getFoodSources() { return Collections.unmodifiableList(foodSources); }
}
