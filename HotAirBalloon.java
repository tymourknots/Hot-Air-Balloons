import java.awt.*;
import java.awt.geom.*;
/**
 * HotAirBalloon class for creating a graphical representation of a hot air balloon.
 * This class is adapted from the StickFigure.java example provided Courseworks.
 *
 * Original Author: based on Cay Horstmann
 * @author Tymour Aidabole
 * @uni taa2146
 *
 * This class implements the MovingObject interface and uses Java AWT and Swing
 * for rendering a hot air balloon with a gondola, cables, and an envelope.
 */
public class HotAirBalloon implements MovingObject {

    /**
     * Constructor for `HotAirBalloon` class.
     * 
     * @param x The x coordinate of the balloon
     * @param y The y coordinate of the balloon
     * @param unit The size of the balloon
     */
    public HotAirBalloon(int x, int y, int unit) {
        this.x = x;
        this.y = y;
        this.UNIT = unit;
    }

    /**
     * Translates the position of the hot air balloon by the specified amounts.
     *
     * @param xChange The amount to translate in the x direction.
     * @param yChange The amount to translate in the y direction.
     */
    @Override
    public void translate(int xChange, int yChange) {
        x += xChange;
        y += yChange;
    }

    /**
     * Draws the hot air balloon using the provided graphics context.
     *
     * @param g2D The graphics context to use for drawing.
     */
    @Override
    public void draw(Graphics2D g2D) {
        // Calculate relative positions and dimensions
        int gondolaWidth = UNIT / 2;
        int gondolaHeight = UNIT / 4;
        int gondolaX = x + (UNIT - gondolaWidth) / 2;
        int gondolaY = y + UNIT;

        // Draw the envelope (circle)
        Ellipse2D.Double envelope = new Ellipse2D.Double(x, y, UNIT, UNIT);

        // Draw the gondola (rectangle)
        Rectangle2D.Double gondola = new Rectangle2D.Double(gondolaX, gondolaY, gondolaWidth, gondolaHeight);

        // Draw cables (lines)
        Line2D.Double cableLeft = new Line2D.Double(gondolaX, gondolaY, x + UNIT / 2, y + UNIT);
        Line2D.Double cableRight = new Line2D.Double(gondolaX + gondolaWidth, gondolaY, x + UNIT / 2, y + UNIT);

        // Use GeneralPath to aggregate shapes
        GeneralPath balloon = new GeneralPath();
        balloon.append(envelope, false);
        balloon.append(gondola, false);
        balloon.append(cableLeft, false);
        balloon.append(cableRight, false);

        // Draw the composite balloon
        g2D.draw(balloon);
    }

    private int x, y; 
    private final int UNIT; 

}
