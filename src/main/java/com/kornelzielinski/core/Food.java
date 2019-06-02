package com.kornelzielinski.core;

import javafx.scene.paint.Color;

public class Food {

    public static final Color COLOR = Color.ROSYBROWN;
    private Point location;

    public Food (Point point) {
        location = point;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point point) {
        location = point;
    }
}
