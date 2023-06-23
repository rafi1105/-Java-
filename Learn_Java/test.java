interface Shape {
    void draw();
    double calculateArea();
}

class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public void draw() {
        System.out.println("Drawing a rectangle.");
    }

    public double calculateArea() {
        return length * width;
    }
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("Drawing a circle.");
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

public class test {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 3);
        rectangle.draw();
        System.out.println("Area of the rectangle: " + rectangle.calculateArea());

        Circle circle = new Circle(2.5);
        circle.draw();
        System.out.println("Area of the circle: " + circle.calculateArea());
    }
}
