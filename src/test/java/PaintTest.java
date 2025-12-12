import javafx.scene.control.Button;
import ui.PaintApplication;
import shapes.ShapeAdapter;
import javafx.scene.control.Labeled;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.junit.Test;
import javafx.scene.shape.Shape;
import org.testfx.framework.junit.ApplicationTest;

import java.util.Iterator;

import static org.junit.Assert.*;

public class PaintTest extends ApplicationTest {

    PaintApplication app;
    private static final String CIRCLE = "CIRCLE";
    private static final String RECTANGLE = "RECTANGLE";
    private static final String TRIANGLE = "TRIANGLE";

    @Override
    public void start(Stage stage) {
        try {
            app = new PaintApplication();
            app.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_draw_circle_programmatically() {
        interact(() -> {
            app.getDrawingPane().addShape(new ShapeAdapter(new Ellipse(20, 20, 30, 30)));
        });
   //     Iterator it = app.getDrawingPane().iterator();
    //    assertTrue(it.next() instanceof Ellipse);
   //     assertFalse(it.hasNext());
    }

    @Test
    public void should_draw_circle() {
        // given:
        clickOn("#circleButton");
        moveBy(60,60);

        // when:
        drag().dropBy(30,30);
        //press(MouseButton.PRIMARY); moveBy(30,30); release(MouseButton.PRIMARY);

        // then:
    //    Iterator it = app.getDrawingPane().iterator();
     //   assertTrue(it.next() instanceof Ellipse);
      //  assertFalse(it.hasNext());
    }

    @Test
    public void should_draw_rectangle() {
        // given:
        Button btn =  lookup("#rectangleButton").queryButton();
        clickOn(btn);
        moveBy(0,60);

        // when:
        drag().dropBy(70,40);

        // then:
     //   Iterator it = app.getDrawingPane().iterator();
     //   assertTrue(it.next() instanceof Rectangle);
       // assertFalse(it.hasNext());
    }

    @Test
    public void should_draw_bermuda_triangle(){
        // given:
        clickOn("Bermuda Triangle");
        moveBy(-60,160);

        // when:
        drag().dropBy(40,40);

        // then:
     //   Iterator it = app.getDrawingPane().iterator();
     //   assertTrue(it.next() instanceof Ellipse);
    //    assertFalse(it.hasNext());
    }

    @Test
    public void should_clear() {
        // given:
        Button btn =  lookup("#rectangleButton").queryButton();
        clickOn(btn);
        moveBy(30,60).drag().dropBy(70,40);
        Button circle =  lookup("#circleButton").queryButton();
        clickOn(circle);
        moveBy(-30,160).drag().dropBy(70,40);
       // clickOn("Bermuda Triangle");
     //   moveBy(-90,260).drag().dropBy(40,40);

        // when:
        clickOn("#clearAllButton");

        // then:
   //     assertFalse(app.getDrawingPane().iterator().hasNext());
    }

    private Labeled statusLabel() {
        return lookup("#statusLabel").queryLabeled();
    }


    @Test
    public void statut_bar_should_update_shape_count(){
        // given:
       Button btn =  lookup("#rectangleButton").queryButton();
        clickOn(btn);
        moveBy(30,60).drag().dropBy(70,40);
        moveBy(-100,-100);

        // when:
        Button circle =  lookup("#circleButton").queryButton();
        clickOn(circle);
        moveBy(-30,160).drag().dropBy(70,40);
        moveBy(-100,-100);

        // then:
        assertEquals("2 forme(s)", statusLabel().getText());
    }

    @Test
    public void statut_bar_should_update_selected_shape_count(){
        // given:
        try{
            Shape triangle = create_shape(TRIANGLE);
            Shape rectangle = create_shape(RECTANGLE);

            press(KeyCode.SHIFT);
            clickOn(triangle);
            clickOn(rectangle);
            release(KeyCode.SHIFT);


            // then:
            assertEquals("2 selected forme(s)", lookup("#selectedLabel").queryLabeled().getText());

        }
        catch (Exception e){}
    }

    @Test
    public void should_clear_selected_shapes(){
        // given:
        try{
            Shape triangle = create_shape(TRIANGLE);
            Shape rectangle = create_shape(RECTANGLE);

            press(KeyCode.SHIFT);
            clickOn(triangle);
            clickOn(rectangle);
            release(KeyCode.SHIFT);

            assertEquals("2 selected forme(s)", lookup("#selectedLabel").queryLabeled().getText());


            // when:
            clickOn("Clear Selected");

            // then:
            assertEquals("0 selected forme(s)", lookup("#selectedLabel").queryLabeled().getText());

            Iterator it = app.getDrawingPane().iterator();
            assertFalse(it.hasNext());

        }
        catch (Exception e){}
    }


    public Shape create_shape(String shapeType) throws Exception {
        switch (shapeType) {
            case RECTANGLE:
                clickOn("Rectangle");
                break;
            case CIRCLE:
                clickOn("Circle");
                break;
            case TRIANGLE:
                clickOn("Bermuda Triangle");
                break;
            default:
                throw new Exception("Error on create shape");
        }

        int x = 20 + app.getDrawingPane().getChildren().size() * 150;
        int y = 200;
        int w = 100;
        moveTo(app.getDrawingPane())
                .moveBy(-PaintApplication.WIDTH / 2 + x, -PaintApplication.HEIGHT / 2 + y)
                .drag().dropBy(w, w);

        return (Shape) app.getDrawingPane().getChildren().get(app.getDrawingPane().getChildren().size() - 1);
    }



}
