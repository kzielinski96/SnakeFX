package com.kornelzielinski.core;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private Direction direction;
    private Point headLocation = new Point(0,0);
    private List<Point> tail = new ArrayList<Point>();
    private int height;
    private int width;
    private int blockSize;
    private boolean collidedWithWall = false;

    public Snake(int height, int width, int blockSize) {
        this.direction = Direction.RIGHT;
        this.height = height;
        this.width = width;
        this.blockSize = blockSize;
    }

    public void update() {

        if (tail.size() > 0) {
            tail.remove(tail.size() - 1);
            tail.add(0, new Point(headLocation.getX(), headLocation.getY()));
        }

        switch (direction) {
            case UP:
                headLocation.setY(headLocation.getY() - blockSize);
                if (headLocation.getY() < 0) {
                    collidedWithWall = true;
                    headLocation.setY(0);
                }
                break;
            case DOWN:
                headLocation.setY(headLocation.getY() + blockSize);
                if (headLocation.getY() >= height) {
                    collidedWithWall = true;
                    headLocation.setY(height - blockSize);
                }
                break;
            case LEFT:
                headLocation.setX(headLocation.getX() - blockSize);
                if (headLocation.getX() < 0) {
                    collidedWithWall = true;
                    headLocation.setX(0);
                }
                break;
            case RIGHT:
                headLocation.setX(headLocation.getX() + blockSize);
                if (headLocation.getX() >= width) {
                    collidedWithWall = true;
                    headLocation.setX(width - blockSize);
                }
                break;
            default:
                break;
        }
    }

    public boolean isCollidedWithWall() {
        return collidedWithWall;
    }

    public boolean collidedWithTail() {
        boolean isCollision = false;

        for (Point tailSegment : tail) {
            if (headLocation.equals(tailSegment)) {
                isCollision = true;
                break;
            }
        }

        return isCollision;
    }

    public void addToTail() {
        tail.add(0, new Point(headLocation.getX(), headLocation.getY()));
        System.out.println("Added to tail");
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setHeadLocation(int x, int y) {
        headLocation.setX(x);
        headLocation.setY(y);
    }

    public Point getHeadLocation() {
        return headLocation;
    }

    public List<Point> getTail() {
        return tail;
    }

    public int getBlockSize() {
        return blockSize;
    }
}
