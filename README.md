# HOT AIR BALLOON

This project is an interactive Java GUI application that simulates a "hot air balloon ascension" using the AWT and Swing libraries. It features multiple animated hot air balloons of varying sizes rising across the screen, along with stick figure observers that jump in excitement. Users can control the ascent speed of the balloons and the jump height of the stick figures through sliders. The project utilizes the Composite pattern to combine graphical shapes and the Observer pattern to handle user interactions and real-time updates, resulting in a dynamic and responsive visual display.

## Lessons Learned

I applied key principles of Object-Oriented Programming (OOP) to build a dynamic interactive Java GUI using AWT and Swing. I focused on creating well-structured classes using inheritance and interfaces, while incorporating Composite and Observer design patterns. Implementing MovingObject and Ascension interfaces allowed me to ensure consistent behavior across different graphical components like hot air balloons and stick figures.

I learned to leverage the Composite pattern by combining multiple shapes (e.g., Ellipse2D and Rectangle2D) into a single GeneralPath, making it easier to treat complex graphics as one object. I also implemented the Observer pattern using JSliders and ChangeListeners to dynamically adjust the state of various elements, enabling smooth, interactive behavior. Additionally, using Timer for animations provided valuable experience in updating positions and redrawing components in real-time.

## Skills Gained

### 1. Object-Oriented Design & Implementation: 

Developed modular, maintainable code using interfaces, polymorphism, and composition.

### 2. Event-Driven Programming: 

Gained hands-on experience with ActionListener and ChangeListener to handle user inputs and control program behavior.

### 3. Graphical Programming: 

Built custom graphics and animations using Java’s Graphics2D and GeneralPath.

### 4. Implementing Design Patterns: 

Applied Composite and Observer patterns to manage complex object hierarchies and ensure responsiveness.

### 5. GUI Component Management: 

Organized layouts using BorderLayout and incorporated interactive elements like sliders and buttons.

## Problems Solved

### 1. Combining Multiple Shapes into a Single Composite Object: 

I successfully used GeneralPath to aggregate different shapes into a cohesive unit, making drawing and manipulation simpler.

### 2. Managing Multi-Object Animation: 

By leveraging Timer and ActionListener, I animated multiple balloons and stick figures simultaneously, ensuring smooth motion without flickering or lag.

### 3. User Interaction through Observer Pattern: 

Implemented sliders to control the speed of balloon ascension and stick figure jumps, effectively managing user input and real-time updates.

### 4. Handling Random Placement and Sizing: 

Dealt with random balloon sizes and placements while maintaining visual appeal and avoiding overlaps.

### 5. Maintaining Smooth Motion: 

Adjusted position offsets and coordinates to create smooth movement for both jumping figures and rising balloons, avoiding jitter and inconsistent animation.
