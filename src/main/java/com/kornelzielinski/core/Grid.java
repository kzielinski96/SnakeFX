package com.kornelzielinski.core;

import javafx.scene.paint.Color;

import java.util.List;
import java.util.Random;

public class Grid {
    public static final int SIZE = 10;
    public static final Color COLOR = Color.LIGHTGRAY;

    private int columns;
    private int rows;

    private Snake snake;
    private Food food;
    private Obstacle  obstacle;

    public Grid(double width, double height) {
        rows = (int) width / SIZE;
        columns = (int) height / SIZE;

        snake = new Snake(this, new Point(rows / 2, columns / 2));
        food = new Food(getRandomPoint());
        obstacle = new Obstacle(getRandomPoint());
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    public double getWidth() {
        return rows * SIZE;
    }

    public double getHeight() {
        return columns * SIZE;
    }

    public Point wrap(Point point) {
        int x = point.getX();
        int y = point.getY();

        if (x >= rows) {
//            snake.setSafe(false);
            x = 0;
        }
        if (y >= columns) {
//            snake.setSafe(false);
            y = 0;
        }

        if (x < 0) {
//            snake.setSafe(false);
            x = rows - 1;
        }
        if (y < 0) {
//            snake.setSafe(false);
            y = columns - 1;
        }

        return new Point(x, y);
    }

    private Point getRandomPoint() {
        Random random = new Random();
        Point point;

        do {
            point = new Point(random.nextInt(rows), random.nextInt(columns));
        } while (point.equals(snake.getHead()));
        return point;
    }

    public void update() {
        if (food.getLocation().equals(snake.getHead())) {
            snake.extend();
            food.setLocation(getRandomPoint());
            obstacle.setLocation(getRandomPoint());
        } else if (obstacle.getLocation().equals(snake.getHead())){
            snake.setSafe(false);
        } else {
            snake.move();
        }
    }
}
