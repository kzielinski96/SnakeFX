package com.kornelzielinski.core;

import java.util.Random;

public class Grid {

    private int height;
    private int width;
    private int pixelsPerSquare;
    Food food;

    public Grid(int height, int width, int pixelsPerSquare) {
        this.height = height;
        this.width = width;
        this.pixelsPerSquare = pixelsPerSquare;
    }

    public void reset() {
        food = new Food(width/2, height/2);
    }

    public boolean foundFood(Snake snake) {
        boolean isIntersected = false;

        if (snake.getHeadLocation().equals(food.getLocation())) {
            isIntersected = true;
        }

        return isIntersected;
    }

    public void addFood() {
        Random random = new Random();
        int x = random.nextInt(width);
        int y = random.nextInt(height);

        x = Math.round(x / pixelsPerSquare) * pixelsPerSquare;
        y = Math.round(y / pixelsPerSquare) * pixelsPerSquare;

        food = new Food(x,y);
        System.out.println(food.toString());
    }

    public Food getFood() {
        return food;
    }
}
