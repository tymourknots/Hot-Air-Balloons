import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.*;
/**
 * The `BalloonRunner` class is the main entry point of the program, 
 * designed to demonstrate a Hot Air Balloon in action with interactive features. 
 * This class creates a graphical user interface (GUI) using Java Swing components to showcase a moving Hot Air Balloon and stick figure observers. 
 * The program allows users to control the balloon's ascent or descent speed and the jump height of the stick figure observers through graphical sliders. 
 * It starts by initializing a `JFrame` named `myFrame` to create the main window, and a `Random` object named `random` for random number generation. 
 * Constants configure dimensions, size, speed limits, and jump height limits. 
 * The program calculates the number of observers randomly and creates an instance of `HotAirBalloonAscension` representing the balloon and observers. 
 * It creates GUI components, attaches change listeners to sliders, adjusts the layout, and uses a timer for animation, updating balloon speed and triggering observer jumps. 
 * Finally, it sets the main frame's properties for display.
 * 
 * To find video demonstrations of this program, please visit the file in the Programming directory named: 'Hot Air Balloon Ascension 2023-12-09 23-39-20.mp4'
 * 
 * Original Author: Based on an example by Cay Horstmann
 * @author Tymour Aidabole
 * @uni taa2146
 */
public class BalloonRunner {
    /**
     * The main entry point of the program. It creates and initializes the GUI components,
     * including the main frame, hot air balloon, sliders, and animation timer. User interactions
     * with sliders control the balloon's ascent or descent speed and the jump height of stick figure observers.
     * 
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Hot Air Balloon Ascension");
        Random random = new Random();

        // Constants for the application
        final int FRAME_WIDTH = 800;
        final int FRAME_HEIGHT = 600;
        final int BALLOON_BASE_SIZE = 40;
        final int ICON_W = 400;
        final int ICON_H = 400;
        final int MIN_SPEED = -5;
        final int MAX_SPEED = 5;
        final int INITIAL_SPEED = 0;
        final int MIN_JUMP_HEIGHT = 10;  // Minimum jump height
        final int MAX_JUMP_HEIGHT = 100; // Maximum jump height
        final int INITIAL_JUMP_HEIGHT = 50; // Initial jump height

        // Determine the number of observers
        final int MIN_OBSERVERS = 5;
        final int MAX_OBSERVERS = 10;
        final int OBSERVER_COUNT = MIN_OBSERVERS + random.nextInt(MAX_OBSERVERS - MIN_OBSERVERS + 1);

        // Create an instance of HotAirBalloonAscension with observers
        final Ascension myAscension = new HotAirBalloonAscension(FRAME_WIDTH, FRAME_HEIGHT, BALLOON_BASE_SIZE, OBSERVER_COUNT, INITIAL_JUMP_HEIGHT);
        final MyIcon myIcon = new MyIcon(myAscension, ICON_W, ICON_H);
        final JLabel myLabel = new JLabel(myIcon);

        // Slider for controlling the speed
        JSlider speedSlider = new JSlider(JSlider.VERTICAL, MIN_SPEED, MAX_SPEED, INITIAL_SPEED);
        speedSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // The slider's value will be used in the Timer's ActionListener
            }
        });

        // Slider for controlling the jump height
        JSlider jumpHeightSlider = new JSlider(JSlider.VERTICAL, MIN_JUMP_HEIGHT, MAX_JUMP_HEIGHT, INITIAL_JUMP_HEIGHT);
        jumpHeightSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int jumpHeight = ((JSlider) e.getSource()).getValue();
                if (myAscension instanceof HotAirBalloonAscension) {
                    for (StickFigure figure : ((HotAirBalloonAscension) myAscension).getObservers()) {
                        figure.setJumpHeight(jumpHeight);
                    }
                }
            }
        });

        // Layout adjustments
        myFrame.setLayout(new BorderLayout());
        myFrame.add(myLabel, BorderLayout.CENTER);
        myFrame.add(speedSlider, BorderLayout.EAST); // Add the speed slider to the frame
        myFrame.add(jumpHeightSlider, BorderLayout.WEST); // Add the jump height slider to the frame

        // Timer for animation
        final int DELAY = 100;
        Timer myTimer = new Timer(DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int speed = speedSlider.getValue(); // Use the slider's value for speed
                myAscension.translate(0, -speed); // Translate based on speed

                // Trigger the jump action for each stick figure
                if (myAscension instanceof HotAirBalloonAscension) {
                    for (StickFigure figure : ((HotAirBalloonAscension) myAscension).getObservers()) {
                        figure.jump();
                    }
                }

                myLabel.repaint();
            }
        });
        myTimer.start();

        // Frame finalization
        myFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);
    }
}