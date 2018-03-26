import org.junit.Assert;
import org.junit.Test;
import patterns.BuilderPattern;
import patterns.Circle;
import patterns.RedShapeDecorator;
import patterns.Singleton;

public class TestPattern {
    @Test
    public void testBuilderpattern(){
        BuilderPattern.Builder builder = new BuilderPattern.Builder();

        final BuilderPattern sample = builder.withName("aaa")
                .build();

        Assert.assertEquals("aaa",sample.name);
    }

    @Test
    public void testDecoratorPattern(){
        Circle circle = new Circle();
        circle.draw();

        RedShapeDecorator red = new RedShapeDecorator(circle);
        red.draw();
    }

    @Test
    public void testSingleton(){
        Singleton.INSTANCE.singletonmethod();
        Singleton.INSTANCE.singletonmethod("sdsadsa");
    }
}
