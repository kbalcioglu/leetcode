package com.solutions.leetcode.utils;

import java.util.*;

public class GridMovement {
    private final int rowMove;
    private final int colMove;

    public static GridMovement of(int rowMove, int colMove){
        return new GridMovement(rowMove,colMove);
    }

    private GridMovement(int rowMove, int colMove) {
        this.rowMove = rowMove;
        this.colMove = colMove;
    }

    public int getRowMove() {
        return rowMove;
    }

    public int getColMove() {
        return colMove;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridMovement that = (GridMovement) o;
        return getRowMove() == that.getRowMove() &&
                getColMove() == that.getColMove();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRowMove(), getColMove());
    }

    @Override
    public String toString() {
        return "GridMovement{" +
                "rowMove=" + rowMove +
                ", colMove=" + colMove +
                '}';
    }
}
