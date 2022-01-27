package com.solutions.leetcode.utils;

import java.util.*;

public class GridPosition {
    private final int row;
    private final int col;

    public static GridPosition of(int row, int col) {
        return new GridPosition(row, col);
    }

    private GridPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public GridPosition move(MoveDirection moveDirection) {
        var move = moveDirection.getGridMovement();
        return new GridPosition(this.row + move.getRowMove(), this.col + move.getColMove());
    }

    public List<GridPosition> moveBaseDirections() {
        List<GridPosition> list = new ArrayList<>(4);
        for(MoveDirection moveDirection : MoveDirection.getBaseMoveDirections()){
            var move = moveDirection.getGridMovement();
            list.add(new GridPosition(this.row + move.getRowMove(), this.col + move.getColMove()));
        }
        return list;
    }

    public List<GridPosition> moveAllDirections() {
        List<GridPosition> list = new ArrayList<>(4);
        for(MoveDirection moveDirection : MoveDirection.getAllMoveDirections()){
            var move = moveDirection.getGridMovement();
            list.add(new GridPosition(this.row + move.getRowMove(), this.col + move.getColMove()));
        }
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridPosition position = (GridPosition) o;
        return getRow() == position.getRow() &&
                getCol() == position.getCol();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getCol());
    }

    @Override
    public String toString() {
        return "Position{row=" + row + ", col=" + col + '}';
    }
}
