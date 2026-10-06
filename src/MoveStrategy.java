@FunctionalInterface
public interface MoveStrategy {
    Cell choose(Ant ant, Map map);
}
