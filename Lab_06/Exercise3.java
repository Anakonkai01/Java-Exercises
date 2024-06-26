

class Point2D{
    protected float x;
    protected float y;
    public Point2D(){
        this.x = 0.0f;
        this.y = 0.0f;
    }
    public Point2D(float x, float y){
        this.x = x;
        this.y = y;
    }
    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }
    public float[] getXY(){
        return new float[]{x,y};    
    }

    @Override
    public String toString() {
        return "Point2D [x=" + x + ", y=" + y + "]";
    }

    
}

class Point3D extends Point2D{
    private float z;
    public Point3D(){
        super();
        this.z = 0.0f;
    }
    public Point3D(float x, float y, float z){
        super(x,y);
        this.z = z;
    }
    public float getZ() {
        return z;
    }
    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x, float y, float z){
        super.setXY(x,y);
        this.z = z;
    }
    public float[] getXYZ() {
        return new float[]{super.getX(),super.getY(),z};
    }
    @Override
    public String toString() {
        return "Point3D [x=" + super.getX() + ", y=" + super.getY() + ", z=" + z + "]";
    }
    
}


public class Exercise3 {
    public static void main(String[] args) {
        Point3D p3 = new Point3D();
        System.out.println(p3);
        p3.setZ(10);
        System.out.println(p3);
        p3.setXYZ(10, 20, 30);
        System.out.println(p3);
        // float point = p3.getXYZ();
        for(float i : p3.getXYZ()){
            System.out.println(i);
        }
    }
}
