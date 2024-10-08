import java.awt.*;
import javax.swing.*;
/**
* MyIcon class for creating a graphical representation of a moving object.
*
* Based on MyIcon.java on Courseworks.
* Original Author: based on Cay Horstmann

* @author Tymour Aidabole
* @uni taa2146
*/
public class MyIcon implements Icon {
    
    /**
     * Constructor for `MyIcon` class.
     * 
     * @param obj The object to be drawn
     * @param w The width of the icon
     * @param h The height of the icon
     */
    public MyIcon(MovingObject obj, int w, int h) {
        this.obj = obj;
        this.w = w;
        this.h = h;
    }

    /**
     * Gets the width of the icon.
     *
     * @return The width of the icon.
     */
    public int getIconWidth() {
        return w;
    }

    /**
     * Gets the height of the icon.
     *
     * @return The height of the icon.
     */
    public int getIconHeight() {
        return h;
    }

    /**
     * Paints the icon using the provided graphics context.
     *
     * @param c The component to paint on.
     * @param g The graphics context to use for painting.
     * @param x The x coordinate of the icon.
     * @param y The y coordinate of the icon.
     */
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2D = (Graphics2D) g;
        obj.draw(g2D);
    }
    private int w;
    private int h;
    private MovingObject obj;
}