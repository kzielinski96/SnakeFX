package com.kornelzielinski.core;

import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    public static final Color COLOR = Color.CORNSILK;
    public static final Color DEAD = Color.RED;

    private Grid grid;
    private int length;
    private boolean safe;
    private List<Point> points;
    private Point head;
    private int x_vel;
    private int y_vel;

    public Snake (Grid grid, Point point) {
        length = 1;
        points = new LinkedList<>();
        points.add(point);
        head = point;
        safe = true;
        this.grid = grid;
        x_vel = 0;
        y_vel = 0;
    }

    public boolean isSafe() {
        return safe || length == 1;
    }

    public List<Point> getPoints() {
        return points;
    }

    public Point getHead() {
        return head;
    }

    public void move() {
        if (!isStill()) {
            shiftTo(head.translate(x_vel, y_vel));
        }
    }

    public void extend() {
        if (!isStill()) {
            growTo(head.translate(x_vel, y_vel));
        }
    }

    public void setUp() {
        if (y_vel == 1 && length > 1) return;
        x_vel = 0;
        y_vel = -1;
    }

    public void setDown() {
        if (y_vel == -1 && length > 1) return;
        x_vel = 0;
        y_vel = 1;
    }

    public void setLeft() {
        if (x_vel == 1 && length > 1) return;
        x_vel = -1;
        y_vel = 0;
    }

    public void setRight() {
        if (x_vel == -1 && length > 1) return;
        x_vel = 1;
        y_vel = 0;
    }

    private boolean isStill() {
        return x_vel == 0 & y_vel == 0;
    }

    private void shiftTo (Point point) {
        checkAndAdd(point);
        points.remove(0);
    }

    private void checkAndAdd (Point point) {
        point = grid.wrap(point);
        safe &= !points.contains(point);
        points.add(point);
        head = point;
    }

    private void growTo(Point point) {
        length++;
        checkAndAdd(point);
    }
}