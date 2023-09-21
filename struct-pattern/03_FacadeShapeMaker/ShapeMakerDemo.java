interface Shape {
    void draw();
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

class Circle implements Shape {

    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Triangle implements Shape {
    public void draw() {
        System.out.println("Drawing a triangle");
    }
}

class ShapeMaker {
    private Shape rectangle;
    private Shape circle;
    private Shape triangle;

    public ShapeMaker() {
        this.rectangle = new Rectangle();
        this.circle = new Circle();
        this.triangle = new Triangle();
    }

    public void makeDrawing() {

        System.out.println("Making a drawing:");
        drawRectangle();
        drawCircle();
        drawTriangle();
    }

    public void drawRectangle() {
        this.rectangle.draw();
    }

    public void drawCircle() {
        this.circle.draw();
    }

    public void drawTriangle() {
        this.triangle.draw();
    }
}

public class ShapeMakerDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawRectangle();
        shapeMaker.drawCircle();
        shapeMaker.drawTriangle();

        shapeMaker.makeDrawing();
    }
}