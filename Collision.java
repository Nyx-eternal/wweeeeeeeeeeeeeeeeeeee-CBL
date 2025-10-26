import java.awt.Rectangle;

public final class Collision {
    private Collision() {}
    public static boolean rectsIntersect(Rectangle a, Rectangle b) {
        return a.intersects(b);
    }
}
