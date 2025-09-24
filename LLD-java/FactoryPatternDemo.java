interface Shape{
    void draw();
}
class Circle implements Shape{
    public void draw(){
        System.out.println("Inside Circle::draw() method.");
    }
}
class Square implements Shape{
    public void draw(){
        System.out.println("Inside Square::draw() method.");
    }
}
class Rectangle implements Shape{
    public void draw(){
        System.out.println("Inside Rectangle::draw() method.");
    }
}

class ShapeFactory{
    // use getShape method to get object of type shape
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        return null;
    }
}
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // Get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        // Get an object of Square and call its draw method.
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();

        // Get an object of Rectangle and call its draw method.
        Shape shape3 = shapeFactory.getShape("RECTANGLE");
        shape3.draw();
    }
}
