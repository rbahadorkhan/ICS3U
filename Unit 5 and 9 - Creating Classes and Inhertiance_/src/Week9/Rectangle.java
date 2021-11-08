public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double l, double w){
        length = l;
        width = w;


    }
    
    public Rectangle(double side){
        length = side;
        width = side;
    }

    public getArea(){
        return length*width;
    }

    public getPeri(){
        double peri= (length*2) + (width*2);
        return peri;
    }

    public isSquare(){
        return length == width;
    }

    public boolean equals(Object obj){
        if (obj == this)
            return true;
        if (obj instanceof Rectangle){
            return this.length == ((Rectangle) obj).length && this.width == ((Rectangle)obj);
            
        }
    }
}
