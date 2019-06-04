package com.kornelzielinski.core;

import javafx.scene.paint.Color;

public class Obstacle {

    public static final Color COLOR = Color.BLUE;
    private Point location;

    public Obstacle (Point location) {
        this.location = location;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
