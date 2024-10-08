import java.awt.*;
/**
 * The `Ascension` interface extends `MovingObject` and defines methods for drawing and translating all objects.
 * Implementing classes must provide concrete implementations for `drawAll` and `translateAll`.
 * 
 * @author Tymour Aidabole
 * @uni taa2146
 */
public interface Ascension extends MovingObject{
    void drawAll(Graphics2D g2D);
    void translateAll(int xChange, int yChange);
}
