package patterns;

public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        System.out.print("Red colored " );
        super.draw();
    }
}
