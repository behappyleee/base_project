package item10.composition;

import item10.Color;
import item10.Point;

import java.util.Objects;

// Adds a value component without violating the equals contract
public class ColorPoint {

    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color color,
                      Point point) {
        this.point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    /**
     *  Returns the point-view of this color point.
     *
     * */
    public Point asPoint() {
        return point;
    }

}
