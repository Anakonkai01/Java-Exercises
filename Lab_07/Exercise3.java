interface IMovable {
    public void moveUp();
    public void moveDown();
    public void moveLeft();
    public void moveRight();
}


class MoveablePoint implements IMovable{
    int x;
    int y;
    int xSpeed;
    int ySpeed;

    //constructor
    public MoveablePoint(int x, int y, int xSpeed, int ySpeed){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveDown() {
        y -= ySpeed;
    }
    @Override
    public void moveUp() {
        y += ySpeed;
    }
    @Override
    public void moveLeft() {
        x -= xSpeed;
    }
    @Override
    public void moveRight() {
        x += xSpeed;
    }

    // Override toString() method to provide a meaningful representation
    @Override
    public String toString() {
        return "MoveablePoint [x=" + x + ", y=" + y + ", xSpeed=" + xSpeed + ", ySpeed=" + ySpeed + "]";
    }
}


class MoveableCircle extends MoveablePoint implements IMovable{
    int radius;
    MoveablePoint center;
    public MoveableCircle(int x, int y, int xSpeed, int ySpeed, int radius){
        super(x,y,xSpeed,ySpeed);
        this.radius = radius;
        this.center = new MoveablePoint(x,y,xSpeed,ySpeed);
    }
    @Override
    public String toString() {
        return "MoveableCircle [radius=" + radius + ", center=" + center + "]";
    }
    @Override
    public void moveDown() {
        center.y -= center.ySpeed;
    }
    @Override
    public void moveLeft() {
        center.x -= center.xSpeed;
    }
    @Override
    public void moveRight() {
        center.x += center.xSpeed;
    }
    @Override
    public void moveUp() {
        center.y += center.ySpeed;
    }
    
}



public class Exercise3 {
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
