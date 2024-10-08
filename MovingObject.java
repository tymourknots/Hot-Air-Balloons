import java.awt.*;
/**
 * Interface for moving graphical objects. It provides methods to draw the object and 
 * change its position.
 * Based on MovingObject.java on Courseworks.
 * 
 * Original Author: based on Cay Horstmann
 * @author Tymour Aidabole
 * @uni taa2146
 */
public interface MovingObject {
    void draw(Graphics2D g2D);
    void translate(int xChange, int yChange);
}
