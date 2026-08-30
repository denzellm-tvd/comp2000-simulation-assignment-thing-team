public class Main {

    public static void main(String[] args) {

        Map map = new Map(10, 10);

        Cell nestCell = map.getCell(0, 0);
        Cell foodCell = map.getCell(5, 5);

        Nest nest = new Nest(nestCell);
        Food food = new Food(foodCell, 10);

        Ant ant = new Ant(nestCell);

        // Test overloaded move()
        ant.move(foodCell);

        // Test Food override
        food.interact(ant);

        System.out.println("Ant has food: " + ant.hasFood());
        System.out.println("Food remaining: " + food.getAmount());

        // Move back to nest
        ant.move(nestCell);

        // Test Nest override
        nest.interact(ant);

        System.out.println("Ant has food: " + ant.hasFood());
        System.out.println("Food stored in nest: " + nest.getStoredFood());
    }
}
