import java.util.ArrayList;
import java.util.List;

public class World {

    private int width;
    private int height;

    private Nest nest;

    private List<FoodSource> foodSources;
    private List<Pheromone> pheromones;

    private Colony<Ant> colony;

    public World(int width, int height) {

        this.width = width;
        this.height = height;

        foodSources =
                new ArrayList<FoodSource>();

        pheromones =
                new ArrayList<Pheromone>();

        nest =
                new Nest(
                        width / 2,
                        height / 2
                );

        colony =
                new Colony<Ant>();
    }

    /*
     * Exception handling.
     * Makes sure ants cannot move outside
     * the simulation boundaries.
     */
    public void validatePosition(
            double x,
            double y)
            throws InvalidPositionException {

        if (x < 0 ||
                x > width ||
                y < 0 ||
                y > height) {

            throw new InvalidPositionException(
                    "Position is outside the simulation."
            );
        }
    }

    /*
     * Original pheromone method.
     */
    public void addPheromone(
            Pheromone pheromone) {

        pheromones.add(pheromone);
    }

    /*
     * Overloaded method 1.
     */
    public void addPheromone(
            double x,
            double y) {

        addPheromone(
                new Pheromone(
                        x,
                        y,
                        1.0
                )
        );
    }

    /*
     * Overloaded method 2.
     */
    public void addPheromone(
            double x,
            double y,
            double strength) {

        addPheromone(
                new Pheromone(
                        x,
                        y,
                        strength
                )
        );
    }

    public void addFoodSource(
            FoodSource food) {

        foodSources.add(food);
    }

    public FoodSource findNearbyFood(
            double x,
            double y,
            double range) {

        for (FoodSource food : foodSources) {

            double dx =
                    food.getX() - x;

            double dy =
                    food.getY() - y;

            double distance =
                    Math.sqrt(
                            dx * dx +
                            dy * dy
                    );

            if (distance <= range &&
                    food.hasFood()) {

                return food;
            }
        }

        return null;
    }

    public void update() {

        colony.updateAll();

        for (Pheromone pheromone :
                pheromones) {

            pheromone.decay();
        }

        removeInactivePheromones();
    }

    private void removeInactivePheromones() {

        List<Pheromone> active =
                new ArrayList<Pheromone>();

        for (Pheromone pheromone :
                pheromones) {

            if (pheromone.isActive()) {

                active.add(pheromone);
            }
        }

        pheromones = active;
    }

    public void createInitialColony() {

        /*
         * Three Scouts
         */
        for (int i = 0; i < 3; i++) {

            colony.addAnt(
                    new Scout(
                            nest.getX(),
                            nest.getY(),
                            this
                    )
            );
        }

        /*
         * Eight Foragers
         */
        for (int i = 0; i < 8; i++) {

            colony.addAnt(
                    new Forager(
                            nest.getX(),
                            nest.getY(),
                            this
                    )
            );
        }

        /*
         * Two Soldiers
         */
        for (int i = 0; i < 2; i++) {

            colony.addAnt(
                    new Soldier(
                            nest.getX(),
                            nest.getY(),
                            this
                    )
            );
        }
    }

    public void createFoodSources() {

        addFoodSource(
                new FoodSource(
                        100,
                        150,
                        200
                )
        );

        addFoodSource(
                new FoodSource(
                        650,
                        450,
                        200
                )
        );

        addFoodSource(
                new FoodSource(
                        700,
                        100,
                        200
                )
        );
    }

    public int getWidth() {

        return width;
    }

    public int getHeight() {

        return height;
    }

    public Nest getNest() {

        return nest;
    }

    public List<FoodSource> getFoodSources() {

        return foodSources;
    }

    public List<Pheromone> getPheromones() {

        return pheromones;
    }

    public Colony<Ant> getColony() {

        return colony;
    }
}