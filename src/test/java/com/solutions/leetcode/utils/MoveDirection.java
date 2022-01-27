package com.solutions.leetcode.utils;

import java.util.*;

public enum MoveDirection {
    NONE("NONE"),
    RIGHT("RIGHT"),
    LEFT("LEFT"),
    UP("UP"),
    DOWN("DOWN"),
    TOP_LEFT("TOP_LEFT"),
    TOP_RIGHT("TOP_RIGHT"),
    BOTTOM_LEFT("BOTTOM_LEFT"),
    BOTTOM_RIGHT("BOTTOM_RIGHT");

    private final String direction;
    private final GridMovement move;
    private final boolean isBaseDirection;

    MoveDirection(String direction) {
        this.direction = direction;
        switch (direction) {
            case "RIGHT":
                this.move = GridMovement.of(0, 1);
                this.isBaseDirection = true;
                break;
            case "LEFT":
                this.move = GridMovement.of(0, -1);
                this.isBaseDirection = true;
                break;
            case "UP":
                this.move = GridMovement.of(-1, 0);
                this.isBaseDirection = true;
                break;
            case "DOWN":
                this.move = GridMovement.of(1, 0);
                this.isBaseDirection = true;
                break;
            case "TOP_LEFT":
                this.move = GridMovement.of(-1, -1);
                this.isBaseDirection = false;
                break;
            case "TOP_RIGHT":
                this.move = GridMovement.of(-1, 1);
                this.isBaseDirection = false;
                break;
            case "BOTTOM_LEFT":
                this.move = GridMovement.of(1, -1);
                this.isBaseDirection = false;
                break;
            case "BOTTOM_RIGHT":
                this.move = GridMovement.of(1, 1);
                this.isBaseDirection = false;
                break;
            default:
                this.move = GridMovement.of(0, 0);
                this.isBaseDirection = false;
                break;
        }
    }

    public GridMovement getGridMovement() {
        return this.move;
    }

    public String getDirection() {
        return this.direction;
    }

    public static List<MoveDirection> getBaseMoveDirections() {
        return getMoveDirections(true);
    }

    public static List<MoveDirection> getAllMoveDirections() {
        return getMoveDirections(false);
    }

    private static List<MoveDirection> getMoveDirections(boolean baseDirections) {
        List<MoveDirection> list = new ArrayList<>();
        for (MoveDirection d : MoveDirection.values()) {
            if (d == MoveDirection.NONE)
                continue;
            if (baseDirections && !d.isBaseDirection)
                continue;
            list.add(d);
        }
        return list;
    }

    public static MoveDirection from(String direction) {
        for (MoveDirection d : MoveDirection.values()) {
            if (d.direction.equals(direction))
                return d;
        }
        return NONE;
    }
}


