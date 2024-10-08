import java.awt.*;
import java.util.*;
import java.util.List;
/**
 * The `HotAirBalloonAscension` class represents the ascension of hot air balloons and their associated stick figure observers
 * in the graphical application. It manages the creation and movement of balloons and stick figures within the frame.
 * 
 * @author Tymour Aidabole
 * @uni taa2146
 */
public class HotAirBalloonAscension implements Ascension {
    private List<HotAirBalloon> balloons;
    private List<StickFigure> observers = new ArrayList<>(); // List for stick figures
    private Random random = new Random();

    /**
     * Constructor for `HotAirBalloonAscension` class.
     * 
     * @param width The width of the frame
     * @param height The height of the frame
     * @param baseSize The base size of the balloons
     * @param observerCount The number of observers
     * @param jumpHeight The height of the jump
     */
    public HotAirBalloonAscension(int width, int height, int baseSize, int observerCount, int jumpHeight) {
        balloons = new ArrayList<>();
        int balloonCount = 3 + random.nextInt(5);

        // Initialize balloons
        for (int i = 0; i < balloonCount; i++) {
            int size = (int) (baseSize * (0.5 + random.nextDouble() * 1.5));
            int initialX = random.nextInt(width - size);
            int initialY = random.nextInt(height - size);
            balloons.add(new HotAirBalloon(initialX, initialY, size));
        }

        int spacing = width / observerCount; // Divide the screen width by the number of observers
        int margin = spacing / 2; // Margin so they're not right at the edge
        for (int i = 0; i < observerCount; i++) {
            int positionX = margin + i * spacing; // Position each figure evenly spaced
            int groundLevelY = height - 50; // Assuming 50 pixels above the bottom of the screen
        
            observers.add(new StickFigure(positionX, groundLevelY, jumpHeight));
        }
    }

    /**
     * Draws the hot air balloons and stick figures using the provided graphics context.
     *
     * @param g2D The graphics context to use for drawing.
     */
    @Override
    public void draw(Graphics2D g2D) {
        drawAll(g2D);
    }

    /**
     * Draws all hot air balloons and stick figures using the provided graphics context.
     *
     * @param g2D The graphics context to use for drawing.
     */
    @Override
    public void drawAll(Graphics2D g2D) {
        for (HotAirBalloon balloon : balloons) {
            balloon.draw(g2D);
        }
        for (StickFigure figure : observers) {
            figure.draw(g2D);
        }
    }

    /**
     * Translates the hot air balloons and stick figures by the specified amounts.
     *
     * @param xChange The amount to translate in the x direction.
     * @param yChange The amount to translate in the y direction.
     */
    @Override
    public void translate(int xChange, int yChange) {
        translateAll(xChange, yChange);
    }

    /**
     * Translates all hot air balloons and stick figures by the specified amounts.
     *
     * @param xChange The amount to translate in the x direction.
     * @param yChange The amount to translate in the y direction.
     */
    @Override
    public void translateAll(int xChange, int yChange) {
        for (HotAirBalloon balloon : balloons) {
            balloon.translate(xChange, yChange);
        }
    }

    /**
     * Gets the list of stick figure observers in the simulation.
     *
     * @return A list of stick figure observers.
     */
    public List<StickFigure> getObservers() {
        return observers;
    }
}