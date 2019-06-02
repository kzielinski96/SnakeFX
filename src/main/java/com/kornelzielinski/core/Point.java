package com.kornelzielinski.core;

import java.util.Objects;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point translate(int dx, int dy) {
        return new Point(x + dx, y + dy);
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x & y == point.y;
    }

    @Override
    public String toString() {
        return "Point[" +
                "x=" + x +
                ", y=" + y +
                "]";
    }
}
