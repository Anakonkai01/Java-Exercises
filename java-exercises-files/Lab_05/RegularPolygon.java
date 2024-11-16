public class RegularPolygon {
    // atributes
    private String name;
    private int edgeAmount;
    private double edgeLength;
    
    //constructor
    public RegularPolygon(){
        this.name = "";
        this.edgeAmount = 3;
        this.edgeLength = 1;
    }
    public RegularPolygon(String name, int edgeAmount, double edgeLength){
        this.name = name;
        this.edgeAmount = edgeAmount;
        this.edgeLength = edgeLength;
    }
    public RegularPolygon(String name, int edgeAmount){
        this.name = name;
        this.edgeAmount = edgeAmount;
        this.edgeLength = 1;
    }
    public RegularPolygon(RegularPolygon polygon){
        this.name = polygon.name;
        this.edgeAmount = polygon.edgeAmount;
        this.edgeLength = polygon.edgeLength;
    }

    //getters and setters
    public void setAgeAmount(int edgeAmount) {
        this.edgeAmount = edgeAmount;
    }
    public void setEdgeLength(double edgeLength) {
        this.edgeLength = edgeLength;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAgeAmount() {
        return edgeAmount;
    }
    public double getEdgeLength() {
        return edgeLength;
    }
    public String getName() {
        return name;
    }

    // other methods
    public String getPolygon(){
        if(edgeAmount == 3) return "Triangle";
        if(edgeAmount == 4) return "Quadrangle";
        if(edgeAmount == 5) return "Pentagon";
        if(edgeAmount == 6) return "Hexagon";
        if(edgeAmount >6) return "Polygon has the number of edges greater than 6";
        return "undefined";
    }
    public double getPerimeter(){
        return edgeLength*edgeAmount;
    }
    public double getArea(){
        if(edgeAmount == 3) return edgeLength*edgeLength*0.433;
        if(edgeAmount == 4) return edgeLength*edgeLength;
        if(edgeAmount == 5) return edgeLength*edgeLength*1.72;
        if(edgeAmount == 6) return edgeLength*edgeLength*2.595;
        return -1;
    }

    @Override
    public String toString(){
        return name+" - "+getPolygon()+" - "+getArea();
    }

    public static void main(String[] args) {
        RegularPolygon polygon = new RegularPolygon("q1",4);
        System.out.println(polygon);
    }
}


