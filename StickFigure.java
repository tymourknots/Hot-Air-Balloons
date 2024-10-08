import java.awt.*;
/**
 * The `StickFigure` class represents a stick figure object that can be moved and drawn on a canvas.
 * 
 * @author Tymour Aidabole
 * @uni taa2146
 */
public class StickFigure implements MovingObject {
    private int x, y;
    private final int BASE_Y; // Base position (ground level)
    private int JUMP_HEIGHT; // Maximum height of jump
    private double jumpPhase = 0; // Phase of the jump 

    /**
     * Constructor for `StickFigure` class.
     * 
     * @param x The x coordinate of the stick figure
     * @param y The y coordinate of the stick figure
     * @param jumpHeight The height of the jump
     */
    public StickFigure(int x, int y, int jumpHeight) {
        this.x = x;
        this.BASE_Y = y;
        this.y = y;
        this.JUMP_HEIGHT = jumpHeight;
    }

    /**
     * Sets the jump height of the stick figure.
     * 
     * @param jumpHeight The height of the jump
     */
    public void setJumpHeight(int jumpHeight) {
        this.JUMP_HEIGHT = jumpHeight;
    }

    /**
     * Performs the jump action of the stick figure.
     */
    public void jump() {
        // Use a fixed value or a class member instead of excitementLevel
        double fixedExcitementLevel = 1.0; // Example fixed value
        jumpPhase += fixedExcitementLevel;
        double jumpOffset = Math.sin(jumpPhase) * JUMP_HEIGHT;
        y = BASE_Y - (int) jumpOffset;
    }

    /**
     * Draws the stick figure using the provided graphics context.
     *
     * @param g2D The graphics context to use for drawing.
     */
    @Override
    public void draw(Graphics2D g2D) {
        int headDiameter = 10;
        int bodyHeight = 20;
        int armWidth = 15;
        int legHeight = 15;
    
        // Coordinates for the head (a circle)
        int headX = x - headDiameter / 2;
        int headY = y - headDiameter;
    
        // Body coordinates
        int bodyTopX = x;
        int bodyTopY = y;
        int bodyBottomX = x;
        int bodyBottomY = y + bodyHeight;
    
        // Arms
        int armLeftX = x - armWidth / 2;
        int armRightX = x + armWidth / 2;
        int armY = y + bodyHeight / 3;
    
        // Legs
        int legLeftX = x - armWidth / 4;
        int legRightX = x + armWidth / 4;
        int legY = y + bodyHeight + legHeight;
    
        // Draw head
        g2D.drawOval(headX, headY, headDiameter, headDiameter);
    
        // Draw body
        g2D.drawLine(bodyTopX, bodyTopY, bodyBottomX, bodyBottomY);
    
        // Draw arms
        g2D.drawLine(armLeftX, armY, armRightX, armY);
    
        // Draw legs
        g2D.drawLine(bodyBottomX, bodyBottomY, legLeftX, legY);
        g2D.drawLine(bodyBottomX, bodyBottomY, legRightX, legY);
    }

    /**
     * Translates the position of the stick figure by the specified amounts.
     *
     * @param xChange The amount to translate in the x direction.
     * @param yChange The amount to translate in the y direction.
     */
    @Override
    public void translate(int xChange, int yChange) {
        x += xChange;
        y += yChange;
    }
}
