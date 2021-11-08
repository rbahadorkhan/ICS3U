public class ShapeDriver {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(4,5);
        Rectangle rect2 = new Rectangle(7, 5);

        if (rect1.isSquare())
            System.out.println("Rect 1 is a square.");
        else 
            System.out.println("Rect 1 is not a square.");

        if (rect2.isSquare())
            System.out.println("Rect 2 is a square.");
        else 
            System.out.println("Rect 2 is not a square.");
            

    }
    
}
