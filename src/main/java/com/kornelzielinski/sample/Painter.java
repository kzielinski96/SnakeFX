package com.kornelzielinski.sample;

import com.kornelzielinski.core.Food;
import com.kornelzielinski.core.Grid;
import com.kornelzielinski.core.Point;
import com.kornelzielinski.core.Snake;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static com.kornelzielinski.core.Grid.SIZE;

public class Painter {

    public static void paint(Grid grid, GraphicsContext context) {
        context.setFill(Grid.COLOR);
        context.fillRect(0,0, grid.getWidth(), grid.getHeight());

        context.setFill(Food.COLOR);
        paintPoint(grid.getFood().getLocation(), context);

        Snake snake = grid.getSnake();
        context.setFill(Snake.COLOR);
        snake.getPoints().forEach(point -> paintPoint(point, context));
        if (!snake.isSafe()) {
            context.setFill(Snake.DEAD);
            paintPoint(snake.getHead(), context);
        }

        context.setFill(Color.BEIGE);
        context.fillText("Score: " + 100 * snake.getPoints().size(), 10, 490);
    }

    public static void paintResetMessage(GraphicsContext context) {
        context.setFill(Color.AQUAMARINE);
        context.fillText("Hit RETURN to reset.",10,10);
    }

    private static void paintPoint(Point point, GraphicsContext context) {
        context.fillRect(point.getX() * SIZE, point.getY() * SIZE, SIZE, SIZE);
    }
}
