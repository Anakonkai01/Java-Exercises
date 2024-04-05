package exercise3;

public class Main {
    public static void main(String[] args) {
        // Create a MoveableCircle instance
        MoveableCircle circle = new MoveableCircle(0, 0, 1, 1, 5); // Center at (0, 0), speeds (1, 1), radius 5

        // Access and manipulate the center point
        MoveablePoint center = circle.center;
        System.out.println("Initial center point: " + center); // Print initial center point

        // Move the circle
        circle.moveRight(); // Move right
        circle.moveUp();    // Move up

        // Print the updated center point after moving
        System.out.println("Updated center point: " + circle.center);
    }
}
